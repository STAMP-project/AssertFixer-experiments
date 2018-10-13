package org.simpleflatmapper.test.map.mapper;

import org.junit.Test;
import org.simpleflatmapper.map.MapperBuildingException;
import org.simpleflatmapper.map.MapperConfig;
import org.simpleflatmapper.map.SetRowMapper;
import org.simpleflatmapper.map.mapper.AbstractMapperFactory;
import org.simpleflatmapper.map.property.IgnoreProperty;
import org.simpleflatmapper.map.property.KeyProperty;
import org.simpleflatmapper.reflect.Getter;
import org.simpleflatmapper.reflect.ReflectionService;
import org.simpleflatmapper.reflect.meta.ClassMeta;
import org.simpleflatmapper.test.map.SampleFieldKey;
import org.simpleflatmapper.util.Consumer;
import org.simpleflatmapper.util.Predicate;


import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class AbstractMapperBuilderDiscriminatorTest {
    
    
    @Test
    public void test561KeyAndNoKey() {
        fail();
    }
    
    @Test
    public void testDiscriminator() {

        AbstractMapperBuilderTest.SampleMapperBuilder<Common> builder = newCommonBuilder();

        builder.addMapping("id");
        builder.addMapping("valueStr");
        builder.addMapping("valueInt");

        SetRowMapper<Object[], Object[][], Common, Exception> mapper = builder.mapper();

        StringValue stringValue = (StringValue) mapper.map(new Object[] {1l, "strValue", 2, "str"});
        assertEquals(1, stringValue.id);
        assertEquals("strValue", stringValue.valueStr);

        IntegerValue integerValue = (IntegerValue) mapper.map(new Object[] {2l, "str", 3, "int"});
        assertEquals(2, integerValue.id);
        assertEquals(3, integerValue.valueInt);

    }

    @Test
    public void testDiscriminatorFailOnNonMatchColumn() {
        try {
            AbstractMapperBuilderTest.SampleMapperBuilder<Common> builder = newCommonBuilder();

            builder.addMapping("id");
            builder.addMapping("valueNotThere");

            fail();
        } catch (MapperBuildingException e){
            // expected
        }
    }
    
    @Test
    public void testDiscriminatorOnJoin() throws Exception {
        AbstractMapperBuilderTest.SampleMapperBuilder<ListOfCommon> builder = newListOfCommonBuilder();

        builder.addMapping("commons_id", KeyProperty.DEFAULT);
        builder.addMapping("commons_valueStr");
        builder.addMapping("commons_valueInt");
        builder.addMapping("type", new IgnoreProperty());
        builder.addMapping("id", KeyProperty.DEFAULT);


        SetRowMapper<Object[], Object[][], ListOfCommon, Exception> mapper = builder.mapper();


        Iterator<ListOfCommon> iterator = mapper.iterator(
                new Object[][]{
                        {1l, "strValue", 2, "str", 1l},
                        {2l, "strValue", 3, "int", 1l},
                        
                        {3l, "strValue2", 2, "str", 2l},
                        {4l, "strValue", 4, "int", 2l},
                        {5l, "strValue", 5, "int", 2l},
                });
        
        ListOfCommon loc = iterator.next();
        
        
        assertEquals(1l, loc.id);
        assertEquals(2, loc.commons.size());
        assertEquals(1l, loc.commons.get(0).id);
        assertEquals(2l, loc.commons.get(1).id);
        assertEquals("strValue", ((StringValue)loc.commons.get(0)).valueStr);
        assertEquals(3, ((IntegerValue)loc.commons.get(1)).valueInt);
        
        loc = iterator.next();

        assertEquals(2l, loc.id);
        assertEquals(3, loc.commons.size());
        assertEquals(3l, loc.commons.get(0).id);
        assertEquals(4l, loc.commons.get(1).id);
        assertEquals(5l, loc.commons.get(2).id);
        assertEquals("strValue2", ((StringValue)loc.commons.get(0)).valueStr);
        assertEquals(4, ((IntegerValue)loc.commons.get(1)).valueInt);
        assertEquals(5, ((IntegerValue)loc.commons.get(2)).valueInt);
        
        assertFalse(iterator.hasNext());
    }

    private AbstractMapperBuilderTest.SampleMapperBuilder<Common> newCommonBuilder() {
        return newBuilder(reflectionService.getClassMeta(Common.class));
    }
    private AbstractMapperBuilderTest.SampleMapperBuilder<ListOfCommon> newListOfCommonBuilder() {
        return newBuilder(reflectionService.getClassMeta(ListOfCommon.class));
    }

    ReflectionService reflectionService = ReflectionService.newInstance();

    private <T> AbstractMapperBuilderTest.SampleMapperBuilder<T> newBuilder(ClassMeta<T> classMeta) {
        return AbstractMapperBuilderTest.SampleMapperFactory.newInstance()
                .discriminator(Common.class,
                        new Getter<Object[], String>() {
                            @Override
                            public String get(Object[] target) throws Exception {
                                return (String) target[3];
                            }
                        },
                        new Consumer<AbstractMapperFactory.DiscriminatorConditionBuilder<Object[], String, Common>>() {
                    @Override
                    public void accept(AbstractMapperFactory.DiscriminatorConditionBuilder<Object[], String, Common> builder) {
                        builder
                            .when("str", StringValue.class).
                            when("int", IntegerValue.class);
                    }
                })
                .newBuilder(classMeta);
    }

    public static class ListOfCommon {
        public final long id;
        public final List<Common> commons;

        public ListOfCommon(long id, List<Common> commons) {
            this.id = id;
            this.commons = commons;
        }
    }

    public static abstract class Common {
        public final long id;

       Common(long id) {
            this.id = id;
        }
    }
    
    public static class StringValue extends Common {
        public final String valueStr;

        public StringValue(long id, String valueStr) {
            super(id);
            this.valueStr = valueStr;
        }
    }

    public static class IntegerValue extends Common {
        public final int valueInt;

        public IntegerValue(long id, int valueInt) {
            super(id);
            this.valueInt = valueInt;
        }
    }
}
