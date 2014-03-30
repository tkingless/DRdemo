package com.example.demo;

import com.example.demo.Utils.ConClickListener;

import android.view.View;
import android.widget.Button;

public class PageChatControl  extends BasePageControl{
	
	Button btn_back;
	
	public PageChatControl(View _Page) {
		
		super(_Page);
		
		btn_back = (Button)Page.findViewById(R.id.chatReturnPrev);
		btn_back.setOnClickListener(new ConClickListener(this, "on_btn_back"));
	}

	
	public void on_btn_back()
	{
		Main.SwitchToPage(Main.page1);
	}
}
