package com.example.demo;


/**
 * Object for saving each zip code Range
 *
 */
public class ZipCode {

    /**
     * zip code range starting from
     */
    private int start ;
    /**
     * zip code range ending at
     */
    private int end ;

    public ZipCode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public ZipCode() {
        this.start = 0;
        this.end = 0;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
}

