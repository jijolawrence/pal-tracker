package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long,TimeEntry> timeEntries = new HashMap<>();

    public InMemoryTimeEntryRepository() {
        IdGenerator.reset();
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry.getId().equals(0L)){
            timeEntry.setId(IdGenerator.getGeneratedId());
        }
        TimeEntry timeEntryObj = new TimeEntry(timeEntry.getId(),timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.put(timeEntry.getId(),timeEntryObj);
        return timeEntryObj;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return timeEntries.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(timeEntries.get(id) != null){
            TimeEntry timeEntryObj = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
            timeEntries.put(id,timeEntryObj);
            return timeEntries.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        timeEntries.remove(id);
    }

}
