package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailActivity extends AppCompatActivity {

    private NeighbourApiService apiService;

    Neighbour mNeighbour;

    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.floatingActionButtonFavorite)
    FloatingActionButton favoriteButton;

    @BindView(R.id.imageViewAvatar)
    ImageView avatarXml;
    @BindView(R.id.textViewName)
    TextView nameXml;
    @BindView(R.id.textViewLocalisation)
    TextView adressXml;
    @BindView(R.id.textViewTelephone)
    TextView phoneNumberXml;
    @BindView(R.id.textViewAboutMe)
    TextView aboutMeXml;
    @BindView(R.id.textViewInternet)
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
        ButterKnife.bind(this);

        getData();
        setData();

        /** Bouton retour */
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /** bouton favoris */
        if (!favorite) {
            favoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        } else {
            favoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
        }

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (!favorite) {
                    favoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
                    apiService.addFavorite(mNeighbour);
                } else {
                    favoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    apiService.removeFavorite(mNeighbour);
                }
            }
        });
    }

    private void getData() {
        mNeighbour = getIntent().getParcelableExtra("neighbour");
        if (mNeighbour != null) {
            avatar = mNeighbour.getAvatarUrl();
            name = mNeighbour.getName();
            adress = mNeighbour.getAddress();
            phoneNumber = mNeighbour.getPhoneNumber();
            aboutMe = mNeighbour.getAboutMe();
            favorite = mNeighbour.getFavotite();
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