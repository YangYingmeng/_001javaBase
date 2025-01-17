package com.yym.io._02IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 文件的字节输入流以及输出流
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2023-06-03 20:16
 */
@Slf4j
public class _01FileInOutStream {

    private static final String filePath = "_001Pre-courseForArchitects/_04IO/src/main/resources/test.txt";

    // 1. FileOutputStream 向文件中写入数据, 可以写入单个字节 也可以写入字节数组
    private static void writeToFile() {
        // public FileOutputStream(String name, boolean append) true表示在原文件的内容上追加, false表示清空原内容重新写入
        try (FileOutputStream fos = new FileOutputStream(filePath, true)) {
            fos.write(97);
            byte[] bytes = {98, 99, 100};
            fos.write(bytes);
            fos.write(bytes, 1, 2);
            // 想直接写入字符串可以调用getBytes()转换为字节数组
            fos.write("name".getBytes());
        } catch (IOException ex) {
            log.error("向文件中写入数据异常: ", ex);
        }
    }

    // 2. FileInputStream 读取文件中的数据
    private static void readFromFile() {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int len = 0;
            byte[] bytes = new byte[1024];
            StringBuilder builder = new StringBuilder("");
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException ex) {
            log.error("读取文件异常: ", ex);
        }
    }

    public static void main(String[] args) throws IOException {
        readFromFile();
    }
}
