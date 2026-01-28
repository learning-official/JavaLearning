package JavaLearning.LinkedListE;

public class ImplementLinkedList {
    public static void main(String[] args){

        LinkedListT<Integer> l = new LinkedListT<Integer>(1,2,3);


        System.out.println("基本測試 :");
        l.printForward();
        l.printBackward();

        System.out.println("刪除功能測試 :");
        l.remove(5);
        l.printBackward();
        l.printForward();
    
    }
}
