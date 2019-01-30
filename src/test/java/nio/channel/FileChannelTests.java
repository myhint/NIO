package nio.channel;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Description Java NIO Channel : 通道，负责IO源与目标间建立关联线路，借助Buffer操作数据
 * @Author blake
 * @Date 2019-01-30 14:32
 * @Version 1.0
 */
public class FileChannelTests {

    /**
     * 参考链接：
     * 1）http://www.importnew.com/28007.html
     * 2）https://www.cnblogs.com/yueshutong/p/9535519.html
     * <p>
     * 一、channel接口的主要实现类有以下4种：
     * 1）FileChannel           用于读取、写入、映射和操作文件的通道
     * ===> AsynchronousFileChannel 异步通道
     * <p>
     * 2）DatagramChannel       通过UDP读写网络中的数据通道
     * 3）SocketChannel         通过TCP读写网络中的数据通道
     * 4）ServerSocketChannel   监听新进来的TCP连接，对每一个新进来的连接都会创建一个 SocketChannel
     * <p>
     * 二、通道的获取方式
     * 1）对支持通道的对象调用 getChannel() 方法。支持通道的类有以下几种：
     * 1.1 FileInputStream
     * 1.2 FileOutputStream
     * 1.3 RandomAccessFile
     * 1.4 DatagramSocket
     * 1.5 Socket
     * 1.6 ServerSocket
     * <p>
     * 2）通过 Files.newByteChannel() 获取字节通道
     * 3）通过通道的静态方法 open() 打开并返回指定通道
     */

    @Test
    public void fileChannelTest() throws IOException {

        FileInputStream fis = new FileInputStream("in.txt");
        FileOutputStream fos = new FileOutputStream("out.txt");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

//        // 缓冲区
//        ByteBuffer dataBuffer = ByteBuffer.allocate(10);
//
//        // 数据流向：缓冲区=>通道
//        inChannel.read(dataBuffer);
//
//        // 切换至数据读取模式
//        dataBuffer.flip();
//
//        // 数据流向：通道=>缓冲区
//        int writeLength = outChannel.write(dataBuffer);
//
//        System.out.println("writeLength: " + writeLength);
//
        ByteBuffer sourceBuffer = ByteBuffer.allocate(10);

        // 可重复读取
        // dataBuffer.rewind();

        inChannel.read(sourceBuffer);
        System.out.println("第一个：" + (char) sourceBuffer.get());
        System.out.println("第二个：" + (char) sourceBuffer.get());
        System.out.println("第三个：" + (char) sourceBuffer.get());
        System.out.println("第四个：" + (char) sourceBuffer.get());
        System.out.println("第五个：" + (char) sourceBuffer.get());

        // 关闭通道 & 关闭流
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
    }

    @Test
    public void fileChannelOpenTests() throws IOException {

        // 打开并返回指定类型的通道
        FileChannel fileChannel = FileChannel.open(Paths.get("in.txt"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE);


    }

}
