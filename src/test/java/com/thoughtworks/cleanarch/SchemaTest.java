package com.thoughtworks.cleanarch;

import com.thoughtworks.cleanarch.FlagSchema;
import com.thoughtworks.cleanarch.Schema;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SchemaTest {
    @Test
    public void should_return_boolean_type_when_given_flag(){
        Set<FlagSchema> flagSchema = new HashSet<>();
        flagSchema.add(new FlagSchema("l",Boolean.TYPE));
        Schema schema = new Schema(flagSchema);

        Assert.assertEquals(schema.getValueOf("l"),Boolean.TYPE);
    }

}
