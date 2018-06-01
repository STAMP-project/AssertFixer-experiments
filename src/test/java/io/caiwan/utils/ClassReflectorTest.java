package io.caiwan.utils;

import io.caiwan.utils.test.DummyTestDto;
import io.caiwan.utils.test.DummyVariousAccessFieldsDto;
import io.github.caiwan.utils.ClassReflector;
import org.junit.Assert;
import org.junit.Test;

public class ClassReflectorTest {

    @Test
    public void TestClassReflectorHasProps() {
        // given
        ClassReflector reflector = new ClassReflector(DummyVariousAccessFieldsDto.class);

        //when
        reflector.build();

        // then

        Assert.assertTrue(reflector.hasGetter("bothSetAndGet"));
        Assert.assertTrue(reflector.hasGetter("getOnly"));
        Assert.assertFalse(reflector.hasGetter("setOnly"));

        Assert.assertTrue(reflector.hasSetter("bothSetAndGet"));
        Assert.assertFalse(reflector.hasSetter("getOnly"));
        Assert.assertTrue(reflector.hasSetter("setOnly"));
    }

    @Test
    public void TestInvokeGetter() {
        // given
        ClassReflector reflector = new ClassReflector(DummyTestDto.class);
        reflector.build();

        // when
        DummyTestDto sourceDto = new DummyTestDto(1L, "hello", "mi", "van");

        // then

        Assert.assertEquals(new Long(1L), reflector.get("id", sourceDto));
        Assert.assertEquals("hello", reflector.get("kitten", sourceDto));
        Assert.assertEquals("mi", reflector.get("puppy", sourceDto));
        Assert.assertEquals("van", reflector.get("giraffe", sourceDto));

    }

    @Test
    public void TestInvokeSetter() {
        // given
        ClassReflector reflector = new ClassReflector(DummyTestDto.class);
        reflector.build();

        // when
        DummyTestDto targetDto = new DummyTestDto();

        reflector.set("id", new Long(1L), targetDto);
        reflector.set("kitten", "hello", targetDto);
        reflector.set("puppy", "mi", targetDto);
        reflector.set("giraffe", "van", targetDto);

        // then
        Assert.assertEquals(new DummyTestDto(1L, "hello", "mi", "van"), targetDto);


    }

}
