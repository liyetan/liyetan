package com.Calculate_Utils;
import com.Abnormal.Abnormal_TextShort;
import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;//大整数操作
import java.nio.charset.StandardCharsets;//字符集编码
import java.security.MessageDigest;//MD5哈希算法
import java.util.List;//存储关键词列表
public class Calculate_SimHash {
    public static String gethash(String text){
        try {
            //首先创建对象，指定使用MD5算法
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //将字符串转换为UTF-8编码的字节数组，计算哈希值，以二进制字符串形式返回
            return new BigInteger(1, messageDigest.digest(text.getBytes(StandardCharsets.UTF_8))).toString(2);
        }catch (Exception e){
            //抛出异常
            throw new RuntimeException("操作失败",e);
        }

    }
    //设计方法——计算文本的simHash值
    public static String getSimHash(String text) throws Abnormal_TextShort {
        //验证文本是否过短，过短则抛出异常
        if(text.length() < 100) throw new Abnormal_TextShort("文本长度过短");
        //初始化整形数组作为特征向量
        int[] eigenvector = new int[128];
        //使用HanLP从文本中提取关键词，并储存在列表中
        List<String> keywords = HanLP.extractKeyword(text, text.length());
        int size = keywords.size();
        System.out.println("关键字的数量:" + size);
        int i = 0;//初始化一个计数器
        //遍历每个关键词，根据权重调整
        for(String keyword : keywords){
            //获取关键词的Hash值，并将其转换为一个对象
            //System.out.println(keyword);
            //System.out.println(gethash(keyword));
            StringBuilder keywordHash = new StringBuilder(gethash(keyword));
            //如果关键字的哈希值长度小于128，则在默末尾用0补齐
            if(keywordHash.length() < 128){
                int temp = 128 - keywordHash.length();
                for(int j = 0; j < temp; j++){
                    keywordHash.append("0");
                }
            }
        //加权
            for(int j = 0; j < eigenvector.length; j++){
                //如果当前位是1，则根据位置进行加权，否则根据位置减权
                if(keywordHash.charAt(j) == '1'){
                    eigenvector[j] += (10 - (i / (size / 10)));
                }else{
                    eigenvector[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }

        //遍历特征向量每个元素根据正负值来构建转化为SimHash
        StringBuilder simHash = new StringBuilder();
        for(int element : eigenvector){
            simHash.append(element > 0 ? "1" : "0");
            //System.out.println(element);
        }
        return simHash.toString();
    }
}
