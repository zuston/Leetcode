package io.github.zuston.DesignPattern;

import io.github.zuston.DesignPattern.Decorator.BaseDecorator;
import io.github.zuston.DesignPattern.Decorator.Impl.ConsumerDecorator;
import io.github.zuston.DesignPattern.Decorator.Impl.ProviderDecorator;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class main{
    public static void main(String[] args) {
        // 第一层
        BaseDecorator base = null;
        // provider object
        base = new ProviderDecorator(base);
        // consumer object
        base = new ConsumerDecorator(base);
        base.decorate();
    }
}
