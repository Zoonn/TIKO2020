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

import com.sample.postgress.entity.Sopimus;
import com.sample.postgress.mapper.SopimusRowMapper;

@Repository
public class SopimusDaoImpl implements SopimusDao{
	
	public SopimusDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Sopimus> findAll() {
		return template.query("select * from sopimus", new SopimusRowMapper());
	}
	@Override
	public void insertSopimus(Sopimus sopimus) {
		 final String sql = "insert into sopimus(sopimusid, kuvaus, osoite, asiakasid)" +
		                    " values(:sopimusid,:kuvaus,:osoite,:asiakasid)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("sopimusid", sopimus.getsopimusid())
					.addValue("kuvaus", sopimus.getkuvaus())
					.addValue("asiakasid", sopimus.getasiakasid())
					.addValue("osoite", sopimus.getosoite());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateSopimus(Sopimus sopimus) {
		 final String sql = "update sopimus set kuvaus=:kuvaus, osoite=:osoite, asiakasid=:asiakasid, "+
		                    "osoite=:osoite, yritys=:yritys where sopimusid=:sopimusid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("sopimusid", sopimus.getsopimusid())
					.addValue("kuvaus", sopimus.getkuvaus())
					.addValue("asiakasid", sopimus.getasiakasid())
					.addValue("osoite", sopimus.getosoite());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void executeUpdateSopimus(Sopimus sopimus) {
		 final String sql = "update sopimus set kuvaus=:kuvaus, osoite=:osoite, asiakasid=:asiakasid, " +
		                    "osoite=:osoite, yritys=:yritys where sopimusid=:sopimusid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("sopimusid", sopimus.getsopimusid());
		 map.put("kuvaus", sopimus.getkuvaus());
		 map.put("asiakasid", sopimus.getasiakasid());
		 map.put("osoite", sopimus.getosoite());
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
	public void deleteSopimus(Sopimus sopimus) {
		 final String sql = "delete from sopimus where sopimusid=:sopimusid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("sopimusid", sopimus.getsopimusid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
