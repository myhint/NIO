package nio.buffer;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @Description Java NIO Buffer : 负责数据的存取（get=>读取数据，put=>存放数据）
 * @Author blake
 * @Date 2019-01-29 18:49
 * @Version 1.0
 */
public class ByteBufferTests {

    /**
     * * 与Java基本数据类型具体对应的有以下7种 ：
     * * 1）ByteBuffer
     * * 2）ShortBuffer
     * * 3）IntBuffer
     * * 4）LongBuffer
     * * 5）FloatBuffer
     * * 6）DoublerBuffer
     * * 7）CharBuffer
     */

    @Test
    public void byteBufferFieldsTest() {

        // 分配 非直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        System.out.println("capacity :" + byteBuffer.capacity());
        System.out.println("limit :" + byteBuffer.limit());
        System.out.println("position :" + byteBuffer.position());
        System.out.println("mark :" + byteBuffer.mark());

        byteBuffer.putChar('b');

        System.out.println("=========================== byteBuffer.put() ========== ");

        System.out.println("capacity :" + byteBuffer.capacity());
        System.out.println("limit :" + byteBuffer.limit());
        System.out.println("position :" + byteBuffer.position());
        System.out.println("mark :" + byteBuffer.mark());

        /**
         * 1）其中，mark <= position <= limit <= capacity
         * 2）Java中，char = 2bytes
         * 3）mark，其实就是 position,limit,capacity 三者的状态值信息
         * 4）position 就是游标索引值
         * 5）limit 就是 position能够到达的最大索引值
         * 6）capacity 就是缓冲区初始分配的容量，亦是 limit 所能达到的最大值
         */

        // 切换IO模式至数据读取模式
        byteBuffer.flip();

        System.out.println("=========================== byteBuffer.flip() ========== ");

        System.out.println("capacity :" + byteBuffer.capacity());
        System.out.println("limit :" + byteBuffer.limit());
        System.out.println("position :" + byteBuffer.position());
        System.out.println("mark :" + byteBuffer.mark());

        System.out.println("=========================== byteBuffer.get() ========== ");

        // 从缓冲区中读取数据
        System.out.println(byteBuffer.getChar());

        System.out.println("capacity :" + byteBuffer.capacity());
        System.out.println("limit :" + byteBuffer.limit());
        System.out.println("position :" + byteBuffer.position());
        System.out.println("mark :" + byteBuffer.mark());
    }

}
