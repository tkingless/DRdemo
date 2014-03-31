package com.example.demo;

import com.example.demo.Utils.ConClickListener;

import android.view.View;
import android.widget.Button;

public class Page6ProductControl extends BasePageControl {
	
	Button btn_back;
	
public Page6ProductControl(View _Page) {
		
		super(_Page);
		
		btn_back = (Button)Page.findViewById(R.id.product_returnPrev);
		btn_back.setOnClickListener(new ConClickListener(this, "on_btn_back"));
	}

public void on_btn_back(View v)
{
	Main.SwitchToPage(Main.chatPage);

}
	

}
