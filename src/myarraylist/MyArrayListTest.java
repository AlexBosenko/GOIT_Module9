package myarraylist;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(Integer.toString(i));
        }
        System.out.println("myArrayList = " + myArrayList);

        System.out.println("myArrayList.size() = " + myArrayList.size());

        System.out.println("myArrayList.get(5) = " + myArrayList.get(5));

        myArrayList.remove(5);
        System.out.println("myArrayList = " + myArrayList);

        myArrayList.add("333");
        System.out.println("myArrayList = " + myArrayList);

        myArrayList.remove(3);
        System.out.println("myArrayList = " + myArrayList);

        myArrayList.clear();
        System.out.println("myArrayList = " + myArrayList);
    }
}
