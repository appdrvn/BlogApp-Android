package com.appdrvn.blogapp.models;

import org.parceler.Parcel;

import java.util.ArrayList;

import static com.appdrvn.blogapp.models.ArticleObject.NAMES;

/**
 * Created by kelvynlaw on 02/02/2018.
 */

@Parcel
public class GalleryObject extends ContentObject {

    public String[] galleries = new String[0];


    static final String[][] GALLERIES = new String[][]{
    {
            "http://www.pictures-thailand.com/Pattaya/WalkingStreet/Pattaya-Walking-Street-IMG_0064.JPG",
            "https://lmschaeffer.files.wordpress.com/2012/12/paper-lanterns-street.jpg",
            "https://www.vacations.info/wp-content/uploads/2012/03/DSC01118.jpg",
            "https://www.pattayaunlimited.com/wp-content/uploads/2014/12/walking-street-pattaya-thailand.jpg",
            "https://i.pinimg.com/originals/1e/f4/52/1ef4528b3f6b02ae8f6ae64d8493fc0c.jpg"
    },{
            "https://www.maldivesexclusive.com/sites/default/files/field/image/beach-villa_1600x900.jpg",
            "https://twistedsifter.files.wordpress.com/2011/04/maldives-beaches-luxury-best-4.jpg?w=800&h=482",
            "http://www.alessandrocarpentiero.com/wp-content/uploads/2017/01/lily-beach-maldives-resort-review-1170x650.jpg",
            "http://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2017/03/Cocoa-Island-Beach.jpg"
    },{
            "http://www.telegraph.co.uk/content/dam/Travel/galleries/travel/picturegalleries/The-worlds-best-city-skylines/skyline-toronto_3461626a.jpg",
            "https://theplanetd.com/images/Hong-kong-city-skyline-X2.jpg",
            "https://photos.smugmug.com/Australia/Queensland/i-2pLvBvx/1/2ddf2f37/X2/brisbane-australia-11-X2.jpg",
            "https://assets3.thrillist.com/v1/image/1411864/size/tmg-article_default_mobile;jpeg_quality=20.jpg"
    },{
            "https://i.hungrygowhere.com/cms/38/52/8c/34/20009752/8d7d34dc95.jpg",
            "https://i.pinimg.com/736x/ee/a7/57/eea757bfc1210b673f62a1d22f4f157b--ipoh-dim-sum.jpg",
            "http://farm4.staticflickr.com/3755/13099463815_da7e9d84dc_b.jpg",
            "https://1.bp.blogspot.com/-TScBxNxiin4/WXWJb18PDTI/AAAAAAAAICs/EPH-0dOJoR4SJZqnhmjkh9yq1PMeYQ9OwCEwYBhgL/s1600/IMG_7808%2B%25282%2529.JPG",

    }, {
            "http://www.youcanseethemilkyway.com/wp-content/themes/milkyway/img/1.jpg",
            "https://petapixel.com/assets/uploads/2016/07/milkywaygreecefeat.jpg",
            "https://i.cbc.ca/1.3638138.1479852274!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_620/milky-way-concordia-pakistan.jpg"
    }, {
            "http://childhoodobesityfoundation.ca/wp-content/uploads/2017/12/AdobeStock_62395120-1030x695.jpeg",
            "http://cdn1.theodysseyonline.com/files/2016/02/14/635910651833815068-341846207_swing-childhood-mood.jpg",
            "http://www.deakin.edu.au/__data/assets/image/0008/549746/bachelor-of-early-childhood-education-teacher-with-toddlers-small-landscape.jpg"
    }, {
            "http://media.astropublications.com.my/media/ifeel/assets/ilifestyle/pop%20culture/concert/june/mayday%20concert%202017/6%E4%BA%94%E6%9C%88%E5%A4%A9%E3%80%8A%E4%BA%BA%E7%94%9F%E7%84%A1%E9%99%90%E5%85%AC%E5%8F%B8%E3%80%8B%E9%A6%99%E6%B8%AF%E7%AB%99-resize.jpg",
            "http://www.woah.my/wp-content/uploads/2017/10/Mayday_01.jpg",
            "http://www.bin-music.com/album/album/58cd37f2af378_550.jpg",
            "http://oneappsgroup.com/wp-content/uploads/2017/04/may.jpg",
            "https://i2.wp.com/my.juksy.com/wp-content/uploads/sites/25/2017/06/20170324001058_7_17310378_900700206738838_8178845992165635740_o.jpg?resize=600%2C383&ssl=1"
    }, {
            "https://i.ytimg.com/vi/-bzec_7F1Tg/maxresdefault.jpg",
            "https://i.ytimg.com/vi/UEwZHUu8hAw/maxresdefault.jpg",
            "https://i.ytimg.com/vi/6RGEdcFPapA/maxresdefault.jpg",
            "https://www.meradio.sg/blob/2105640/1441504476000/2015090609-jj-lin-concert-5-sep-10-jpg-data.jpg"
    }
    };

    static final String[] TITLES = new String[]{
            "Streets in Thailand",
            "Maldives Beaches",
            "City Skyline",
            "All about Food",
            "Milky Way",
            "Childhood",
            "Mayday Event",
            "JJ Lin Event"
    };


    public static ArrayList<GalleryObject> createGalleryDummy() {
        ArrayList<GalleryObject> output = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            GalleryObject galleryObject = new GalleryObject();
            galleryObject.galleries = new String[GALLERIES.length];
            for (int x = 0; x < galleryObject.galleries.length; x++) {
                galleryObject.galleries[x] = GALLERIES[i%GALLERIES.length][x % GALLERIES[i%GALLERIES.length].length];
            }
            galleryObject.thumbnail = galleryObject.galleries[0];
            galleryObject.title = TITLES[i % TITLES.length];
            galleryObject.datetime = System.currentTimeMillis() - (i * 1000 * 60 * 60 * 4);
            galleryObject.commentObjects = CommentObject.createDummy(i);
            galleryObject.author.name = NAMES[(i + 2) % NAMES.length];
            output.add(galleryObject);
        }
        return output;
    }
}
