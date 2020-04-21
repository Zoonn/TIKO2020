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

import com.sample.postgress.entity.Tyo;
import com.sample.postgress.mapper.TyoRowMapper;

@Repository
public class TyoDaoImpl implements TyoDao{
	
	public TyoDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Tyo> findAll() {
		return template.query("select * from tyo", new TyoRowMapper());
	}
	@Override
	public void insertTyo(Tyo tyo) {
		 final String sql = "insert into tyo(tyoid, tyonnimi, vero) " +
		                    " values(:tyoid,:tyonnimi,:vero)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("tyoid", tyo.gettyoid())
					.addValue("tyonnimi", tyo.gettyonnimi())
					.addValue("vero", tyo.getvero());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateTyo(Tyo tyo) {
		 final String sql = "update tyo set tyonnimi=:tyonnimi, vero=:vero, "+
		                    " where tyoid=:tyoid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("tyoid", tyo.gettyoid())
					.addValue("tyonnimi", tyo.gettyonnimi())
					.addValue("vero", tyo.getvero());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void executeUpdateTyo(Tyo tyo) {
		 final String sql = "update tyo set tyonnimi=:tyonnimi, vero=:vero, " +
		                    "where tyoid=:tyoid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("tyoid", tyo.gettyoid());
		 map.put("tyonnimi", tyo.gettyonnimi());
		 map.put("vero", tyo.getvero());
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
	public void deleteTyo(Tyo tyo) {
		 final String sql = "delete from tyo where tyoid=:tyoid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("tyoid", tyo.gettyoid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
