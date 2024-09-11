package com.Calculate_Utils;

public class Calculate_Similarity {
    public static int getHammingDistance(String simHash1, String simHash2)
    {
        //设计方法——通过hash值来计算海明距离
        int Haiming_distance = 0;
        if(simHash1.length()!=simHash2.length()){
            return -1;
        } else {
            for(int i = 0; i < simHash1.length(); i++){
                //循环比较二者的字符
                if(simHash1.charAt(i) != simHash2.charAt(i)) {
                    //遍历二者字符，如果不同，距离加一
                    Haiming_distance += 1;
                }
            }
        }
        System.out.println("海明距离为：" + Haiming_distance);//输出海明距离
        return Haiming_distance;
    }
    public static double getSimilarity(String simHash1, String simHash2)
    {
        //计算海明距离
        int distance = getHammingDistance(simHash1, simHash2);
        //通过海明距离计算相似度
        System.out.println("相似度为：" + (100 - (double)(distance * 100) / 128));
        return (100 - (double)(distance * 100) / 128);

    }
}
