package com.ironman.fashionstore.domain.business.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {
    ENABLED("A") {
        @Override
        public String toString() {
            return "Habilitado";
        }
    },
    DISABLED("E") {
        @Override
        public String toString() {
            return "Desabilitado";
        }
    };

    private final String code;
    private final String description;

    StatusEnum(String code) {
        this.code = code;
        this.description = this.toString();
    }
}
