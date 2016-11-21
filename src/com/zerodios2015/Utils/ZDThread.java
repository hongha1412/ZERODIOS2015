/**
 * Copyright(C) ZeroDios2015
 *
 * ZDMultiThread.java, Nov 3, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author HaVH
 *
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ZDThread extends Thread {

    private Class<?> mainThread;
    private String runMethod;
    private List<Object> lsParam;
    public Object returnValue;

    private Map<String,Class<?>> builtInMap = new HashMap<String, Class<?>>();
    {
        builtInMap.put("java.lang.Integer", int.class );
        builtInMap.put("java.lang.Long", long.class );
        builtInMap.put("java.lang.Double", double.class );
        builtInMap.put("java.lang.Float", float.class );
        builtInMap.put("java.lang.Boolean", boolean.class );
        builtInMap.put("java.lang.Character", char.class );
        builtInMap.put("java.lang.Byte", byte.class );
        builtInMap.put("java.lang.Void", void.class );
        builtInMap.put("java.lang.Short", short.class );
    }

    /**
     * Default constructor
     */
    public ZDThread() {
        this.mainThread = null;
        this.runMethod = null;
        this.lsParam = null;
    }

    public ZDThread(Class<?> mainThread, String runMethod) {
        this.mainThread = mainThread;
        this.runMethod = runMethod;
        this.lsParam = null;
    }

    public ZDThread(Class<?> mainThread, String runMethod, List<Object> lsParam) {
        this.mainThread = mainThread;
        this.runMethod = runMethod;
        this.lsParam = lsParam;
    }

    public boolean checkValid() {
        if (this.mainThread == null || ZDStringUtils.isEmpty(runMethod)) {
            return false;
        }
        try {
            Class.forName(this.mainThread.getName());
        } catch (ClassNotFoundException ex) {
            return false;
        }
        for (Method method : this.mainThread.getDeclaredMethods()) {
            if (method.getName().equals(this.runMethod)) {
                return true;
            }
        }
        return false;
    }

    /* (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        if (!checkValid()) {
            t.destroy();
            ZDLogUtils.log(Level.WARNING, this, null, "Thread " + this.mainThread.getName() + " not valid");
            return;
        }

        try {
            List<Class<?>> lsParamType = lsParam.stream().map(x -> {
                // Change param type to primitive
                if (builtInMap.containsKey(x.getClass().getName())) {
                    return builtInMap.get(x.getClass().getName());
                }
                return x.getClass();
            }).collect(Collectors.toList());

            Class<?>[] paramArr = new Class<?>[lsParamType.size()];
            lsParamType.toArray(paramArr);
            Object o = this.mainThread.newInstance();
            Method m = o.getClass().getMethod(this.runMethod, paramArr);

            m.setAccessible(true);
            m.invoke(o, lsParam.toArray());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            ZDLogUtils.log(Level.WARNING, this, e, e.getCause().toString());
            t.interrupt();
        }
    }

}
