package com.bsmlabs.restclient;

import java.util.List;

public interface UniversityDataService {
    List<UniversityDataResponse> getUniversityDetails(String countryName);

    List<UniversityDataResponse> getUniversityDataWithBuilder(String countryName);
}
