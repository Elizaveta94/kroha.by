package com.kroha.domain;

import lombok.*;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ApplicationDto {
    private String name;
    private String phoneNumber;
    private String additionalInfo;


}

