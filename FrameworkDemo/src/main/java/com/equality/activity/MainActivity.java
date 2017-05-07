package com.equality.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.equality.tools.model.OnlineUserInfo;
import com.equality.tools.util.IdentityHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnlineUserInfo user= IdentityHelper.getUser();

    }
}
