package com.ayesa.model;

import java.sql.SQLException;
import java.util.List;

public interface CRUDrepository<T> {
	boolean create(T t );
	List<T> readAll();
	List<T> readOne(T t ) throws SQLException;
	boolean update(T t, T t2);
	boolean delete(T t );

}
