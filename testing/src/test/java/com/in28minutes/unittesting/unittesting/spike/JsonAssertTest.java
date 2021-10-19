package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"ball\",\"price\":100,\"qty\":100}";

    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"ball\",\"price\":100}";
        //JSONAssert.assertEquals(expectedResponse, actualResponse, true); // this fails
        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // this success
    }

    @Test
    public void jsonAssert_WithoutEscapes() throws JSONException {
        String expectedResponse = "{id:1,name:ball,price:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false); // this success
    }
}
