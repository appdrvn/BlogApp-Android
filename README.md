## [BlogApp Template Android][![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Introduction

BlogApp Template Template is based on a blog viewing app. The app consists of main list page, user profile with activity timeline, login page, register page, edit profile page, article details page, and gallery page. 

The main objective of this template is to assist startups to build their mobile application faster and easier. 

## How to start
This template comes with dummy data in it, if the app need to connect to Web API, then modify loadData() methods to integrate Web API library. All list page adapters (except GalleryThumbnailAdapter and GalleryPagerAdapter) are accepting ArrayList via setData() for setting data for the first page, add() method for appending data for the following pages. Data binding from Web API result to Model object is not included, you have to implement your own data binding.

## What is inside
### Activities Classes

AboutActivity.java

This activity class is for about page.

ArticleDetailsActivity.java

This activity class is displaying article details, it is expecting ArticleObject object, new instance can be created by calling its static method newInstance() , loadData() method should be modified to retrieve the restaurant data from Web API. 

CommentsActivity.java

This activity class is displaying comments of the article, it is expecting ArticleObject object, new instance can be created by calling its static method newInstance(). Its list view adapter is CommentsAdapter.java, loadData() method should be modified to retrieve the restaurant data from Web API. 

EditProfileActivity.java

This activity class allows user to edit their profile information. New instance can be created by calling its static method newInstance().

GalleryDetailsActivity.java

This activity class is displaying gallery post, it is expecting GalleryObject object, new instance can be created by calling its static method newInstance(). Its gallery thumbnail adapter is GalleryThumbnailAdapter.java, and its gallery pager adapter is GalleryPagerAdapter.java. loadData() method should be modified to retrieve the restaurant data from Web API. 

GalleryInformationActivity.java

This activity class is displaying gallery post information including its comments, it is expecting GalleryObject object, new instance can be created by calling its static method newInstance(). Its comment list adapter is CommentsAdapter.java. loadData() method should be modified to retrieve the restaurant data from Web API. 

LoginActivity.java

This activity class is the login page. New instance can be created by calling its static method newInstance().

MainActivity.java

This is the main activity class. It consists of 3 tabs: Home tab (refer to HomeFragment.java), Profile tab (refer to ProfileFragment.java), More tab (refer to MoreFragment.java). New instance can be created by calling its static method newInstance().

RegisterActivity.java

This activity class is the register page. New instance can be created by calling its static method newInstance().

ViewLargeImageActivity.java

This activity class displays images in full screen, it allows users zoom in and out and pan to view the image. It is expecting images URL or full path to the image file, both in String array format and the position of the image it should display first (optional). New instance can be created by calling its static method newInstance().

### Fragments Classes

GalleryPager.java

This fragment class is the individual page in the gallery activity (refer to GalleryDetailsActivity.java), it display the image in a gallery post. It is expecting the image URL in string format, new instance can be created by calling its static method newInstance().

HomeFragment.java

This fragment class is the home tab, it displays the list of all posts including article posts and gallery posts. loadData() method should be modified to retrieve the restaurant data from Web API. The adapter used for the list is ContentsAdapter.java. New instance can be created by calling its static method newInstance().

MoreFragment.java

This fragment class consists of few buttons, Logout, Change Password, About Us and Edit Profile button. New instance can be created by calling its static method newInstance().

ProfileFragment.java

This fragment class is the home tab, it displays the users name, posts and comments count, and also list of all activities including article posts and gallery posts, comments and likes. loadData() method should be modified to retrieve the restaurant data from Web API. The adapter used for the list is ActivityAdapter.java. New instance can be created by calling its static method newInstance().

### Adapters Classes

AboutReferenceAdapter.java

This adapter class is the adapter for references in AboutActivity.java. Use its setData() for setting data.

ActivityAdapter.java

This adapter class is the adapter for user activity in ProfileFragment.java. Use its setData() for setting data for the first page, add() method for appending data for the following pages.

CommentsAdapter.java

This adapter class is the adapter for user comments in CommentsActivity.java and GalleryInformationActivity.java. Use its setData() for setting data for the first page, add() method for appending data for the following pages.

ContentsAdapter.java

