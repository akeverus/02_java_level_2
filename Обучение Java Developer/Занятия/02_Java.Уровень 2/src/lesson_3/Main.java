package lesson_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"Груша","Яблоко","Апельсин",
                "Груша","Яблоко","Апельсин",
                "Груша","Яблоко","Апельсин",
                "Груша","Яблоко","Апельсин",
                "Груша","Яблоко","Апельсин"};

        Set<String> setWords = new HashSet<>();

        Collections.addAll(setWords, words);

        for(String word : setWords) {
            System.out.println(word);
        }

        Map<String, String> phonebook = new Phonebook();
        ((Phonebook) phonebook).add("Воронин", "8989595");
        ((Phonebook) phonebook).add("неВоронин", "2626156");
        ((Phonebook) phonebook).add("Воронин", "7263121");

        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            System.out.println("Name =  " + entry.getKey() + " Телефон = " + entry.getValue());
        }

        System.out.println(phonebook.get("Воронин"));
    }
}

class Phonebook extends TreeMap {

    public void add (String name, String phone){
        if(this.containsKey(name)) {
            this.put(name, this.get(name) + "," + phone);
        } else {
            this.put(name, phone);
        }
    }

}
