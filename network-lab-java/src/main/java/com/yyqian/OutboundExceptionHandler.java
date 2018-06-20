package com.yyqian;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Author: Yinyin Qian
 * Date: 2018-06-20
 */
public class OutboundExceptionHandler extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws
            Exception {
        promise.addListener(f -> {
           if (!f.isSuccess()) {
               f.cause().printStackTrace();
           }
        });
    }
}
