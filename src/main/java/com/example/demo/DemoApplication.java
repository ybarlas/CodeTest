package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Main entry point of code execution
 */
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main. . . .");
        SpringApplication.run(DemoApplication.class, args);
    }


    /**
     *
     * Run method implementation of CommandLineRunner
     * @param args
     * @throws FileNotFoundException
     */

    public void run(String ... args) {

        /*
        System.out.println("run. . . .");
        ArrayList<ZipCode> zipCodeInputList = null;
        try {
            zipCodeInputList = readZipCodes("classpath:input.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Input Zip Code List");
        printZipCodeList(zipCodeInputList);
        ZipCodeRangeReducer zipCodeRangeReducer = new ZipCodeRangeReducer();
        ArrayList<ZipCode> zipCodeReducedList = zipCodeRangeReducer.reduceZipCodeRange(zipCodeInputList, 1);
        System.out.println("Reduced Zip Code List");
        printZipCodeList(zipCodeReducedList);
        */
    }

    /**
     * print all zip codes on console from zipCodeArrayList
     * @param zipCodeArrayList
     */
    public static void printZipCodeList(ArrayList<ZipCode> zipCodeArrayList){
        zipCodeArrayList.forEach(zipCode -> System.out.println("[ "+zipCode.getStart()+" , "+zipCode.getEnd()+" ]"));
    }

    /**
     * read zip codes from file input-1.csv saved in resources directory
     * @param filePath
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<ZipCode> readZipCodes(String filePath) throws FileNotFoundException {
        ArrayList<ZipCode> zipCodeRangeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ResourceUtils.getFile(filePath)))) {
            String line = br.readLine();
            while (line != null) {
                String[] zipcodes = line.split(",");
                ZipCode zipCodeRange = new ZipCode(Integer.parseInt(zipcodes[0]), Integer.parseInt(zipcodes[1]));
                zipCodeRangeList.add(zipCodeRange);
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return zipCodeRangeList;
    }
}