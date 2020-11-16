package src.main.utils;

import src.main.java.Employee;

public class LinkedList {
    private String test;
    public class Iterator {
        public void insert(int x){

        }
        public int erase(){
            return 0;
        }
    }
    private class Link{
        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Link nextNode;
        private int data;
    }

    public void testLink(){
        Link link = new Link();
        link.setData(1);
        link.data = 2;
        System.out.println(link.data);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.testLink();
    }
}
