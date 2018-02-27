package com.bin.studentmanager;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by xiaolang on 2018/2/22.
 */

public class Login extends AppCompatActivity {
    private EditText mUser; // 帐号编辑框
    private EditText mPassword; // 密码编辑框
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login_layout);

        mUser = findViewById(R.id.login_user_edit);
        mPassword = findViewById(R.id.login_passwd_edit);
    }

    //主界面
    public void login_mainweixin(View v) {

        //测试用
        if (true) {
            Intent intent = new Intent();
            intent.setClass(Login.this, CameraOpenActivity.class);
            startActivity(intent);
            return;
        }

        if ("xbin".equals(mUser.getText().toString()) && "123456".equals(mPassword.getText().toString())) {
            Intent intent = new Intent();
            intent.setClass(Login.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
        } else if ("xbin".equals(mUser.getText().toString()) && "123456".equals(mPassword.getText().toString())) {

        } else if ("".equals(mUser.getText().toString()) || "".equals(mPassword.getText().toString())) {
            new AlertDialog.Builder(Login.this)
//                    .setIcon(getResources().getDrawable(R.drawable.login_error_icon))//过时
                    .setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.login_error_icon, null))
                    .setTitle("登录错误")
                    .setMessage("微信帐号或者密码不能为空，\n请输入后再登录！")
                    .create()//为什么不使用create()函数也可以弹出对话框？
                    .show();

        } else {
            new AlertDialog.Builder(Login.this)
                    .setIcon(ResourcesCompat.getDrawable(getResources(), R.drawable.login_error_icon, null))
                    .setTitle("登录错误")
                    .setMessage("微信帐号或者密码不正确，\n请检查后重新输入！")
                    .create()
                    .show();
        }

        //登录按钮
    	/*
      	Intent intent = new Intent();
		intent.setClass(Login.this,Whatsnew.class);
		startActivity(intent);
		Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
		this.finish();*/
    }

    //返回
    public void login_back(View v) {     //标题栏 返回按钮
        this.finish();
    }

    //忘记密码
    public void login_pw(View v) {
        Uri uri = Uri.parse("http://3g.qq.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        //Intent intent = new Intent();
        //intent.setClass(Login.this,Whatsnew.class);
        //this.finish();
    }

}