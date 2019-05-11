package com.store.car.controller;

import com.store.car.dto.TelevisionSetDto;
import com.store.car.service.TelevisionSetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv")
public class TelevisionSetController {

    private final TelevisionSetService televisionSetService;

    public TelevisionSetController(TelevisionSetService televisionSetService) {
        this.televisionSetService = televisionSetService;
    }

    @GetMapping
    public List<TelevisionSetDto> getAll() {
        return televisionSetService.getAll();
    }

    @GetMapping("/{id}")
    public List<String> getImagesForTv(@PathVariable int id) {
        return televisionSetService.getImagesByTvId(id);
    }

    @PatchMapping
    public void buy(@RequestBody int id) {
        televisionSetService.buy(id);
    }

    @PostMapping
    public void createTV(@RequestBody TelevisionSetDto televisionSetDto) {
        televisionSetService.createTV(televisionSetDto);
    }

    @PatchMapping("/modify")
    public void modifyTV(@RequestBody TelevisionSetDto televisionSetDto) {
        televisionSetService.updateTV(televisionSetDto);
    }

    @DeleteMapping
    public void deleteTV(@RequestBody int id) {
        televisionSetService.deleteTV(id);
    }
}
