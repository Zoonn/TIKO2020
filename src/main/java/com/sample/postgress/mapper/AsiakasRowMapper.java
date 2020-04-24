package com.sample.postgress.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sample.postgress.entity.Asiakas;

public class AsiakasRowMapper implements RowMapper<Asiakas> {

	@Override
	public Asiakas mapRow(ResultSet rs, int arg1) throws SQLException {
		Asiakas asiakas = new Asiakas();
		asiakas.setasiakasid(rs.getString("asiakasid"));
		asiakas.setnimi(rs.getString("nimi"));
		asiakas.setpuhelinnumero(rs.getInt("puhelinnumero"));
		asiakas.setosoite(rs.getString("osoite"));
		asiakas.setsahkoposti(rs.getString("sahkoposti"));
		asiakas.setyritys(rs.getString("yritys"));
 
        return asiakas;
	}


}
