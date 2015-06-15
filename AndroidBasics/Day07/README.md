#Day07笔记多个界面Activity的开发

##AndroidManifest.xml

```xml
<application
        android:allowBackup="true"
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name"
        android:theme="@style/AppTheme" >
        <activity
            android:name="com.timosang.rpcalc.MainActivity"
            android:label="activity1" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity
            android:name="com.timosang.rpcalc.ResultActivity"
            android:label="activity2" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
```

* 一个应用程序可以在桌面创建多个快捷图标。
* activity的名称和应用程序的名称可以不相同
> * activity的名称是配置在activity的label节点里面的
> * 应用程序(application)的名称是配置application的lable节点里面的

* activity的图标和应用程序的图标可以不相同，分别用各自标签里的icon节点指定

###桌面快捷图标创建的方法
通过 intent-filter 意图过滤器来创建的。
* 动作 （入口）
	```xml	
	<action android:name="android.intent.action.MAIN" />
	```
* 类别 （启动器）
		
	```xml
	<category 	android:name="android.intent.category.LAUNCHER" />
    ```

##Intent激活新的Activity的参数
```xml
        <activity
            android:name="com.timosang.rpcalc.ResultActivity"
            android:label="activity2" >
            <intent-filter>
                <action android:name="android.intent.action.SHOWRESULT" />
				<data android:scheme="timosang"/>
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
```
```java
		Intent intent = new Intent();
		intent.setAction("android.intent.action.SHOWRESULT");
		intent.setData(Uri.parse("timosang://aaaa"));
		startActivity(intent);
```
* action 指定动作（可以自定义，可以使用系统自带的）
* data   指定数据（操作什么内容）
* category 类别 （默认类别，机顶盒，车载电脑）


#Intent

