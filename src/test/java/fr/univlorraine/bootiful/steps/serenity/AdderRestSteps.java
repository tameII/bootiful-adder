package fr.univlorraine.bootiful.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;


import static io.restassured.RestAssured.*;


/**
 * @author notMe
 */
public class AdderRestSteps {


    private int currentNum;
    @Step("Testing if the server give a status code: 200")
    public void contactServer(){
        when().get("/adder/current").then().statusCode(200);
    }

    @Step("get the current number")
    public void givenCurrentNumber(){
        currentNum = 10;
            given().
                    param("base", currentNum).
                    when().post("/adder/changeBaseNum");

        when().get("/adder/current").
                then().assertThat().body(Matchers.equalTo(""+currentNum));
        }

    @Step("adding {0}")
    public void whenAddNumber(int num) {
        given().param("num", num).get("/adder/accumulate");
        currentNum += num;
    }

    @Step("got the sum")
    public void thenSummedUp() {
        when().
                get("/adder/current" ).
                then().assertThat().body(Matchers.equalTo(""+currentNum));

    }

}