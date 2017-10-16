package io.swagger.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.dao.SQLExecuter;

public class BaseDao {
	private SqlSessionFactory factory;

	@Autowired
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	protected <T> T mybatisExecuter(SQLExecuter<T> executer) {
		T t = null;
		SqlSession session = null;
		try {
			session = this.factory.openSession(false);
			t = executer.execute(session);
			session.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return t;
	}
}
