package com.sample.postgress.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sample.postgress.entity.Asiakas;
import com.sample.postgress.mapper.AsiakasRowMapper;

@Repository
public class AsiakasDaoImpl implements AsiakasDao{
	
	public AsiakasDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Asiakas> findAll() {
		return template.query("select * from asiakas", new AsiakasRowMapper());
	}
	@Override
	public void insertAsiakas(Asiakas asiakas) {
		 final String sql = "insert into asiakas(nimi, puhelinnumero, sahkoposti, osoite, yritys)" +
		                    " values(?, ?, ?, ?, ?)";
		 
		jdbcTemplate.update(sql, asiakas.getnimi(), asiakas.getpuhelinnumero(), asiakas.getsahkoposti(),
		                    asiakas.getosoite(), asiakas.getyritys());
	}
	
	@Override
	public void updateAsiakas(Asiakas asiakas) {
		 final String sql = "update asiakas set nimi=?, puhelinnumero=?::int, sahkoposti=?, "+
		                    "osoite=?, yritys=? where asiakasid=?::int";
		jdbcTemplate.update(sql, asiakas.getnimi(), asiakas.getpuhelinnumero(), asiakas.getsahkoposti(),
		                    asiakas.getosoite(), asiakas.getyritys(), asiakas.getasiakasid());
	}
	
	@Override
	public void executeUpdateAsiakas(Asiakas asiakas) {
		 final String sql = "update asiakas set nimi=:nimi, puhelinnumero=:puhelinnumero::int, sahkoposti=:sahkoposti, " +
		                    "osoite=:osoite, yritys=:yritys where asiakasid=:asiakasid::int";
			 
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
	public void deleteAsiakas(int asiakasid) {
		 final String sql = "delete from asiakas where asiakasid=?";
		 jdbcTemplate.update(sql, asiakasid); 
	}	
	@Override
	public Asiakas findAsiakasById(int asiakasid) {
		String query = "SELECT * FROM asiakas WHERE asiakasid = ?";
		RowMapper<Asiakas> rowMapper = new BeanPropertyRowMapper<Asiakas>(Asiakas.class);
		Asiakas asiakas = jdbcTemplate.queryForObject(query, rowMapper, asiakasid);
  
        return asiakas;
	}
}
