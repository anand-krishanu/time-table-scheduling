package com.anand;

import java.util.ArrayList;

public class Scheduler {
    private Graph graph;

    public Scheduler () {
        this.graph = new Graph();
    }

    public void createNode (String subject, String type) {
        Node node = new Node(subject, type);
        graph.addNode(node);
    }

    public void addConflict (String subject1, String type1, String subject2, String type2) {
        Node n1 = new Node (subject1, type1);
        Node n2 = new Node(subject2, type2);

        if(n1 != null && n2 != null) {
            graph.addVertex(n1, n2);
        }
    }

    public ArrayList<Node> getScheduledNodes () {
        ArrayList<Node> scheduledNodes = new ArrayList<>();

        for (Node node: graph.getNodes()) {
            if(node.getTimeSlot() != -1) {
                scheduledNodes.add(node);
            }
        }
        return scheduledNodes;
    }

    private Node findNode (String subject, String type) {
        for (Node node: graph.getNodes()) {
            if (node.getSubject().equals(subject) && node.getType().equals(type)) {
                return node;
            }
        }
        return null;
    }

    public void scheduleTimeTable () {
        graph.schedule();
    }
}
