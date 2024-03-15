package com.bsmlabs.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityDataController {

    private final UniversityDataService universityDataService;

    public UniversityDataController(UniversityDataService universityDataService) {
        this.universityDataService = universityDataService;
    }

    @GetMapping("{country}")
    public List<UniversityDataResponse> getUniversityData(@PathVariable("country") String country) {
       return universityDataService.getUniversityDetails(country);
    }

    @GetMapping("data/{country}")
    public List<UniversityDataResponse> getUniversityDataWithBuilder(@PathVariable("country") String country) {
        return universityDataService.getUniversityDetails(country);
    }
}
