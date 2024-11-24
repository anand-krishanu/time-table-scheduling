package com.anand;

import java.util.ArrayList;

public class Graph {
    private final ArrayList<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addVertex(Node n1, Node n2) {
        n1.addNeighbourNodes(n2);
        n2.addNeighbourNodes(n1);
    }

    public void schedule() {
        boolean[][] timetable = new boolean[5][12];

        for (Node node : nodes) {
            boolean scheduled = false;

            for (int slot = 1; slot <= 12; slot++) {
                if (!timetable[node.getDay() - 1][slot] && isValidSlot(node, slot)) {
                    node.setTimeSlot(slot);
                    timetable[node.getDay() - 1][slot] = true;
                    scheduled = true;
                    break;
                }
            }

            if (!scheduled) {
                System.out.println("Could not schedule class: " + node.getSubject() + " (" + node.getType() + ") on day " + getDayName(node.getDay()));
            }
        }
    }

    public boolean isValidSlot(Node node, int slot) {
        return switch (node.getType()) {
            case "Lecture" -> slot >= 7 && slot <= 12;
            case "Tutorial" -> slot == 1 || slot == 6;
            case "Lab" -> slot <= 10;
            default -> true;
        };
    }

    private String getDayName(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            default -> "Unknown Day";
        };
    }
}
