package io.swagger.dao;

import java.util.List;

import io.swagger.model.City;

public interface CityDao {
	Integer insert(City city);
	List<City> gta();
}
