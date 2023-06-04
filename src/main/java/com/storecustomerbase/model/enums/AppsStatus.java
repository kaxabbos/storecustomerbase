package com.storecustomerbase.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppsStatus {
    WAITING("Ожидание"),
    REVIEWED("Рассмотрено"),
    ;
    private final String name;
}

