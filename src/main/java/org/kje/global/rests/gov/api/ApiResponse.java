package org.kje.global.rests.gov.api;

import lombok.Data;

@Data
public class ApiResponse {
    private ApiHeader header;
    private ApiBody body;

}