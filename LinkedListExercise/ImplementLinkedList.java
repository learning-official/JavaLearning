public class ImplementLinkedList {
    public static void main(String[] args){

        int[] a = {1,2,3,4,5,66};
        LinkedListT l = new LinkedListT(a);

        System.out.println("基本測試 :");
        l.printForward();
        l.printBackward();

        System.out.println("刪除功能測試 :");
        l.remove(5);
        l.printBackward();
        l.printForward();
    
    }
}
