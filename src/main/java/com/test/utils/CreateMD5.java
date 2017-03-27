package com.test.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 张宏浩 on 2017/2/28.
 */
public class CreateMD5
{
    public static String getMd5(String plainText){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[]= md.digest();

            int i;
            StringBuffer buf = new StringBuffer("");
            for(int offset = 0 ; offset<b.length;offset++){
                i = b[offset];
                if(i<0){
                    i+=256;
                }
                if(i<16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            //16位加密
            //return buf.toString().subString(8,24);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[ ] args){
        System.out.println(CreateMD5.getMd5("zhanghonghao"));
    }
}
