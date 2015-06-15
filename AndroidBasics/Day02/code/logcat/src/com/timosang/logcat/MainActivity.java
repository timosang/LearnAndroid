package com.timosang.logcat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("logcat", "加油同学们");
		Log.d("logcat", "加油同学们");
		Log.i("logcat", "加油同学们");
		Log.w("logcat", "加油同学们");
		Log.e("logcat", "加油同学们");

	}

}
