package org.example;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MainScheduler {
    @Scheduled(cron="*/10 * * * * ?")
    @SchedulerLock(name = "MainScheduler_everyMinute",
            lockAtLeastFor = "PT1M", lockAtMostFor = "PT2M")
    public void everyMinute() {
        System.out.println("Every minute : " + LocalDateTime.now());
    }
}
