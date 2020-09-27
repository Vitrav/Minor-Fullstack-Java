package com.example.assignment.model;

import java.util.StringTokenizer;

public class WordCounter {
    private String text;
    private Integer count;

    public WordCounter(String text){
        this.text = text;
        this.count = WordCountHelper(text);
    }

    private Integer WordCountHelper(String text){
        return new StringTokenizer(text).countTokens();
    }


    public Integer getCount(){
        return this.count;
    }

    public String getText(){
        return this.text;
    }
}
