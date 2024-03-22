package fr.mbds.position.mappers;

import fr.mbds.position.dtos.PositionDto;
import fr.mbds.position.entities.PositionEntity;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {

    public PositionDto toDTO(PositionEntity position)
    {
        return new PositionDto(position.getId(), position.getTitle(), position.getAverageSalary(), position.getSkillIds(), position.getSkills());
    }
/*
    public PositionEntity toPosition(PositionDto positionDto)
    {
        if (positionDto != null)
            return new PositionEntity(null, positionDto.getTitle(), positionDto.getAverageSalary(), positionDto.getSkillIds());
        return null;
    }

 */
}
