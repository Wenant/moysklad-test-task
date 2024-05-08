package ru.biryukov.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestBuilder {
    public static PageRequest buildPageRequest(int page, int size, String sortBy, String sortDirection) {
        if (sortBy != null && sortDirection != null) {
            Sort.Direction direction = Sort.Direction.fromString(sortDirection);
            Sort sort = Sort.by(direction, sortBy);
            return PageRequest.of(page, size, sort);
        } else {
            return PageRequest.of(page, size);
        }
    }
}

