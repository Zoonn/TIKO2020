package com.sample.postgress.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Asiakas;
import com.sample.postgress.mapper.AsiakasRowMapper;

@Repository
public class AsiakasDaoImpl implements AsiakasDao{
	
	public AsiakasDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Asiakas> findAll() {
		return template.query("select * from Asiakas", new AsiakasRowMapper());
	}
	@Override
	public void insertAsiakas(Asiakas asiakas) {
		 final String sql = "insert into Asiakas(asiakasid, nimi, puhelinnumero, sahkoposti, osoite, yritys)" +
		                    " values(:asiakasid,:nimi,:puhelinnumero,:sahkoposti, :osoite, :yritys)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("asiakasid", asiakas.getasiakasid())
					.addValue("nimi", asiakas.getnimi())
					.addValue("sahkoposti", asiakas.getsahkoposti())
					.addValue("puhelinnumero", asiakas.getpuhelinnumero())
					.addValue("osoite", asiakas.getosoite())
					.addValue("yritys", asiakas.getyritys());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateAsiakas(Asiakas asiakas) {
		 final String sql = "update Asiakas set nimi=:nimi, puhelinnumero=:puhelinnumero, sahkoposti=:sahkoposti, "+
		                    "osoite=:osoite, yritys=:yritys where asiakasid=:asiakasid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("asiakasid", asiakas.getasiakasid())
					.addValue("nimi", asiakas.getnimi())
					.addValue("sahkoposti", asiakas.getsahkoposti())
					.addValue("puhelinnumero", asiakas.getpuhelinnumero())
					.addValue("osoite", asiakas.getosoite())
					.addValue("yritys", asiakas.getyritys());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void executeUpdateAsiakas(Asiakas asiakas) {
		 final String sql = "update Asiakas set nimi=:nimi, puhelinnumero=:puhelinnumero, sahkoposti=:sahkoposti, " +
		                    "osoite=:osoite, yritys=:yritys where asiakasid=:asiakasid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("asiakasid", asiakas.getasiakasid());
		 map.put("nimi", asiakas.getnimi());
		 map.put("sahkoposti", asiakas.getsahkoposti());
		 map.put("puhelinnumero", asiakas.getpuhelinnumero());
		 map.put("osoite", asiakas.getosoite());
		 map.put("yritys", asiakas.getyritys());
		 ;

		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}
	
	@Override
	public void deleteAsiakas(Asiakas asiakas) {
		 final String sql = "delete from Asiakas where asiakasid=:asiakasid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("asiakasid", asiakas.getasiakasid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
