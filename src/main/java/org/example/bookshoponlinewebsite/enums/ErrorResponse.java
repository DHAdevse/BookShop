package org.example.bookshoponlinewebsite.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorResponse {
    AUTHOR_NOT_FOUND(101,"AUTHOR NOT FOUND","PLEASE CHECK THE AUTHOR NAME AND TRY AGAIN"),
    USERNAME_NOT_FOUND(102,"USER NOT FOUND","PLEASE CHECK THE USER NAME AND TRY AGAIN"),
    INPUT_ERROR(103,"INPUT ERROR","PLEASE CHECK THE INPUT AND TRY AGAIN")
    ;
    ErrorResponse(ErrorResponse errors) {
        this.code = errors.getCode();
        this.message = errors.getMessage();
        this.resolution = errors.getResolution();
    }

    private final int code;
    private final String message;
    private final String resolution;

}
