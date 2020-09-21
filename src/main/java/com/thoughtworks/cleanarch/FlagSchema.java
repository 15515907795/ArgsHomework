package com.thoughtworks.cleanarch;

public class FlagSchema {
    private String flag;
    private Object valueType;

    public FlagSchema(String flag,Object valueType){
        this.flag = flag;
        this.valueType = valueType;
    }

    public Object getType(){
        return valueType;
    }

    public boolean equalsWith(String flag){
        return flag.equals(this.flag);
    }

}
