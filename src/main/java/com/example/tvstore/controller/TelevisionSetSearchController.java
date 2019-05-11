package com.example.tvstore.controller;

import com.example.tvstore.dto.TelevisionSetDto;
import com.example.tvstore.dto.TelevisionSetFilterDto;
import com.example.tvstore.service.TelevisionSetSearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class TelevisionSetSearchController {

    private final TelevisionSetSearchService televisionSetSearchService;

    public TelevisionSetSearchController(TelevisionSetSearchService televisionSetSearchService) {
        this.televisionSetSearchService = televisionSetSearchService;
    }

    @PostMapping("/name")
    public List<TelevisionSetDto> searchByName(@RequestBody String name) {
        return televisionSetSearchService.searchByName(name);
    }

    @PostMapping("/diagonal")
    public List<TelevisionSetDto> searchByDiagonal(@RequestBody List<String> diagonals) {
        return televisionSetSearchService.searchByDiagonal(diagonals);
    }

    @PostMapping("/band")
    public List<TelevisionSetDto> searchByDigitalTunerBand(@RequestBody List<String> digitalTunerBands) {
        return televisionSetSearchService.searchByDigitalTunerBand(digitalTunerBands);
    }

    @PostMapping("/manufacturer")
    public List<TelevisionSetDto> searchByManufacturer(@RequestBody List<String> manufacturers) {
        return televisionSetSearchService.searchByManufacturer(manufacturers);
    }

    @PostMapping("/resolution")
    public List<TelevisionSetDto> searchByResolution(@RequestBody List<String> resolutions) {
        return televisionSetSearchService.searchByResolution(resolutions);
    }

    @PostMapping("/props")
    public List<TelevisionSetDto> searchBySpecialProps(@RequestBody List<String> specialProps) {
        return televisionSetSearchService.searchBySpecialProps(specialProps);
    }

    @PostMapping("/wifi")
    public List<TelevisionSetDto> searchByWifiModule(@RequestBody Boolean isWifi) {
        return televisionSetSearchService.searchByWifiModule(isWifi);
    }

    @PostMapping("/filter")
    public List<TelevisionSetDto> filters(@RequestBody TelevisionSetFilterDto televisionSetFilterDto) {
        return televisionSetSearchService.filters(televisionSetFilterDto);
    }
}
