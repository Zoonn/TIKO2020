package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Sopimus;

public class SopimusRowMapper implements RowMapper<Sopimus> {

	@Override
	public Sopimus mapRow(ResultSet rs, int arg1) throws SQLException {
		Sopimus emp = new Sopimus();
		emp.setsopimusid(rs.getInt(1));
		emp.setkuvaus(rs.getString("kuvaus tähän"));
		emp.setosoite(rs.getString("Mielikuvituspolku 123, Helsinki 00100"));
 
        return emp;
	}


}
