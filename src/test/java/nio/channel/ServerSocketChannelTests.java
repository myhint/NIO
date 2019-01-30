package nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Description ServerSocketChannel
 * @Author blake
 * @Date 2019-01-30 17:13
 * @Version 1.0
 */
public class ServerSocketChannelTests {

    @Test
    public void serverSocketChannelTest() throws IOException {

        // 实例 serverSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 监听 8080 端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true) {
            // 一旦有一个TCP连接进来，就对应创建一个 SocketChannel 进行处理
            SocketChannel socketChannel = serverSocketChannel.accept();
        }
        /**
         * ServerSocketChannel不和Buffer打交道，因为它并不实际处理数据，它一旦接收到请求后，将实例化 SocketChannel，在这之后，该连接
         * 通道上的数据传递，它将不再理会了。
         */
    }

}
