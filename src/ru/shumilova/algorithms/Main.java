package ru.shumilova.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Tree dTree = new Tree();
            dTree.insert(getRandomInt());
            while (dTree.getTreeDepth(dTree.getRoot()) < 6) {
                dTree.insert(getRandomInt());
            }
            trees.add(dTree);
        }

        Tree balancedTree = new Tree();
        balancedTree.insert(10);
        balancedTree.insert(9);
        balancedTree.insert(11);
        balancedTree.insert(12);
        balancedTree.insert(8);
        trees.add(balancedTree);

        for (int i = 0; i < trees.size(); i++) {
            System.out.println("____PRINT TREES____" + i);
            trees.get(i).displayTree();
            System.out.println("Is balanced: " + trees.get(i).isBalanced());
        }
    }

    private static int getRandomInt() {
        return (int) (Math.random() * 201) - 100;
    }
}