package com.caro.controller;





import java.util.ArrayList;
import java.util.List;
/*
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Friend;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

@Controller
public class Controller2 {
	

	private Facebook facebook;
    public Controller2() throws FacebookException {
        facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("1577853698915697", "13bbe9f5c7771d39045194d0373a570b");
        String shortLivedToken = "EAACEdEose0cBALOduTFMgSoZBWl0NaBFtsklrrEpRm37F33p2icNPCzZB0mgq2C9JEtA5UWZCGIWgyB9vTjAi2riBAn8YZC5eDheoxApNsuAINa6SkbxflZC25uB5p0iZBOOkLO2n9SBAfTbfTsD7Ckhe5FlNHBbTwb9e7zaWdBm4TqW3zTeYfFQK6THWRpssZD";
        facebook.setOAuthAccessToken(new AccessToken(shortLivedToken, null));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloFacebook(Model model) {
        return "connect/facebookConnected";
    }
    @RequestMapping(value = "/feed", method = RequestMethod.GET)
    public String Feed(Model model) throws FacebookException {
    	User usrp;
		try {
			usrp = facebook.getMe();
			model.addAttribute("facebookProfile", usrp);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	ResponseList<Post> feed;
		try {
			feed = facebook.getPosts("168243403351367");
			System.out.println(feed.get(0).toString());
			model.addAttribute("feed", feed);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		facebook.deletePost("168412216667819");
		// id là object_id
        return "hello";
    }
	
    @RequestMapping(value = "/delete-{idPost}", method = RequestMethod.GET)
    public String deletePost(@PathVariable String idPost) throws FacebookException {
    	System.out.println(facebook.deletePost(idPost));

        return "redirect:/feed";
    }
    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    public String ShowListFriend(Model model) throws FacebookException {
    	ResponseList<Friend> listFriend = facebook.getFriends();
    	System.out.println(listFriend.get(0).toString());
        return "friend";
    }
}
