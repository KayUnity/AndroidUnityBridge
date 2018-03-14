package com.iky.aub.app;

import java.lang.reflect.Method;

import com.iky.aub.BridgeConstant;

public class BridgeUnityApp implements BridgeApp
{
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
			mUnitySendMessage.invoke(null, BridgeConstant.GlobalGameObjectName, funcName, params);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
