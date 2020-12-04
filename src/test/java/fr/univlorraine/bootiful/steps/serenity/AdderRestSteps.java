package fr.univlorraine.bootiful.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;


import static io.restassured.RestAssured.*;


/**
 * @author not me
 */
public class AdderRestSteps {


    private int currentNum;
    @Step("Testing if the server give a status code: 200")
    public void contactServer(){
        when().get("http://localhost:8080/adder/current").then().statusCode(200);
    }

    @Step("get the current number")
    public void givenCurrentNumber(){
        currentNum = 10;
            given().
                    param("base", currentNum).
                    when().post("http://localhost:8080/adder/changeBaseNum");

            when().get("http://localhost:8080/adder/current").
                    then().assertThat().body(Matchers.equalTo(""+currentNum));
        }

    @Step("adding {0}")
    public void whenAddNumber(int num) {
        given().param("num", num).get("http://localhost:8080/adder/accumulate");
        currentNum += num;
    }

    @Step("got the sum")
    public void thenSummedUp() {
        when().
                get("http://localhost:8080/adder/current" ).
                then().assertThat().body(Matchers.equalTo(""+currentNum));

    }

}