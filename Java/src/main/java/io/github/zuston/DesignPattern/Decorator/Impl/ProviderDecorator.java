package io.github.zuston.DesignPattern.Decorator.Impl;

import io.github.zuston.DesignPattern.Decorator.BaseDecorator;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class ProviderDecorator extends BaseDecorator{

    public ProviderDecorator(BaseDecorator baseDecorator) {
        super(baseDecorator);
    }

    public void decorate() {
        System.out.println("Provider Decorator");
        if (_tail != null){
            _tail.decorate();
        }
    }
}
