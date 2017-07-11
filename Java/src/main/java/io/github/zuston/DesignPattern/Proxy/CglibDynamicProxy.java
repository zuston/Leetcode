package io.github.zuston.DesignPattern.Proxy;

import net.sf.cglib.core.ClassGenerator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class CglibDynamicProxy implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before action");
        methodProxy.invokeSuper(o,objects);
        System.out.println("before action");

        return null;
    }

    private Object obj ;

    public Object getProxyInstance(Object target){
        this.obj = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}

class ProviderAnotherAction{
    public void show(){
        System.out.println("provider action");
    }
}

class MainAnother{
    public static void main(String[] args) {
        CglibDynamicProxy proxy = new CglibDynamicProxy();
        ProviderAnotherAction action = (ProviderAnotherAction) proxy.getProxyInstance(new ProviderAnotherAction());
        action.show();
    }
}
