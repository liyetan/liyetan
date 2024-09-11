package com.In_Out_Utils;
//断言方法————assertEquals
//导入测试注解（@Test）
import org.junit.jupiter.api.Test;
//导入处理异常————输入输出异常
import java.io.IOException;
class File_Output_Test {
    @Test
    void output() throws IOException {
        File_Output.Output("D:/test/out.txt",70);
    }
}
