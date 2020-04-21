package com.cazmatrans.news.exception;

public class ListNotFoundException extends Exception {
    private long list_id;
    public ListNotFoundException(long list_id) {
        super(String.format("Nisu nadjene liste sa id-em: '%s'", list_id));
    }
}