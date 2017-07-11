package io.github.zuston.DesignPattern.Decorator;

import java.util.BitSet;

/**
 * Created by zhang_jf on 2017/7/7.
 */

/**
 *
 * 业务中用的很精妙
 *
 * 装饰器 实现一条是否装饰的链式结构
 *
 * 代理模式 的区别？也可以实现链式结构
 *
 * ??? 之前实现 aop 框架的时候实现链式代理的结构
 *
 */
public abstract class BaseDecorator {

    protected BaseDecorator _tail;

    public BaseDecorator(BaseDecorator baseDecorator){
        _tail = baseDecorator;
    }

    public abstract void decorate();
}


/**
 * 自己的理解是：巧用了 baseDecorator 的 tail 来实现原有链式队列。
 */
