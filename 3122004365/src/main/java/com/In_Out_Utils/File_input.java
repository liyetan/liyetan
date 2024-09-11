package com.In_Out_Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class File_input {
    // 定义一个读取文件的方法，可能抛出异常——文件未找到
    public static String Read(String url) throws FileNotFoundException {
        //通过给定的路径创建一个File对象
        File file = new File(url);
        try {
            //尝试创建Scanner对象，准备读取文件内容
            Scanner scanner = new Scanner(file);
            //创建一个StringBuilder对象，用于存储文件内容
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                //读取每一行，并将其添加到StringBuilder对象中
                content.append(scanner.nextLine());
                //添加系统行分隔符来保持文件的初始格式
                content.append(System.lineSeparator());
            }
            //关闭Scanner对象，释放资源。
            scanner.close();
            //输出文件内容
            //System.out.println(content.toString());
            //以字符串的形式返回文件内容
            return content.toString();
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("文件不存在");
        }
    }
}
