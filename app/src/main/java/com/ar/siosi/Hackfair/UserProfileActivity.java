package com.ar.siosi.Hackfair;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class UserProfileActivity extends Activity {
    private ImageView profileImage;
    private TextView profileName;
    private User user = null;
    private int shadowSize = 10;
    private double popupWindowRatio = 0.8;
    private int userProfilePadding = 16;
    private int circleSize = 128;
    private int circleBorder = 2;
    private int nameSize = 16;
    private int nameRightMargin = 200;
    private int nameBottomMargin = 10;
    private int introSize = 12;
    private int followerCircleSize = 80;
    private int followingCircleSize = 80;
    private int userProfileTopMarginBottom = 10;
    private int myIntroLeftMargin = 10;
    private int followingTextSize = 10;
    private int followerTextSize = 10;
    private int commentListLayoutPadding = 16;
    //comment
    private int commentLayoutPadding = 5;
    private int commentCircleSize = 80;
    private int commentBorder = 2;
    private int commentNameSize = 16;
    private int commentSize = 16;
    private int commentPadding = 20;
    private int commentNameMarginLeft = 10;
    private int commentNameMarginTop = 20;
    private int commentIconMarginRight = 10;
    private int commentIconMarginTop = 10;
    private int iconTextSize = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        RelativeLayout topLayout = new RelativeLayout(this);
        setContentView(topLayout);
        Bitmap testIcon = BitmapFactory.decodeResource(getResources(), R.drawable.profile);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        FrameLayout.LayoutParams topLayoutParams = new FrameLayout.LayoutParams(size.x, size.y);
        topLayout.setLayoutParams(topLayoutParams);

        FrameLayout shadow = new FrameLayout(this);
        shadow.setBackgroundResource(R.drawable.shadow);
        RelativeLayout.LayoutParams shadowParams = new RelativeLayout.LayoutParams((int)(size.x*popupWindowRatio)+shadowSize, (int)(size.y*popupWindowRatio)+shadowSize);
        shadowParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        shadow.setLayoutParams(shadowParams);
        topLayout.addView(shadow);

        LinearLayout userProfileLayout = new LinearLayout(this);
        userProfileLayout.setOrientation(LinearLayout.VERTICAL);
        userProfileLayout.setBackgroundResource(R.drawable.toplayer);
        userProfileLayout.setPadding(userProfilePadding, userProfilePadding, userProfilePadding, userProfilePadding);
        RelativeLayout.LayoutParams userProfileParams = new RelativeLayout.LayoutParams((int)(size.x*popupWindowRatio), (int)(size.y*popupWindowRatio));
        userProfileParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        userProfileLayout.setLayoutParams(userProfileParams);
        topLayout.addView(userProfileLayout);

        RelativeLayout userProfileTopLayout = new RelativeLayout(this);
        userProfileTopLayout.setGravity(Gravity.CENTER_VERTICAL);
        LinearLayout.LayoutParams userProfileTopParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        userProfileTopParams.setMargins(0, 0, 0, userProfileTopMarginBottom);
        userProfileTopLayout.setLayoutParams(userProfileTopParams);
        userProfileLayout.addView(userProfileTopLayout);

        LinearLayout profileWithIntro = new LinearLayout(this);
        profileWithIntro.setOrientation(LinearLayout.HORIZONTAL);
        profileWithIntro.setGravity(Gravity.CENTER_VERTICAL);
        RelativeLayout.LayoutParams profileWithIntroParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        profileWithIntroParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        profileWithIntro.setLayoutParams(profileWithIntroParams);
        userProfileTopLayout.addView(profileWithIntro);

        ImageView profile = new ImageView(this);
        profile.setImageDrawable(new RoundedAvatarDrawable(testIcon, circleSize, circleSize));
        LinearLayout.LayoutParams profileParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        profile.setLayoutParams(profileParams);
        profileWithIntro.addView(profile);

        LinearLayout myIntroLayout = new LinearLayout(this);
        myIntroLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams myIntroParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        myIntroParams.setMargins(myIntroLeftMargin, 0, 0, 0);
        myIntroLayout.setLayoutParams(myIntroParams);
        profileWithIntro.addView(myIntroLayout);

        TextView nameView = new TextView(this);
        nameView.setText("조영제");
        nameView.setTextColor(Color.parseColor("#000000"));
        nameView.setTypeface(Typeface.DEFAULT_BOLD);
        nameView.setTextSize(nameSize);
        LinearLayout.LayoutParams nameViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nameViewParams.setMargins(0, 0, nameRightMargin, nameBottomMargin);
        nameView.setLayoutParams(nameViewParams);
        myIntroLayout.addView(nameView);

        TextView introView = new TextView(this);
        introView.setText("ASKDOASKDOASKDOAKDOASKDOASOD");
        introView.setTextColor(Color.parseColor("#40000000"));
        introView.setTextSize(introSize);
        //introView.setMaxWidth(nameView.getWidth());
        LinearLayout.LayoutParams introViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        introView.setLayoutParams(introViewParams);
        myIntroLayout.addView(introView);

        FrameLayout followLayout = new FrameLayout(this);
        RelativeLayout.LayoutParams followParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        followParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        followParams.addRule(RelativeLayout.CENTER_VERTICAL);
        followLayout.setLayoutParams(followParams);
        userProfileTopLayout.addView(followLayout);

        TextView followingView = new TextView(this);
        followingView.setBackgroundResource(R.drawable.circleyellow);
        followingView.setText("10");
        followingView.setTextSize(followingTextSize);
        followingView.setGravity(Gravity.CENTER);
        followingView.setTextColor(Color.parseColor("#FFFFFF"));
        FrameLayout.LayoutParams followingViewParams = new FrameLayout.LayoutParams(followingCircleSize, followingCircleSize);
        followingViewParams.setMargins(followerCircleSize/2, followerCircleSize/2, 0, 0);
        followingViewParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        followingView.setLayoutParams(followingViewParams);
        followLayout.addView(followingView);

        TextView followerView = new TextView(this);
        followerView.setBackgroundResource(R.drawable.circleblue);
        followerView.setText("10");
        followerView.setTextSize(followerTextSize);
        followerView.setGravity(Gravity.CENTER);
        followerView.setTextColor(Color.parseColor("#FFFFFF"));
        FrameLayout.LayoutParams followerViewParams = new FrameLayout.LayoutParams(followerCircleSize, followerCircleSize);
        followerViewParams.gravity = Gravity.TOP | Gravity.LEFT;
        followerView.setLayoutParams(followerViewParams);
        followLayout.addView(followerView);

        ScrollView documentListScroll = new ScrollView(this);
        documentListScroll.setBackgroundColor(Color.parseColor("#E6E6E6"));
        LinearLayout.LayoutParams documentListScrollParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        documentListScroll.setLayoutParams(documentListScrollParams);
        userProfileLayout.addView(documentListScroll);

        LinearLayout documentListLayout = new LinearLayout(this);
        documentListLayout.setPadding(commentListLayoutPadding, commentListLayoutPadding, commentListLayoutPadding, commentListLayoutPadding);
        LinearLayout.LayoutParams documentListLayoutParams =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        documentListLayout.setOrientation(LinearLayout.VERTICAL);
        documentListLayout.setLayoutParams(documentListLayoutParams);
        documentListScroll.addView(documentListLayout);

        for(int i=0; i<10; i++)
            documentListLayout.addView(makeDocumentLayout(testIcon, testIcon, null, "조영제", "ㅁㄴㅇㅁㅇㅁㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㅇㄴ", 10, 10, 10));
        /*
        profileImage = (ImageView)findViewById(R.id.profile);
        profileName = (TextView)findViewById(R.id.profileName);
        user = User.getInstance();
        */
        //profileLoad();
    }

    public RelativeLayout makeDocumentLayout(Bitmap profileImg, Bitmap pic, Uri video, String name, String comment, int beWithMeCount, int notNiceCount, int seeYaCount) {
        RelativeLayout documentLayout = new RelativeLayout(this);
        documentLayout.setPadding(commentLayoutPadding, commentLayoutPadding, commentLayoutPadding, commentLayoutPadding);
        RelativeLayout.LayoutParams documentLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        documentLayout.setLayoutParams(documentLayoutParams);

        TextView nameView = new TextView(this);
        RelativeLayout.LayoutParams nameViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        nameViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        nameViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        nameViewParams.setMargins(commentCircleSize+commentNameMarginLeft, commentNameMarginTop, 0, 0);
        nameView.setLayoutParams(nameViewParams);
        nameView.setText(name);
        nameView.setTextColor(0x40000000);
        nameView.setTypeface(Typeface.DEFAULT_BOLD);
        nameView.setTextSize(commentNameSize);
        documentLayout.addView(nameView);

        LinearLayout iconsLayout = new LinearLayout(this);
        iconsLayout.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams iconLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        iconLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        iconLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        iconLayoutParams.setMargins(0, commentIconMarginTop, commentIconMarginRight, 0);
        iconsLayout.setLayoutParams(iconLayoutParams);
        documentLayout.addView(iconsLayout);

        LinearLayout iconWithmeLayout = new LinearLayout(this);
        iconWithmeLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams iconWithmeLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        iconWithmeLayout.setLayoutParams(iconWithmeLayoutParams);
        iconWithmeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView iconWithme = new ImageView(this);
        iconWithme.setBackgroundResource(R.drawable.icon_emotion_bewithme2);
        iconWithmeLayout.addView(iconWithme);

        TextView iconWithmeTextView = new TextView(this);
        LinearLayout.LayoutParams iconWithmeTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iconWithmeTextView.setText(new Integer(beWithMeCount).toString());
        iconWithmeTextView.setTextColor(Color.parseColor("#000000"));
        iconWithmeTextView.setTextSize(iconTextSize);
        iconWithmeTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        iconWithmeTextView.setLayoutParams(iconWithmeTextViewParams);
        iconWithmeLayout.addView(iconWithmeTextView);

        iconsLayout.addView(iconWithmeLayout);

        LinearLayout iconNotNiceLayout = new LinearLayout(this);
        iconNotNiceLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams iconNotNiceLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        iconNotNiceLayout.setLayoutParams(iconNotNiceLayoutParams);

        ImageView iconNotNice = new ImageView(this);
        iconNotNice.setBackgroundResource(R.drawable.icon_emotion_notnice2);
        iconNotNiceLayout.addView(iconNotNice);
        iconNotNiceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TextView iconNotNiceTextView = new TextView(this);
        LinearLayout.LayoutParams iconNotNiceTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iconNotNiceTextView.setText(new Integer(notNiceCount).toString());
        iconNotNiceTextView.setTextColor(Color.parseColor("#000000"));
        iconNotNiceTextView.setTextSize(iconTextSize);
        iconNotNiceTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        iconNotNiceTextView.setLayoutParams(iconNotNiceTextViewParams);
        iconNotNiceLayout.addView(iconNotNiceTextView);

        iconsLayout.addView(iconNotNiceLayout);

        LinearLayout iconSeeyaLayout = new LinearLayout(this);
        iconSeeyaLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams iconSeeyaLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        iconSeeyaLayout.setLayoutParams(iconSeeyaLayoutParams);
        iconSeeyaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView iconSeeya = new ImageView(this);
        iconSeeya.setBackgroundResource(R.drawable.icon_emotion_seeya2);
        iconSeeyaLayout.addView(iconSeeya);

        TextView iconSeeyaTextView = new TextView(this);
        LinearLayout.LayoutParams iconSeeyaTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        iconSeeyaTextView.setText(new Integer(seeYaCount).toString());
        iconSeeyaTextView.setTextColor(Color.parseColor("#000000"));
        iconSeeyaTextView.setTextSize(iconTextSize);
        iconSeeyaTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        iconSeeyaTextView.setLayoutParams(iconSeeyaTextViewParams);
        iconSeeyaLayout.addView(iconSeeyaTextView);

        iconsLayout.addView(iconSeeyaLayout);

        LinearLayout contentLayout = new LinearLayout(this);
        contentLayout.setPadding(commentPadding, commentPadding, commentPadding, commentPadding);
        contentLayout.setBackgroundColor(0xFFFFFFFF);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams contentLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        contentLayoutParams.setMargins(0, commentCircleSize*2, 0, 0);
        contentLayout.setLayoutParams(contentLayoutParams);
        documentLayout.addView(contentLayout);

        if(pic != null) {
            ImageView imgView = new ImageView(this);
            LinearLayout.LayoutParams imgViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imgView.setLayoutParams(imgViewParams);
            imgView.setBackground(new BitmapDrawable(pic));
            contentLayout.addView(imgView);
        }

        if(video != null) {
            VideoView videoView = new VideoView(this);
            videoView.setVideoURI(video);
            contentLayout.addView(videoView);
        }

        TextView commentView = new TextView(this);
        LinearLayout.LayoutParams commentViewParams = new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        commentView.setLayoutParams(commentViewParams);
        commentView.setText(comment);
        commentView.setTextSize(commentSize);
        commentView.setTextColor(Color.BLACK);
        commentView.setGravity(Gravity.LEFT | Gravity.TOP);
        contentLayout.addView(commentView);

        ImageView profile = new ImageView(this);
        RelativeLayout.LayoutParams profileParams = new RelativeLayout.LayoutParams(commentCircleSize, commentCircleSize);
        profileParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        profileParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        //Drawable img = new BitmapDrawable(getCircularBitmapWithWhiteBorder(profileImg, commentCircleSize, commentCircleSize, commentBorder));
        Drawable img = new RoundedAvatarDrawable(profileImg, commentCircleSize, commentCircleSize);
        profile.setBackground(img);
        profile.setLayoutParams(profileParams);
        documentLayout.addView(profile);

        return documentLayout;
    }

    public void profileLoad () {
        // TODO: 2016. 9. 14. user image 가져오는거해야됨
        String profileURL = user.getImageUri();
        String userName = user.getUserName();

        Log.i("google get information",userName);

        Picasso.with(this).load(profileURL).into(profileImage);
        profileName.setText(userName);
    }
}