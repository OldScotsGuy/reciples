package org.nickharle.recipeapp.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nickharle.recipeapp.domain.UnitOfMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)    // Starts Spring Context
@DataJpaTest                    // Brings up an embedded database
public class UnitOfMeasureRepositoryIT {

    @Autowired                  // Can use @Autowird as the context will start
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    // @DirtiesContext  - This annotation would force a context reload after the test had been run
    public void findByDescription() throws Exception {

        Optional <UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getDescription());

    }

    @Test
    public void findByDescriptionCup() throws Exception {

        Optional <UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uomOptional.get().getDescription());

    }
}