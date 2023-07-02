package com.whereigo.model;

import java.util.List;
import lombok.Data;

@Data
public class PageResult<T> {
    private List<T> attractions;
    private Integer nextPage;

    public PageResult(List<T> data, Integer nextPage) {
        this.attractions = data;
        this.nextPage = nextPage;
    }
}
