package com.cazmatrans.news.request;

import javax.validation.constraints.NotBlank;

public class NewNews {
    @NotBlank
    private String title;
    @NotBlank
    private boolean isActive;
    @NotBlank
    private String context;
    @NotBlank
    private String href;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
