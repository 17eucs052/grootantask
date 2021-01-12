
package com.gokulg.training.friendsname;

import java.util.HashMap;

public class FriendsName {

    public static HashMap<Integer, String> friendsName;

    public FriendsName()
    {
        friendsName = new HashMap<Integer, String>();
    }

    public FriendsName(int registerNumber, String name) {
        this.friendsName.put(registerNumber, name);
    }

    public static HashMap<Integer, String> getFriendsName() {
        return friendsName;
    }

    public static void addFriendsName(HashMap<Integer, String> friendsName) {
        FriendsName.friendsName.putAll(friendsName);
    }


}



