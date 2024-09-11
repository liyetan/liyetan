package com;
import com.Calculate_Utils.Calculate_Similarity;
import com.Calculate_Utils.Calculate_SimHash;
import com.Abnormal.Abnormal_InsufficientParameters;
import com.In_Out_Utils.File_input;
import com.In_Out_Utils.File_Output;
public class Main {
    public static void main(String[] args) throws Exception {
        //对输入参数进行验证
        if(args.length < 3) throw new Abnormal_InsufficientParameters("参数不足");
        //读取文件
        String text1 = File_input.Read(args[0]);
        String text2 = File_input.Read(args[1]);
        //将文本转换为simhash的值
        String simhash1 = Calculate_SimHash.getSimHash(text1);
        String simhash2 = Calculate_SimHash.getSimHash(text2);
        //计算海明距离并输出相似度similarity
        double similarity = Calculate_Similarity.getSimilarity(simhash1, simhash2);
        //写入文件
        File_Output.Output(args[2], similarity);

    }
}
