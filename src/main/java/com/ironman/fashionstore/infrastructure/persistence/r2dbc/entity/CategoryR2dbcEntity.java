package com.ironman.fashionstore.infrastructure.persistence.r2dbc.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table("categories")
public class CategoryR2dbcEntity implements Serializable {

    @Id
    private Integer id;

    private String name;
    private String description;

    @Column("url_key")
    private String urlKey;

    private String status;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;

}
