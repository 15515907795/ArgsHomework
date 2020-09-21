package com.thoughtworks.cleanarch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArgsTest {
    public Schema schema;
    @Before
    public void init(){
        FlagSchema BooSchema = new FlagSchema("l",Boolean.TYPE);
        FlagSchema IntSchema = new FlagSchema("p",Integer.TYPE);
        FlagSchema StrSchema = new FlagSchema("d",String.class);
        Set<FlagSchema> flagSchemas = new HashSet();
        flagSchemas.add(BooSchema);
        flagSchemas.add(IntSchema);
        flagSchemas.add(StrSchema);
        Schema schema = new Schema(flagSchemas);
    }
    @Test
    public void should_return_args_when_input_arsText(){
        String argsText = "-l true -p 8080 -d /usr/logs";
        Args args = new Args(argsText,schema);
        List<Arg> keyValue = args.scan();
        Assert.assertEquals(3,keyValue.size());
        Assert.assertEquals("true",keyValue.get(0).getValue());
        Assert.assertEquals("8080",keyValue.get(1).getValue());
        Assert.assertEquals("/usr/logs",keyValue.get(2).getValue());
    }
    @Test
    public void should_return_boolean_when_given_flag_l(){
        Set<FlagSchema> flagSchema = new HashSet<>();
        flagSchema.add(new FlagSchema("l",Boolean.TYPE));
        Schema schema = new Schema(flagSchema);
        Assert.assertEquals(schema.getValueOf("l"),Boolean.TYPE);
    }
    @Test
    public void should_return_integer_when_given_flag_p(){
        Set<FlagSchema> flagSchema = new HashSet<>();
        flagSchema.add(new FlagSchema("p",Integer.TYPE));
        Schema schema = new Schema(flagSchema);
        Assert.assertEquals(schema.getValueOf("p"),Integer.TYPE);
    }

    @Test
    public void should_return_string_when_given_flag_d(){
        Set<FlagSchema> flagSchema = new HashSet<>();
        flagSchema.add(new FlagSchema("d",String.class));
        Schema schema = new Schema(flagSchema);
        Assert.assertEquals(schema.getValueOf("d"),String.class);
    }
    @Test
    public void should_return_false_when_repeat(){
        String argsText = "-l true -l true";
        Args args = new Args(argsText,schema);
        boolean result = args.checkRepeat(args.scan());
        Assert.assertEquals(false,result);
    }

}
