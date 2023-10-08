package com.barokah.bean.validator;

import com.barokah.bean.validator.containers.DataInteger;
import jakarta.validation.constraints.Min;

class SampleDataInteger {
    @Min(value = 10, message = "integer value should not less than {value}")
    DataInteger integer;

    public DataInteger getInteger() {
        return integer;
    }

    public void setInteger(DataInteger integer) {
        this.integer = integer;
    }
}
