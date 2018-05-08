package com.github.opticwafare.postkasten_app;

import android.widget.CompoundButton;

import com.google.firebase.messaging.FirebaseMessaging;

public class OnNotificationCheckBoxChangeListener implements CompoundButton.OnCheckedChangeListener {

    private String topic;

    public OnNotificationCheckBoxChangeListener(String topic) {
        this.topic = topic;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked == true) {
            FirebaseMessaging.getInstance().subscribeToTopic(topic);
        }
        else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(topic);
        }
    }
}
