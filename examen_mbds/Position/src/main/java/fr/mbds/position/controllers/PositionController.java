package fr.mbds.position.controllers;

import fr.mbds.position.dtos.PositionDto;
import fr.mbds.position.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PositionController {
private final IPositionService positionService;

    @Autowired
    public PositionController(IPositionService positionService) {
        this.positionService = positionService;
    }

    // Récupère toutes les positions
    @GetMapping()
    public ResponseEntity<List<PositionDto>> findAll() {
        List<PositionDto> positions = positionService.getAllPositionsWithSkills();
        return ResponseEntity.ok(positions); // Retourne la liste des positions avec un statut 200 OK
    }

    // Récupère une position spécifique par son ID
    @GetMapping("/{id}")
    public ResponseEntity<PositionDto> findById(@PathVariable Long id) {
        PositionDto positionDTO = positionService.getPositionByIdWithSkills(id);
        if (positionDTO != null) {
            return ResponseEntity.ok(positionDTO); // Retourne la position avec un statut 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Retourne un statut 404 Not Found si la position n'est pas trouvée
        }
    }
}
