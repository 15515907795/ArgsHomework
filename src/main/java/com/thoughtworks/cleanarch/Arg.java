package com.thoughtworks.cleanarch;

public class Arg {
    private String flag;
    private String value;

    public Arg(String flag, String value) {
        this.flag = flag;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Object switchValue() {
        switch (flag) {
            case "l":
                return Boolean.parseBoolean(value);
            case "p":
                return Integer.parseInt(value);
            case "d":
                return String.valueOf(value);
            default:
                return null;
        }
    }

}
