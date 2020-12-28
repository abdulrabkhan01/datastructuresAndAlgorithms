package com.ark.algo.greedy;

import java.time.LocalTime;
import java.util.*;

/**
 * <p> Given M meeting rooms and N meetings with given time slots, schedule
 * meeting in such a way that minimum number of meeting rooms should be used. </p>
 */
public class MinMeetingRoomsProblem {

    public int getMinMeetingRoom(List<Meeting> meetings) {
        int minMeetingRooms = 1;
        //Sort Meetings by Start Time
        meetings.sort(Comparator.comparing(Meeting::getStart));
        //Create Priority Queue based on Meeting end
        PriorityQueue<LocalTime> priorityQueue = new PriorityQueue<>();
        //Lets schedule first meeting
        Meeting firstMeeting = meetings.get(0);
        priorityQueue.offer(firstMeeting.getEnd());
        for (int i = 1; i < meetings.size(); i++) {
            Meeting nextMeeting = meetings.get(i);
            //Check if this meeting overlaps with the already scheduled meeting
            //if overlapped then we require separate meeting room
            if (nextMeeting.getStart().compareTo(priorityQueue.peek()) < 0) {
                minMeetingRooms++;
            } else {
                //otherwise remove the last element from priority queue
                priorityQueue.poll();
            }
            //Add the meeting end time to the priority queue
            priorityQueue.offer(nextMeeting.getEnd());
        }
        return minMeetingRooms;
    }

    public static void main(String[] args) {
        List<Meeting> meetings = populateMeetings();
        int minNoOfMeetings = new MinMeetingRoomsProblem().getMinMeetingRoom(meetings);
        System.out.println(minNoOfMeetings);
    }

    private static List<Meeting> populateMeetings() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(localTime(11, 0), localTime(12, 0)));
        meetings.add(new Meeting(localTime(10, 30), localTime(12, 0)));
        return meetings;
    }

    private static LocalTime localTime(int hour, int min) {
        return LocalTime.of(hour, min);
    }
}

class Meeting {
    private final LocalTime start;
    private final LocalTime end;

    public Meeting(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}