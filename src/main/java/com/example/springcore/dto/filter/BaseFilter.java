package com.example.springcore.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseFilter {
    private Integer page;
    private Integer limit;
    private String sortBy;
}
