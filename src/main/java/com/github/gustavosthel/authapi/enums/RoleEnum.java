package com.github.gustavosthel.authapi.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public enum RoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
