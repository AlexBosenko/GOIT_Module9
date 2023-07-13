import myarraylist.MyArrayList;
import myhashmap.MyHashMap;
import mylinkedlist.MyLinkedList;
import myqueue.MyQueue;
import mystack.MyStack;

public class Main {
    public static void main(String[] args) {
        //MyArrayList
        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(Integer.toString(i));
        }
        System.out.println("myArrayList = " + myArrayList);

        //MyLinkedList
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("abc");
        myLinkedList.add("bcd");
        myLinkedList.add("cde");
        myLinkedList.add("def");
        myLinkedList.add("efg");
        System.out.println("myLinkedList = " + myLinkedList);

        //MyQueue
        MyQueue<Double> queue = new MyQueue<>();
        queue.add(1.5d);
        queue.add(44.d);
        queue.add(0.1d);
        queue.add(15.78d);
        System.out.println("queue = " + queue);

        //MyStack
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(222);
        myStack.push(555);
        myStack.push(444);
        myStack.push(333);
        myStack.push(111);
        myStack.push(777);
        System.out.println("myStack = " + myStack);

        //MyHashMap
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("a", "A");
        myHashMap.put("b", "B");
        myHashMap.put("aaa", "AAA");
        myHashMap.put("bb", "BB");
        myHashMap.put("bbb", "BBB");
        myHashMap.put("aaa", "AAA");
        System.out.println("myHashMapa = " + myHashMap);
    }
}
