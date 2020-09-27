package com.example.assignment.service;

import com.example.assignment.model.ReversedString;
import com.example.assignment.model.WordCounter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class TextService implements ITextService{

    private static List<WordCounter> amountOfWords;
    public TextService() {
        amountOfWords = new ArrayList<>();
    }

    @Override
    public Integer countWords(String text){
        if(!textExcists(text)){
            WordCounter counter = new WordCounter(text);
            amountOfWords.add(counter);
            return counter.getCount();

        }
        else{
            return this.amountOfWords.stream()
                    .filter(o -> text.equals(o.getText()))
                    .findAny()
                    .orElse(null).getCount();
        }
    }


    private Boolean textExcists(String text){
        return this.amountOfWords.stream().map(WordCounter::getText).filter(text::equals).findFirst().isPresent();
    }
}
