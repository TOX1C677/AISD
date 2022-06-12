public class MyQueue<T> {
    private class Node{
        T data;
        Node next = null;
        public Node(T data){
            this.data=data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }
    public void add(T data){
        if(size == 0){
            head = new Node(data);
            tail = head;
        } else{
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
    }

    public T poll(){
        if(head != null){
            T result = head.data;
            if(head == tail){
                tail = null;
            }
            head = head.next;
            size--;
            return  result;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        if(size >0) {
            Node tmp = head;
            str.append(tmp.data.toString());
            tmp = tmp.next;
            while (tmp != null) {
                str.append(", ").append(tmp.data.toString());
                tmp = tmp.next;
            }
        }
        str.append(']');
        return str.toString();
    }
}
