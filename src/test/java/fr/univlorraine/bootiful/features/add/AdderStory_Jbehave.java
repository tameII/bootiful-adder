package fr.univlorraine.bootiful.features.add;

import fr.univlorraine.bootiful.steps.serenity.AdderRestSteps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * This adder story is linked to AdderStory_Jbehave.story (in theory)
 * Given a number
 * When I submit another number 10 to adder
 * Then I get a sum of the numbers
 */
public class AdderStory_Jbehave {
    @Steps AdderRestSteps restSteps;

    @Given("a number")
    public void givenANumber(){
        restSteps.givenCurrentNumber();
    }
    @When("I submit another number $num to adder")
    public void whenISubmitToAdderWithNumber(int num){
        restSteps.whenAddNumber(num);
    }
    @Then("I get a sum of the numbers")
    public void thenIGetTheSumOfTheNumbers(){
        restSteps.thenSummedUp();
    }
}
