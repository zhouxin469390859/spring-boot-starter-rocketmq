package com.wpj.spring.boot.rocketmq.starter.repertory;

import com.wpj.spring.boot.rocketmq.starter.channel.ChannelNormal;
import com.wpj.spring.boot.rocketmq.starter.channel.ChannelOrder;
import com.wpj.spring.boot.rocketmq.starter.channel.ChannelTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component(ChannelRepertory.CHANNEL_REPERTORY_BEAN_NAME)
public class ChannelRepertory {

    public final static String CHANNEL_REPERTORY_BEAN_NAME = "channelRepertory";

    //普通消息
    private final HashMap<String, ChannelNormal> channelNormal = new HashMap<>();

    //顺序消息
    private final HashMap<String, ChannelOrder> channelOrder = new HashMap<>();

    //事务消息
    private final HashMap<String, ChannelTransaction> channelTransaction = new HashMap<>();

    public ChannelNormal addChannelNormal(String name, ChannelNormal channelNormal) {
        this.channelNormal.put(name, channelNormal);
        return channelNormal;
    }

    public ChannelOrder addChannelOrder(String name, ChannelOrder channelOrder) {
        this.channelOrder.put(name, channelOrder);
        return channelOrder;
    }

    public ChannelTransaction addChannelTransaction(String name, ChannelTransaction channelTransaction) {
        this.channelTransaction.put(name, channelTransaction);
        return channelTransaction;
    }

    public ChannelNormal getChannelNormal(String name) {
        return channelNormal.get(name);
    }

    public ChannelOrder getChannelOrder(String name) {
        return channelOrder.get(name);
    }

    public ChannelTransaction getChannelTransaction(String name) {
        return channelTransaction.get(name);
    }

    /**
     * 反射使用时，查找全部Channel
     *
     * @param name
     * @return
     */
    public Object findChannel(String name) {
        Object channel;

        channel = this.getChannelNormal(name);

        if (channel != null) {
            return channel;
        }

        channel = this.getChannelOrder(name);

        if (channel != null) {
            return channel;
        }

        channel = this.getChannelTransaction(name);

        if (channel != null) {
            return channel;
        }

        return null;
    }
}
