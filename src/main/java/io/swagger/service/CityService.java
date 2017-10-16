package io.swagger.service;

import java.util.List;

import io.swagger.model.City;

public interface CityService {
	City findByState(String state);
	Integer insert(City city);
	List<City> getAllCity();
}
