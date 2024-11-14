// FoyerServiceTest.java
package tn.esprit.spring.Services.Foyer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Repositories.BlocRepository;
import tn.esprit.spring.DAO.Repositories.FoyerRepository;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FoyerServiceTest {

    @InjectMocks
    private FoyerService foyerService;

    @Mock
    private FoyerRepository foyerRepository;

    @Mock
    private BlocRepository blocRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculerTauxOccupation() {
        // Création de données simulées
        Foyer foyer = new Foyer();
        Bloc bloc1 = new Bloc();
        bloc1.setNombreChambres(10);
        bloc1.setReservations(List.of(new Reservation(), new Reservation())); // 2 réservations
        
        Bloc bloc2 = new Bloc();
        bloc2.setNombreChambres(20);
        bloc2.setReservations(List.of(new Reservation())); // 1 réservation

        foyer.setBlocs(List.of(bloc1, bloc2));

        // Configuration du comportement mock
        when(foyerRepository.findById(1L)).thenReturn(Optional.of(foyer));

        // Appel de la méthode de test
        int tauxOccupation = foyerService.calculerTauxOccupation(1L);

        // Vérification
        assertEquals(10, tauxOccupation, "Le taux d'occupation devrait être de 10%");
    }
}
