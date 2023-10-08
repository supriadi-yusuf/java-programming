package com.barokah.bean.validator;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class MyHobbies {
    private List<@NotBlank(message = "hobby can not blank") String> hobbies; // correct way to validate container element

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
