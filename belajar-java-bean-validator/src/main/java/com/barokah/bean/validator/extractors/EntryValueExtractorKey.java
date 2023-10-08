package com.barokah.bean.validator.extractors;

import com.barokah.bean.validator.containers.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class EntryValueExtractorKey implements ValueExtractor<Entry<@ExtractedValue ?, ?>> {
    @Override
    public void extractValues(Entry<?, ?> originalValue, ValueReceiver receiver) {
        Object key = originalValue.getKey();
        receiver.keyedValue("", "key", key);
    }
}
