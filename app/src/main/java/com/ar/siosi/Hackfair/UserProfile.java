package com.ar.siosi.Hackfair;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class UserProfile extends AppCompatActivity {

    ImageView profileImage;
    TextView profileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileImage = (ImageView)findViewById(R.id.Profile);
        profileName = (TextView)findViewById(R.id.profileName);

        profileLoad();
    }

    public void profileLoad () {
        // TODO: 2016. 9. 14. user image 가져오는거해야됨

        String profileURL = User.currentUser.getImageUri();
        String userName = User.currentUser.getUserName();

        Log.i("google get information",userName);

        Picasso.with(this).load(profileURL).into(profileImage);

        //profileImage.setImageURI(profileURL);
        profileName.setText(userName);

    }


}
