package com.example.demo.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ConClickListener implements OnClickListener{

	private Method method = null;
	private Object receiver;
	
	public ConClickListener(Object Receiver, String MethodName)
	{
		receiver = Receiver;
		try {
			method = receiver.getClass().getMethod(MethodName);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(method != null)
		{
			try {
				method.invoke(receiver);
			} catch (IllegalArgumentException e) {
				Log.d("onClick", "IllegalArgumentException");
			} catch (IllegalAccessException e) {
				Log.d("onClick", "IllegalAccessException");
			} catch (InvocationTargetException e) {
				Log.d("onClick", "InvocationTargetException");
			}
		}
	}
}
