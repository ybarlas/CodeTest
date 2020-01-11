package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;

@SpringBootTest
class DemoApplicationTests {


    @Test
    public void testOne() throws FileNotFoundException {

        ArrayList<ZipCode> zipCodeInputList = DemoApplication.readZipCodes("classpath:test01.csv");
        System.out.println("Zip code Input List");
        DemoApplication.printZipCodeList(zipCodeInputList);
        ZipCodeRangeReducer zipCodeRangeReducer = new ZipCodeRangeReducer();
        ArrayList<ZipCode> reducedZipCodes = zipCodeRangeReducer.reduceZipCodeRange(zipCodeInputList,1);
        System.out.println("Zip code Reduced List");
        DemoApplication.printZipCodeList(reducedZipCodes);
        ArrayList<ZipCode> zipCodeAnsList = DemoApplication.readZipCodes("classpath:test01ans.csv");
        System.out.println("Zip code Required List");
        DemoApplication.printZipCodeList(zipCodeAnsList);
        System.out.println("Equals : " + reducedZipCodes.equals(zipCodeAnsList));
        for(int i = 0 ; i<reducedZipCodes.size(); i++){
            assertEquals(zipCodeAnsList.get(i).getStart(), reducedZipCodes.get(i).getStart());
            assertEquals(zipCodeAnsList.get(i).getEnd(), reducedZipCodes.get(i).getEnd());
        }
    }


    @Test
    public void testTwo() throws FileNotFoundException {

        ArrayList<ZipCode> zipCodeInputList = DemoApplication.readZipCodes("classpath:test02.csv");
        System.out.println("Zip code Input List");
        DemoApplication.printZipCodeList(zipCodeInputList);
        ZipCodeRangeReducer zipCodeRangeReducer = new ZipCodeRangeReducer();
        ArrayList<ZipCode> reducedZipCodes = zipCodeRangeReducer.reduceZipCodeRange(zipCodeInputList, 1);
        System.out.println("Zip code Reduced List");
        DemoApplication.printZipCodeList(reducedZipCodes);
        ArrayList<ZipCode> zipCodeAnsList = DemoApplication.readZipCodes("classpath:test02ans.csv");
        System.out.println("Zip code Required List");
        DemoApplication.printZipCodeList(zipCodeAnsList);
        System.out.println("Equals : " + reducedZipCodes.equals(zipCodeAnsList));
        for (int i = 0; i < reducedZipCodes.size(); i++) {
            assertEquals(zipCodeAnsList.get(i).getStart(), reducedZipCodes.get(i).getStart());
            assertEquals(zipCodeAnsList.get(i).getEnd(), reducedZipCodes.get(i).getEnd());
        }
    }
}
