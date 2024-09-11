package com;
import com.Calculate_Utils.Calculate_Similarity;
import com.Calculate_Utils.Calculate_SimHash;
import com.Abnormal.Abnormal_InsufficientParameters;
import com.In_Out_Utils.File_input;
import com.In_Out_Utils.File_Output;
import org.junit.jupiter.api.Test;
//导入处理异常————输入输出异常
import java.io.IOException;

class Main_Test {
    @Test
    void main()throws IOException{
        String[] args = {"D:/test/orig.txt","D:/test/orig_add.txt","D:/test/out.txt"};
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
//        while (true) {
//            try {
//                Thread.sleep(1000); // 每秒休眠一次
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.out.println("Interrupted");
//                break;
//            }
//        }
    }

}
