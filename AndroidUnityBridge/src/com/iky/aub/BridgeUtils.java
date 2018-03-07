package com.iky.aub;

import java.util.concurrent.ConcurrentHashMap;

import com.iky.aub.callback.BridgeAbstractCallback;
import com.iky.aub.callback.BridgeSessionCallback;
import com.unity3d.player.UnityPlayer;

import android.util.Log;

/*
 * 
 * 1 Unity主动调用的函数写在此类中
 * 2 需要回调的函数， 提供 BridgeAbstractCallback 实例
 * 3 不需要回调的函数，可以直接调用 Request，将函数名写在 BridgeConstant里
 * 
 * */
public class BridgeUtils
{
	private static ConcurrentHashMap<Integer, BridgeAbstractCallback> mCallbacks = new ConcurrentHashMap<>();
	
	public static void Request(String funcName, String params, BridgeAbstractCallback handler)
	{
		Log.e("abu", "a3");
		// Android call Unity
		if (handler != null)
		{
			int key = handler.Key();
			if (!mCallbacks.containsKey(key))
			{
				mCallbacks.put(key, handler);
			}
			UnityPlayer.UnitySendMessage(BridgeConstant.GlobalGameObjectName, funcName, 
					String.format("%s%s%d", params, BridgeConstant.SplitFlag, key));
			Log.e("abu", "a4");
		}
		else
		{
			// no callback
			UnityPlayer.UnitySendMessage(BridgeConstant.GlobalGameObjectName, funcName, params);
			Log.e("abu", "a5");
		}
	}
	
	public static void Response(int key, String result)
	{
		if (mCallbacks.containsKey(key))
		{
			mCallbacks.get(key).Handle(result);
			Log.e("abu", "a6");
		}
		Log.e("abu", "a7");
	}
	
	public static void Remove(BridgeAbstractCallback handler)
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
	
	public static void TestUnityCallAndroid()
	{
		BridgeSessionCallback sessionCallback = new BridgeSessionCallback();
		sessionCallback.CallUnity();
		Log.e("abu", "a1");
	}
}
