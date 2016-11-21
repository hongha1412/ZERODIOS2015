/**
 * Copyright(C) ZeroDios2015
 *
 * Test2Thread.java, Nov 3, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.test;

/**
 * @author HaVH
 *
 */
public class Test2Thread {
    public Test2Thread() {
        super();
    }

    public void test2Method(String assignValue) {
        for (int j = 0; j < 20; j++) {
            System.out.println(this.getClass().getName() + " " + assignValue + ": " + j);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
