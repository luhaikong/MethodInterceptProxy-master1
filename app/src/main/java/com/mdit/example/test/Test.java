package com.mdit.example.test;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * <pre>
 *     author : zhangke
 *     e-mail : zhangke3016@gmail.com
 *     time   : 2017/05/08
 *     desc   :
 * </pre>
 */

public class Test {

    public void toast1(Context ctx,String msg){
        Log.e("TAG","--"+msg+"----");
    }

    public String test(){
        Log.e("TAG","--test----");
        return "aabbcc";
    }
    public void toast2(Context ctx,String msg){
        Log.e("TAG","--"+msg+"----");
    }

    public void toast3(Context ctx,String msg){
        Log.e("TAG","--"+msg+"----");
    }


}