This adapter class is the adapter for article and gallery posts in HomeFragment.java. Use its setData() for setting data for the first page, add() method for appending data for the following pages.

GalleryPagerAdapter.java

This adapter class is the adapter for gallery post images in GalleryDetailsActivity.java. Its constructor is accepting String array of the image URLs.

GalleryThumbnailAdapter.java

This adapter class is the adapter for gallery post thumbnails in GalleryDetailsActivity.java. Use its setData() for setting data.

ViewLargeImageAdapter.java

This adapter class is the adapter for banners in ViewFullImageActivity.java. Its constructor is accepting images URL in String array format.

### Models Classes

AboutReference.java

This model class is for the references in this app.

ActivityObject.java

This model class is for the user activity.

ArticleObject.java

This model class is for article post.

CommentObject.java

This model class is the user comments for article and gallery posts.

ContentObject.java

This model class is the super class of ArticleObject.java and GalleryObject.java.

GalleryObject.java

This model class is for gallery post.

UserObject.java

This model class is for user.

### Delegates Classes

Constants.java

This is the constant class, it holds all URLs, and any other constant values.

DialogDelegates.java

This class consists of the methods to create Android default dialogs.

MyAppGlideModule.java

This class is Glide module, it is required for using Glide v4 (refer to Tools and Libraries used).

UtilityFunctions.java

This class holds all the utility methods, for example formatting the date format.

### Dialogs Classes

ChangePasswordDialog.java

This dialog class is for user to change password. New instance can be created by calling its static method newInstance().

ForgotPasswordDialog.java

This dialog class is for user to recover password. New instance can be created by calling its static method newInstance().

### Widgets Classes

BaseActivity.java

This is the base class of DefaultActivity.java. Override appResumed() method if there is certain function needs to be executed when the app is resumed.

DefaultActivity.java

This is the super class of all Activity classes. Call to initToolbar() method to set toolbar title, left and right icon and action.

DefaultDialogFragment.java

This is the super class of all DialogFragment classes. Call to initToolbar() method to set toolbar title, left and right icon and action.

DefaultFragment.java

This is the super class of all Fragment classes. Call to initToolbar() method to set toolbar title, left and right icon and action.

DefaultListActivity.java

This is an Activity class for activity which has list and needs to implement pagination functions. It consists of methods which caters for pagination functions. setupLoadMore() method will setup the recyclerview with pagination functions. showProgressDialog() method will return false if the list is loading more items or the list is refreshing, it will return true otherwise. finishLoading() method will hide the refresh layout and load more loading indicator. loadData() method will automatically call when swipe to refresh or loading more is triggered.
To use this class, simply extend it and assign a SwipeRefreshLayout to the variable mSwipeRefreshLayout, RecyclerView to the variable mRecyclerView. After that, call to the method setupLoadMore() and assign the variable refreshListener to the mSwipeRefreshLayout.

DefaultListFragment.java

This is the fragment version of DefaultListActivity.java. You may refer to DefaultListActivity.java to learn how to use it.

RoundedCornerLayout.java

This is a layout class which will mask the content to rounded corner rectangle.

ViewPagerForPhotoView.java

This is a view pager class which is used for hosting photoview.

WebViewControlActivity.java

This is an activity which hosts the WebViewControlFragment.java. New Instance can be created by calling newIntance(). There are variants of newInstance() method:
1. Accepts context in Context, content in String, title in String;
2. Accepts context in Context, content in String, title in String, flag in boolean (this flag is determine if the content is URL format or HTML format, false for URL format, true for HTML format).

WebViewControlFragment.java

This fragment contain only WebView and Toolbar.New Instance can be created by calling newIntance(). There are variants of newInstance() method:
1. Accepts content in String, title in String;
2. Accepts content in String, title in String, flag in boolean (this flag is determine if the content is URL format or HTML format, false for URL format, true for HTML format).

