package com.example.assignment.model;

public class ReversedString  extends Object{
    private String original;
    private String reversed;

    public ReversedString(String original, String reversed){
        this.original = original;
        this.reversed = reversed;
    }

    public String getOriginal(){
        return this.original;
    }
    public String getReversed(){ return this.reversed; }
}

