package com.Abnormal;
import com.In_Out_Utils.File_input;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class Abnormal_TextShort_Test {
    @Test
    void test() throws FileNotFoundException {
        String[] args = {"D:/test/orig.txt","D:/test/orig_add.txt","D:/test/out.txt"};
        if(args.length < 3) throw new Abnormal_InsufficientParameters("参数不足");
        //读取文件
        String text1 = File_input.Read(args[0]);
        String text2 = File_input.Read(args[1]);
        int result = text1.length();
        if(text1.length() < 100 || text2.length() < 100) throw new Abnormal_TextShort("文本长度过短"+"长度为"+result);
    }
}
