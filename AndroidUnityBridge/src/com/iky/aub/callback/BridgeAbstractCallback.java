package com.iky.aub.callback;

public class BridgeAbstractCallback
{	
	public int Key()
	{
		// may override toString using FuncName
		return this.toString().hashCode();
	}
	
	public void Handle(String value) 
	{
		// to override by subclass if needed
	}

	// 无参
	public void CallUnity()
	{
		// to override by subclass if needed
	}
	
	// 带参
	public void CallUnity(String params)
	{
		// to override by subclass if needed
	}
	
}
