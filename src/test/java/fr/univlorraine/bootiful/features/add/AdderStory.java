package fr.univlorraine.bootiful.features.add;

import fr.univlorraine.bootiful.steps.serenity.AdderRestSteps;
import fr.univlorraine.bootiful.steps.serenity.AdderServiceSteps;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringIntegrationSerenityRunner.class)
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
        restSteps.givenCurrentNumber();
        restSteps.whenAddNumber(10);
        restSteps.thenSummedUp();

    }



}
