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

import com.sample.postgress.entity.Tarvikkeet;
import com.sample.postgress.mapper.TarvikkeetRowMapper;

@Repository
public class TarvikkeetDaoImpl implements TarvikkeetDao{
	
	public TarvikkeetDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Tarvikkeet> findAll() {
		return template.query("select * from tarvikkeet", new TarvikkeetRowMapper());
	}
	@Override
	public void insertTarvikkeet(Tarvikkeet tarvikkeet) {
		 final String sql = "insert into tarvikkeet(tarvikeid, tarvikenimi, yksikko, mitta, varastotilanne, sisaanottohinta, vero)" +
		                    " values(:tarvikeid,:tarvikenimi,:yksikko,:mitta, :varastotilanne, :sisaanottohinta, :vero)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("tarvikeid", tarvikkeet.gettarvikeid())
					.addValue("tarvikenimi", tarvikkeet.gettarvikenimi())
					.addValue("mitta", tarvikkeet.getmitta())
					.addValue("yksikko", tarvikkeet.getyksikko())
					.addValue("varastotilanne", tarvikkeet.getvarastotilanne())
					.addValue("sisaanottohinta", tarvikkeet.getsisaanottohinta())
					.addValue("vero", tarvikkeet.getvero());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateTarvikkeet(Tarvikkeet tarvikkeet) {
		 final String sql = "update tarvikkeet set tarvikenimi=:tarvikenimi, yksikko=:yksikko, mitta=:mitta, "+
		                    "varastotilanne=:varastotilanne, sisaanottohinta=:sisaanottohinta, vero=:vero where tarvikeid=:tarvikeid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("tarvikeid", tarvikkeet.gettarvikeid())
					.addValue("tarvikenimi", tarvikkeet.gettarvikenimi())
					.addValue("mitta", tarvikkeet.getmitta())
					.addValue("yksikko", tarvikkeet.getyksikko())
					.addValue("varastotilanne", tarvikkeet.getvarastotilanne())
					.addValue("sisaanottohinta", tarvikkeet.getsisaanottohinta())
					.addValue("vero", tarvikkeet.getvero());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void executeUpdateTarvikkeet(Tarvikkeet tarvikkeet) {
		 final String sql = "update tarvikkeet set tarvikenimi=:tarvikenimi, yksikko=:yksikko, mitta=:mitta, " +
		                    "varastotilanne=:varastotilanne, sisaanottohinta=:sisaanottohinta, vero=:vero where tarvikeid=:tarvikeid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("tarvikeid", tarvikkeet.gettarvikeid());
		 map.put("tarvikenimi", tarvikkeet.gettarvikenimi());
		 map.put("mitta", tarvikkeet.getmitta());
		 map.put("yksikko", tarvikkeet.getyksikko());
		 map.put("varastotilanne", tarvikkeet.getvarastotilanne());
		 map.put("sisaanottohinta", tarvikkeet.getsisaanottohinta());
		 map.put("vero", tarvikkeet.getvero());
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
	public void deleteTarvikkeet(Tarvikkeet tarvikkeet) {
		 final String sql = "delete from tarvikkeet where tarvikeid=:tarvikeid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("tarvikeid", tarvikkeet.gettarvikeid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
