package com.ironman.fashionstore.application.dto.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest implements Serializable {

    @NotBlank(message = "Name is required")
    @Size(min=3, max = 200, message = "Name must be between 3 and 200 characters")
    private String name;

    @Size(max = 500, message = "Description must be up to 500 characters")
    private String description;
}
