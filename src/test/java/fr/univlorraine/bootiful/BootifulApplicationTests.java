package fr.univlorraine.bootiful;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class BootifulApplicationTests {

    @Test
    void contextLoads() {
        //You can do something like choose the current number here
    }

    /**
     * This test is just to see if restassured work correctly
     */
    @Test public void
    adder_current_return_sth() {
        when().
                get("/adder/current" ).
                then().contentType(ContentType.JSON);

    }

    @Test public void
    adder_post_new_number() {
        given().
                param("base", 10).
                when().post("/adder/changeBaseNum");

        when().get("/adder/current").
                then().assertThat().body(equalTo("10"));
    }

    /**
     * These test below test with a method POST at the begin
     **note that we can use "get current number" to do the test to.
     */
    @Test public void
    adder_get_add() {
        given().
                param("base", 10).
                when().post("/adder/changeBaseNum");

        given().
                param("num", 10).
                when().get("/adder/add").
                then().assertThat().body(equalTo("20"));
    }

    @Test public void
    adder_get_substract(){
        given().
                param("base", 10).
                when().post("/adder/changeBaseNum");

        given().
                param("num", 10).
                when().get("/adder/substract").
                then().assertThat().body(equalTo("0"));
    }

    @Test public void
    adder_get_accumulate(){
        given().
                param("base", 10).
                when().post("/adder/changeBaseNum");

        given().param("num", 10).get("/adder/accumulate");

        when().
                get("/adder/current" ).
                then().assertThat().body(equalTo("20"));

    }


}
