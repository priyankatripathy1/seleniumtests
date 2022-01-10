package com.priyanka.seleniumtests;

import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.annotations.Test;

import java.util.*;

public class DataStructures {

    @Test
    public void setTest() {
        Set<String> handlers = new HashSet<String>();

        handlers.add("priyanka");
        handlers.add("Abhishek");

        System.out.println(handlers.contains("abhishek"));

        System.out.println(handlers.size());

        Iterator<String> it = handlers.iterator();

        it.next();
        it.next();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    @Test
    public void mapTest(){
        Map<String,Integer> name = new LinkedHashMap<String, Integer>();
        name.put("priyanka",2);
        name.put("Abhishek",1);
        name.put("Priya",3);
        System.out.println(name.get("priyanka"));
        Iterator<Map.Entry<String ,Integer>> it = name.entrySet().iterator();

        System.out.println(name.containsKey("sena"));

        while (it.hasNext()) {
            Map.Entry<String, Integer> en = it.next();
            System.out.println("key: " + en.getKey() + " value: " + en.getValue());
        }
    }

    @Test
    public void arrayListTest() {
        List<String> names = new ArrayList<String>();

        names.add("abhishek");
        names.add("priyanka");

        for(String s: names) {
            System.out.println(s);
        }
    }

    @Test
    public void exceptionTest() {
        String myName = null;
        int size =0;
        try {
            size = stringSize(myName);
        } catch (ElementNotVisibleException ex) {
            System.out.println("An exception was thrown");
        }

        System.out.println("String size: " + size);
    }

    private int stringSize(String input) {
        if (input == null) {
            throw new ElementNotVisibleException("not visible");
        }

        return input.length();
    }

}
