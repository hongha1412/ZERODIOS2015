/**
 * Copyright(C) ZeroDios2015
 *
 * BaseDTO.java, Jul 6, 2016
 * @author: HaVH
 *
 */
package com.zerodios2015.DTO;

import java.lang.reflect.Field;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.zerodios2015.Utils.ZDUtils;

import lombok.Data;

/**
 * @author HaVH
 *
 */
@Data
public class BaseFormDTO {

    public void loadFromJSON(String json) throws IllegalArgumentException, IllegalAccessException, JSONException {
        JSONObject jsonObject = new JSONObject(json);

        for (Field f : this.getClass().getDeclaredFields()) {
            // Set access permission for this field
            f.setAccessible(true);
            // Check type of property
            if (jsonObject.has(f.getName().toLowerCase())) {
                String value = jsonObject.get(f.getName().toLowerCase()).toString();

                if (f.getType().equals(int.class) || Integer.class.isAssignableFrom(f.getType())) {
                    if (ZDUtils.isEmpty(value)) {
                        f.set(this, 0);
                    } else {
                        f.set(this, Integer.parseInt(value));
                    }
                } else if (f.getType().equals(long.class) || Long.class.isAssignableFrom(f.getType())) {
                    if (ZDUtils.isEmpty(value)) {
                        f.set(this, new Long(0));
                    } else {
                        f.set(this, Long.parseLong(value));
                    }
                } else if (f.getType().equals(double.class) || Double.class.isAssignableFrom(f.getType())) {
                    if (ZDUtils.isEmpty(value)) {
                        f.set(this, new Double(0));
                    } else {
                        f.set(this, Double.parseDouble(value));
                    }
                } else if (f.getType().equals(float.class) || Float.class.isAssignableFrom(f.getType())) {
                    if (ZDUtils.isEmpty(value)) {
                        f.set(this, new Float(0));
                    } else {
                        f.set(this, Float.parseFloat(value));
                    }
                } else if (f.getType().equals(Date.class)) {
                    if (ZDUtils.isEmpty(value)) {
                        f.set(this, new Date());
                    } else {
                        f.set(this, new Date(Long.parseLong(value)));
                    }
                } else if (f.getType().equals(boolean.class) || Boolean.class.isAssignableFrom(f.getType())) {
                    if (ZDUtils.isEmpty(value)) {
                        f.set(this, false);
                    } else {
                        f.set(this, Boolean.parseBoolean(value));
                    }
                } else if (String.class.isAssignableFrom(f.getType())) {
                    f.set(this, ZDUtils.escapeDB(value));
                }else {
                    f.set(this, f.getType().cast(value));
                }
            } else if (f.getType().equals(long.class) || f.getType().equals(int.class) ||
                    f.getType().equals(double.class) || f.getType().equals(float.class) ||
                    Long.class.isAssignableFrom(f.getType()) || Integer.class.isAssignableFrom(f.getType()) ||
                    Double.class.isAssignableFrom(f.getType()) || Float.class.isAssignableFrom(f.getType())) {

                f.set(this, -1);
            } else {
                f.set(this, null);
            }
        }
    }
}
