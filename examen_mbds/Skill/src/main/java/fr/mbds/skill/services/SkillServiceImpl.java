package fr.mbds.skill.services;

import fr.mbds.skill.dtos.SkillDto;
import fr.mbds.skill.mappers.SkillMapper;
import fr.mbds.skill.repositories.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SkillServiceImpl implements ISkillService {

    private final SkillRepository skillRepository;

    private final SkillMapper skillMapper;

    public SkillServiceImpl(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    @Override
    public List<SkillDto> findAll() {
        return skillRepository
                .findAll()
                .stream()
                .map(skillMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SkillDto findById(Long id) {
        return skillMapper.toDTO(skillRepository.findById(id).orElse(null));
    }
}
