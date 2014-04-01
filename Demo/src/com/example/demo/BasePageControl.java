package com.example.demo;

import android.util.Log;
import android.view.View;

public class BasePageControl{
	protected View Page;
	protected MainActivity Main;
	public BasePageControl(View _Page) {
		Main = MainActivity.Main;
		Page = _Page;
		Log.d("Construct Page Control", Page.toString());
	}
	
	public void init()
	{
		
	}
	
	public void exit()
	{
		
	}

}
