package com.in28minutes.unittesting.unittesting.business;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

public class BusinessImpl {

    private SomeDataService ds;

    public SomeDataService getDs() {
        return ds;
    }

    public void setDs(SomeDataService ds) {
        this.ds = ds;
    }

    public int calculateSum(int[] data){
        int sum = 0;
        for(int value:data){
            sum+=value;
        }
        return sum;
    }

    public int calculateSumFromDs(){
        int sum = 0;
        int[] data = ds.retrieveAllData();
        for(int value:data){
            sum+=value;
        }
        return sum;
    }

}
