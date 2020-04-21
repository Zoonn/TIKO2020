package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tyoluettelo;

public class TyoluetteloRowMapper implements RowMapper<Tyoluettelo> {

	@Override
	public Tyoluettelo mapRow(ResultSet rs, int arg1) throws SQLException {
		Tyoluettelo tyoluettelo = new Tyoluettelo();
		tyoluettelo.setsopimusid(rs.getInt(1));
		tyoluettelo.settyoid(rs.getInt(01));
		tyoluettelo.setmaara(rs.getInt(250));
 
        return tyoluettelo;
	}


}
