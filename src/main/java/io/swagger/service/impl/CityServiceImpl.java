package io.swagger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.dao.CityDao;
import io.swagger.dao.CityMapper;
import io.swagger.dao.impl.CityDaoImpl;
import io.swagger.model.City;
import io.swagger.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	private CityMapper cityMapper;
	private CityDao cityDao;

	public City findByState(String state) {
		return this.cityMapper.findByState(state);
	}

	@Override
	public Integer insert(City city) {
		return this.cityDao.insert(city);
	}
	

	@Override
	public List<City> getAllCity() {
		return this.cityDao.gta();
	}

	@Autowired
	public void setCityDao(CityDaoImpl cityDao) {
		this.cityDao = cityDao;
	}

	@Autowired
	public void setCityMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}
}
