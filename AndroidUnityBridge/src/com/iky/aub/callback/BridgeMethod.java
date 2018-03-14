package com.iky.aub.callback;

public class BridgeMethod
{	
	public int Key()
	{
		// may override toString using FuncName
		return this.getClass().getName().hashCode();
	}
	
	public void Callback(String value) 
	{
		// to override by subclass if needed
	}

	// 无参
	public void CallApp()
	{
		// to override by subclass if needed
	}
	
}
