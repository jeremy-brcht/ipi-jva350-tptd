package com.ipi.jva350;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
}
