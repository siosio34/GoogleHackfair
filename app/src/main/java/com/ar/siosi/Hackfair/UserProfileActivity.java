package com.ar.siosi.Hackfair;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class UserProfileActivity extends Activity {
    ImageView profileImage;
    TextView profileName;
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_user_profile);

        profileImage = (ImageView)findViewById(R.id.profile);
        profileName = (TextView)findViewById(R.id.profileName);
        user = User.getInstance();

        //profileLoad();
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