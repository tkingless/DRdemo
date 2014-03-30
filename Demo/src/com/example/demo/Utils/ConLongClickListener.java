package com.example.demo.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.View;
import android.view.View.OnLongClickListener;

public class ConLongClickListener implements OnLongClickListener{

	private Method method = null;
	private Object receiver;
	
	public ConLongClickListener(Object Receiver, String MethodName)
	{
		receiver = Receiver;
		try {
			method = receiver.getClass().getMethod(MethodName, View.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		if(method != null)
		{
			try {
				method.invoke(receiver, v);
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
