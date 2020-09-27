package com.example.assignment;

import com.example.assignment.model.ReversedString;
import com.example.assignment.service.IStringService;
import com.example.assignment.service.StringService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Assignment12ApplicationTests {

    @Autowired
    private IStringService stringService;

    @Test
    void serviceTestNotFind(){
        //given
        String given = "test";

        //when
        boolean found = stringService.findString(given);

        //then
        assertThat(found)
                .isEqualTo(false);
    }

    @Test
    void serviceTestFind(){
        //given
        String given = "test";
        StringService helper = new StringService();
        ReversedString givenReverse = new ReversedString(given, helper.ReverseHelper(given));
        stringService.addString(givenReverse);

        //when
        boolean found = stringService.findString(given);

        //then
        assertThat(found)
                .isEqualTo(true);
    }


    @Test
    void controllerNotReversedTest(){
        //given
        String expected = "test";

        //when
        String found = stringService.getReversed("test:");
        //then
        assertThat(found)
                .isNotEqualTo(expected);
    }

    @Test
    void controllerReversedTest(){
        //given
        String expected = "tseT";
        //when
        String found = stringService.getReversed("Test");

        //then
        assertThat(found)
                .isEqualTo(expected);
    }

}
