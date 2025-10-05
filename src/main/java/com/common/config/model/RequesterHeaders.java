package com.common.config.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequesterHeaders {
    private UUID userId;

    private String[] roles;

    private String language;

    private UUID companyId;
}
