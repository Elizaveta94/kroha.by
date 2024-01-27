package com.kroha.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ApplicationDto {
    private String name;
    private String phoneNumber;
    private String additionalInfo;

}

