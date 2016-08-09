package com.cblue.designpattern.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cblue.designpattern.*;

public class LoginActivity extends AppCompatActivity {


    EditText et_name,et_pass;
    Button btn_login;
    String name ;
    String password;
    LoginDao loginDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginDao = new LoginDao();
        et_name = (EditText)findViewById(R.id.et_name);
        et_pass = (EditText)findViewById(R.id.et_pass);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录验证
                name = et_name.getText().toString();
                password = et_pass.getText().toString();
                if(name!=null&&password!=null) {
                    User user = new User(name, password);
                    boolean flag = loginDao.validateUser(user);
                    if(flag){
                       Intent intent = new Intent(LoginActivity.this, com.cblue.designpattern.MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "用户名或密码输入错误", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }



}