### File Structure
```
BlogApp
|---LICENSE.md
|---README.md
|---build.gradle
|---gradle.properties
|---gradlew
|---gradlew.bat
|---local.properties
|---BlogApp.iml
|---settings.gradle
|---app
| |---app.iml
| |---build.gradle
| |---proguard-rules.pro
| | |---src
| | | |---main
| | | | |---java/com/appdrvn/blogapp
| | | | | |---activities
| | | | | | |---AboutActivity.java
| | | | | | |---ArticleDetailsActivity.java
| | | | | | |---CommentsActivity.java
| | | | | | |---EditProfileActivity.java
| | | | | | |---GalleryDetailsActivity.java
| | | | | | |---GalleryInformationActivity.java
| | | | | | |---LoginActivity.java
| | | | | | |---MainActivity.java
| | | | | | |---RegisterActivity.java
| | | | | |---adapters
| | | | | | |---AboutReferenceAdapter.java
| | | | | | |---ActivityAdapter.java
| | | | | | |---CommentsAdapter.java
| | | | | | |---ContentsAdapter.java
| | | | | | |---GalleryPagerAdapter.java
| | | | | | |---GalleryThumbnailAdapter.java
| | | | | |---delegates
| | | | | | |---Constants.java
| | | | | | |---DialogsDelegates.java
| | | | | | |---MyAppGlideModule.java
| | | | | | |---UtilityFunctions.java
| | | | | |---dialogs
| | | | | | |---ChangePasswordDialog.java
| | | | | | |---ForgotPasswordDialog.java
| | | | | |---fragments
| | | | | | |---GalleryPager.java
| | | | | | |---HomeFragment.java
| | | | | | |---MoreFragment.java
| | | | | | |---ProfileFragment.java
| | | | | |---models
| | | | | | |---AboutReference.java
| | | | | | |---ActivityObject.java
| | | | | | |---ArticleObject.java
| | | | | | |---CommentObject.java
| | | | | | |---ContentObject.java
| | | | | | |---GalleryObject.java
| | | | | | |---UserObject.java
| | | | | |---widgets
| | | | | | |---BaseActivity.java
| | | | | | |---DefaultActivity.java
| | | | | | |---DefaultDialogFragment.java
| | | | | | |---DefaultFragment.java
| | | | | | |---DefaultListActivity.java
| | | | | | |---DefaultListFragment.java
| | | | | | |---RoundedCornerLayout.java
| | | | | | |---ViewLargeImageActivity.java
| | | | | | |---ViewLargeImageAdapter.java
| | | | | | |---ViewPagerForPhotoView.java
| | | | | | |---WebViewControlActivity.java
| | | | | | |---WebViewControlFragment.java
| | | | |---res
| | | | | |---anim
| | | | | | |---enter.xml
| | | | | | |---exit_down.xml
| | | | | | |---exit_up.xml
| | | | | |---drawable
| | | | | | |---circle_grey.xml
| | | | | | |---ic_home_selector.xml
| | | | | | |---ic_more_selector.xml
| | | | | | |---ic_profile_selector.xml
| | | | | | |---img_placeholder_wide.xml
| | | | | | |---left_line_black.xml
| | | | | | |---ripple_button_bg_color_accent.xml
| | | | | | |---ripple_button_bg_red.xml
| | | | | | |---ripple_button_bg_semi_black.xml
| | | | | | |---ripple_button_bg_transparent.xml
| | | | | | |---ripple_button_bg_transparent_black_mask.xml
| | | | | | |---rounded_corner_bottom_dark_grey.xml
| | | | | | |---rounded_corner_grey.xml
| | | | | | |---rounded_side_color_primary.xml
| | | | | | |---rounded_side_semi_black.xml
| | | | | | |---scrim.xml
| | | | | | |---thumbnail_selector.xml
| | | | | |---drawable-xxxhdpi
| | | | | | |---ic_activity_article.png
| | | | | | |---ic_activity_gallery.png
| | | | | | |---ic_author.png
| | | | | | |---ic_back_white.png
| | | | | | |---ic_clock.png
| | | | | | |---ic_close.png
| | | | | | |---ic_comment.png
| | | | | | |---ic_email.png
| | | | | | |---ic_email_black.png
| | | | | | |---ic_email_white.png
| | | | | | |---ic_facebook.png
| | | | | | |---ic_home.png
| | | | | | |---ic_home_h.png
| | | | | | |---ic_information.png
| | | | | | |---ic_like.png
| | | | | | |---ic_like_grey.png
| | | | | | |---ic_like_white.png
| | | | | | |---ic_logout.png
| | | | | | |---ic_more.png
| | | | | | |---ic_more_h.png
| | | | | | |---ic_password.png
| | | | | | |---ic_password_black.png
| | | | | | |---ic_profile.png
| | | | | | |---ic_profile_h.png
| | | | | | |---ic_profile_picture_placeholder.png
| | | | | | |---ic_right.png
| | | | | | |---ic_rotated_div.png
| | | | | | |---ic_send.png
| | | | | | |---ic_share.png
| | | | | | |---ic_share_white.png
| | | | | | |---ic_username.png
| | | | | | |---ic_username_black.png
| | | | | | |---ic_website.png
| | | | | | |---img_logo_long.png
| | | | | | |---img_splash.jpg
| | | | | | |---img_splash_blur.jpg
| | | | | | |---img_tempimage.png
| | | | | |---layout
| | | | | | |---activity_about.xml
| | | | | | |---activity_article_details.xml
| | | | | | |---activity_comments.xml
| | | | | | |---activity_edit_profile.xml
| | | | | | |---activity_fragment.xml
| | | | | | |---activity_gallery_details.xml
| | | | | | |---activity_gallery_information.xml
| | | | | | |---activity_login.xml
| | | | | | |---activity_main.xml
| | | | | | |---activity_register.xml
| | | | | | |---activity_view_large.xml
| | | | | | |---dialog_change_password.xml
| | | | | | |---dialog_forgot_password.xml
| | | | | | |---fragment_home.xml
| | | | | | |---fragment_more.xml
| | | | | | |---fragment_profile.xml
| | | | | | |---fragment_webview_control.xml
| | | | | | |---item_about_references.xml
| | | | | | |---item_activity_article_post.xml
| | | | | | |---item_activity_comment.xml
| | | | | | |---item_activity_gallery_post.xml
| | | | | | |---item_activity_like.xml
| | | | | | |---item_article.xml
| | | | | | |---item_comment.xml
| | | | | | |---item_gallery.xml
| | | | | | |---item_gallery_thumbnail.xml
| | | | | | |---layout_comment_input.xml
| | | | | | |---layout_more_comments.xml
| | | | | | |---layout_toolbar.xml
| | | | | | |---layout_toolbar_dialog.xml
| | | | | | |---layout_toolbar_double_icon_transparent.xml
| | | | | | |---layout_toolbar_transparent.xml
| | | | | | |---pager_gallery.xml
| | | | | |---mipmap-hdpi
| | | | | | |---ic_launcher.png
| | | | | | |---ic_launcher_round.png
| | | | | |---mipmap-mdpi
| | | | | | |---ic_launcher.png
| | | | | | |---ic_launcher_round.png
| | | | | |---mipmap-xhdpi
| | | | | | |---ic_launcher.png
| | | | | | |---ic_launcher_round.png
| | | | | |---mipmap-xxhdpi
| | | | | | |---ic_launcher.png
| | | | | | |---ic_launcher_round.png
| | | | | |---mipmap-xxxhdpi
| | | | | | |---ic_launcher.png
| | | | | | |---ic_launcher_round.png
| | | | | |---values
| | | | | | |---arrays.xml
| | | | | | |---colors.xml
| | | | | | |---dimens.xml
| | | | | | |---strings.xml
| | | | | | |---styles.xml
| | | | | |---AndroidManifest.xml
```
### Tools and Libraries used

1. Glide - https://github.com/bumptech/glide 
2. PhotoView - https://github.com/chrisbanes/PhotoView
3. Parceler - https://github.com/johncarl81/parceler
4. Google-gson - https://github.com/google/gson
5. Paginate - https://github.com/MarkoMilos/Paginate
6. Unsplash - https://unsplash.com/
7. Icons8 - https://icons8.com/
8. Android Asset Studio - https://romannurik.github.io/AndroidAssetStudio/icons-generic.html#source.type=clipart&source.clipart=ac_unit&source.space.trim=1&source.space.pad=0&size=32&padding=8&color=rgba(0%2C%200%2C%200%2C%200.54)&name=ic_ac_unit


## Useful Links

Appdrvn official website - http://www.appdrvn.com/ 

Appdrvn official facebook page - https://www.facebook.com/appdrvn/ 

Appdrvn email address - hello@appdrvn.com
