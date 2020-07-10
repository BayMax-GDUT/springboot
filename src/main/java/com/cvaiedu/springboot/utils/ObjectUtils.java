package com.cvaiedu.springboot.utils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 对对象或者对象集合进行处理的工具类，使用泛型通用化
 * @param <T>
 */
public class ObjectUtils<T> {

    public ObjectUtils() {}

    /**
     * 灵活根据不同的类字段对集合进行排序（冒泡）
     * @param list 对象集合
     * @param fieldName 对象字段 字段权限等级必须要本类可以访问到
     */
    public void sortByField(List<T> list, String fieldName) {
        try {
            Field field = list.get(0).getClass().getField(fieldName);
            field.setAccessible(true);
            for(int i = 0; i < list.size() - 1; i++) {
                boolean bool = false;
                for(int j = 0; j < list.size() - i - 1; j++) {
                    if (Long.valueOf(field.get(list.get(j)).toString()) > Long.valueOf(field.get(list.get(j + 1)).toString())) {
                        bool = true;
                        // 交换位置
                        T temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                    }
                }
                // 优化 整个循环没有进行过改变 则全部位置都正确 直接跳出循环
                if (!bool) {
                    break;
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }
}
