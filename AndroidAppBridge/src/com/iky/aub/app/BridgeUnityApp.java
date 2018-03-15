package com.iky.aub.app;

import java.lang.reflect.Method;

public class BridgeUnityApp implements BridgeApp
{
	private final static String GlobalGameObjectName = "Global";
	// 针对  Unity3d
	private Method mUnitySendMessage = null;	
	public BridgeUnityApp(Method method)
	{
		mUnitySendMessage = method;
	}
	
	@Override
	public void Request(String funcName, String params) 
	{
		try 
		{
			mUnitySendMessage.invoke(null, GlobalGameObjectName, funcName, params);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
