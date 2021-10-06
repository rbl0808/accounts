package com.rbl.accounts.utils;

import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author zxd
 * @date 2021/7/15
 */
@Repository
public class CommonUtils {
    /**
     * 生成交易id
     *
     * @param userId
     * @return
     */
    public String getTradeId(String userId) {
        String tmp = System.currentTimeMillis() + userId;
        return DigestUtils.md5DigestAsHex(tmp.getBytes());
    }

    /**
     * 数字转换
     * @param source
     * @return
     */
    public String convert(Integer source) {
        if (source % 100 == 0) {
            return source / 100 + "";
        } else {
            Double res = Double.valueOf(source / 100) + Double.valueOf(source % 100) / 100;
            return new DecimalFormat("0.0").format(res);
        }
    }

    /**
     * list去重 保持插入顺序
     *
     * @param source
     * @return
     */
    public List<String> distinct(List<String> source) {
        List<String> result = new ArrayList<>(new LinkedHashSet<>(source));
        return result;
    }

    /**
     * 初始化类填充默认值
     *
     * @param obj
     */
    public void filling(Object obj) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object o = field.get(obj);
                if (null == o) {
                    String type = field.getType().getName();
                    if ("java.util.List".equals(type)) {
                        field.set(obj, new ArrayList<>());
                    } else if ("java.util.Map".equals(type)) {
                        field.set(obj, new HashMap<>(1));
                    }else if ("java.lang.Integer".equals(type)) {
                        field.set(obj, 0);
                    }else if ("java.lang.String".equals(type)) {
                        field.set(obj, "");
                    } else {
                        Object tmp = null;
                        try {
                            tmp = field.getType().newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                        field.set(obj, tmp);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
