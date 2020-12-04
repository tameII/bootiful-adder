package fr.univlorraine.bootiful.features.add;

import fr.univlorraine.bootiful.steps.serenity.AdderRestSteps;
import fr.univlorraine.bootiful.steps.serenity.AdderServiceSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(SerenityRunner.class)
public class AdderStory {

    @Steps
    public AdderServiceSteps adderService;

    @Steps
    public AdderRestSteps restSteps;

    @Test
    public void contact_server(){
        restSteps.contactServer();
    }

    @Test
    public void adding_two_should_give_the_sum_of_both() {
        //GIVEN
        adderService.givenBaseAndAdder(10, 5);
        //WHEN
        adderService.whenAdd();
        //THEN
        adderService.summedUp();
    }

    @Test
    public void without_connection_adding_two_number_with_adderRest_should_give_sum_of_both() {
        restSteps.givenCurrentNumber();
        restSteps.whenAddNumber(10);
        restSteps.thenSummedUp();
    }


}
