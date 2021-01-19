package com.gokulg.training.controller;

import com.gokulg.training.exceptions.KeyAlreadyPresentException;
import com.gokulg.training.friendsdetails.FriendsDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class Controller {
    @RequestMapping(value = "/getTest", method = RequestMethod.GET)
    public String result() {
        return "Hello World!";
    }

    @PostMapping("/postTest")
    public String getFromUrl(@RequestBody String content) {
        System.out.println("Coming in: " + content);
        return "Done";
    }

    FriendsDetails obj;

    HashMap<Integer, Object> friendsDetails;

    Controller() {
       obj = new FriendsDetails();
       friendsDetails = new HashMap<Integer, Object>();

       friendsDetails.put(1,new FriendsDetails("Raj",21,"8487874454"));
       friendsDetails.put(2,new FriendsDetails("Riya",33,"8487877784"));
       friendsDetails.put(3,new FriendsDetails("Rita",11,"8101074412"));
       friendsDetails.put(4,new FriendsDetails("Ravi",50,"7845874487"));
       friendsDetails.put(5,new FriendsDetails("Ram",34,"9987870001"));

    }

    @GetMapping("/friendsDetails/")
    public Set<Map.Entry<Integer, Object>> printFriendsNames() {
            return friendsDetails.entrySet();
    }

    @PostMapping("/addEntry")

    public void addEntry(@RequestBody HashMap<Integer, Object> input) throws KeyAlreadyPresentException {

        for (Map.Entry mapElement : input.entrySet()){
            int key =  (int)mapElement.getKey();
            if(friendsDetails.containsKey(key)==true)
                throw new KeyAlreadyPresentException("Register Number Already Exists");
            else {
                friendsDetails.put(key, mapElement.getValue());
            }
        }

    }

    @PostMapping("/deleteEntry")

    public void deleteEntry(@RequestBody int input) {
        friendsDetails.remove(input);
    }



}
