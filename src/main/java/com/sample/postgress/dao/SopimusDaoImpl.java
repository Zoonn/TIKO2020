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

import com.sample.postgress.entity.Sopimus;
import com.sample.postgress.mapper.SopimusRowMapper;

@Repository
public class SopimusDaoImpl implements SopimusDao{
	
	public SopimusDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Sopimus> findAll() {
		return template.query("select * from sopimus", new SopimusRowMapper());
	}
	@Override
	public void insertSopimus(Sopimus sopimus) {
		 final String sql = "insert into sopimus(sopimusid, kuvaus, osoite, asiakasid)" +
							" values(?,?,?,?)";
			
		jdbcTemplate.update(sql,sopimus.getsopimusid(), sopimus.getkuvaus(), sopimus.getosoite(),
		sopimus.getasiakasid());
	}
	
	@Override
	public void updateSopimus(Sopimus sopimus) {
		 final String sql = "update sopimus set kuvaus=?, osoite=?, asiakasid=? "+
							" where sopimusid=?";
							
		jdbcTemplate.update(sql, sopimus.getkuvaus(), sopimus.getosoite(), sopimus.getasiakasid(),
				sopimus.getsopimusid());		
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
	public void deleteSopimus(int sopimusid) {
		 final String sql = "delete from sopimus where sopimusid=?";
		 jdbcTemplate.update(sql, sopimusid); 
	}	
	@Override
	public Sopimus findSopimusById(int sopimusid) {
		String query = "SELECT * FROM sopimus WHERE sopimusid = ?";
		RowMapper<Sopimus> rowMapper = new BeanPropertyRowMapper<Sopimus>(Sopimus.class);
		Sopimus sopimus = jdbcTemplate.queryForObject(query, rowMapper, sopimusid);
  
        return sopimus;
	}	
}
