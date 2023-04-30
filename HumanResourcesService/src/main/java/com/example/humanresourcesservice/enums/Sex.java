package com.example.humanresourcesservice.enums;


import lombok.Getter;

@Getter
public enum Sex {
    MALE(1),
    FEMALE(2),
    NOT_APPLICABLE(9),
    UNKNOWN(0);

    public final Integer value;
    Sex(Integer value) {
        this.value = value;
    }
}
