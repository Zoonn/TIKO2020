package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tyo;

public class TyoRowMapper implements RowMapper<Tyo> {

	@Override
	public Tyo mapRow(ResultSet rs, int arg1) throws SQLException {
		Tyo tyo = new Tyo();
		tyo.settyoid(rs.getInt("tyoid"));
		tyo.settyonnimi(rs.getString("tyonnimi"));
		tyo.setvero(rs.getInt("vero"));
 
        return tyo;
	}


}
