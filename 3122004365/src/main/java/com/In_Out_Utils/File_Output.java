package com.In_Out_Utils;
//导入将字节流写入文件的类
import java.io.FileOutputStream;
//表示I/O可能出现的异常
import java.io.IOException;
//用于将字节流转换为字符流
import java.io.OutputStreamWriter;
public class File_Output {
    public static void Output(String url, Number similarity) throws IOException {
        try {
            //创建FileOutputStream对象, 将字节流写入指定路径的文件
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            //创建OutputStreamWriter对象，将字节流转换为字符流
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            //写入内容
            System.out.println("论文查重率为："+ String.format("%.2f",similarity.doubleValue()) + "%");
            outputStreamWriter.write("论文查重率为："+ String.format("%.2f",similarity.doubleValue()) + "%");
            //关闭确保正确并释放资源
            outputStreamWriter.close();
        }catch (IOException e){
            //捕获异常————发生错误时，抛出异常
            throw new IOException("写入失败" + e);
        }
    }
}
