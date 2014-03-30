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

public class ClientPageControl extends BasePageControl{
	
	ImageButton btn_p1_company;
	
	public ClientPageControl(View _Page) {
		super(_Page);
	}
	
	@Override
	protected void init()
	{
		btn_p1_company = (ImageButton) Page.findViewById(R.id.btn_p1_company);
		btn_p1_company.setOnTouchListener(new ConTouchListener(this, "on_btn_p1_company_touch"));
		btn_p1_company.setOnClickListener(new ConClickListener(this, "on_btn_p1_company"));
	}
	
	public void on_btn_p1_company_touch()
	{
		btn_p1_company.setImageResource(R.drawable.btn_demo_company_down);
	}
	
	public void on_btn_p1_company()
	{
		Log.d("on_btn_p1_company", "hihi4");
		btn_p1_company.setImageResource(R.drawable.btn_demo_company);
	}

}
