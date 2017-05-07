package com.equality.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.equality.comm.MyApplication;
import com.equality.frameworklibrary.tools.model.OnlineUserInfo;
import com.equality.frameworklibrary.tools.util.IdentityHelper;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnlineUserInfo user= IdentityHelper.getUser();

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar.setTitle("主界面");//不指定则默认加载此activity中android:label
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.backup:
                Toast.makeText(MyApplication.getContext(),"backup",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(MyApplication.getContext(),"delete",Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(MyApplication.getContext(),"settings",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }
}
