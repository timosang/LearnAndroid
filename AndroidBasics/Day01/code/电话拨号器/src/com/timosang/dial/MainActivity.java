package com.timosang.dial;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private Button btn_dial;
	private EditText et_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //通过资源id获取到布局文件中对应的组件
        btn_dial = (Button) findViewById(R.id.btn_dial);	
        //给按钮设置监听器
        btn_dial.setOnClickListener(new BtnListener());
    }

    class BtnListener implements OnClickListener{
    		
    	//当按钮被点击时，此方法被调用
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//通过资源id获取到输入框
			et_number= (EditText) findViewById(R.id.et_number);
			//获取输入框的内容
			String number = et_number.getText().toString().trim();
			//告诉系统我们的工作是打电话
			Intent intent = new Intent();
			//设置动作action Activity Action: Perform a call to someone specified by the data. 
			intent.setAction(Intent.ACTION_CALL);//String android.content.Intent.ACTION_CALL = "android.intent.action.CALL"
			//设置数据
			intent.setData(Uri.parse("tel:"+number));
			//启动打电话应用,把意图告诉系统
			startActivity(intent);
		}}

 }
