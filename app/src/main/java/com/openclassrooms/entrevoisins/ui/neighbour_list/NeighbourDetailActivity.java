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

    private Neighbour mNeighbour;

    @BindView(R.id.backButton)
    ImageButton backButton;
    @BindView(R.id.floatingActionButtonFavorite)
    FloatingActionButton favoriteButton;

    @BindView(R.id.imageViewAvatar)
    ImageView imageViewAvatar;
    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewLocalisation)
    TextView textViewLocation;
    @BindView(R.id.textViewPhone)
    TextView textViewPhone;
    @BindView(R.id.textViewAboutMe)
    TextView textViewAboutMe;
    @BindView(R.id.textViewInternet)
    TextView textViewInternet;

    private String name;
    private String avatar;
    private String address;
    private String phoneNumber;
    private String aboutMe;
    private Boolean isFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        apiService = DI.getNeighbourApiService();
        ButterKnife.bind(this);

        getData();
        setData();
        initClick();
        updateButtonFavorite();
    }

    private void getData() {
        mNeighbour = getIntent().getParcelableExtra("neighbour");
        if (mNeighbour != null) {
            avatar = mNeighbour.getAvatarUrl();
            name = mNeighbour.getName();
            address = mNeighbour.getAddress();
            phoneNumber = mNeighbour.getPhoneNumber();
            aboutMe = mNeighbour.getAboutMe();
            isFavorite = mNeighbour.getFavotite();
        }
    }

    private void setData() {
        if (avatar != null) {
            Glide.with(imageViewAvatar.getContext())
                    .load(avatar)
                    .apply(RequestOptions.centerCropTransform())
                    .into(imageViewAvatar);
        }
        if (name != null) {
            textViewName.setText(name);
        }
        if (address != null) {
            textViewLocation.setText(address);
        }
        if (phoneNumber != null) {
            textViewPhone.setText(phoneNumber);
        }
        if (aboutMe != null) {
            textViewAboutMe.setText(aboutMe);
        }
        if (name != null) {
            textViewInternet.setText(getString(R.string.facebook_label, name));
        }
    }

    private void initClick() {
        // Button back
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // button favorite
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (!isFavorite) {
                    favoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
                    apiService.addFavorite(mNeighbour);
                } else {
                    favoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    apiService.removeFavorite(mNeighbour);
                }
            }
        });
    }

    private void updateButtonFavorite() {
        if (!isFavorite) {
            favoriteButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        } else {
            favoriteButton.setImageResource(R.drawable.ic_star_white_24dp);
        }
    }
}