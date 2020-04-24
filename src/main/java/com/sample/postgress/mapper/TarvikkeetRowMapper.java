package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Tarvikkeet;

public class TarvikkeetRowMapper implements RowMapper<Tarvikkeet> {

	@Override
	public Tarvikkeet mapRow(ResultSet rs, int arg1) throws SQLException {
		Tarvikkeet tarvikkeet = new Tarvikkeet();
		tarvikkeet.settarvikeid(rs.getInt("tarvikeid"));
		tarvikkeet.settarvikenimi(rs.getString("tarvikenimi"));
		tarvikkeet.setyksikko(rs.getString("yksikko"));
		tarvikkeet.setmitta(rs.getInt("setmitta"));
		tarvikkeet.setsisaanottohinta(rs.getDouble("sisaanottohinta"));
		tarvikkeet.setvarastotilanne(rs.getInt("varastotilanne"));
		tarvikkeet.setvero(rs.getInt("vero"));
 
        return tarvikkeet;
	}


}
