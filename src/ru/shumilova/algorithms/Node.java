package ru.shumilova.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    private String nodeName;
    private List<Node> shortPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> nearestNodes = new HashMap<>();

    public Node(String name) {
        this.nodeName = name;
    }

    public void addRoute(Node destination, int distance) {
        nearestNodes.put(destination, distance);
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<Node> getShortPath() {
        return shortPath;
    }

    public void setShortPath(List<Node> shortPath) {
        this.shortPath = shortPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getNearestNodes() {
        return nearestNodes;
    }

    public void setNearestNodes(Map<Node, Integer> nearestNodes) {
        this.nearestNodes = nearestNodes;
    }
}
