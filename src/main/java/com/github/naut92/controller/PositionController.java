package com.github.naut92.controller;

import com.github.naut92.services.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class PositionController {
    private final PositionService positionService;

    public PositionController(PositionService ps) {
        positionService = ps;
    }

    //for dev-mode only:
    @GetMapping("/positions")
    public Collection<String> getAllPositions(){
        return positionService.getAllPositions();
    }
}
