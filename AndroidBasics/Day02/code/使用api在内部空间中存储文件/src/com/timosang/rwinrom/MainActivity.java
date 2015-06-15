package com.timosang.rwinrom;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
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
		// public static final int LENGTH_SHORT = 0;
		// public static final int LENGTH_LONG = 1;

		// Interface to global information about an application environment.
		// This is an abstract class whose implementation is provided by the
		// Android system.
		// It allows access to application-specific resources and classes, as
		// well as
		// up-calls for application-level operations such as launching
		// activities, broadcasting
		// and receiving intents, etc.应用环境全局信息的接口
		// 弹出提示框
		Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

	}

	public void saveAccount(String name, String pwd) {

		try {
			//File file = new File("data/data/com.timosang.rwinrom/files/info.txt");
			File file = new File("data/data/com.timosang.rwinrom/cache/info.txt");
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
			//getFilesDir()：Returns the path of the directory holding application files.
			//得到一个file对象，路径是/data/data/com.timosang.rwinrom/files
			//
			//File file = new File(getFilesDir(),"info.txt");
			//Returns the absolute path to the application specific cache directory on the filesystem. 
			//These files will be ones that get deleted first when the device runs low on storage.
			//比如QQ头像、微信头像会被缓存cache文件夹内
			//得到一个file对象，路径是/data/data/com.timosang.rwinrom/cache
			File file = new File(getCacheDir(),"info.txt");
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
