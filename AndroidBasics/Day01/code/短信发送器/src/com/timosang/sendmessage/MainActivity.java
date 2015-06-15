package com.timosang.sendmessage;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private EditText et_number;
	private EditText et_text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void send(View v) {
		et_number = (EditText) findViewById(R.id.et_number);
		et_text = (EditText) findViewById(R.id.et_text);
		String number = et_number.getText().toString().trim();
		String text = et_text.getText().toString().trim();

		SmsManager sm = SmsManager.getDefault();
		/**
		 * Divide a message text into several fragments, none bigger than the
		 * maximum SMS message size.
		 * 
		 * Parameters: text the original message. Must not be null. Returns: an
		 * ArrayList of strings that, in order, comprise the original message
		 * 
		 * */
		ArrayList<String> smss = sm.divideMessage(text);
		/**
		 * Parameters: destinationAddress: the address to send the message
		 * to目标地址 scAddress is the service center address or null to use the
		 * current default SMSC 服务中心地址，如果设置为null则是默认SMSC地址 text :the body of the
		 * message to send 发送的文本内容 sentIntent： if not NULL this PendingIntent is
		 * broadcast when the message is successfully sent, or failed. The
		 * result code will be Activity.RESULT_OK for success,
		 * 
		 * */
		for (String content : smss) {
			sm.sendTextMessage(number, null, content, null, null);
		}
	}

}
