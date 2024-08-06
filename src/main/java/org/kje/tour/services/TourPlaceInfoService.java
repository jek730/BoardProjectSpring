package org.kje.tour.services;

import lombok.RequiredArgsConstructor;
import org.kje.tour.controllers.TourPlaceSearch;
import org.kje.tour.entities.TourPlace;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TourPlaceInfoService {

    private final RestTemplate restTemplate;

    public List<TourPlace> getList(TourPlaceSearch search) {

        return null;
    }
}