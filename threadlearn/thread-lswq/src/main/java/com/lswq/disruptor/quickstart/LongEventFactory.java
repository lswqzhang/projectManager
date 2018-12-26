package com.lswq.disruptor.quickstart;

import com.lmax.disruptor.EventFactory;

/**
 * 由于需要让Disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象。
 *
 * @author zhangshaowei
 */
public class LongEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}
