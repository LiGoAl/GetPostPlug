package com.example.test.plug.Services;

import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class Delay {
    private final long lowBorder;
    private final long highBorder;

    @Autowired
    public Delay(@Value("${app.delay.low_order}") long lowBorder, @Value("${app.delay.high_order}") long highBorder) {
        this.lowBorder = lowBorder;
        this.highBorder = highBorder;
    }

    public void timeStop() throws ServletException {
        long random = ThreadLocalRandom.current().nextLong(lowBorder, highBorder);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            throw new ServletException("Interrupted", e);
        }
    }
}
