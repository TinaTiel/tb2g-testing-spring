package org.springframework.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.web.VetController;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class VetControllerTest {

    @Mock
    ClinicService clinicService;

    @InjectMocks
    VetController vetController;

    @BeforeEach
    void setUp() {

    }

    @Test
    void showVetListModelPopulatedWithVets() {

        // Given the clinic service returns vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Nancy");
        Vet vet2 = new Vet();
        vet2.setFirstName("Bob");
        given(clinicService.findVets()).willReturn(Arrays.asList(vet1, vet2));

        // When called
        Map<String, Object> map = new HashMap<>();
        String result = vetController.showVetList(map);

        // Then the model contains the vets, and the expected view is returned
        assertThat(result).isEqualTo("vets/vetList");
        assertThat(((Vets) map.get("vets")).getVetList()).containsExactly(vet1, vet2);

    }

    @Test
    void showResourcesVetListPopulatedWithVets() {

        // Given the clinic service returns vets
        Vet vet1 = new Vet();
        vet1.setFirstName("Nancy");
        Vet vet2 = new Vet();
        vet2.setFirstName("Bob");
        given(clinicService.findVets()).willReturn(Arrays.asList(vet1, vet2));

        // When called
        Map<String, Object> map = new HashMap<>();
        vetController.showVetList(map);

        // Then the model contains the vets, and the expected view is returned
        assertThat(((Vets) map.get("vets")).getVetList()).containsExactly(vet1, vet2);

    }
}
