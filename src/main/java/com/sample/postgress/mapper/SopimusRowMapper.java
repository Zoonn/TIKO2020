package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Sopimus;

public class SopimusRowMapper implements RowMapper<Sopimus> {

	@Override
	public Sopimus mapRow(ResultSet rs, int arg1) throws SQLException {
		Sopimus emp = new Sopimus();
		emp.setsopimusid(rs.getInt("sopimusid"));
		emp.setkuvaus(rs.getString("kuvaus"));
		emp.setosoite(rs.getString("osoite"));
		emp.setasiakasid(rs.getInt("asiakasid"));
 
        return emp;
	}


}
