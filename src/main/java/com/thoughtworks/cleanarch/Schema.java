package com.thoughtworks.cleanarch;

import java.util.Set;

public class Schema {
    Set<FlagSchema> flagSchema;

    public Schema(Set<FlagSchema> flagSchema){
        this.flagSchema = flagSchema;
    }

    public Object getValueOf(String flag){
        return flagSchema.stream()
                .filter(flagSchema -> flagSchema.equalsWith(flag))
                .findFirst()
                .get()
                .getType();
    }

}
