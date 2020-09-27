package com.example.assignment.service;

import com.example.assignment.model.ReversedString;

public interface IStringService {

    void addString(ReversedString input);
    boolean findString(String input);
    ReversedString handleInput(String input);
    String getReversed(String input);
}
