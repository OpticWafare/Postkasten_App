package com.github.opticwafare.postkasten_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        FirebaseMessaging.getInstance().unsubscribeFromTopic("postkasten");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("postkasten_offen");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("postkasten_geschlossen");

        // Checkboxen aus dem Design holen
        CheckBox checkBoxAll = (CheckBox) findViewById(R.id.checkBoxAll);
        CheckBox checkBoxOpen = (CheckBox) findViewById(R.id.checkBoxOpen);
        CheckBox checkBoxClose = (CheckBox) findViewById(R.id.checkBoxClose);

        // Listener zu Checkboxen hinzufügen
        checkBoxAll.setOnCheckedChangeListener(new OnNotificationCheckBoxChangeListener("postkasten"));
        checkBoxOpen.setOnCheckedChangeListener(new OnNotificationCheckBoxChangeListener("postkasten_offen"));
        checkBoxClose.setOnCheckedChangeListener(new OnNotificationCheckBoxChangeListener("postkasten_geschlossen"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
