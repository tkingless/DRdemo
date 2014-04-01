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

public class Page5Control_Company extends BasePageControl {

	Button btn_back;
	View CurrentDraggingView = null;
	float touchX;
	float touchY;
	
	
	public Page5Control_Company(View _Page) {
		super(_Page);
	}
	
	@Override
	public void init()
	{
		btn_back = (Button)Page.findViewById(R.id.page5_advertize_btn_back);
		btn_back.setOnClickListener(new ConClickListener(this, "on_btn_back"));
		for(int i=0; i<((ViewGroup)Page).getChildCount(); ++i) {
		    View child = ((ViewGroup)Page).getChildAt(i);
		    if(child.getClass() == ImageView.class)
		    {
		    	child.setOnLongClickListener(new ConLongClickListener(this, "ImageOnLongClick"));
		    }
		}
		Page.setOnDragListener(new ConDragListener(this, "ImageOnDrag" ));
	}
	
	@Override
	public void exit()
	{
		for(int i=0; i<((ViewGroup)Page).getChildCount(); ++i) {
		    View child = ((ViewGroup)Page).getChildAt(i);
		    if(child.getClass() == ImageView.class)
		    {
		    	child.setOnLongClickListener(null);
		    }
		}
		Page.setOnDragListener(null);
	}
	
	
	public void ImageOnDrag(View v, DragEvent event)
	{
		
		switch (event.getAction()) 
		{
		case DragEvent.ACTION_DROP:
			touchX = event.getX();
			touchY = event.getY();
			break;
		case DragEvent.ACTION_DRAG_ENDED:
			if(CurrentDraggingView != null)
			{
				CurrentDraggingView.setX(touchX - CurrentDraggingView.getWidth()/2);
				CurrentDraggingView.setY(touchY - CurrentDraggingView.getHeight()/2);
				CurrentDraggingView.setVisibility(View.VISIBLE);
				CurrentDraggingView = null;
			}
			break;
		}
	}
	
	public void ImageOnLongClick(View v)
	{
		if(CurrentDraggingView == null)
		{
			CurrentDraggingView = v;
			CurrentDraggingView.setVisibility(View.INVISIBLE);
			ClipData data = ClipData.newPlainText("", "");
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
			v.startDrag(data, shadowBuilder, v, 0);
		}
	}
	
	public void on_btn_back(View v)
	{
		Main.SwitchToPage(Main.mainPage, null);
	}

}
