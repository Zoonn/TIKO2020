package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Lasku;

public class LaskuRowMapper implements RowMapper<Lasku> {

	@Override
	public Lasku mapRow(ResultSet rs, int arg1) throws SQLException {
		Lasku lasku = new Lasku();
		lasku.setlaskuid(rs.getInt(1));
		lasku.setsopimusid(rs.getInt(1));
		lasku.seterapaiva(rs.getString("17012021"));
 
        return lasku;
	}


}
