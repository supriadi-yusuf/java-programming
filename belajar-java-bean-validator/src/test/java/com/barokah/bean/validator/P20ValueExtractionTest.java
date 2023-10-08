package com.barokah.bean.validator;

// https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/valueextraction/valueextractor

import com.barokah.bean.validator.containers.Data;
import com.barokah.bean.validator.containers.DataInteger;
import com.barokah.bean.validator.containers.Entry;
import com.barokah.bean.validator.extractors.DataValueExtractor;
import com.barokah.bean.validator.extractors.EntryValueExtractorKey;
import com.barokah.bean.validator.extractors.EntryValueExtractorValue;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class P20ValueExtractionTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp(){
        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown(){
        validatorFactory.close();
    }

    @Test
    void testSampleData(){

        SampleData sampleData = new SampleData();
        sampleData.setSample(new Data<>());
        sampleData.getSample().setData("t003");

        Set<ConstraintViolation<SampleData>> violations = validator.validate(sampleData);
        for (var violation:violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getMessage());
            System.out.println("===========================");
        }
    }

    @Test
    void testSampleEntry(){
        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("o");
        sampleEntry.getEntry().setValue("o");

        Set<ConstraintViolation<SampleEntry>> violations = validator.validate(sampleEntry);
        for (var violation:violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getMessage());
            System.out.println("===========================");
        }
    }

    @Test
    void testSampleDataInteger(){
        SampleDataInteger sampleDataInteger = new SampleDataInteger(); // non generic container
        sampleDataInteger.setInteger(new DataInteger());
        sampleDataInteger.getInteger().setData(10);

        Set<ConstraintViolation<SampleDataInteger>> violations = validator.validate(sampleDataInteger);
        for (var violation : violations){
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getInvalidValue());
            System.out.println(violation.getMessage());
            System.out.println("================================");
        }
    }
}
