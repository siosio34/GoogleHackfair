package com.ar.siosi.Hackfair;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

/**
 * Created by Mansu on 2016-09-18.
 */
public class ReadDocumentActivity extends Activity {
    private LinearLayout document = null;
    private double popupWindowRatio = 0.8;
    private int circleSize = 128;
    private int circleBorder = 2;
    private int myProfileTextMarginLeft = 10;
    private int myProfileTextMarginTop = 10;
    private int myNameSize = 16;
    private int myIntroMarginBottom = 10;
    private int myIntroSize = 10;
    private int documentLeftScrollMarginTop = 10;
    private int check = 2;

    //comment
    private int commentLayoutPadding = 16;
    private int commentCircleSize = 64;
    private int commentBorder = 2;
    private int commentNameSize = 12;
    private int commentTimeSize = 12;
    private int commentSize = 16;
    private int commentPadding = 10;
    private int commentNameMarginLeft = 10;
    private int commentNameMarginTop = 10;
    private int commentTimeMarginRight = 10;
    private int commentTimeMarginTop = 10;

    Bitmap testIcon = null;
    Drawable testDrawble = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_read_document);
        RelativeLayout topLayer = (RelativeLayout)findViewById(R.id.readDocumentTopLayer);

        testIcon = BitmapFactory.decodeResource(getResources(), R.drawable.busicon);
        testDrawble = new BitmapDrawable(getCircularBitmapWithWhiteBorder(testIcon, circleSize, circleSize, circleBorder));

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        getWindow().getAttributes().width = size.x;
        getWindow().getAttributes().height = size.y;

        document = (LinearLayout)findViewById(R.id.documentTopLayer);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int)(size.x*popupWindowRatio), (int)(size.y*popupWindowRatio));
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        document.setLayoutParams(params);

        ImageView myLocation = new ImageView(this);
        myLocation.setBackground(testDrawble);
        RelativeLayout.LayoutParams myLocationParams = new RelativeLayout.LayoutParams(circleSize, circleSize);
        myLocationParams.setMargins((int)((size.x*(1-popupWindowRatio)))/2-circleSize/2, (int)(size.y*(1-popupWindowRatio))/2-circleSize/2, 0, 0);
        myLocation.setLayoutParams(myLocationParams);
        topLayer.addView(myLocation);

        ImageView mark = new ImageView(this);
        mark.setBackground(testDrawble);
        RelativeLayout.LayoutParams markParams = new RelativeLayout.LayoutParams(circleSize, circleSize);
        markParams.setMargins((int)(size.x*(1-popupWindowRatio))/2-circleSize/2, (int)(size.y*(1-popupWindowRatio))/2-circleSize/2, 0, 0);
        mark.setLayoutParams(markParams);
        topLayer.addView(mark);

        ImageView myPic = new ImageView(this);
        myPic.setBackground(testDrawble);
        RelativeLayout.LayoutParams myPicParams = new RelativeLayout.LayoutParams(circleSize, circleSize);
        myPicParams.setMargins((int)(size.x*(1-popupWindowRatio))/2, (int)(size.y*(1-popupWindowRatio))/2, 0, 0);
        myPic.setLayoutParams(myPicParams);
        topLayer.addView(myPic);

        LinearLayout myProfileText = (LinearLayout)findViewById(R.id.myProfileText);
        LinearLayout.LayoutParams myProfileTextParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        myProfileTextParams.setMargins(circleSize+myProfileTextMarginLeft, myProfileTextMarginTop, 0, 0);
        myProfileText.setLayoutParams(myProfileTextParams);

        TextView myIntro = new TextView(this);
        LinearLayout.LayoutParams myIntroParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        myIntroParams.setMargins(0, 0, 0, myIntroMarginBottom);
        myIntro.setLayoutParams(myIntroParams);
        myIntro.setText("난 바보다");
        myIntro.setTextColor(0x40000000);
        myIntro.setTextSize(myIntroSize);
        myProfileText.addView(myIntro);

        TextView myName = new TextView(this);
        LinearLayout.LayoutParams myNameParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        myName.setLayoutParams(myNameParams);
        myName.setText("조영제");
        myName.setTypeface(Typeface.DEFAULT_BOLD);
        myName.setTextColor(Color.BLACK);
        myName.setTextSize(myNameSize);
        myProfileText.addView(myName);

        ScrollView documentLeftScroll = (ScrollView)findViewById(R.id.documentLeftScroll);
        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        scrollParams.setMargins(0, circleSize/2+documentLeftScrollMarginTop, 0, 0);
        documentLeftScroll.setLayoutParams(scrollParams);

        LinearLayout documentLeft = (LinearLayout)findViewById(R.id.documentLeft);
        if(check == 0) {
            //picture
            ImageView documentPic = new ImageView(this);
            //documentPic.setBackground(new Drawable(bitmap));
            documentLeft.addView(documentPic);
        }
        else if(check == 1) {
            //camera
            VideoView documentVideo = new VideoView(this);
            //documentVideo.setVideoURI();
            documentLeft.addView(documentVideo);
        }

        TextView documentText = new TextView(this);
        String data = "asdad";
        documentText.setText(data);
        documentText.setGravity(Gravity.TOP | Gravity.LEFT);
        documentText.setTextColor(Color.BLACK);
        documentLeft.addView(documentText);
        LinearLayout commentLayout = (LinearLayout)findViewById(R.id.commentLayout);
        for(int i=0; i<10; i++)
            commentLayout.addView(createCommentLayout(testIcon, "조영제", "10분 전", "datatatatatata"));
    }

    public RelativeLayout createCommentLayout(Bitmap profileImg, String name, String time, String comment) {
        RelativeLayout commentLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        commentLayout.setPadding(commentLayoutPadding, commentLayoutPadding, commentLayoutPadding, commentLayoutPadding);
        commentLayout.setLayoutParams(params);

        TextView nameView = new TextView(this);
        RelativeLayout.LayoutParams nameViewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nameViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        nameViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        nameViewParams.setMargins(commentCircleSize+commentNameMarginLeft, commentNameMarginTop, 0, 0);
        nameView.setLayoutParams(nameViewParams);
        nameView.setText(name);
        nameView.setTextColor(0x40000000);
        nameView.setTypeface(Typeface.DEFAULT_BOLD);
        nameView.setTextSize(commentNameSize);
        commentLayout.addView(nameView);

        TextView timeView = new TextView(this);
        RelativeLayout.LayoutParams timeViewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        timeViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        timeViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        timeViewParams.setMargins(0, commentTimeMarginTop, commentTimeMarginRight, 0);
        timeView.setLayoutParams(timeViewParams);
        timeView.setText(time);
        timeView.setTextColor(0x40000000);
        timeView.setTypeface(Typeface.DEFAULT_BOLD);
        timeView.setTextSize(commentTimeSize);
        commentLayout.addView(timeView);

        TextView commentView = new TextView(this);
        RelativeLayout.LayoutParams commentViewParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        commentViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        commentViewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        commentViewParams.setMargins(0, 9*commentCircleSize/10, 0, 0);
        commentView.setLayoutParams(commentViewParams);
        commentView.setPadding(commentPadding, commentPadding, commentPadding, commentPadding);
        commentView.setText(comment);
        commentView.setTextSize(commentSize);
        commentView.setTextColor(Color.BLACK);
        commentView.setGravity(Gravity.LEFT | Gravity.TOP);
        commentView.setBackgroundColor(0xFFFFFFFF);
        commentLayout.addView(commentView);

        ImageView profile = new ImageView(this);
        RelativeLayout.LayoutParams profileParams = new RelativeLayout.LayoutParams(commentCircleSize, commentCircleSize);
        profileParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        profileParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        Drawable img = new BitmapDrawable(getCircularBitmapWithWhiteBorder(profileImg, commentCircleSize, commentCircleSize, commentBorder));
        profile.setBackground(img);
        profile.setLayoutParams(profileParams);
        commentLayout.addView(profile);

        return commentLayout;
    }

    public Bitmap getCircularBitmapWithWhiteBorder(Bitmap bitmap, int b_width, int b_height, int borderWidth) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }

        final int width =  b_width+ borderWidth;
        final int height = b_height + borderWidth;

        Bitmap canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(shader);

        Canvas canvas = new Canvas(canvasBitmap);
        float radius = width > height ? ((float) height) / 2f : ((float) width) / 2f;
        canvas.drawCircle(width / 2, height / 2, radius, paint);
        paint.setShader(null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(borderWidth);
        canvas.drawCircle(width / 2, height / 2, radius - borderWidth / 2, paint);
        return canvasBitmap;
    }
}