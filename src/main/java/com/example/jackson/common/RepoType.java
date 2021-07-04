package com.example.jackson.common;

/**
 * @author xiaoxuxuy
 */
public enum RepoType {

    GITHUB("GITHUB"),
    GITLAB("GITLAB");

    private String name;

    RepoType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
