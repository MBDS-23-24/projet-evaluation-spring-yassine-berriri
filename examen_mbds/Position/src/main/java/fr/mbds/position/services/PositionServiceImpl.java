package fr.mbds.position.services;

import fr.mbds.position.clients.SkillProxy;
import fr.mbds.position.dtos.PositionDto;
import fr.mbds.position.entities.PositionEntity;
import fr.mbds.position.mappers.PositionMapper;
import fr.mbds.position.models.Skill;
import fr.mbds.position.repositories.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements IPositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;
    private final SkillProxy skillProxy;

    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper,SkillProxy skillProxy) {
        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
        this.skillProxy = skillProxy;


    }


    @Override
    public List<PositionDto> findAll() {
        // Utilisez le repository pour récupérer toutes les positions, puis convertissez-les en DTOs
        return positionRepository.findAll().stream()
                .map(positionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDto findById(Long id) {
        // Utilisez le repository pour trouver une position par son ID, convertissez-la en DTO si présente
        Optional<PositionEntity> position = positionRepository.findById(id);
        return position.map(positionMapper::toDTO).orElse(null);
    }
    @Override
    public List<PositionDto> getAllPositionsWithSkills() {
        return positionRepository.findAll().stream()
                .map(this::convertPositionToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDto getPositionByIdWithSkills(Long id) {
        Optional<PositionEntity> positionOptional = positionRepository.findById(id);
        if (positionOptional.isPresent()) {
            return convertPositionToDTO(positionOptional.get());
        }
        // Gérer le cas où la position n'existe pas, par exemple en renvoyant null ou en lançant une exception
        return null;
    }



    private PositionDto convertPositionToDTO(PositionEntity position) {
        List<Skill> skills = position.getSkillIds().stream()
                .map(skillId -> {
                    try {
                        Skill skill = skillProxy.getSkill(skillId); // Utilisez le proxy pour récupérer chaque compétence
                        return new Skill(skill.getId(), skill.getName());
                    } catch (Exception e) {
                        return new Skill(skillId, "Default Skill"); // Gestion d'erreur simplifiée
                    }
                })
                .collect(Collectors.toList());

        return new PositionDto(position.getId(), position.getTitle(), position.getAverageSalary(), position.getSkillIds(),skills);
    }
}
