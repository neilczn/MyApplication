package com.equality.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.equality.comm.MyApplication;
import com.equality.tools.model.OnlineUserInfo;
import com.equality.tools.util.IdentityHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUserName;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUserName=(EditText)findViewById(R.id.txtUserName);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
    }

    public void Login(View e)
    {
        String userName = txtUserName.getText().toString().trim();
        String password=txtPassword.getText().toString().trim();
        if (userName.isEmpty())
        {
            Toast.makeText(MyApplication.getContext(),"账号不能为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (password.isEmpty())
        {
            Toast.makeText(MyApplication.getContext(),"密码不能为空",Toast.LENGTH_LONG).show();
            return;
        }

        //存储用户名和密码
        OnlineUserInfo user =new OnlineUserInfo(userName,password);
        IdentityHelper.login(user);
        Intent intent=new Intent(MyApplication.getContext(),MainActivity.class);
        startActivity(intent);
        //关闭自己
        finish();

    }

}
