package com.anand;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Node> nodes;

    public Graph () {
        this.nodes = new ArrayList<>();
    }

    public void addNode (Node node) {
        nodes.add(node);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void addVertex (Node n1, Node n2) {
        n1.addNeighbourNodes(n2);
        n2.addNeighbourNodes(n1);
    }

    public void schedule () {
        for (Node node: nodes) {
            for (int slot = 1; slot <=12; slot++) {
                if(!node.timeConflict(slot) && isValidSlot(node, slot)) {
                    node.setTimeSlot(slot);
                    break;
                }
            }
        }
    }

    public boolean isValidSlot (Node node, int slot) {
        return switch (node.getType()) {
            case "Lecture" -> slot >= 7 && slot <= 12;
            case "Tutorial" -> slot == 1 || slot == 6;
            case "Labs" -> slot <= 10;
            default -> true;
        };
    }
}
