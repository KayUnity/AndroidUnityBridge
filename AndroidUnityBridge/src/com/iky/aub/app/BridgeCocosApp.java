
package com.iky.aub.app;

public class BridgeCocosApp implements BridgeApp
{
	// 针对  Cocos2d
	public native static void CallCocos2d(String funcName, String params);
	
	/*  
	 * 1 JNI 需要初始化 
	    JniMethodInfo minfo;
	    //getStaticMethodInfo判断java定义的静态函数是否存在，返回bool
	    bool ret = JniHelper::getStaticMethodInfo(minfo, "com/iky/aub/BridgeUtils", "Response", "(ILjava/lang/String)V");
	   2 JNI 调用后，需要回调时调用
	    minfo.env->CallStaticVoidMethod(minfo.classID, minfo.methodID, key, result);
    */
	
	@Override
	public void Request(String funcName, String params)
	{
		CallCocos2d(funcName, params);
	}
	
}
