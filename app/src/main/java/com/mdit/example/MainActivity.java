package com.mdit.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mdit.example.test.Test;
import com.mdit.library.proxy.CallbackFilter;
import com.mdit.library.proxy.Enhancer;
import com.mdit.library.proxy.MethodInterceptor;
import com.mdit.library.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View v){
        Enhancer enhancer = new Enhancer(this);
        enhancer.setSuperclass(Test.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept  -- after---");
                return obj;
            }
        });
        Test test = (Test) enhancer.create();

        test.toast1(this,"111111");
    }

    public void click2(View v){
        Enhancer enhancer = new Enhancer(this);
        enhancer.setSuperclass(Test.class);
        enhancer.setCallbacks(new MethodInterceptor[]{new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept0  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept0  -- after---");
                return obj;
            }
        },new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept1  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept1  -- after---");
                return obj;
            }
        },new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept2  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept2  -- after---");
                return obj;
            }
        },new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Object[] args, MethodProxy methodProxy) throws Exception {
                Log.e("TAG","intercept3  -- before---");
                Object obj = methodProxy.invokeSuper(object, args);
                Log.e("TAG","intercept3  -- after---");
                return obj;
            }
        }});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                Log.e("TAG","Method修饰符:"+ Modifier.toString(method.getModifiers()));
                Log.e("TAG","Method返回值:"+ method.getReturnType());
                Log.e("TAG","Method方法名称:"+ method.getName());
                Log.e("TAG","Method参数列表:"+ Arrays.toString(method.getParameterTypes()));
                if (method.getName().equals("toast1"))
                    return 1;
                if (method.getName().equals("toast2"))
                    return 2;
                if (method.getName().equals("toast3"))
                    return 3;
                return 0;
            }
        });
        Test test = (Test) enhancer.create();

        test.test();
        test.toast1(this,"111111");
        test.toast2(this,"222222");
        test.toast3(this,"333333");
    }
}
