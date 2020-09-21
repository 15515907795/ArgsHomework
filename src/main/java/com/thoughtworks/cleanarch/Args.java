package com.thoughtworks.cleanarch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private String argsText;

    public Args(String argsText){
        this.argsText = argsText;
    }

    public List scan(){
        List<String> keyValueStringList = Arrays.asList(argsText.split(" -"));
        keyValueStringList = keyValueStringList.stream().map(String::trim).collect(Collectors.toList());
        List<KeyValuePair> keyValuePairs = new ArrayList<>();
        for(String kv : keyValueStringList){
            String key = kv.split(" ")[0];
            String value = kv.split(" ")[1];
            KeyValuePair keyValuePair = new KeyValuePair(key,value);
            keyValuePairs.add(keyValuePair);
        }
        return keyValuePairs;
    }
}
