package com.ipi.jva350;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ipi.jva350.model.Entreprise;

public class EntrepriseTest {
    
    @ParameterizedTest
    @CsvSource({
            "'2022-11-01', true",
            "'2022-11-02', false",

    })
    void testEstJourFerie(LocalDate jour, Boolean expected) {

        Boolean res = Entreprise.estJourFerie(jour);

        Assertions.assertThat(res).isEqualTo(expected);
    }
}
