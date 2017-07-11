package io.github.zuston.DesignPattern.Decorator;

import io.github.zuston.DesignPattern.Decorator.Impl.ConsumerDecorator;
import io.github.zuston.DesignPattern.Decorator.Impl.ProviderDecorator;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class Main {
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
