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
        //ͨ����Դid��ȡ�������ļ��ж�Ӧ�����
        btn_dial = (Button) findViewById(R.id.btn_dial);	
        //����ť���ü�����
        btn_dial.setOnClickListener(new BtnListener());
    }

    class BtnListener implements OnClickListener{
    		
    	//����ť�����ʱ���˷���������
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//ͨ����Դid��ȡ�������
			et_number= (EditText) findViewById(R.id.et_number);
			//��ȡ����������
			String number = et_number.getText().toString().trim();
			//����ϵͳ���ǵĹ����Ǵ�绰
			Intent intent = new Intent();
			//���ö���action Activity Action: Perform a call to someone specified by the data. 
			intent.setAction(Intent.ACTION_CALL);//String android.content.Intent.ACTION_CALL = "android.intent.action.CALL"
			//��������
			intent.setData(Uri.parse("tel:"+number));
			//������绰Ӧ��,����ͼ����ϵͳ
			startActivity(intent);
		}}

 }
