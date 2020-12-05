package org.springframework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.samples.petclinic.service.ClinicServiceImpl;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ClinicServiceImplTest {

    @Mock
    PetRepository petRepository;

    @Mock
    VetRepository vetRepository;

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    VisitRepository visitRepository;

    @InjectMocks
    ClinicServiceImpl clinicService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void findPetTypes() {

        // Given pet repo returns pet types
        PetType petType1 = new PetType();
        petType1.setName("doggo");
        PetType petType2 = new PetType();
        petType2.setName("birb");
        given(petRepository.findPetTypes()).willReturn(Arrays.asList(petType1, petType2));

        // When called
        Collection<PetType> results = petRepository.findPetTypes();

        // The the expected pet types are returned
        assertThat(results).containsExactly(petType1, petType2);

    }
}
