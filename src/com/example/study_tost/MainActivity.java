package com.example.study_tost;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button bt_default;
	private Toast toast;
	private Button bt_custom;
	private Button bt_custom_image;
	private Button bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**默认样式吐司*/
		bt_default = (Button) findViewById(R.id.bt_default);
		bt_default.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("static-access")
			@Override
			public void onClick(View arg0) {
				new Toast(getApplication()).makeText(getApplication(), "默认样式",
						toast.LENGTH_SHORT).show();
			}
		});
		/**自定义位置吐司*/
		bt_custom = (Button) findViewById(R.id.bt_custom);
		bt_custom.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("static-access")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				toast = new Toast(getApplicationContext()).makeText(
						getApplication(), "自定义位置吐司", toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		});
		/**自定义带图片的吐司*/
		bt_custom_image = (Button) findViewById(R.id.bt_custom_image);
		bt_custom_image.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("static-access")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				toast = new Toast(getApplicationContext()).makeText(
						getApplicationContext(), "我是自定义带图片吐司",
						toast.LENGTH_LONG);
				LinearLayout ll = (LinearLayout) toast.getView();
				ImageView image = new ImageView(getApplicationContext());
				image.setBackgroundResource(R.drawable.ic_launcher);
				ll.addView(image, 100, 100);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
		});
		/**完全自定义吐司*/
		bt = (Button) findViewById(R.id.bt);
		bt.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("static-access")
			@Override
			public void onClick(View arg0) {
				LayoutInflater inflater = (LayoutInflater) getApplicationContext()
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View v = inflater.inflate(R.layout.activity_toast,
						(ViewGroup) findViewById(R.id.toast));
				toast = new Toast(getApplicationContext());
				
				toast.setView(v);
				toast.setGravity(Gravity.BOTTOM, 0, 0);
				toast.setDuration(toast.LENGTH_SHORT);
				toast.show();
			}
		});
	}
}
