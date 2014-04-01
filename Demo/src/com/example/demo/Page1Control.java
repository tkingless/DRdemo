package com.example.demo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.demo.Utils.*;

public class Page1Control extends BasePageControl{
	
	ImageButton btn_p1_company;
	Button btn_back;
	
	public Page1Control(View _Page) {
		super(_Page);
	}
	
	@Override
	public void init()
	{
		btn_p1_company = (ImageButton) Page.findViewById(R.id.page1_list_btn_company);
		btn_p1_company.setOnTouchListener(new ConTouchListener(this, "on_btn_company_touch"));
		btn_p1_company.setOnClickListener(new ConClickListener(this, "on_btn_company"));
		
		btn_back = (Button)Page.findViewById(R.id.page1_list_btn_back);
		btn_back.setOnClickListener(new ConClickListener(this, "on_btn_back"));
	}
	
	public void exit()
	{
		btn_p1_company.setOnTouchListener(null);
		btn_p1_company.setOnClickListener(null);
		btn_back.setOnClickListener(null);
	}
	
	public void on_btn_company_touch(View v, MotionEvent event)
	{
		btn_p1_company.setImageResource(R.drawable.btn_demo_company_down);
	}
	
	public void on_btn_company(View v)
	{
		Log.d("on_btn_p1_company", "hihi4");
		btn_p1_company.setImageResource(R.drawable.btn_demo_company);
		Main.SwitchToPage(Main.chatPage, Main.pageChatControl);
	}
	
	public void on_btn_back(View v)
	{
		Main.SwitchToPage(Main.mainPage, null);
	}

}
