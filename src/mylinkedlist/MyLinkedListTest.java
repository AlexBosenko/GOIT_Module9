package mylinkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("abc");
        myLinkedList.add("bcd");
        myLinkedList.add("cde");
        myLinkedList.add("def");
        myLinkedList.add("efg");
        System.out.println("myLinkedList.size() = " + myLinkedList.size());

        System.out.println("myLinkedList.get(4) = " + myLinkedList.get(4));

        myLinkedList.remove(3);
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        System.out.println("myLinkedList = " + myLinkedList);

        myLinkedList.add("xxx");
        System.out.println("myLinkedList = " + myLinkedList);

        myLinkedList.clear();
        System.out.println("myLinkedList = " + myLinkedList);
    }
}
