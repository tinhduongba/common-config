package com.common.config.util;

import org.springframework.data.domain.Sort;

public class StringUtil {

    public static Sort getSort(String sorts) {
        if (sorts == null || sorts.isEmpty()) {
            return Sort.unsorted();
        }
        String[] sortArray = sorts.split(",");
        Sort sort = Sort.unsorted();
        for (String sortField : sortArray) {
            String trimmedField = sortField.trim();
            if (trimmedField.startsWith("-")) {
                String fieldName = trimmedField.substring(1);
                sort = sort.and(Sort.by(Sort.Direction.DESC, fieldName));
            } else {
                sort = sort.and(Sort.by(Sort.Direction.ASC, trimmedField));
            }
        }
        return sort;
    }

    public static Sort getNativeSort(String sorts) {
        if (sorts == null || sorts.isEmpty()) {
            return Sort.unsorted();
        }
        String[] sortArray = sorts.split(",");
        Sort sort = Sort.unsorted();
        for (String sortField : sortArray) {
            String trimmedField = sortField.trim();
            if (trimmedField.startsWith("-")) {
                String fieldName = camelToSnake(trimmedField.substring(1));
                sort = sort.and(Sort.by(Sort.Direction.DESC, fieldName));
            } else {
                sort = sort.and(Sort.by(Sort.Direction.ASC, camelToSnake(trimmedField)));
            }
        }
        return sort;
    }

    public static String camelToSnake(String s) {
        if (s == null || s.isEmpty()) return s;
        return s
                .replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2")
                .replaceAll("([a-z\\d])([A-Z])", "$1_$2")
                .replaceAll("([A-Za-z])(\\d)", "$1_$2")
                .replaceAll("(\\d)([A-Za-z])", "$1_$2")
                .replaceAll("[^A-Za-z\\d]+", "_")
                .replaceAll("_+", "_")
                .replaceAll("^_+|_+$", "")
                .toLowerCase();
    }
}
