package com.tests.domains;

public class Application {
    public String getUrl(){
        return System.getenv("url");
    }
}
