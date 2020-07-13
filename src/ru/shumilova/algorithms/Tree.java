package ru.shumilova.algorithms;

public class Tree {
    private class TreeNode implements Comparable {

        private int content;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int c) {
            this.content = c;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + content +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Integer))
                throw new ClassCastException("Not int");
            return content - ((int) o);
        }
    }

    TreeNode root;

    public void insert(int content) {
        TreeNode node = new TreeNode(content);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (content < current.content) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (content > current.content) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public int find(int content) {
        TreeNode current = root;
        while (current.content != content) {
            current = (content < current.content) ? current.left : current.right;
            if (current == null) return Integer.MIN_VALUE;
        }
        return current.content;
    }

    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.content + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public boolean delete(int content) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.content != content) {
            parent = current;
            if (content < current.content) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left;
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

}


