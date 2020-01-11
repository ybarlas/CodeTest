package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


/**
 * class for implementation of core logic of reducing zip codes range
 */

public class ZipCodeRangeReducer {

    /**
     * core logic is
     * 1. sort array list according to start rage of all zip codes
     * 2. get 1st zip code and stored in stack
     * 3. compare each zip code from array list with stack top
     * 4. add zip code to stack if not overlap
     * 5. replace stack top if overlap
     * 6. for removing consecutive zip code set threshold to 1 and test remove consecutive zip codes
     * 7. return all zip codes from stack in an array list.
     *
     * @param zipCodeList input list of zip codes to reduce to minimum
     * @return reduced ArrayList of type ZipCode
     */
    public ArrayList<ZipCode> reduceZipCodeRange(ArrayList<ZipCode> zipCodeList, int reductionThreshold){

        ArrayList<ZipCode> reducedZipCodes = new ArrayList<ZipCode>();
        int size = zipCodeList.size() ;
        Stack<ZipCode> zipCodeStack = new Stack<ZipCode>();

        if(size > 1){
            Collections.sort(zipCodeList, new ZipCodeListComparator());
            zipCodeStack.push(zipCodeList.get(0));

            for(int i = 1; i < size; i++){
                ZipCode temp = zipCodeStack.peek();

                if (temp.getEnd() < zipCodeList.get(i).getStart() && (temp.getEnd()+reductionThreshold) != zipCodeList.get(i).getStart()){
                    zipCodeStack.push(zipCodeList.get(i));

                }else if(temp.getEnd() < zipCodeList.get(i).getEnd()) {
                    zipCodeStack.pop();
                    zipCodeStack.push(new ZipCode(temp.getStart(), zipCodeList.get(i).getEnd()));
                }

            }
        }
        return new ArrayList<ZipCode>(zipCodeStack);
    }
}