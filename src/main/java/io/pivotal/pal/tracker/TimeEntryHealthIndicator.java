package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {

    private static final int MAX_TIME_ENTRIES = 5;
    private final TimeEntryRepository timeEntryRepo;

    public TimeEntryHealthIndicator(TimeEntryRepository timeEntryRepo) {
        this.timeEntryRepo = timeEntryRepo;
    }

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();

<<<<<<< HEAD
        if (timeEntryRepo.list().size() < MAX_TIME_ENTRIES) {
=======
        if(timeEntryRepo.list().size() < MAX_TIME_ENTRIES) {
>>>>>>> 524c5a2... Add actuator endpoints
            builder.up();
        } else {
            builder.down();
        }

        return builder.build();
    }
<<<<<<< HEAD

}
=======
}
>>>>>>> 524c5a2... Add actuator endpoints
