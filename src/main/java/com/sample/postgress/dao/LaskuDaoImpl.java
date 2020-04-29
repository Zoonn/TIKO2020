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

import com.sample.postgress.entity.Lasku;
import com.sample.postgress.mapper.LaskuRowMapper;
@Repository
public class LaskuDaoImpl implements LaskuDao{
	
	public LaskuDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Lasku> findAll() {
		return template.query("select * from lasku", new LaskuRowMapper());
	}
	@Override
	public void insertLasku(Lasku lasku) {
		 final String sql = "insert into lasku(laskuid, sopimusid, paivamaara, erapaiva, laskutuslisa, tila)" +
		                    " values(?,?,?,?,?,?)";
		 
		jdbcTemplate.update(sql,lasku.getlaskuid(), lasku.getsopimusid(), lasku.getpaivamaara(),
		lasku.geterapaiva(), lasku.getlaskutuslisa(), lasku.gettila());
	}
	
	@Override
	public void updateLasku(Lasku lasku) {
		 final String sql = "update lasku set paivamaara=?, erapaiva=?, "+
		                    "laskutuslisa=?, tila=? where laskuid=?::int";
		 
		jdbcTemplate.update(sql, lasku.getpaivamaara(), lasku.geterapaiva(), lasku.getlaskutuslisa(),
		lasku.gettila(),  lasku.getlaskuid());
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
	public void deleteLasku(int laskuid) {
		 final String sql = "delete from lasku where laskuid=?";
		 jdbcTemplate.update(sql, laskuid); 
	}	
	@Override
	public Lasku findLaskuById(int laskuid) {
		String query = "SELECT * FROM lasku WHERE laskuid = ?";
		RowMapper<Lasku> rowMapper = new BeanPropertyRowMapper<Lasku>(Lasku.class);
		Lasku lasku = jdbcTemplate.queryForObject(query, rowMapper, laskuid);
  
        return lasku;
	}	
}
