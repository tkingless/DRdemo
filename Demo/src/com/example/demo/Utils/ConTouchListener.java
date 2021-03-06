package com.example.demo.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class ConTouchListener implements OnTouchListener{

	private Method method = null;
	private Object receiver;
	
	public ConTouchListener(Object Receiver, String MethodName)
	{
		receiver = Receiver;
		try {
			method = receiver.getClass().getMethod(MethodName, View.class, MotionEvent.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(method != null)
		{
			try {
				method.invoke(receiver, v, event);
			} catch (IllegalArgumentException e) {
				Log.d("onClick", "IllegalArgumentException");
			} catch (IllegalAccessException e) {
				Log.d("onClick", "IllegalAccessException");
			} catch (InvocationTargetException e) {
				Log.d("onClick", "InvocationTargetException");
			}
		}
		return false;
	}
}
