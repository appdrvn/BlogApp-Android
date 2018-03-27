package com.appdrvn.blogapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by kelvynlaw on 31/01/2018.
 */

@Parcel
public class ContentObject {

    public String id = "";
    public String title = "";
    public long datetime = 0l;
    public String thumbnail = "";
    public ArrayList<CommentObject> commentObjects = new ArrayList<>();
    public UserObject author = new UserObject();


    public static ArrayList<ContentObject> createDummy() {
        ArrayList<ContentObject> output = new ArrayList<>();

        ArrayList<ArticleObject> articleObjects = ArticleObject.createArticleDummy();
        ArrayList<GalleryObject> galleryObjects = GalleryObject.createGalleryDummy();

        for (int i = 0; i < 40; i++) {
            if (i % 2 == 0) {
                if (i == 8 || i == 16 || i == 18) {
                    output.add(galleryObjects.get(i % galleryObjects.size()));
                } else {
                    output.add(articleObjects.get(i % articleObjects.size()));
                }
            } else if (i == 5 || i == 15 || i == 9) {
                output.add(articleObjects.get(i % articleObjects.size()));
            } else {
                output.add(galleryObjects.get(i % galleryObjects.size()));
            }
        }

        return output;
    }
}
