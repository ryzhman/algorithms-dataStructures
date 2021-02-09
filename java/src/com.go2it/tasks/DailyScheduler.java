package com.go2it.tasks;

import java.util.Arrays;

public class DailyScheduler {
    EventItem[] dailySchedule;
    int size;
    int maxSize;

    public DailyScheduler() {
        this.maxSize = 100;
        this.size = 0;
        this.dailySchedule = new EventItem[maxSize];
    }

    public void sortAscendingByEventName() {
        int j;
        EventItem event;
        int i;

        for (j = 1; j < this.size; j++) {
            event = this.dailySchedule[j];
            for (i = j - 1; (i >= 0) && (event.name.compareTo(this.dailySchedule[i].name) < 0); i--) {
                this.dailySchedule[i + 1] = this.dailySchedule[i];
            }
            this.dailySchedule[i + 1] = event;
        }
    }

    public void sortAScendingByStartTime() {
        int j;
        EventItem event;
        int i;

        for (j = 1; j < this.size; j++) {
            event = this.dailySchedule[j];
            for (i = j - 1; (i >= 0) && (event.startHour < this.dailySchedule[i].startHour); i--) {
                this.dailySchedule[i + 1] = this.dailySchedule[i];
            }
            this.dailySchedule[i + 1] = event;
        }
    }

    public void sortDescendingByLength() {
        for (int i = 0; i < this.size; i++) {
            int minElemIndex = i;
            for (int j = minElemIndex + 1; j < this.size; j++) {
                EventItem eventItem = this.dailySchedule[j];
                EventItem eventItem1 = this.dailySchedule[minElemIndex];
                if ((eventItem.endHour - eventItem.startHour) > (eventItem1.endHour - eventItem1.startHour)) {
                    minElemIndex = j;
                }
            }
            EventItem temp = this.dailySchedule[i];
            this.dailySchedule[i] = this.dailySchedule[minElemIndex];
            this.dailySchedule[minElemIndex] = temp;
        }
    }

    String printDayScheduleByStartTime() {
        this.sortAScendingByStartTime();
        return this.toString();
    }

    @Override
    public String toString() {
        return "DailyScheduler{" +
                "dailySchedule=" + Arrays.toString(dailySchedule) +
                '}';
    }

    int binarySearch(String eventName) {
        this.sortAscendingByEventName();
        int left = 0;
        int right = this.size - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (this.dailySchedule[middle].name.equals(eventName))
                return middle;

            if (this.dailySchedule[middle].name.compareTo(eventName) < 0) {
                left = middle + 1;

                // If x is smaller, ignore right half
            } else {
                right = middle - 1;
            }
        }
        // if we reach here, then element was
        // not present
        return -1;
    }

    public boolean addEventItem(String location, String eventName, int startTime, int endTime) {
        if (size >= maxSize) {
            return false;
        }
        this.sortAscendingByEventName();
        int index = this.binarySearch(eventName);
        if (this.size == 0) {
            index = 0;
        }
        if (index != -1) {
            EventItem eventWithSameName = this.dailySchedule[index];
            if (eventWithSameName != null && eventWithSameName.location.equals(location)) {
                return false;
            }
        }
        this.dailySchedule[size++] = new EventItem(location, eventName, startTime, endTime);
        return true;
    }

    public static void main(String[] args) {
        final DailyScheduler dailyScheduler = new DailyScheduler();
        dailyScheduler.addEventItem("Library", "breakFast1", 7, 9);
        dailyScheduler.addEventItem("Main Hall", "Conference3", 12, 13);
        dailyScheduler.addEventItem("Boardroom1", "breakFast1", 8, 11);
        dailyScheduler.addEventItem("Boardroom1", "Meeting2", 14, 17);
//        dailyScheduler.sortAscendingByEventName();
//        dailyScheduler.sortAScendingByStartTime();
//        dailyScheduler.sortDescendingByLength();
//        System.out.println(dailyScheduler.printDayScheduleByStartTime());
//        System.out.println(dailyScheduler.binarySearch("CC"));
        System.out.println(dailyScheduler);
    }
}
