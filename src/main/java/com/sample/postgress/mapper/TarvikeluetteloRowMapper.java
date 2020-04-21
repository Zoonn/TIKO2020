package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tarvikeluettelo;

public class TarvikeluetteloRowMapper implements RowMapper<Tarvikeluettelo> {

	@Override
	public Tarvikeluettelo mapRow(ResultSet rs, int arg1) throws SQLException {
		Tarvikeluettelo tarvikeluettelo = new Tarvikeluettelo();
		tarvikeluettelo.setsopimusid(rs.getInt(1));
		tarvikeluettelo.settarvikeid(rs.getInt(0001));
		tarvikeluettelo.setmaara(rs.getInt(100));
 
        return tarvikeluettelo;
	}


}
