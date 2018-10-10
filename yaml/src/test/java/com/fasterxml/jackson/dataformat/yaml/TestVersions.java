package com.fasterxml.jackson.dataformat.yaml;

import java.io.*;

import com.fasterxml.jackson.core.*;

public class TestVersions extends ModuleTestBase
{
    private final YAMLMapper MAPPER = newObjectMapper();

    @SuppressWarnings("resource")
    public void testMapperVersions() throws IOException
    {
//        assertVersion(MAPPER);
        assertVersion(MAPPER.tokenStreamFactory());
        JsonParser p = MAPPER.createParser("123");
        assertVersion(p);
        p.close();
        JsonGenerator gen = MAPPER.createGenerator(new ByteArrayOutputStream());
        assertVersion(gen);
    }

    @SuppressWarnings("resource")
    public void testDefaults() throws Exception
    {
        YAMLFactory f = MAPPER.tokenStreamFactory();
        assertFalse(f.canHandleBinaryNatively());
        assertFalse(f.canUseCharArrays());

        JsonParser p = MAPPER.createParser(new StringReader(""));
        assertTrue(p.canReadObjectId());
        assertTrue(p.canReadTypeId());
        p.close();

        JsonGenerator g = MAPPER.createGenerator(new StringWriter());
        assertTrue(g.canOmitFields());
        assertTrue(g.canWriteFormattedNumbers());
        assertTrue(g.canWriteObjectId());
        assertTrue(g.canWriteTypeId());
        assertFalse(g.canWriteBinaryNatively());
        // note: do not try to close it, no content, exception
    }
    
    /*
    /**********************************************************
    /* Helper methods
    /**********************************************************
     */
    
    private void assertVersion(Versioned vers)
    {
        assertEquals(PackageVersion.VERSION, vers.version());
    }
}

