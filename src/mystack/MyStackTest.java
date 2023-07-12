package mystack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(222);
        myStack.push(555);
        myStack.push(444);
        myStack.push(333);
        myStack.push(111);
        myStack.push(777);
        System.out.println("myStack = " + myStack);

        System.out.println("myStack.size() = " + myStack.size());

        myStack.remove(3);
        System.out.println("myStack = " + myStack);

        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println("myStack = " + myStack);

        System.out.println("myStack.poll() = " + myStack.poll());
        System.out.println("myStack = " + myStack);
    }
}
