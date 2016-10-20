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
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Data;

/**
 * @author HaVH
 *
 */
@Data
public class BaseFormDTO {

    /**
     * Menu list in database List<MenuDTO>
     */
    private List<MenuDTO> lsMenu;

    public void convertJSon(String json) throws IllegalArgumentException, IllegalAccessException, JSONException {
        JSONObject jsonObject = new JSONObject(json);

        for (Field f : this.getClass().getDeclaredFields()) {
            // Set access permission for this field
            f.setAccessible(true);
            // Check type of property
            if (jsonObject.has(f.getName().toLowerCase())) {
                if (f.getType().equals(int.class)) {
                    f.set(this, Integer.parseInt(jsonObject.get(f.getName().toLowerCase()).toString()));
                } else if (f.getType().equals(long.class)) {
                    f.set(this, Long.parseLong(jsonObject.get(f.getName().toLowerCase()).toString()));
                } else if (f.getType().equals(double.class)) {
                    f.set(this, Double.parseDouble(jsonObject.get(f.getName().toLowerCase()).toString()));
                } else if (f.getType().equals(float.class)) {
                    f.set(this, Float.parseFloat(jsonObject.get(f.getName().toLowerCase()).toString()));
                } else {
                    f.set(this, f.getType().cast(jsonObject.get(f.getName().toLowerCase()).toString()));
                }
            } else if (f.getType().equals(String.class)) {
                f.set(this, null);
            } else if (f.getType().equals(long.class) || f.getType().equals(int.class) ||
                    f.getType().equals(double.class) || f.getType().equals(float.class)) {
                f.set(this, -1);
            } else if (f.getType().equals(Date.class)) {
                f.set(this, null);
            } else if (f.getType().equals(boolean.class)) {
                f.set(this, false);
            } else {
                f.set(this, null);
            }
        }
    }
}
