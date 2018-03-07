using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public partial class Global
{
    static AndroidJavaClass _jc = null;
    public static AndroidJavaClass jc
    {
        get
        {
            if (_jc == null)
            {
                _jc = new AndroidJavaClass("com.iky.aub.BridgeUtils");
            }
            return _jc;
        }
    }
    public void AndroidCallUnity(string param)
    {
        Debug.Log("u3 SessionId received: " + param);
        Debug.Log("u4 AndroidCallUnity to do");
        jc.CallStatic("Response", 200, "成功");
        Debug.Log("u5 AndroidCallUnity result returned");
    }

    void UnityCallAndroid()
    {
        jc.CallStatic("TestUnityCallAndroid");
        // jc.CallStatic<object>("TestUnityCallAndroid");
        Debug.Log("u2 Test called");
    }

    void OnGUI()
    {
        if (GUILayout.Button("Unity Call Android", GUILayout.Height(50)))
        {
            UnityCallAndroid();
        }
    }
}

public partial class Global : MonoBehaviour
{

    // Use this for initialization
    void Start ()
    {
		
	}
	
	// Update is called once per frame
	void Update ()
    {
	    	
	}
}
