package com.appdrvn.blogapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

@Parcel
public class CommentObject {

    public String id = "";
    public String comment = "";
    public int likeCount = 0;
    public long datetime = 0l;
    public UserObject commentor = new UserObject();

    public static final String[] PROFILE_PICTURES = new String[]{
            "http://3.bp.blogspot.com/-Qt9WuoxZRgk/TdKrIV0l76I/AAAAAAAAAAg/bkLzetwiqmg/s1600/huge.jpg",
            "http://www.popcornfor2.com/upload/user_2/images/2012_6/parkyoochun.jpg",
            "https://1.soompi.io/wp-content/uploads/2014/11/kim-soo-hyun1.jpg",
            "http://www.beautifulwomenpedia.com/images/xbeautiful-asian-woman-10.jpg.pagespeed.ic_.KbFu71zkmS.jpg",
            "http://cdn2.stylecraze.com/wp-content/uploads/2013/05/Top-20-Most-Beautiful-Asian-Women-10.jpg",
            "http://www.theaureview.com/sites/default/files/fan-bingbing.jpg"
    };
    public static final String[] NAMES = new String[]{
            "James Tan",
            "Park Kyoo Chun",
            "Kim Soo Hyun",
            "Busarakham",
            "Rachel Tan",
            "Fan BingBing"
    };
    static final String[] COMMENTS = new String[]{
            "Nunc eget tortor at lorem venenatis sollicitudin id rhoncus mauris. Cras dignissim, velit ac bibendum euismod, felis metus elementum nibh, eu suscipit nibh augue id lorem. Sed suscipit ante id arcu consequat maximus.",
            "Proin imperdiet pretium libero vitae tincidunt. Donec nisi risus, rutrum eget consectetur sit amet, tempor ac urna.",
            "Sed iaculis, ligula at dapibus commodo, tortor magna vulputate odio, a tempus augue neque ut sem.",
            "Sed blandit purus maximus elit convallis, sed molestie nisi varius. Nunc eu faucibus sem, et aliquet est."
    };


    public static ArrayList<CommentObject> createDummy(int count) {
        ArrayList<CommentObject> output = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CommentObject commentObject = new CommentObject();
            commentObject.id = (i + 1) + "";
            commentObject.comment = COMMENTS[i % COMMENTS.length];
            commentObject.datetime = System.currentTimeMillis() - (i * 60 * 60 * 4 * 1000);
            commentObject.likeCount = new Random().nextInt(41) + i;
            commentObject.commentor.id = (i+20) + "";
            commentObject.commentor.name = NAMES[i%NAMES.length];
            commentObject.commentor.profileImage = PROFILE_PICTURES[i%PROFILE_PICTURES.length];
            output.add(commentObject);

        }
        return output;
    }

}
