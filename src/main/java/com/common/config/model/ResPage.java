package com.common.config.model;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static <T, R> ResPage<R> of(Page<T> page, Function<T, R> mapper) {
        List<R> content = page.stream()
                .map(mapper)
                .collect(Collectors.toList());

        return ResPage.<R>builder()
                .page(page.getNumber())
                .size(page.getSize())
                .total(page.getTotalElements())
                .data(content)
                .build();
    }
}
