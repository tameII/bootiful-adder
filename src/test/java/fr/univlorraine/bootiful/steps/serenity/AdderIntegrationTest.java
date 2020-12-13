package fr.univlorraine.bootiful.steps.serenity;

import fr.univlorraine.bootiful.controller.AdderController;
import fr.univlorraine.bootiful.services.AdderService;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.BeforeStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Attention, lors des premiers essais, ils y avait des soucis lors de l'utilisation du bouton play d'inteliJ pour lancer le projet
 * si ça ne fonctionne pas, faire mvn verify dans le terminal
 */
@ContextConfiguration(classes = {
        AdderController.class, AdderService.class })
public class AdderIntegrationTest extends SerenityStories {
    @Autowired
    private AdderService adderService;
    @BeforeStory
    public void init() {
        System.out.println("-----HELLO MASTER, YOUR SERVER IS STARTING RIGHT AWAY-----");
    }
}
