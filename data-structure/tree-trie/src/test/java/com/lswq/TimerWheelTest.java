package com.lswq;

import com.lswq.timer.Timeout;
import com.lswq.timer.Timer;
import com.lswq.timer.TimerTask;
import com.lswq.timer.TimerWheel;

import java.util.concurrent.TimeUnit;

public class TimerWheelTest implements TimerTask {


    final static Timer timer = new TimerWheel();


    public static void main(String[] args) {
        TimerTask timerTask = new TimerWheelTest();
        for (int i = 0; i < 10; i++) {
            timer.newTimeout(timerTask, 5, TimeUnit.SECONDS, "" + i);
        }
    }

    @Override
    public void run(Timeout timeout, String argv) throws Exception {
        System.out.println("timeout, argv = " + argv);
    }
}
