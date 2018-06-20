package com.yyqian;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * Author: Yinyin Qian
 * Date: 2018-06-20
 */
public class BufTest {
    @Test
    public void buf() {
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action Rocks!", StandardCharsets.UTF_8);
        ByteBuf sliced = buf.slice(0, 14);
        System.out.println(sliced.toString(StandardCharsets.UTF_8));
        buf.setByte(0, (byte) 'J');
        System.out.println(sliced.toString(StandardCharsets.UTF_8));
        System.out.println(buf.getByte(0));
        System.out.println(buf.getInt(0));
        System.out.println(116 + 116 * 256 + 101 * 256 * 256 + 74 * 256 * 256 * 256); // Jett
        System.out.println("capacity: " + buf.capacity());
        System.out.println("readerIndex: " + buf.readerIndex());
        System.out.println("writerIndex: " + buf.writerIndex());
        System.out.println("readable: " + buf.readableBytes());
        System.out.println((char)buf.readByte());
        System.out.println("readerIndex: " + buf.readerIndex());
        System.out.println(buf.readInt());
        System.out.println("readerIndex: " + buf.readerIndex());
    }

    @Test
    public void allocator() {
        ByteBuf buf = Unpooled.buffer(10, 100);
        System.out.println(buf.capacity());
        System.out.println(buf.maxCapacity());
        buf.writeByte(255);
        buf.writeByte(0);
        buf.writeByte(1);
        buf.writeByte(2);
        System.out.println(ByteBufUtil.hexDump(buf));
    }
}
