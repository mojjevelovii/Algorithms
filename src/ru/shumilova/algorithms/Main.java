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

        for (int i = 0; i < trees.size(); i++) {
            System.out.println("____PRINT TREES____" + i);
            trees.get(i).displayTree();
        }
    }

    private static int getRandomInt() {
        return (int) (Math.random() * 201) - 100;
    }
}