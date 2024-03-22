package fr.mbds.position.entities;

import fr.mbds.position.models.Skill;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class PositionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double averageSalary;
    @Transient
    private List<Skill> skills;

    @ElementCollection
    private List<Long> skillIds;



}
