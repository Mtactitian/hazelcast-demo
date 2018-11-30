package com.alexb.empstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee with given id not found")
public class EmpNotFoundException extends RuntimeException {
}
