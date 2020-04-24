package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Lasku;

public class LaskuRowMapper implements RowMapper<Lasku> {

	@Override
	public Lasku mapRow(ResultSet rs, int arg1) throws SQLException {
		Lasku lasku = new Lasku();
		lasku.setlaskuid(rs.getInt("laskuid"));
		lasku.setsopimusid(rs.getInt("sopimusid"));
		lasku.seterapaiva(rs.getString("erapaiva"));
		lasku.setlaskutuslisa(rs.getInt("laskutuslisa"));
		lasku.setpaivamaara(rs.getString("paivamaara"));
		lasku.settila(rs.getBoolean("tila"));
 
        return lasku;
	}


}
