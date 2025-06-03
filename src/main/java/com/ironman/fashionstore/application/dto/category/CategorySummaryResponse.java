package com.ironman.fashionstore.application.dto.category;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategorySummaryResponse implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String urlKey;
    private String status;
}
