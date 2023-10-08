package com.barokah.bean.validator;

import com.barokah.bean.validator.containers.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SampleData {
    private Data<String> sample;

    public Data<@NotBlank(message = "data can not blank") @Size(min = 3, message = "data minimal {min} characters") String> getSample() {
        return sample;
    }

    public void setSample(Data<String> sample) {
        this.sample = sample;
    }
}
