package com.anand;

import java.util.ArrayList;

public class Node {
    private String subject;
    private String type;
    private int timeSlot;
    private int day;
    private final ArrayList<Node> neighborNodes;

    public Node(String subject, String type, int day) {
        this.subject = subject;
        this.type = type;
        this.timeSlot = -1;
        this.day = day;
        this.neighborNodes = new ArrayList<>();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void addNeighbourNodes(Node neighbor) {
        this.neighborNodes.add(neighbor);
    }

    public boolean timeConflict(int timeSlot) {
        for (Node neighbor : neighborNodes) {
            if (this.timeSlot == timeSlot) {
                return true;
            }
        }
        return false;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }
}
