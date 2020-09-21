package com.thoughtworks.cleanarch;

import java.util.*;
import java.util.stream.Collectors;

public class Args {
    private String argsText;
    private List<Arg> argsPairs;
    private Schema schema;

    public Args(String argsText, Schema schema) {
        this.argsText = argsText;
        this.schema = schema;
    }

    public List<Arg> scan() {
        List<String> keyValueStringList = Arrays.asList(argsText.split("-"));
        keyValueStringList = keyValueStringList.stream().map(String::trim).collect(Collectors.toList());
        List<Arg> keyValuePairs = new ArrayList<>();
        for (String kv : keyValueStringList) {
            if (null != kv && !"".equals(kv)) {
                String key = kv.split(" ")[0];
                String value = kv.split(" ")[1];
                Arg arg = new Arg(key, value);
                keyValuePairs.add(arg);
            }
        }
        return keyValuePairs;
    }

    public boolean checkRepeat(List<Arg> args) {
        Set result = new HashSet(args);
        if (result.size() != args.size()) {
            return true;
        }
        return false;
    }

}
