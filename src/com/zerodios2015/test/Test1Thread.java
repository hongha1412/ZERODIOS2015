/**
 * Copyright(C) ZeroDios2015
 *
 * Test1Thread.java, Nov 3, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.test;

/**
 * @author HaVH
 *
 */
public class Test1Thread {
    private int i;

    public Test1Thread() {
        super();
    }

    public void test1Method(int startValue) {
        System.out.println(this.getClass().getName() + " param: " + startValue);
        for (i = startValue; i < 20; i++) {
            System.out.println(this.getClass().getName() + ": " + i);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
