package com.timosang.clickevent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    private Button btn_click1;
    private Button btn_click2;
    private Button btn_click3;
    private Button btn_click4;
    private Button btn_click31;
    private Button btn_click32;
    private Button btn_click33;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //第一种
        btn_click1=(Button) findViewById(R.id.btn_clickevent1);
        btn_click1.setOnClickListener(new MyClickListener());
       //第二种
        btn_click2 = (Button) findViewById(R.id.btn_clickevent2);
        btn_click2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			System.out.println("这是第二种");	
			}
		});
        //第三种
        btn_click3 = (Button) findViewById(R.id.btn_clickevent3);
        btn_click3.setOnClickListener(this);//this至MainActivity这个类
    
        //三1、2、3
        btn_click31 = (Button) findViewById(R.id.btn_clickevent31);
        btn_click32= (Button) findViewById(R.id.btn_clickevent32);
        btn_click33= (Button) findViewById(R.id.btn_clickevent33);
        btn_click31.setOnClickListener(new MyClickListener());
        btn_click32.setOnClickListener(new MyClickListener());
        btn_click33.setOnClickListener(new MyClickListener());
//        MyClickListener   ml = new MyClickListener();
//        //不同的按钮使用同一个监听对象也是可以的
//        btn_click31.setOnClickListener(ml);
//        btn_click32.setOnClickListener(ml);
//        btn_click33.setOnClickListener(ml);
        
        
	}
	class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			int i = v.getId();
			// TODO Auto-generated method stub
			switch (i) {
			case R.id.btn_clickevent31:
				System.out.println("31");
				break;
			case R.id.btn_clickevent32:
				System.out.println("32");
				break;
			case R.id.btn_clickevent33:
				System.out.println("33");
				break;

			case R.id.btn_clickevent1:
				System.out.println("1");
				break;
			}
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("这是第三种");
	}
	
	public void click(View v){
		System.out.println("这是第四种");
	}
}
