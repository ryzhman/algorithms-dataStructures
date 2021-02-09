package com.go2it.tasks;

public class EventItem {
    String location;
    String name;
    int startHour;
    int endHour;

     public EventItem(String location, String name, int startHour, int endHour) {
          this.location = location;
          this.name = name;
          this.startHour = startHour;
          this.endHour = endHour;
     }

    @Override
    public String toString() {
        return "EventItem{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                "} \r\n";
    }
}
