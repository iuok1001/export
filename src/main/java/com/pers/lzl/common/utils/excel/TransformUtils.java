package com.pers.lzl.common.utils.excel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串转换工具类
 * @date 2017-11-12 21:16:39
 * @author zhiliang.liu
 */
public class TransformUtils {

    /**
     * 将json对象字符字符串转换为对象数组
     * @param jsonArrayStr 请求的json对象数组字符串 PS:[{},{}...]
     * @param t 映射的对象类  PS: User.class
     * @param <T> 泛型对象
     * @return 对象数组 List<User>
     * @author zhiliang.liu
     * @date 2017-11-12 21:20:26
     */
    public static <T> List<T> getEntityArray(String jsonArrayStr, Class<T> t) {
        List<T> classArray = new ArrayList<>();
        JSONArray jsonArray = JSONArray.fromObject(jsonArrayStr);
        for (Object jsonObject : jsonArray) {
            T temp = (T) JSONObject.toBean(JSONObject.fromObject(jsonObject), t);
            classArray.add(temp);
        }
        return classArray;
    }

}
