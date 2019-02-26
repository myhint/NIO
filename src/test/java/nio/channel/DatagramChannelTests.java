package nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @Description DatagramChannel
 * @Author blake
 * @Date 2019-01-30 17:13
 * @Version 1.0
 */
public class DatagramChannelTests {


    /**
     * DatagramChannel 一个类全权负责服务端和客户端。
     */
    @Test
    public void datagramChannelReceiveTest() throws IOException {

        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(9090));
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();

        // 监听端口
        datagramChannel.receive(buf);
    }

    /**
     * 测试时，建议抽取成两个类，分别在两个main方法中执行，进而观察执行效果
     */
    @Test
    public void datagramChannelSendTest() throws IOException {

        DatagramChannel datagramChannel = DatagramChannel.open();

        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        // 发送数据
        int byteSent = datagramChannel.send(buf, new InetSocketAddress("jenkov.com", 9090));
    }

}
