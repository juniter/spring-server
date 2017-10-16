package io.swagger.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import io.swagger.model.City;

@Mapper
public interface CityMapper {
	@Select("SELECT id,name,state,country FROM city WHERE state = #{state}")
	City findByState(String state);
}
