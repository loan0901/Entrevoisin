package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.SingleRequest;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.w3c.dom.Text;

import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    private NeighbourApiService apiService;

    ImageButton backButton;
    FloatingActionButton favoriteButton;

    ImageView avatarXml;
    TextView nameXml;
    TextView adressXml;
    TextView phoneNumberXml;
    TextView aboutMeXml;
    TextView internetXml;

    String name;
    String avatar;
    String adress;
    String phoneNumber;
    String aboutMe;
    Boolean favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        apiService = DI.getNeighbourApiService();

        avatarXml = findViewById(R.id.imageViewAvatar);
        nameXml = findViewById(R.id.textViewName);
        adressXml = findViewById(R.id.textViewLocalisation);
        phoneNumberXml = findViewById(R.id.textViewTelephone);
        aboutMeXml = findViewById(R.id.textViewAboutMe);
        internetXml = findViewById(R.id.textViewInternet);

        getData();
        setData();

        /** Bouton retour */
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /** bouton favoris */
        favoriteButton = findViewById(R.id.floatingActionButtonFavorite);

        if (favorite == false) {
            favoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        } else {
            favoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
        }

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favorite == false) {
                    favoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
                    apiService.addFavorite();
                } else {
                    favoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    apiService.removeFavorite();
                }
            }
        });
    }

    private void getData() {
        Neighbour neighbour = getIntent().getParcelableExtra("neighbour");
        if (neighbour != null) {
            avatar = neighbour.getAvatarUrl();
            name = neighbour.getName();
            adress = neighbour.getAddress();
            phoneNumber = neighbour.getPhoneNumber();
            aboutMe = neighbour.getAboutMe();
            favorite = neighbour.getFavotite();
        }
    }

    private void setData() {
        if (avatar != null) {
            Glide.with(avatarXml.getContext())
                    .load(avatar)
                    .apply(RequestOptions.centerCropTransform())
                    .into(avatarXml);
        }
        if (name != null) {
            nameXml.setText(name);
        }
        if (adress != null) {
            adressXml.setText(adress);
        }
        if (phoneNumber != null) {
            phoneNumberXml.setText(phoneNumber);
        }
        if (aboutMe != null) {
            aboutMeXml.setText(aboutMe);
        }
        if (name != null) {
            internetXml.setText("www.facebook.com/" + name);
        }
    }


}