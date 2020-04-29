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

import com.sample.postgress.entity.Tyo;
import com.sample.postgress.mapper.TyoRowMapper;

@Repository
public class TyoDaoImpl implements TyoDao{
	
	public TyoDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;
	@Autowired
	private JdbcTemplate jdbcTemplate;  

	@Override
	public List<Tyo> findAll() {
		return template.query("select * from tyo", new TyoRowMapper());
	}
	@Override
	public void insertTyo(Tyo tyo) {
		 final String sql = "insert into tyo(tyoid, tyonnimi, vero) " +
							" values(?,?,?)";
							
		jdbcTemplate.update(sql, tyo.gettyoid(), tyo.gettyonnimi(), tyo.getvero());
	}
	
	@Override
	public void updateTyo(Tyo tyo) {
		 final String sql = "update tyo set tyonnimi=?, vero=? "+
		                    " where tyoid=?";
		
		jdbcTemplate.update(sql, tyo.gettyonnimi(), tyo.getvero(), tyo.gettyoid());

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
	public void deleteTyo(int tyoid) {
		 final String sql = "delete from tyo where tyoid=?";
		 jdbcTemplate.update(sql, tyoid); 
	}	
	@Override
	public Tyo findTyoById(int tyoid) {
		String query = "SELECT * FROM tyo WHERE tyoid = ?";
		RowMapper<Tyo> rowMapper = new BeanPropertyRowMapper<Tyo>(Tyo.class);
		Tyo tyo = jdbcTemplate.queryForObject(query, rowMapper, tyoid);
  
        return tyo;
	}	
}
