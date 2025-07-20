package com.common.config.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResPage<T> {
    private int page;

    private int size;

    private long total;

    private List<T> data;
}
