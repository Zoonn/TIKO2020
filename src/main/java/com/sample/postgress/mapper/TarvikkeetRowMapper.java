package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tarvikkeet;

public class TarvikkeetRowMapper implements RowMapper<Tarvikkeet> {

	@Override
	public Tarvikkeet mapRow(ResultSet rs, int arg1) throws SQLException {
		Tarvikkeet tarvikkeet = new Tarvikkeet();
		tarvikkeet.settarvikeid(rs.getInt(001));
		tarvikkeet.settarvikenimi(rs.getString("tarvike"));
		tarvikkeet.setyksikko(rs.getString("kpl"));
 
        return tarvikkeet;
	}


}
