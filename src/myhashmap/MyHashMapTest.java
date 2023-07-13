package myhashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("a", "A");
        myHashMap.put("b", "B");
        myHashMap.put("aaa", "AAA");
        myHashMap.put("bb", "BB");
        myHashMap.put("bbb", "BBB");
        myHashMap.put("aaa", "AAA");
        System.out.println("myHashMapa = " + myHashMap);

        myHashMap.put("a", "New value for key");
        myHashMap.put("aaa", "Another value for key");
        System.out.println("myHashMapa = " + myHashMap);
        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println("============");
        System.out.println("myHashMapa.getHash(\"a\") = " + myHashMap.getHash("a"));
        System.out.println("myHashMapa.getHash(\"aa\") = " + myHashMap.getHash("aa"));
        System.out.println("myHashMapa.getHash(\"aaa\") = " + myHashMap.getHash("aaa"));
        System.out.println("============");

        myHashMap.remove("abccda");
        System.out.println("myHashMapa = " + myHashMap);
        myHashMap.remove("bb");
        System.out.println("myHashMapa = " + myHashMap);
        System.out.println("myHashMap.size() = " + myHashMap.size());

        System.out.println("myHashMapa.get(\"dfdsfs\") = " + myHashMap.get("sdfsdf"));
        System.out.println("myHashMapa.get(\"bbb\") = " + myHashMap.get("bbb"));

        myHashMap.clear();
        System.out.println("myHashMapa = " + myHashMap);
    }
}
