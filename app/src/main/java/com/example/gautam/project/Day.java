package com.example.gautam.project;

import java.io.Serializable;

public class Day implements Serializable {

    private String title;

    public Day(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
