package Decorator;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputDemo.txt")));
        //此encoded中装饰了两层：原生的filedatasource 传给第一层：encryptiondecorator (wrappee = filedatasource)
        //之后再装饰一层：compressiondecorator (wrappee = encryptiondecorator)
        //写数据加密流向 string串 -> compressiondecorator.compress -> encryptiondecorator.encode -> write -> 文件
        //读数据解密流向 文件文本 -> read -> encryptiondecorator.decode -> compressiondecorator.decompress -> string串
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());

        // 基础组件：读取文件
        InputStream fis = new FileInputStream("data.txt");
        // 装饰器1：添加缓冲功能
        InputStream bis = new BufferedInputStream(fis);
        // 装饰器2：添加数据解析功能
        DataInputStream dis = new DataInputStream(bis);
    }

}
