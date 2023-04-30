package com.example.humanresourcesservice.converter;

import com.example.humanresourcesservice.enums.Sex;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class
SexConverter implements AttributeConverter<Sex, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Sex sex) {
        if (sex == null) {
            return null;
        }
        return sex.getValue();
    }

    @Override
    public Sex convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Sex.values())
                .filter(c -> c.getValue().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
