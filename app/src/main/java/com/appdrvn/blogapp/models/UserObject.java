package com.appdrvn.blogapp.models;

import org.parceler.Parcel;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

@Parcel
public class UserObject {

    public String id = "";
    public String name = "";
    public String profileImage = "";
    public int postCount = 0;
    public int commentCount = 0;

    public static UserObject createDummy(){
        UserObject output = new UserObject();
        output.name = CommentObject.NAMES[0];
        output.profileImage = CommentObject.PROFILE_PICTURES[0];
        output.postCount = 28;
        output.commentCount = 98;

        return output;
    }


}
