package fr.mbds.skill.mappers;

import fr.mbds.skill.dtos.SkillDto;
import fr.mbds.skill.entities.SkillEntity;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper {

    public SkillDto toDTO(SkillEntity skill)
    {
        return new SkillDto(skill.getId(), skill.getName());
    }

    public SkillEntity toSkill(SkillDto skillDto)
    {
        if (skillDto != null)
            return new SkillEntity(null, skillDto.getName());
        return null;
    }
}
