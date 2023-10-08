package com.barokah.bean.validator;

import com.barokah.bean.validator.containers.Entry;
import jakarta.validation.constraints.NotBlank;

public class SampleEntry {
    private Entry<String, String> entry;

    public Entry<@NotBlank(message = "entry key value can not blank") String, @NotBlank(message = "value of entry can not blank") String> getEntry() {
        return entry;
    }

    public void setEntry(Entry<String, String> entry) {
        this.entry = entry;
    }
}
