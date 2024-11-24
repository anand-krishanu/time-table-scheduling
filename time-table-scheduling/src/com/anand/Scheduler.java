package com.anand;

import java.util.ArrayList;

public class Scheduler {
    private final Graph graph;

    public Scheduler() {
        this.graph = new Graph();
    }

    public void createNode(String subject, String type, int day) {
        Node node = new Node(subject, type, day);
        graph.addNode(node);
    }

    public ArrayList<Node> getScheduledNodes() {
        ArrayList<Node> scheduledNodes = new ArrayList<>();
        for (Node node : graph.getNodes()) {
            if (node.getDay() != -1 && node.getTimeSlot() != -1) {
                scheduledNodes.add(node);
            }
        }
        return scheduledNodes;
    }

    public void scheduleTimeTable() {
        graph.schedule();
    }
}
