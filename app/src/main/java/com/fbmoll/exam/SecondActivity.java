package com.fbmoll.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //createToolbar(); // creates the toolbar and switches between activities
    }

    /*public void createToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }*/

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