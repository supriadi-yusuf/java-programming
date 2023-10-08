package com.barokah.bean.validator;

import jakarta.validation.Validator;
import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

import java.util.Set;

//https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/metadata/beandescriptor

public class P22MetadataTest extends AbstractValidatorTest{
    @Test
    void testPerson(){
        Validator validator = getValidator();
        BeanDescriptor beanDescriptor = validator.getConstraintsForClass(Person.class);
        Set<PropertyDescriptor> propertyDescriptors = beanDescriptor.getConstrainedProperties();
        for (var propertyDescriptor : propertyDescriptors){
            System.out.println(propertyDescriptor.getPropertyName());

            Set<ConstraintDescriptor<?>> constraintDescriptors = propertyDescriptor.getConstraintDescriptors();
            for (var constraintDescriptor:constraintDescriptors){
                System.out.println(constraintDescriptor);
                System.out.println("-----------------------------");
            }

            System.out.println("=====================================");
        }
    }
}
