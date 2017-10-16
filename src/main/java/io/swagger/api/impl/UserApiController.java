package io.swagger.api.impl;

import io.swagger.annotations.*;
import io.swagger.api.UserApi;
import io.swagger.model.City;
import io.swagger.model.InlineResponseDefault;
import io.swagger.service.CityService;
import io.swagger.service.impl.CityServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import javax.validation.constraints.*;

@Controller
public class UserApiController implements UserApi {

	private CityService cityService;

	public ResponseEntity<Object> userGet(
			@NotNull @ApiParam(value = "a user's name", required = true) @RequestParam(value = "username", required = true) String username) {
		InlineResponseDefault body = new InlineResponseDefault();
		body.setFields(this.cityService.findByState("CA").toString());
		this.cityService.insert(new City().setName("BeiJing").setCountry("China").setState("BeiJing"));
		List<City> cities = this.cityService.getAllCity();
		StringBuilder message = new StringBuilder();
		cities.forEach((city) -> message.append(city.toString()));
		body.setMessage(cities.toString());
		return new ResponseEntity<Object>(body, HttpStatus.OK);
	}

	@Autowired
	public void setCityService(CityServiceImpl cityService) {
		this.cityService = cityService;
	}
}
