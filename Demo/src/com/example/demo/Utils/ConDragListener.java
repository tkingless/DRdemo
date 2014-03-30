package com.example.demo.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;

public class ConDragListener implements OnDragListener{

	private Method method = null;
	private Object receiver;
	
	public ConDragListener(Object Receiver, String MethodName)
	{
		receiver = Receiver;
		try {
			method = receiver.getClass().getMethod(MethodName, View.class, DragEvent.class);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onDrag(View v, DragEvent event) {
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
		return true;
	}
}
