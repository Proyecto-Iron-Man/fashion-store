package com.ironman.fashionstore.application.dto.category;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDetailResponse implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String urlKey;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
