package myhashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("abc", "CBA");
        myHashMap.put("bcd", "DCB");
        myHashMap.put("cde", "EDC");
        myHashMap.put("def", "FED");

        System.out.println("myHashMap = " + myHashMap);
        System.out.println("myHashMap.get(\"bcd\") = " + myHashMap.get("bcd"));
        System.out.println("myHashMap.size() = " + myHashMap.size());

        myHashMap.remove("def");
        System.out.println("myHashMap = " + myHashMap);
        System.out.println("myHashMap.size() = " + myHashMap.size());

        myHashMap.put("bcd", "333");
        System.out.println("myHashMap = " + myHashMap);
    }
}
