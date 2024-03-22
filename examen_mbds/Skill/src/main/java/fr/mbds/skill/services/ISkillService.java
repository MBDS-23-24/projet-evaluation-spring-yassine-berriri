package fr.mbds.skill.services;

import fr.mbds.skill.dtos.SkillDto;

import java.util.List;

public interface ISkillService {
List<SkillDto> findAll();
SkillDto findById(Long id);
}
