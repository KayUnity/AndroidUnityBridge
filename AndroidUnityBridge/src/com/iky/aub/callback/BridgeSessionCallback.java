package com.iky.aub.callback;

import com.iky.aub.BridgeUtils;

import android.util.Log;

public class BridgeSessionCallback extends BridgeAbstractCallback
{
	private final static String FuncSession = "AndroidCallUnity";

	@Override
	public void Handle(String value)
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
	public void CallUnity()
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
