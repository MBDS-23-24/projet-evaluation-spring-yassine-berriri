package fr.mbds.position.services;

import fr.mbds.position.dtos.PositionDto;

import java.util.List;

public interface IPositionService {
    List<PositionDto> findAll();
    PositionDto findById(Long id);
    List<PositionDto> getAllPositionsWithSkills();
    PositionDto getPositionByIdWithSkills(Long id);
}
