package com.example.assignment.service;
import java.util.*;

import com.example.assignment.model.ReversedString;
import org.springframework.stereotype.Service;

@Service
public class StringService implements IStringService{

    public static List<ReversedString> reversedStrings;
    public StringService() {
        reversedStrings = new ArrayList<>();
    }

    @Override
    public void addString(ReversedString input){
        this.reversedStrings.add(input);
    }

    @Override
    public boolean findString(String input){
//        return this.reversedStrings.contains(input);
        return this.reversedStrings.stream().map(ReversedString::getOriginal).filter(input::equals).findFirst().isPresent();
    }

    @Override
    public ReversedString handleInput(String input){
        boolean found = findString(input);
        if(!found){
            ReversedString reversed = new ReversedString(input, ReverseHelper(input) );
            addString(reversed);
            return reversed;
        }
        else{
            ReversedString result = this.reversedStrings.stream()
                    .filter(o -> input.equals(o.getOriginal()))
                    .findAny()
                    .orElse(null);

            return result;
        }
    }

    @Override
    public String getReversed(String input){
        return handleInput(input).getReversed();
    }

    private String ReverseHelper(String input){
        StringBuffer sbr = new StringBuffer(input);
        sbr.reverse();
        return sbr.toString();
    }
}
