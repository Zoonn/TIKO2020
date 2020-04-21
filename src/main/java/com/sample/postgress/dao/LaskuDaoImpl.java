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

import com.sample.postgress.entity.Lasku;
import com.sample.postgress.mapper.LaskuRowMapper;

@Repository
public class LaskuDaoImpl implements LaskuDao{
	
	public LaskuDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Lasku> findAll() {
		return template.query("select * from lasku", new LaskuRowMapper());
	}
	@Override
	public void insertLasku(Lasku lasku) {
		 final String sql = "insert into lasku(laskuid, sopimusid, paivamaara, erapaiva, laskutuslisa, tila)" +
		                    " values(:laskuid,:sopimusid,:paivamaara,:erapaiva, :laskutuslisa, :tila)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("laskuid", lasku.getlaskuid())
					.addValue("sopimusid", lasku.getsopimusid())
					.addValue("erapaiva", lasku.geterapaiva())
					.addValue("paivamaara", lasku.getpaivamaara())
					.addValue("laskutuslisa", lasku.getlaskutuslisa())
					.addValue("tila", lasku.gettila());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateLasku(Lasku lasku) {
		 final String sql = "update lasku set sopimusid=:sopimusid, paivamaara=:paivamaara, erapaiva=:erapaiva, "+
		                    "laskutuslisa=:laskutuslisa, tila=:tila where laskuid=:laskuid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("laskuid", lasku.getlaskuid())
					.addValue("sopimusid", lasku.getsopimusid())
					.addValue("erapaiva", lasku.geterapaiva())
					.addValue("paivamaara", lasku.getpaivamaara())
					.addValue("laskutuslisa", lasku.getlaskutuslisa())
					.addValue("tila", lasku.gettila());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void executeUpdateLasku(Lasku lasku) {
		 final String sql = "update lasku set sopimusid=:sopimusid, paivamaara=:paivamaara, erapaiva=:erapaiva, " +
		                    "laskutuslisa=:laskutuslisa, tila=:tila where laskuid=:laskuid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("laskuid", lasku.getlaskuid());
		 map.put("sopimusid", lasku.getsopimusid());
		 map.put("erapaiva", lasku.geterapaiva());
		 map.put("paivamaara", lasku.getpaivamaara());
		 map.put("laskutuslisa", lasku.getlaskutuslisa());
		 map.put("tila", lasku.gettila());
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
	public void deleteLasku(Lasku lasku) {
		 final String sql = "delete from lasku where laskuid=:laskuid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("laskuid", lasku.getlaskuid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
