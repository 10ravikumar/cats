package com.endava.cats.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;

class CatsParamsTest {

    private final CatsUtil catsUtil = new CatsUtil(Mockito.mock(CatsDSLParser.class));

    @Test
    void shouldThrowExceptionOnMissingRefData() {
        CatsParams catsParams = new CatsParams(catsUtil);
        ReflectionTestUtils.setField(catsParams, "refDataFile", "mumu");

        Assertions.assertThrows(IOException.class, catsParams::loadRefData);
    }

    @Test
    void shouldThrowExceptionOnMissingHeadersFile() {
        CatsParams catsParams = new CatsParams(catsUtil);
        ReflectionTestUtils.setField(catsParams, "headersFile", "mumu");

        Assertions.assertThrows(IOException.class, catsParams::loadHeaders);
    }

    @Test
    void shouldThrowExceptionOnNullUrlParams() {
        CatsParams catsParams = new CatsParams(catsUtil);

        Assertions.assertThrows(IOException.class, catsParams::loadURLParams);
    }
}
