package io.github.zuston.DesignPattern.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class BasicDynamicProxy implements InvocationHandler{

    public Object obj ;
    public BasicDynamicProxy(Object o){
        this.obj = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before action");
        method.invoke(obj,args);
        System.out.println("after action");
        return null;
    }
}

interface Action{
    void show();
}

class ProviderAction implements Action{

    public void show() {
        System.out.println("Provider Action");
    }
}

class Main{
    public static void main(String[] args) {
        ProviderAction pa = new ProviderAction();
        InvocationHandler handler = new BasicDynamicProxy(pa);
        ProviderAction proxyObj = (ProviderAction) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                Action.class.getInterfaces(),
                handler
        );
        proxyObj.show();
    }
}