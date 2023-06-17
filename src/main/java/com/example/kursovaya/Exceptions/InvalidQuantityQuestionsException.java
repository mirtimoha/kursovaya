package com.skypro.javaind.course_work_2.Exceptions;

public class InvalidQuantityQuestionsException extends RuntimeException {
    public InvalidQuantityQuestionsException() {
    }

    public InvalidQuantityQuestionsException(String message) {
        super(message);
    }

    public InvalidQuantityQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidQuantityQuestionsException(Throwable cause) {
        super(cause);
    }

    public InvalidQuantityQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
