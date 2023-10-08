package com.barokah.bean.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

// container : data type containing data : optional, collection, map, etc
// value extractor
public class P19ContainerDataTest extends AbstractValidatorTest {

    @Test
    void testContainerData(){

        MyHobbies myHobbies = new MyHobbies();

        myHobbies.setHobbies(new ArrayList<String>());

        myHobbies.getHobbies().add("");
        myHobbies.getHobbies().add("   ");
        myHobbies.getHobbies().add("programming");

        Validator validator = getValidator();
        Set<ConstraintViolation<MyHobbies>> violations = validator.validate(myHobbies);
        for (var violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======================");
        }

    }
}
