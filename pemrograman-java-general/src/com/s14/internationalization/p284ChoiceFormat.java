package com.s14.internationalization;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

public class p284ChoiceFormat {
    private static void p01Choice() {
        String pattern = "40#E | 50#D | 60#C | 70#B | 80#A";
        ChoiceFormat choiceFormat = new ChoiceFormat(pattern);
        String mark = choiceFormat.format(100);
        System.out.println(mark);
    }

    private static void p02ChoiceInMessageFormat() {
        String pattern = "There {0,choice,0#are no files | 1#is one file | 1<are {0,number,integer} files}";
        MessageFormat messageFormat = new MessageFormat(pattern);
        String message = messageFormat.format(new Object[]{0});
        System.out.println(message);
    }

    public static void main(String[] args) {
        p01Choice();

        p02ChoiceInMessageFormat();
    }
}
