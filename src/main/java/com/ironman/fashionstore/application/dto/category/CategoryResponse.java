package com.ironman.fashionstore.application.dto.category;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse implements Serializable {
    private Integer id;
    private String status;
}
