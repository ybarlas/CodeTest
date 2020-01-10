package com.example.demo;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;

/**
 * Comparator Class provide compare method implementation.
 */

public class ZipCodeListComparator implements Comparator<ZipCode> {


    /**
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(ZipCode o1, ZipCode o2) {

        int zip1 = o1.getStart();
        int zip2 = o2.getStart();
        /*
        int comp = zip1 - zip2 ;
        if(comp != 0){
            return comp ;
        } else {
            zip1 = o1.getEnd();
            zip2 = o2.getEnd();
        }
        */
        return zip1 - zip2;
    }

}
