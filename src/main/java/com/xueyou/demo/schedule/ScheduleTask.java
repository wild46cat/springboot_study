package com.xueyou.demo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class ScheduleTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final long INTERVALTIME = 3000L;

//    @Scheduled(fixedRate = INTERVALTIME)
//    public void reportCurrentTime() {
//        LOGGER.info("now time is {}", dateFormat.format(new Date()));
//    }

}
