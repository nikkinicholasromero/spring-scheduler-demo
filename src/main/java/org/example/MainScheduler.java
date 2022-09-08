package org.example;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MainScheduler {
    @Scheduled(cron="0 * * * * ?")
    @SchedulerLock(name = "MainScheduler_everyMinute",
            lockAtLeastForString = "PT5M", lockAtMostForString = "PT14M")
    public void everyMinute() {
        System.out.println("Every minute : " + LocalDateTime.now());
    }
}
