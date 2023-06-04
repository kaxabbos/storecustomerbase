package com.storecustomerbase.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ADMIN("Управляющий"),
    MANAGER("Сотрудник"),
    CLIENT("Клиент");

    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}

