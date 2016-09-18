package com.ar.siosi.Hackfair;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//Theme.dialog는 AppCombatAcitivity로는 만들지 못함 Activity로 해야함
public class WriteDocumentActivity extends Activity {
    private LinearLayout picCamBtnLayout = null;
    private Button picBtn = null;
    private Button camBtn = null;
    private Button okBtn = null;
    private ImageView imageView = null;
    private VideoView videoView = null;
    private int REQUEST_IMAGE = 1;
    private int REQUEST_VIDEO = 2;

    private File destination = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_write_document);

        picCamBtnLayout = (LinearLayout)findViewById(R.id.picCamBtnLayout);
        picBtn =  (Button)findViewById(R.id.writeDocumentPicBtn);
        camBtn =  (Button)findViewById(R.id.writeDocumentCamBtn);
        okBtn =  (Button)findViewById(R.id.writeDocumentOkBtn);
        imageView = (ImageView)findViewById(R.id.writeDocumentImageView);
        videoView = (VideoView)findViewById(R.id.writeDocumentVideoView);

        picCamBtnLayout.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.GONE);
        videoView.setVisibility(View.GONE);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        getWindow().getAttributes().width = (int)(size.x*0.9);
        getWindow().getAttributes().height = (int)(size.y*0.9);


        picBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/testImage/");
                if(!file.exists())
                    file.mkdir();
                destination = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/testImage/"+System.currentTimeMillis()+".jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(destination));
                startActivityForResult(intent, REQUEST_IMAGE);
            }
        });

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/testCamera/");
                if(!file.exists())
                    file.mkdir();
                destination = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/testCamera/"+System.currentTimeMillis()+".mp4");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(destination));
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                startActivityForResult(intent, REQUEST_VIDEO);
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("asdasd1");

        if(requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                try {
                    FileInputStream in = new FileInputStream(destination);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 10;
                    Bitmap bmp = BitmapFactory.decodeStream(in, null, options);
                    imageView.setImageBitmap(bmp);

                    picCamBtnLayout.setVisibility(View.GONE);
                    videoView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                } catch(FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(resultCode == RESULT_CANCELED)
                Toast.makeText(this, "사진을 취소하셨습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(requestCode == REQUEST_VIDEO) {
            if(resultCode == RESULT_OK) {
                System.out.println("asdasd2 "+requestCode);


                videoView.setVideoPath(destination.getPath());
                videoView.start();

                picCamBtnLayout.setVisibility(View.GONE);
                videoView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
            }
            else if(resultCode == RESULT_CANCELED)
                Toast.makeText(this, "비디오를 취소하셨습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}