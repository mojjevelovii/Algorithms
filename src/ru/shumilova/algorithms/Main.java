package ru.shumilova.algorithms;

public class Main {

    public static void main(String[] args) {
        Node aNode = new Node("A");
        Node bNode = new Node("B");
        Node cNode = new Node("C");
        Node dNode = new Node("D");
        Node eNode = new Node("E");
        Node fNode = new Node("F");
        Node gNode = new Node("G");
        Node hNode = new Node("H");
        Node iNode = new Node("I");
        Node jNode = new Node("J");

        aNode.addRoute(bNode, 1);
        bNode.addRoute(cNode, 1);
        bNode.addRoute(fNode, 2);
        cNode.addRoute(dNode, 1);
        dNode.addRoute(hNode, 1);
        eNode.addRoute(fNode, 3);
        fNode.addRoute(eNode, 3);
        fNode.addRoute(gNode, 3);
        fNode.addRoute(iNode, 3);
        gNode.addRoute(hNode, 3);
        gNode.addRoute(iNode, 3);
        hNode.addRoute(jNode, 1);
        iNode.addRoute(jNode, 3);

        Graph graph = new Graph();

        graph.addNode(aNode);
        graph.addNode(bNode);
        graph.addNode(cNode);
        graph.addNode(dNode);
        graph.addNode(eNode);
        graph.addNode(fNode);
        graph.addNode(gNode);
        graph.addNode(hNode);
        graph.addNode(iNode);
        graph.addNode(jNode);

        graph.calculateShortestPath(aNode);
        graph.showInfo();
    }
}
