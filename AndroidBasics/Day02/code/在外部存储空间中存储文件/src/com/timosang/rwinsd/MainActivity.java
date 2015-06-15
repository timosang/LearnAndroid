package com.timosang.rwinsd;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText et_username;
	private EditText et_password;
	private CheckBox cb_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		readAccout();
	}

	public void click(View v) {
		// 获得账号和密码
		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		String username = et_username.getText().toString().trim();
		String password = et_password.getText().toString().trim();

		// 获取选框组件
		cb_register = (CheckBox) findViewById(R.id.cb_register);
		// 检测选框是否被勾选
		if (cb_register.isChecked()) {
			saveAccount(username,password);
		}
		Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

	}

	public void saveAccount(String name, String pwd) {
		//判断sd卡的状态
		//Environment.getExternalStorageState();
		//Environment.MEDIA_REMOVED;//手机没插sd卡getExternalStorageState() returns MEDIA_REMOVED if the media is not present.
		//Environment.MEDIA_CHECKING //手机插了sd卡，正在检测，比如开机getExternalStorageState() returns MEDIA_CHECKING if the media is present and being disk-checked
		//Environment.MEDIA_MOUNTED//可读写getExternalStorageState() returns MEDIA_MOUNTED if the media is present and mounted at its mount point with read/write access. 

		try {
			//File file = new File("mnt/sdcard/info.txt");
			//Environment.getExternalStorageDirectory()得到sd卡的真实路径
			File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write((name + "##" + pwd).getBytes());
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readAccout() {

		try {
			File file = new File(Environment.getExternalStorageDirectory(),"info.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
			String text = bis.readLine();
			String[] s = text.split("##");
			et_username=(EditText) findViewById(R.id.et_username);
			et_password=(EditText) findViewById(R.id.et_password);
			et_username.setText(s[0]);
			et_password.setText(s[1]);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
