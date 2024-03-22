package fr.mbds.skill.controllers;

import fr.mbds.skill.dtos.SkillDto;
import fr.mbds.skill.services.ISkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {
private final ISkillService skillService;

    public SkillController(ISkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/skills")
    public List<SkillDto> findAllSkills() {
        return skillService.findAll();
    }

    @GetMapping("/skill/{id}")
    public SkillDto findSkillById(@PathVariable Long id) {
        return skillService.findById(id);
    }
}
