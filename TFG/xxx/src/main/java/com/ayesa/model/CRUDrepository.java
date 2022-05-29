package com.ayesa.model;

import java.sql.SQLException;
import java.util.List;

public interface CRUDrepository<T> {
	boolean Create(T t );
	List<T> ReadAll();
	List<T> ReadOne(T t ) throws SQLException;
	boolean Update(T t, T t2);
	boolean Delete(T t );

}
