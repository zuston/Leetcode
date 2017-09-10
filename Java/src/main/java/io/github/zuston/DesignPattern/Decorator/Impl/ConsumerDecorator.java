package io.github.zuston.DesignPattern.Decorator.Impl;

import io.github.zuston.DesignPattern.Decorator.BaseDecorator;

/**
 * Created by zhang_jf on 2017/7/7.
 */
public class ConsumerDecorator extends BaseDecorator{

    public ConsumerDecorator(BaseDecorator baseDecorator) {
        super(baseDecorator);
    }

    public void decorate() {
        System.out.println("Consumer Decorator");
        if (_tail != null){
            _tail.decorate();
        }
    }
}
