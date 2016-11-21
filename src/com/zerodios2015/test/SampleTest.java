/**
 * Copyright(C) ZeroDios2015
 *
 * SampleTest.java, Nov 3, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.test;

import java.util.ArrayList;
import java.util.List;

import com.zerodios2015.Utils.ZDThread;

/**
 * @author HaVH
 *
 */
public class SampleTest {

    public static void main(String[] args) throws InterruptedException {
        List<ZDThread> lsThread = new ArrayList<>();
        List<Object> lsParam = new ArrayList<>();
        lsParam.add(10);
        lsThread.add(new ZDThread(Test1Thread.class, "test1Method", lsParam));
        lsParam = new ArrayList<>();
        lsParam.add("thread2");
        lsThread.add(new ZDThread(Test2Thread.class, "test2Method", lsParam));

        for (ZDThread t : lsThread) {
            t.start();
        }
    }
}
