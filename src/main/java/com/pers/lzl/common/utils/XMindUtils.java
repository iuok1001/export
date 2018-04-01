package com.pers.lzl.common.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

import java.util.Iterator;

public class XMindUtils {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("[{\"code\":\"QISHON\",\"id\":1,\"text\":\"启尚科技\"},{\"code\":\"QS_DEV\",\"id\":2,\"text\":\"启尚开发\"},{\"code\":\"SHOP_MARK\",\"id\":3,\"text\":\"购物平台\"}]");
        StringBuffer result = transform2Str(new JSONTokener(str.toString()).nextValue(), 0);
        System.out.println(result.toString().replaceAll("\n\n","\n"));
        System.out.println("ok");
    }

    private static StringBuffer transform2Str(Object object, Integer level) {
        StringBuffer result = new StringBuffer("");
        if (object instanceof JSONNull) {
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += "\t";
            }
            return new StringBuffer(temp + "null");
        } else if (object instanceof Boolean) {
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += "\t";
            }
            return new StringBuffer(temp + object.toString());
        } else if (object instanceof Number) {
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += "\t";
            }
            return new StringBuffer(temp + object.toString());
        } else if (object instanceof String) {
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += "\t";
            }
            return new StringBuffer(temp + "\"" + object.toString() + "\"");
        } else if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
            Iterator it = jsonObject.keys();
            while (it.hasNext()) {
                String key = it.next().toString();
                String temp = "";
                for (int i = 0; i < level; i++) {
                    temp += "\t";
                }
                result.append(temp + key + "\n" + transform2Str(jsonObject.get(key), ++level) + "\n");
                --level;
            }
            return result;
        } else if (object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += "\t";
            };
            for (int i = 0; i < jsonArray.size(); i++) {
                result.append(temp +"[" + i + "]\n" + transform2Str(jsonArray.get(i), level+1));
            }
        } else {
            System.out.println("错误的JSON格式！" + object);
            return result;
        }
        return result;
    }

}
