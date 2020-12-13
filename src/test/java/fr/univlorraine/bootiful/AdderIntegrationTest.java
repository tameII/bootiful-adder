package fr.univlorraine.bootiful;


import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.annotations.BeforeStories;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Attention, lors des premiers essais, ils y avait des soucis lors de l'utilisation du bouton play d'inteliJ pour lancer le projet
 * si ça ne fonctionne pas, faire mvn verify dans le terminal
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AdderIntegrationTest extends SerenityStories {
    @BeforeStories
    public void init() {
        System.out.println("-----HELLO MASTER, YOUR SERVER IS STARTING RIGHT AWAY-----");
    }
}
