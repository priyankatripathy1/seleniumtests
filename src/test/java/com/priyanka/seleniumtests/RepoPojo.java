package com.priyanka.seleniumtests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepoPojo {
    public long id;
    public String full_name;
    public String name;
}
