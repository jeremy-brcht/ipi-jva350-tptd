package com.ipi.jva350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ipi.jva350.model.SalarieAideADomicile;
import com.ipi.jva350.repository.SalarieAideADomicileRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SalarieAideADomicileRepositoryTest {
    @Autowired
    SalarieAideADomicileRepository salarieAideADomicileRepository;

    @Test
    public void findByNomTestNotSave(){
        SalarieAideADomicile aide = new SalarieAideADomicile();
        aide.setNom("jeremy");
        Assertions.assertThat(salarieAideADomicileRepository.findByNom("jeremy")).isNull();
    }

    @Test
    public void findByNomTestSave(){
        SalarieAideADomicile aide = new SalarieAideADomicile();
        aide.setNom("jeremy");
        salarieAideADomicileRepository.save(aide);
        Assertions.assertThat(salarieAideADomicileRepository.findByNom("jeremy")).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({
            "2, 4, 0.5",
            "4, 4, 1",
            "3, 4, 0.75",

    })
    void testPartCongesPrisTotauxAnneeNMoins1(Double pris, Double acquis, Double res) {

        SalarieAideADomicile aide = new SalarieAideADomicile();

        aide.setCongesPayesPrisAnneeNMoins1(pris);
        aide.setCongesPayesAcquisAnneeNMoins1(acquis);
        
        salarieAideADomicileRepository.save(aide);
        
        Assertions.assertThat(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1()).isEqualTo(res);
    }
}
