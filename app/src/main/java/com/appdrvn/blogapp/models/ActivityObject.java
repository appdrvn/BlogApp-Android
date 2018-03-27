package com.appdrvn.blogapp.models;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 13/02/2018.
 */

public class ActivityObject {

    public static final int TYPE_COMMENT = 1;
    public static final int TYPE_LIKE = 2;
    public static final int TYPE_ARTICLE_POST = 3;
    public static final int TYPE_GALLERY_POST = 4;

    public ContentObject contentObject = new ContentObject();
    public int type = 0;
    public long datetime = 0l;
    public String comment = "";

    public static ArrayList<ActivityObject> createDummy() {
        ArrayList<ActivityObject> output = new ArrayList<>();
        ArrayList<ContentObject> contentObjects = ContentObject.createDummy();
        int[] TYPES = new int[]{
                TYPE_COMMENT, TYPE_COMMENT, TYPE_LIKE, TYPE_ARTICLE_POST, TYPE_GALLERY_POST, TYPE_GALLERY_POST, TYPE_LIKE, TYPE_COMMENT, TYPE_GALLERY_POST, TYPE_ARTICLE_POST, TYPE_ARTICLE_POST
        };
        for (int i = 0; i < 21; i++) {
            ActivityObject activityObject = new ActivityObject();
            activityObject.contentObject = contentObjects.get(i % contentObjects.size());
            activityObject.type = TYPES[i%TYPES.length];
            activityObject.datetime = System.currentTimeMillis() - (i * 1000 * 60 * 60 * 4);
            activityObject.comment = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum porttitor consectetur mauris, nec imperdiet dolor venenatis quis. Xnec imperdiet dolor venenatis quis.";
            output.add(activityObject);
        }
        return output;
    }
}
