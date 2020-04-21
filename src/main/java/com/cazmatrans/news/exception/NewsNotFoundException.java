package com.cazmatrans.news.exception;

public class NewsNotFoundException extends Exception {
    private long news_id;
    public NewsNotFoundException(long news_id) {
        super(String.format("Novosti nisu nadjene sa id-em: '%s'", news_id));
    }
}
