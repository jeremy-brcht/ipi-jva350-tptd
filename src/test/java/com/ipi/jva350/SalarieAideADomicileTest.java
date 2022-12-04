package com.ipi.jva350;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ipi.jva350.model.SalarieAideADomicile;

public class SalarieAideADomicileTest {

    @Test
    // indique que sera exécutée par Junit
    public void testALegalementDroitADesCongesPayesLessThan10() {
        // Given : Mise en place de l'environnement du test et de ses données
        // (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(9);
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        Boolean droitCongesPayesOk = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui
        // attendu
        Assertions.assertThat(droitCongesPayesOk).isFalse();
    }

    @Test
    // indique que sera exécutée par Junit
    public void testALegalementDroitADesCongesPayesEquals10() {
        // Given : Mise en place de l'environnement du test et de ses données
        // (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(10);
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        Boolean droitCongesPayesOk = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui
        // attendu
        Assertions.assertThat(droitCongesPayesOk).isTrue();
    }

    @Test
    // indique que sera exécutée par Junit
    public void testALegalementDroitADesCongesPayesMoreThan10() {
        // Given : Mise en place de l'environnement du test et de ses données
        // (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(11);
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        Boolean droitCongesPayesOk = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui
        // attendu
        Assertions.assertThat(droitCongesPayesOk).isTrue();
    }

    @ParameterizedTest(name = "numeroSecu {0} est valide : {1}")
    @CsvSource({
            "'9', false",
            "'10', true",
            "'11', true"
    })
    // indique que sera exécutée par Junit
    public void testALegalementDroitADesCongesPayes(int nbJours, boolean expected) {
        // Given : Mise en place de l'environnement du test et de ses données
        // (hypothèses)
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(nbJours);
        // When : Comportement à tester, en pratique une (ou des) méthode(s) à exécuter
        Boolean droitCongesPayesOk = salarie.aLegalementDroitADesCongesPayes();
        // Then : Comparaison du résultat de la méthode ou de l'état final avec celui
        // attendu
        Assertions.assertThat(droitCongesPayesOk).isEqualTo(expected);
    }
}
