package ru.shumilova.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Node> nodeSet = new HashSet<>();

    public void addNode(Node node) {
        nodeSet.add(node);
    }

    public void calculateShortestPath(Node startNode) {
        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();

        startNode.setDistance(0);

        unvisitedNodes.add(startNode);

        while (unvisitedNodes.size() != 0) {
            Node currentNode = getNearestNode(unvisitedNodes);
            unvisitedNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> nearestPair : currentNode.getNearestNodes().entrySet()) {
                Node nearestNode = nearestPair.getKey();
                Integer routeDistance = nearestPair.getValue();
                if (!visitedNodes.contains(nearestNode)) {
                    calculateMinDistance(currentNode, nearestNode, routeDistance);
                    unvisitedNodes.add(nearestNode);
                }
            }
            visitedNodes.add(currentNode);
        }
    }

    private Node getNearestNode(Set<Node> unvisitedNodes) {
        Node nearestNode = null;
        int distance = Integer.MAX_VALUE;

        for (Node node : unvisitedNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < distance) {
                distance = nodeDistance;
                nearestNode = node;
            }
        }
        return nearestNode;
    }

    private void calculateMinDistance(Node visitedNode, Node targetNode, Integer routeDistance) {
        Integer visitedDistance = visitedNode.getDistance();

        if (visitedDistance + routeDistance < targetNode.getDistance()) {
            targetNode.setDistance(visitedDistance + routeDistance);
            LinkedList<Node> shortestPath = new LinkedList<>(visitedNode.getShortPath());
            shortestPath.add(visitedNode);
            targetNode.setShortPath(shortestPath);
        }
    }

    public void showInfo() {
        StringBuilder shortestPath = new StringBuilder();
        for (Node node : nodeSet) {
            shortestPath.setLength(0);
            for (Node sNode : node.getShortPath()) {
                shortestPath.append(sNode.getNodeName());
            }
            System.out.println(node.getNodeName() + " -> " + shortestPath);
        }
    }
}
