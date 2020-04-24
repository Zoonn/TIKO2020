package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tarvikeluettelo;

public class TarvikeluetteloRowMapper implements RowMapper<Tarvikeluettelo> {

	@Override
	public Tarvikeluettelo mapRow(ResultSet rs, int arg1) throws SQLException {
		Tarvikeluettelo tarvikeluettelo = new Tarvikeluettelo();
		tarvikeluettelo.setsopimusid(rs.getInt("sopimusid"));
		tarvikeluettelo.settarvikeid(rs.getInt("tarvikeid"));
		tarvikeluettelo.setmaara(rs.getInt("maara"));
		tarvikeluettelo.setalennus(rs.getInt("alennus"));
		tarvikeluettelo.setveroton_hinta(rs.getInt("veroton_hinta"));
 
        return tarvikeluettelo;
	}


}
