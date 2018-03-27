package com.appdrvn.blogapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

@Parcel
public class ArticleObject extends ContentObject {

    public String textBody = "";


    static final String[] THUMBNAILS = new String[]{
            "https://www.mytaiwantour.com/blog/wp-content/uploads/2015/10/MyTaiwanTour_blog_hiking-in-snow-mountain.jpg",
            "http://www.mysabah.com/wordpress/wp-content/uploads/2017/05/20170521_6.jpg",
            "http://www.klia2.info/images/trip/penang-local-cuisines.jpg",
            "http://blog.kesari.in/wp-content/uploads/2017/05/Kesari-Tours-Jumeirah-Beach.jpg",
            "https://cdn.theculturetrip.com/wp-content/uploads/2017/01/la-paz-waterfall-.jpg",
            "https://www.smartdestinations.com/blog/wp-content/uploads/2017/02/Aquaventure-Waterpark-at-Atlantis-The-Palm-1-600x300.jpg",
            "https://az616578.vo.msecnd.net/files/2016/07/15/636042135859880972877034761_AmusementPark.jpg"
    };

    static final String[] TITLES = new String[]{
            "Snowy Mountain Hiking",
            "Milky Way Photography Journey to the peak of Mount Kinabalu",
            "Food Hunting Trip to Food Paradise - Penang",
            "Relaxing Trip to Dubai",
            "Long Weekend Escape to the Waterfall",
            "School Holiday at Water Theme Park",
            "Weekend Family Event at Amusement Park"
    };

    static final String[] NAMES = new String[]{
            "Jamie Chong",
            "Justin Timothy",
            "Cassie",
            "Dharnakumarran",
            "Nathan Nigel",
            "JTSK",
            "Park Hao Yen"
    };

    static final String[] BODYTEXTS = new String[]{
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras commodo rutrum mauris, vitae pharetra sem venenatis eget. Donec lobortis arcu sed erat fringilla, sed faucibus leo facilisis. Duis scelerisque dignissim mauris, nec vulputate justo venenatis a. Cras purus mauris, pellentesque id metus et, feugiat laoreet turpis. Sed finibus velit lacus, at interdum diam rutrum in. Pellentesque et iaculis velit, sed cursus nisi. Etiam ipsum arcu, interdum porta tempor nec, maximus et leo. Etiam interdum nisl sit amet erat vestibulum egestas. Donec luctus, erat nec consectetur tristique, dolor ante laoreet dui, sed commodo sapien ex sed massa. Sed id mollis felis. Etiam sodales faucibus libero, a dignissim justo posuere sed. Proin nec magna eget dui bibendum scelerisque. Maecenas pellentesque laoreet sem a vehicula. Donec interdum scelerisque libero at malesuada.\n" +
                    "\n" +
                    "Nunc eget tortor at lorem venenatis sollicitudin id rhoncus mauris. Cras dignissim, velit ac bibendum euismod, felis metus elementum nibh, eu suscipit nibh augue id lorem. Sed suscipit ante id arcu consequat maximus. Duis enim magna, lacinia id justo consequat, aliquet dignissim est. Donec condimentum aliquet ex id sollicitudin. Morbi vulputate ultrices accumsan. Duis lobortis sit amet lacus eu porta.\n" +
                    "\n" +
                    "Proin imperdiet pretium libero vitae tincidunt. Donec nisi risus, rutrum eget consectetur sit amet, tempor ac urna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam id diam sit amet sem ornare facilisis. Vivamus luctus scelerisque mauris, non volutpat ex dignissim non. Nunc pharetra suscipit dui, a viverra massa consectetur vel. Nam euismod volutpat risus, viverra condimentum libero venenatis eget.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras commodo rutrum mauris, vitae pharetra sem venenatis eget. Donec lobortis arcu sed erat fringilla, sed faucibus leo facilisis. Duis scelerisque dignissim mauris, nec vulputate justo venenatis a. Cras purus mauris, pellentesque id metus et, feugiat laoreet turpis. Sed finibus velit lacus, at interdum diam rutrum in. Pellentesque et iaculis velit, sed cursus nisi. Etiam ipsum arcu, interdum porta tempor nec, maximus et leo. Etiam interdum nisl sit amet erat vestibulum egestas. Donec luctus, erat nec consectetur tristique, dolor ante laoreet dui, sed commodo sapien ex sed massa. Sed id mollis felis. Etiam sodales faucibus libero, a dignissim justo posuere sed. Proin nec magna eget dui bibendum scelerisque. Maecenas pellentesque laoreet sem a vehicula. Donec interdum scelerisque libero at malesuada.",
            "Nunc eget tortor at lorem venenatis sollicitudin id rhoncus mauris. Cras dignissim, velit ac bibendum euismod, felis metus elementum nibh, eu suscipit nibh augue id lorem. Sed suscipit ante id arcu consequat maximus. Duis enim magna, lacinia id justo consequat, aliquet dignissim est. Donec condimentum aliquet ex id sollicitudin. Morbi vulputate ultrices accumsan. Duis lobortis sit amet lacus eu porta. Proin imperdiet pretium libero vitae tincidunt. Donec nisi risus, rutrum eget consectetur sit amet, tempor ac urna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam id diam sit amet sem ornare facilisis. Vivamus luctus scelerisque mauris, non volutpat ex dignissim non. Nunc pharetra suscipit dui, a viverra massa consectetur vel. Nam euismod volutpat risus, viverra condimentum libero venenatis eget."
    };


    public static ArrayList<ArticleObject> createArticleDummy() {
        ArrayList<ArticleObject> output = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            ArticleObject articleObject = new ArticleObject();
            articleObject.thumbnail = THUMBNAILS[i%THUMBNAILS.length];
            articleObject.title = TITLES[i%TITLES.length];
            articleObject.textBody = BODYTEXTS[i%BODYTEXTS.length];
            articleObject.datetime = System.currentTimeMillis() - (i * 1000 * 60 * 60 * 4);
            articleObject.commentObjects = CommentObject.createDummy(i);
            articleObject.author.name = NAMES[i%NAMES.length];
            output.add(articleObject);
        }
        return output;
    }
}
