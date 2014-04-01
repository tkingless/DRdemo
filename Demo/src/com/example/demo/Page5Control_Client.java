package com.example.demo;

import com.example.demo.Utils.ConClickListener;
import com.example.demo.Utils.ConDragListener;
import com.example.demo.Utils.ConLongClickListener;
import com.example.demo.Utils.ConTouchListener;

import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Page5Control_Client extends BasePageControl {

	Button btn_back;
	
	
	public Page5Control_Client(View _Page) {
		super(_Page);
	}
	
	@Override
	public void init()
	{
		btn_back = (Button)Page.findViewById(R.id.page5_advertize_btn_back);
		btn_back.setOnClickListener(new ConClickListener(this, "on_btn_back"));
	}
	
	@Override
	public void exit()
	{

	}

}
