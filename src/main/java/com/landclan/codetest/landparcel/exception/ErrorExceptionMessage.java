package com.landclan.codetest.landparcel.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorExceptionMessage {

    private final String errorMessage;
    private final String exceptionMessage;
}
