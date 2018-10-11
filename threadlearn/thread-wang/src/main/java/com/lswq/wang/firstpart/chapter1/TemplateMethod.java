package com.lswq.wang.firstpart.chapter1;

/**
 * 标准模板方法
 *
 * @author zhangsw
 */
public abstract class TemplateMethod {

    public final void template() {
        System.err.println(absMethod());
    }

    protected abstract int absMethod();


    public static void main(String[] args) {
        new TemplateMethod() {
            @Override
            protected int absMethod() {
                return 2;
            }
        }.template();
        
        new TemplateMethod() {
            @Override
            protected int absMethod() {
                return 3;
            }
        }.template();
    }
}
