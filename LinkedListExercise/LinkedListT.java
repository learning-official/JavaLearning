public class LinkedListT{

    private static class Node {
        Node next, prev;
        int data;

        Node(int data){
            this.next = null;
            this.prev = null;
            this.data = data;
        }
    }

    private Node head, tail;
    int length;

    LinkedListT(int[] array){
        if (array.length == 0) {
            System.out.println("陣列是空的!");
            return;
        }

        Node[] nodeG = new Node[array.length];
        this.length = array.length;

        for (int i = 0; i<array.length; i++){
            nodeG[i] = new Node(array[i]);
        }

        for (int i = 0; i<array.length-1; i++){
            nodeG[i+1].prev = nodeG[i];
            nodeG[i].next = nodeG[i+1];
        }
        // 讓head作為nodeG[0]的別名，當建構完成後，nodeG消失，head留著，並存有next的位置 -> Reachability，不會被GC回收
        this.head = nodeG[0];
        this.tail = nodeG[array.length - 1];
    }

    public void remove(int index){
        if (this.length == 0) return;
        Node node = this.head;
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
        Node node = this.head;
        while(node != null){

            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    public void printBackward(){
        if (this.length == 0) return;
        Node tail = this.tail;
        while(tail != null){
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println("");
    }
}