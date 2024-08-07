package org.kje.tour.controllers;

import lombok.Data;

@Data
public class TourPlaceSearch {
    private Double latitude;
    private Double longitude;
    private Integer radius = 1000;
}