package com.company;
public class MyList<T> {

    private class ListNode{
        T data;
        ListNode next = null;
        ListNode prev = null;
        public ListNode(T data){
            this.data = data;
        }
    }

    ListNode head = null;
    ListNode tail = null;
    int size = 0;

    public void add(T data){
        if(size == 0){
            head = new ListNode(data);
            tail = head;
        }
        if(size >= 1){
            ListNode tmp = new ListNode(data);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        size++;
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        ListNode tmp = head;
        for (int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        removeNode(tmp);
        size--;
    }

    private void removeNode(ListNode node){
        if(node == head){
            head = node.next;
            head.prev = null;
        } else
        if(node == tail){
            tail = node.prev;
            tail.next = null;
        } else{
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    public void reverse(){
        ListNode right = tail;
        ListNode left = head;
        head = tail;
        tail = left;
        for(int i = 0; i < size / 2; i++){
            swap(right, left);
            if(i % 2 == 1) {
                right = right.prev;
                left = left.next;
            } else{
                right = right.next;
                left = left.prev;
            }
        }
    }

    private void swap(ListNode right, ListNode left) {
        ListNode rightPrev = right.prev;
        ListNode leftPrev = left.prev;
        if (rightPrev != null) {
            rightPrev.next = left;
            left.prev = rightPrev;
        }
        else{
            head = left;
            left.prev = null;
        }
        if (leftPrev != null) {
            leftPrev.next = right;
            right.prev = leftPrev;
        }
        else {
            head = right;
            right.prev = null;
        }
        ListNode rightNext = right.next;
        ListNode leftNext = left.next;
        if(rightNext != null)
            rightNext.prev = left;
        if(leftNext != null)
            leftNext.prev = right;
        right.next = left.next;
        left.next = rightNext;
    }

    private void insert(ListNode nodePrev, ListNode node){
        if(nodePrev.next != null)
            nodePrev.next.prev = node;
        node.next = nodePrev.next;
        node.prev = nodePrev;
        nodePrev.next = node;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        ListNode tmp = head;
        str.append(tmp.data);
        while (tmp != tail){
            tmp = tmp.next;
            str.append(", ").append(tmp.data);
        }
        return str.toString();
    }
}
