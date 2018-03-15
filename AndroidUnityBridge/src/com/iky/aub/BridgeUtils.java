package com.iky.aub;

import java.util.concurrent.ConcurrentHashMap;

import com.iky.aub.app.BridgeApp;
import com.iky.aub.app.BridgeCocosApp;
import com.iky.aub.app.BridgeUnityApp;
import com.iky.aub.method.BridgeMethod;
import com.iky.aub.method.BridgeSessionMethod;

import android.util.Log;

/*
 * 
 * 1 需要回调的函数， 提供 BridgeAbstractCallback 实例
 * 2 不需要回调的函数，可以直接调用 Request，将函数名写在 BridgeConstant里
 * 
 * */
public class BridgeUtils
{
	private static ConcurrentHashMap<Integer, BridgeMethod> mCallbacks = new ConcurrentHashMap<>();
	
	private static BridgeApp app = null;

	static 
	{
		try 
		{
			Class<?> clazz = Class.forName("com.unity3d.player.UnityPlayer");
			if (clazz != null)
			{
				app = new BridgeUnityApp(clazz.getMethod("UnitySendMessage", String.class, String.class, String.class));	
			}
		} 
		catch (Exception e)
		{
			app = new BridgeCocosApp();
		}
	}
	
	public static void Request(String funcName, String params, BridgeMethod handler)
	{
		Log.e("abu", "a3");
		try
		{
			String temp = params; 
			if (handler != null)
			{
				int key = handler.Key();
				if (!mCallbacks.containsKey(key))
				{
					mCallbacks.put(key, handler);
				}
				temp = String.format("%s%s%d", temp, BridgeConstant.SplitFlag, key);
			}
			app.Request(funcName, temp);
			Log.e("abu", "a4");
		}
		catch (Exception e)
		{
			
		}
	}
	
	public static void Response(int key, String result)
	{
		if (mCallbacks.containsKey(key))
		{
			mCallbacks.get(key).Callback(result);
			Log.e("abu", "a6");
		}
		Log.e("abu", "a7");
	}
	
	public static void Remove(BridgeMethod handler)
	{
		if (handler != null)
		{
			int key = handler.Key();
			if (!mCallbacks.containsKey(key))
			{
				mCallbacks.remove(key);
			}
		}
	}
	
	public static void Test()
	{
		BridgeSessionMethod sessionCallback = new BridgeSessionMethod();
		sessionCallback.CallApp();
		Log.e("abu", "a1");
	}

}
