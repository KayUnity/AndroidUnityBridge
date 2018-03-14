package com.iky.aub.method;

import com.iky.aub.BridgeUtils;

import android.util.Log;

public class BridgeSessionMethod extends BridgeMethod
{
	private final static String FuncSession = "AndroidCallUnity";

	@Override
	public void Callback(String value)
	{
		try
		{
			// may throw exception
			int sid = Integer.parseInt(value);
			// to do
			Log.i("test_android", "sid: " + sid);
		}
		catch (Exception e)
		{
			
		}
	}

	@Override
	public void CallApp()
	{
		BridgeUtils.Request(FuncSession, "", this);
		Log.e("abu", "a2");
	}
	
	@Override
	public String toString()
	{
		return FuncSession;
	}
}
