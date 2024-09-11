package com.Abnormal;
//导入测试注解（@Test）
import org.junit.jupiter.api.Test;



class Abnormal_InsufficientParameters_Test {
    @Test
    void InsufficientParametersExceptionTest(){
        String[] args = {"D:/test/test.txt","D:/test/test0.txt"};
        if(args.length < 3) throw new Abnormal_InsufficientParameters("参数不足");


    }
}
