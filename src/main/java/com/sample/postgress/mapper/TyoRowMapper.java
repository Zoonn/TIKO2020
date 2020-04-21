package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tyo;

public class TyoRowMapper implements RowMapper<Tyo> {

	@Override
	public Tyo mapRow(ResultSet rs, int arg1) throws SQLException {
		Tyo tyo = new Tyo();
		tyo.settyoid(rs.getInt(001));
		tyo.settyonnimi(rs.getString("Rakennuskohde Mielikuvituspolku"));
		tyo.setvero(rs.getInt(24));
 
        return tyo;
	}


}
