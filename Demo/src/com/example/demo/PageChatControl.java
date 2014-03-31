package com.example.demo;

import com.example.demo.Utils.ConClickListener;

import android.view.View;
import android.widget.Button;

public class PageChatControl  extends BasePageControl{
	
	Button btn_back;
	Button btn_companyService;
	Button btn_product;
	
	View view_CSPopup;
	
	public PageChatControl(View _Page) {
		
		super(_Page);
		
		btn_back = (Button)Page.findViewById(R.id.chatReturnPrev);
		btn_companyService = (Button)Page.findViewById(R.id.chat_companyService);
		btn_product = (Button)Page.findViewById(R.id.chat_product);
		view_CSPopup = (View)Page.findViewById(R.id.chatPopup);
		
		btn_back.setOnClickListener(new ConClickListener(this, "on_btn_back"));
		btn_companyService.setOnClickListener(new ConClickListener(this, "on_btn_CS"));
		btn_product.setOnClickListener(new ConClickListener(this, "on_btn_product"));
		
		
		
		view_CSPopup.setVisibility(4); //0 : visible, 4: invisible, 8: gone
	}

	
	public void on_btn_CS (View v) {
		
		if (view_CSPopup.isShown())
		{
			view_CSPopup.setVisibility(4);
		}else
			view_CSPopup.setVisibility(0);
		
	}
	
	public void on_btn_product (View v) {
		
		Main.SwitchToPage(Main.productPage6);
		resetPopUp();
	}
	
	public void on_btn_back(View v)
	{
		Main.SwitchToPage(Main.page1);
		resetPopUp();
	}
	
	void resetPopUp () {
		
		view_CSPopup.setVisibility(4);
	}
}
