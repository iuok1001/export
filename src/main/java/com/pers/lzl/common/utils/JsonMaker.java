package com.pers.lzl.common.utils;

import com.pers.lzl.modules.dpt.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsonMaker {

    public static void main(String[] args) {
        System.out.println(getJsonResult(20));
    }

    /**
     * 生成json对象个数
     * @param size
     * @return
     */
    public static String getJsonResult(int size) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setAge(i);
            user.setCreateDate(new Date());
            //user.setUpdateDate(new Date());
            user.setSeniority(random.nextFloat());
            user.setGradePoint(random.nextDouble());
            user.setCompany(getRandomString(random.nextInt(30)));
            user.setOffice(getRandomString(random.nextInt(30)));
            user.setLoginName(getRandomString(random.nextInt(30)));
            user.setPassword(getRandomString(random.nextInt(30)));
            user.setNo(getRandomString(random.nextInt(30)));
            user.setName(getRandomString(random.nextInt(30)));
            user.setEmail(getRandomString(random.nextInt(30)));
            user.setPhone(getRandomString(random.nextInt(30)));
            user.setMobile(getRandomString(random.nextInt(30)));
            user.setUserType(getRandomString(random.nextInt(30)));
            user.setLoginIp(getRandomString(random.nextInt(30)));
            user.setLoginFlag(getRandomString(random.nextInt(30)));
            user.setPhoto(getRandomString(random.nextInt(30)));
            user.setOldLoginName(getRandomString(random.nextInt(30)));
            user.setNewPassword(getRandomString(random.nextInt(30)));
            user.setOldLoginIp(getRandomString(random.nextInt(30)));
            user.setLoginDate(new Date());
            user.setOldLoginDate(new Date());
            userList.add(user);
        }
        JSONArray jsonArray = JSONArray.fromObject(userList);

        return jsonArray.toString();
    }
    /**
     * 生成不同的字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789_~!@#$（）￥！%^&*()-=+{}[]:;、“”\"?/><,.ASDFGHJKLQERTYUIOPMNBVCXZ【】：‘’？/";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
            sb.append(getRandomChar());
        }
        return sb.toString();
    }

    /**
     *生成汉字
     * @return
     */
    private static char getRandomChar() {
        String str = "";
        int hightPos;
        int lowPos;
        Random random = new Random();
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("错误");
        }
        return str.charAt(0);
    }
}
