package com.levegra.anthonius_1202150034_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/***
 * Detail Activity that is launched when a list item is clicked. It shows more info on the sport.
 */
public class DetailActivity extends AppCompatActivity {

    //Construct initial state
    ImageView v, waterImage;
    TextView waterTitle, water_counter;
    int i, max_val, min_val;
    int water_val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        waterTitle = (TextView)findViewById(R.id.titleDetail);
        waterImage = (ImageView)findViewById(R.id.waterImageDetail);
        v = (ImageView)findViewById(R.id.galon);

        v.setImageLevel(water_val);

        Toast def = Toast.makeText(getApplicationContext(), "Air Sedikit", Toast.LENGTH_SHORT);
        def.show();

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Water.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        waterTitle.setText(getIntent().getStringExtra(Water.TITLE_KEY));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Water.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(waterImage);
    }

    public void increaseVal(View view) {
        v = (ImageView)findViewById(R.id.galon);
        water_counter = (TextView)findViewById(R.id.water_count);
        max_val = 6;

        if(water_val < max_val) {

            water_val++;
            v.setImageLevel(water_val);
            water_counter.setText(String.valueOf(water_val + " L"));

            if( water_val == max_val ) {
                Toast max = Toast.makeText(getApplicationContext(), "Sudah Penuh", Toast.LENGTH_SHORT);
                max.show();
            }

        }
    }

    public void decreaseVal(View view) {
        v = (ImageView)findViewById(R.id.galon);
        water_counter = (TextView)findViewById(R.id.water_count);
        min_val = 0;

        if(water_val > 0) {

            water_val--;
            v.setImageLevel(water_val);
            water_counter.setText(String.valueOf(water_val) + " L");

            if( water_val == 0 ) {
                Toast max = Toast.makeText(getApplicationContext(), "Air Sedikit", Toast.LENGTH_SHORT);
                max.show();
            }

        }
    }
}