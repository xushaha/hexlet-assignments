package exercise;

import java.util.Set;
import java.util.TreeSet;

public class Example {
    public static void main(String[] args) {
        // maps

//        // LinkedHashMap
//        Map<String, String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put("Egor", "Yakovlev");
//        linkedHashMap.put("Max", "Maximov");
//        linkedHashMap.put("Ivan", "Ivanov");
//
//        System.out.println(linkedHashMap);
//
//        // TreeMap
//        Map<Integer, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());
//        treeMap.put(23, List.of("Victor", "Ivan"));
//        treeMap.put(18, List.of("Eugene"));
//        treeMap.put(40, List.of("Anna", "Henry", "Igor"));
//
//        System.out.println(treeMap);
//
//        treeMap.put(35, List.of("Vera"));
//        System.out.println(treeMap);
//
//        // sets
//        Set<String> set = new HashSet<>();
//        set.add("Egor");
//        set.add("Max");
//        set.add("Ivan");
//
//        System.out.println(set);
//        System.out.println(set.size());
//
//        Set<Item> itemSet = new HashSet<>();
//        itemSet.add(new Item(1, "Зубная щетка", 100));
//        itemSet.add(new Item(2, "Замороженная пицца", 200));
//        itemSet.add(new Item(3, "Мороженое", 100));
//        System.out.println(itemSet);
////
//        itemSet.add(new Item(1, "Пельмени", 300));
//        System.out.println(itemSet);
////
//        itemSet.add(new Item(4, "Пельмени", 300));
//        System.out.println(itemSet);

//
        //LinkedHashSet

//        Set<Item> itemLinkedHashSet = new LinkedHashSet<>();
//        itemLinkedHashSet.add(new Item(1, "Зубная щетка", 100));
//        itemLinkedHashSet.add(new Item(2, "Замороженная пицца", 200));
//        itemLinkedHashSet.add(new Item(3, "Мороженое", 100));
//        System.out.println(itemLinkedHashSet);
//
//        // TreeSet
        Set<Item> itemTreeSet = new TreeSet<>();
        itemTreeSet.add(new Item(1, "Зубная щетка", 100));
        itemTreeSet.add(new Item(2, "Замороженная пицца", 200));
        itemTreeSet.add(new Item(3, "Мороженое", 50));
        System.out.println(itemTreeSet);


    }
}
