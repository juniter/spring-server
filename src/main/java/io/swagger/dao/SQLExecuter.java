package io.swagger.dao;

import org.apache.ibatis.session.SqlSession;

/**
 * SQL 具体执行类
 * @author Juniter
 *
 * @param <T>
 */
public interface SQLExecuter<T> {
	T execute(SqlSession session);
}
