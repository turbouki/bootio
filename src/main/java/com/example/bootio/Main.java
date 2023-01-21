package com.example.bootio;

import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.ServletContextListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

        for(Map.Entry<Object, Object> entry : properties.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


//        Iterator<Object> itr =  properties.keySet().iterator();
//        while(itr.hasNext()) {
//            String key = (String)itr.next();
//            System.out.printf("%s : %s\n", key, System.getProperty(key));
//        }
    }


}
