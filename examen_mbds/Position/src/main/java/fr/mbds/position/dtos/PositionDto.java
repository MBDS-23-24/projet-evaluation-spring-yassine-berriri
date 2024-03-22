package fr.mbds.position.dtos;

import fr.mbds.position.models.Skill;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    private Long id;
    private String title;
    private double averageSalary;
    private List<Long> skillIds;
    private List<Skill> skills;
}

