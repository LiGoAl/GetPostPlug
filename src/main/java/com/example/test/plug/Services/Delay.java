package com.example.test.plug.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class Delay {
    private final long lowBorder;
    private final long highBorder;
    private final Logger logger = LoggerFactory.getLogger(Delay.class);

    public Delay(@Value("${app.delay.low_border}") long lowBorder, @Value("${app.delay.high_border}") long highBorder) {
        this.lowBorder = lowBorder;
        this.highBorder = highBorder;
    }

    public void timeStop() {
        long random = ThreadLocalRandom.current().nextLong(lowBorder, highBorder);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
