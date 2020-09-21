package com.thoughtworks.cleanarch;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArgsTest {
    @Test
    public void should_return_size_and_value_given_txt(){
        String argsText = "-l true -p 8080 -d /usr/logs";
        Args args = new Args(argsText);
        List<KeyValuePair> keyValueString = args.scan();

        Assert.assertEquals(3,keyValueString.size());
        Assert.assertEquals("true",keyValueString.get(0).getValue());
        Assert.assertEquals("8080",keyValueString.get(1).getValue());
        Assert.assertEquals("/usr/logs",keyValueString.get(2).getValue());
    }
}
