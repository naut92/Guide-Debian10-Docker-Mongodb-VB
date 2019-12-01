package com.github.naut92.services.impl;

import com.github.naut92.model.Position;
import com.github.naut92.repository.PositionRepository;
import com.github.naut92.services.PositionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository repository) {
        positionRepository = repository;
    }

    @Override
    //public Collection<Position> getAllPositions() {
        //return positionRepository.findAll();
    public Collection<String> getAllPositions() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream().map(Position::getPosition_name).collect(Collectors.toCollection(ArrayList::new));
    }
}
