package nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description SocketChannel:
 * @Author blake
 * @Date 2019-01-30 17:13
 * @Version 1.0
 */
public class SocketChannelTests {

    @Test
    public void socketChannelTest() throws IOException {

        // SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("https://www.javadoop.com", 80));

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("https://www.javadoop.com", 80));

        /**
         * SocketChannel 的读写和 FileChannel 没什么区别，就是操作缓冲区
         */

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 读取数据
        socketChannel.read(byteBuffer);

        // 写入数据到网络连接中
        while (byteBuffer.hasRemaining()) {
            socketChannel.write(byteBuffer);
        }

    }

}
