package com.barokah.bean.validator;

import com.barokah.bean.validator.containers.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExtractor implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override
    public void extractValues(@ExtractedValue(type = Integer.class) DataInteger originalValue, ValueReceiver receiver) {
        Integer data = originalValue.getData();
        receiver.value("", data);
    }
}
