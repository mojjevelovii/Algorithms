package ru.shumilova.algorithms;

import java.util.Objects;

public class RelatedList {
    private class Node {
        Cat c;
        Node next;
        Node previous;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }

    private Node head;
    private int size;

    public RelatedList() {
        head = null;
        size = 0;
    }

    public RelatedListIterator getIterator() {
        return new RelatedListIterator(this);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat c) {
        Node n = new Node(c);
        if (head != null) {
            head.previous = n;
        }
        n.next = head;
        head = n;
        size++;
    }

    public Cat pop() {
        if (isEmpty()) {
            return null;
        }
        Cat temp = head.c;
        head = head.next;
        head.previous = null;
        size--;
        return temp;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) == null;
    }

    private Node find(Cat c) {
        if (isEmpty()) {
            return null;
        }
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean delete(Cat c) {
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
            previous.next.previous = previous;
        }
        return true;
    }

    public class RelatedListIterator {
        private Node current;
        private Node previous;
        private RelatedList list;

        public RelatedListIterator(RelatedList list) {
            this.list = list;
            this.reset();
        }

        public void reset() {
            current = list.head;
            previous = null;
        }

        public Cat next() {
            if (current == null) {
                return null;
            }
            previous = current;
            current = current.next;
            return getCurrent();
        }

        public Cat previous() {
            if (current == null) {
                return null;
            }
            current = previous;
            if (current != head) {
                previous = current.previous;
            } else {
                previous = null;
            }
            return getCurrent();
        }

        public Cat getCurrent() {
            if (current == null) {
                return null;
            }
            return current.c;
        }

        public boolean hasNext() {
            if (current == null) {
                return false;
            }
            return current.next != null;
        }

        public boolean atEnd() {
            if (current == null) {
                return true;
            }
            return current.next == null;
        }

        public void insertAfter(Cat c) {
            if (current == null) {
                return;
            }

            Node afterNewNode;
            Node newNode = new Node(c);
            if (!atEnd()) {
                afterNewNode = current.next;
                afterNewNode.previous = newNode;
                newNode.next = afterNewNode;
            }
            current.next = newNode;
            newNode.previous = current;
            size++;
        }

        public boolean deleteCurrent() {
            if (current == null) {
                return false;
            }
            if (!atEnd()) {
                current.next.previous = current.previous;
                current.previous.next = current.next;
            } else if (current == head) {
                if (hasNext()) {
                    head = current.next;
                    head.previous = null;
                } else {
                    head = null;
                }
            } else {
                current.previous.next = null;
                current.previous = null;
            }
            size--;
            return true;
        }

        public void insertBefore(Cat c) {
            if (current == null) {
                return;
            }
            Node newNode = new Node(c);
            if (current == head) {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            } else {
                current.previous.next = newNode;
                newNode.next = current;
                newNode.previous = current.previous;
                current.previous = newNode;
            }
            size++;
        }
    }
}
