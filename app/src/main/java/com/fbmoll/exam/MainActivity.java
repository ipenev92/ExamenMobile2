package com.fbmoll.exam;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createToolbar(); // creates the toolbar and switches between activities
        moveSun(); // onClick on the layout, will move the sun downwards
        changeBackground(); // WIP as the sun moves, the background changes depending on where the sun is
    }

    public void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void moveSun() {
        FrameLayout layout = (FrameLayout) findViewById(R.id.background);
        layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ImageView sun = (ImageView) findViewById(R.id.sun);
                ObjectAnimator first = ObjectAnimator.ofFloat(sun, "translationY", 1100f);
                first.setDuration(3000);
                first.start();

                /*ObjectAnimator second = ObjectAnimator.ofFloat(sun, "translationY",  850f);
                second.setDuration(2300);

                ObjectAnimator third = ObjectAnimator.ofFloat(sun, "translationY", 50f);
                third.setDuration(200);

                AnimatorSet as = new AnimatorSet();
                as.play(first).after(500).after(second).after(2300).after(third);
                as.start();*/
            }
        });
    }

    private void changeBackground() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.change_to_hello:
                Intent secondary_activity = new Intent(this, SecondActivity.class);
                this.startActivity(secondary_activity);
                break;
            case R.id.change_to_sun:
                Intent main_activity = new Intent(this, MainActivity.class);
                this.startActivity(main_activity);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }

        return super.onOptionsItemSelected(item);
    }
}