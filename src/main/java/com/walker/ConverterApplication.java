package com.walker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConverterApplication {
    public static void main (String [] args){

        SpringApplication.run(ConverterApplication.class,args);


        if (args.length < 1 ){
            System.out.println("\"No input file defined\"");
            return;
        }
        }
}
