package myhashmap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            if (i == 907) {
                myHashMap.getHash("a"+i);
                System.out.println("i = " + i);
            }
            myHashMap.put("a"+i, "A");
        }
        System.out.println("myHashMap = " + myHashMap);
//        myHashMap.put("a", "A");
//        myHashMap.put("b", "B");
//        myHashMap.put("aaa", "AAA");
//        myHashMap.put("bb", "BB");
//        myHashMap.put("bbb", "BBB");
//        myHashMap.put("c", "C");
//        myHashMap.put("d", "D");
//        myHashMap.put("e", "E");
//        myHashMap.put("f", "F");
//        myHashMap.put("g", "G");
//        myHashMap.put("h", "H");
//        myHashMap.put("i", "I");
//        myHashMap.put("j", "J");
//        myHashMap.put("k", "K");
//        myHashMap.put("l", "L");
//        myHashMap.put("m", "M");
//        myHashMap.put("n", "N");
//        myHashMap.put("o", "P");
//        myHashMap.put("q", "Q");
//        myHashMap.put("r", "R");
//        System.out.println("myHashMapa = " + myHashMap);
//
//        myHashMap.put("a", "New value for key");
//        myHashMap.put("aaa", "Another value for key");
//        System.out.println("myHashMapa = " + myHashMap);
//        System.out.println("myHashMap.size() = " + myHashMap.size());
//
//        System.out.println("============");
//        System.out.println("myHashMapa.getHash(\"a\") = " + myHashMap.getHash("a"));
//        System.out.println("myHashMapa.getHash(\"aa\") = " + myHashMap.getHash("aa"));
//        System.out.println("myHashMapa.getHash(\"aaa\") = " + myHashMap.getHash("aaa"));
//        System.out.println("============");
//
//        myHashMap.remove("abccda");
//        System.out.println("myHashMapa = " + myHashMap);
//        myHashMap.remove("bb");
//        System.out.println("myHashMapa = " + myHashMap);
//        System.out.println("myHashMap.size() = " + myHashMap.size());
//
//        System.out.println("myHashMapa.get(\"dfdsfs\") = " + myHashMap.get("sdfsdf"));
//        System.out.println("myHashMapa.get(\"bbb\") = " + myHashMap.get("bbb"));
//
//        System.out.println("myHashMap.size() = " + myHashMap.size());
//
//        myHashMap.clear();
//        System.out.println("myHashMapa = " + myHashMap);
    }
}
