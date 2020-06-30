package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    ImageView avatarXml;
    TextView nameXml;

    String name;
    String avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        avatarXml = findViewById(R.id.imageViewAvatar);
        nameXml = findViewById(R.id.textViewName);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("name") && getIntent().hasExtra("avatar")) {
            name = getIntent().getStringExtra("name");
            avatar = getIntent().getStringExtra("avatar");
        } else {
            Toast.makeText(this, "informations insufisantes", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData () {
        Glide.with(avatarXml.getContext())
                .load(avatar)
                .apply(RequestOptions.centerCropTransform())
                .into(avatarXml);
        nameXml.setText(name);
    }
}