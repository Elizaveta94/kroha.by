package com.kroha.service.validation;

import com.kroha.domain.ApplicationDto;
import com.kroha.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@AllArgsConstructor
public class FormValidator {
    public void validate(ApplicationDto applicationDto) {
        validateName(applicationDto.getName());
        validatePhoneNumber(applicationDto.getPhoneNumber());
    }

    private void validateName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new ValidationException("Имя не введено");
        }

        if (!name.matches("[А-Яа-яA-Za-z]+(\\s[А-Яа-яA-Za-z]*)?")) {
           throw new ValidationException("Имя содержит недопустимые символы");
        }
    }

    private void validatePhoneNumber(String phoneNumber) {
          if (!phoneNumber.matches("375(25|29|33|44|55|99)\\d{7}")){
        throw new ValidationException("Номер должен начинаться с 375(25/29/33/44/55/99)XXXXXXX");
        }
    }
}


