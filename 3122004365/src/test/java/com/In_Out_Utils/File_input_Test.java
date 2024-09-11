package com.In_Out_Utils;
//断言方法————assertEquals
//导入测试注解（@Test）
import org.junit.jupiter.api.Test;
//导入异常——文件未找到
import java.io.FileNotFoundException;

class File_input_Test {

    @Test
    void read() throws FileNotFoundException {
        String result = File_input.Read("D:/test/orig.txt");

        //System.out.println(result);
        //assertEquals(sum, sum);
        //assertEquals("我们现在的程序中暗藏了两个BUG，一个是不符合题目的需求，另一个是实现上有一个小问题。现在请你利用刚学习到的单元测试与Debug的相关知识，找出程序的bug吧！Part5.回归测试单元测试不仅仅用来保证当前代码的正确性，更重要的是用来保证代码修复、改进或重构之后的正确性。也就是说，在每次修改完bug之后，我们其实都需要运行一遍来看看是不是满足之前所有的单元测试样例。所以，在每次因为现有的 failed test 而修复原有代码后，最好都全部运行一遍单元测试，保证以前 passed test 仍然是可以通过的。同样地，Git 的使用也是讲究勤提交，提交的粒度最好是细到每个小功能的完成。一个小功能可以是一处小bug的修复，也可以是一个简单函数的实现。所以，在我们本次的编程训练任务中，Git 至少会提交 2 次或以上。Part6.效能工具介绍为了测试并改进程序生成四则运算算式的效率，我们需要使用效能分析工具。效能分析工具并不能帮助我们直接改进算法的效率，但它可以帮我们分析找到代码中执行效率最差，也就是所谓【效能瓶颈】的部分。这之后我们就可以把精力花费在改进瓶颈上，从而高效快速地提升程序性能。JProfiler 是一款大名鼎鼎的 Java 效能分析工具，为了使用它，首先我们需要下载一个JProfiler的可执行文件。在这里我们推荐 10.1.1 版本，下载地址在 https://www.ej-technologies.com/download/jprofiler/files，选择适合电脑版本的 JProfiler 文件即可。下面以 Windows 用户的安装过程为例。首先进入官网后，点击右侧 Download 按钮下载 JProfiler 的安装程序\r\n", sum);
    }
}
