package com.bsmlabs.restclient;

import java.util.List;

public record UniversityDataResponse(String alpha_two_code,
                                     List<String> web_pages,
                                     String state_province,
                                     String name,
                                     List<String> domains,
                                     String country) {
}
