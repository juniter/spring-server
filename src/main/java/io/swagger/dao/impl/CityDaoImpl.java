package io.swagger.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import io.swagger.dao.CityDao;
import io.swagger.dao.SQLExecuter;
import io.swagger.model.City;

@Repository
public class CityDaoImpl extends BaseDao implements CityDao {

	@Override
	public Integer insert(City city) {
		return super.mybatisExecuter(new SQLExecuter<Integer>() {
			@Override
			public Integer execute(SqlSession session) {
				return session.insert("com.juniter.city.ins", city);
			}
		});
	}

	@Override
	public List<City> gta() {
		return super.mybatisExecuter(new SQLExecuter<List<City>>() {
			@Override
			public List<City> execute(SqlSession session) {
				return session.selectList("com.juniter.city.gta");
			}
		});
	}
	
	

}
