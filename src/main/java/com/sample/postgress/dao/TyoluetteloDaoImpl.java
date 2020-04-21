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

import com.sample.postgress.entity.Tyoluettelo;
import com.sample.postgress.mapper.TyoluetteloRowMapper;

@Repository
public class TyoluetteloDaoImpl implements TyoluetteloDao{
	
	public TyoluetteloDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Tyoluettelo> findAll() {
		return template.query("select * from tyoluettelo", new TyoluetteloRowMapper());
	}
	@Override
	public void insertTyoluettelo(Tyoluettelo tyoluettelo) {
		 final String sql = "insert into tyoluettelo(sopimusid, tyoid, maara, alennus)" +
		                    " values(:sopimusid,:tyoid,:maara, :alennus)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("sopimusid", tyoluettelo.getsopimusid())
					.addValue("maara", tyoluettelo.getmaara())
					.addValue("tyoid", tyoluettelo.gettyoid())
					.addValue("alennus", tyoluettelo.getalennus());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateTyoluettelo(Tyoluettelo tyoluettelo) {
		 final String sql = "update tyoluettelo set sopimusid=:sopimusid, tyoid=:tyoid, maara=:maara, "+
		                    "alennus=:alennus, where sopimusid=:sopimusid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("sopimusid", tyoluettelo.getsopimusid())
					.addValue("maara", tyoluettelo.getmaara())
					.addValue("tyoid", tyoluettelo.gettyoid())
					.addValue("alennus", tyoluettelo.getalennus());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void executeUpdateTyoluettelo(Tyoluettelo tyoluettelo) {
		 final String sql = "update tyoluettelo set sopimusid=:sopimusid, tyoid=:tyoid, maara=:maara, " +
		                    "alennus=:alennus, tila=:tila where sopimusid=:sopimusid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("sopimusid", tyoluettelo.getsopimusid());
		 map.put("maara", tyoluettelo.getmaara());
		 map.put("tyoid", tyoluettelo.gettyoid());
		 map.put("alennus", tyoluettelo.getalennus());
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
	public void deleteTyoluettelo(Tyoluettelo tyoluettelo) {
		 final String sql = "delete from tyoluettelo where sopimusid=:sopimusid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("sopimusid", tyoluettelo.getsopimusid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
