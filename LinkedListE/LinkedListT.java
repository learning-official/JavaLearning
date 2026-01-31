package LinkedListE;

public class LinkedListT<T>{

    private static class Node <T> {
        Node<T> next, prev;
        T data;

        Node(T data){
            this.next = this.prev = null;
            this.data = data;
        }
    }

    private Node<T> head, tail;
    int length;

    @SafeVarargs
    LinkedListT(T... array){
        if (array.length == 0) {
            System.out.println("陣列是空的!");
            return;
        }

        this.length = array.length;

        for (T item: array){
            Node<T> node = new Node<>(item);
            if (head == null){
                this.head = this.tail = node;
            }else{
                tail.next = node;
                node.prev = tail;
                this.tail = node;
            }
        }
    }

    

    public void remove(int index){
        if (this.length == 0) return;
        Node<T> node = this.head;
        // 讓node跟head指向同一塊記憶體位置，node是head的reference
        // node本身是要被刪除的那個，因此整體都是由node在跑

        if (index <0 || index >= length){
            System.out.println("超出陣列範圍!");
            return;
        }
        
        for (int i = 0; i < index; i++) node = node.next;
        
        // 顧好Head位置
        if (node.prev == null){
            this.head = node.next;   
            if (this.head != null) this.head.prev = null;
        }else node.prev .next = node.next;
        
        // 顧好Tail位置
        if (node.next == null){
            this.tail = node.prev;
            if (this.tail != null) this.tail.next = null;
        } else node.next.prev = node.prev;

        // 最後要讓node本身跟指向斷開
        node.next = null;
        node.prev = null;
        this.length -= 1;
    }

    public void printForward(){
        if (this.length == 0) return;
        Node<T> node = this.head;
        while(node != null){

            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public void printBackward(){
        if (this.length == 0) return;
        Node<T> tail = this.tail;
        while(tail != null){
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println("");
    }
}