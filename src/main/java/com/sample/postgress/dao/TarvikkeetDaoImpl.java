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

import com.sample.postgress.entity.Tarvikkeet;
import com.sample.postgress.mapper.TarvikkeetRowMapper;

@Repository
public class TarvikkeetDaoImpl implements TarvikkeetDao{
	
	public TarvikkeetDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Tarvikkeet> findAll() {
		return template.query("select * from tarvikkeet", new TarvikkeetRowMapper());
	}
	@Override
	public void insertTarvikkeet(Tarvikkeet tarvikkeet) {
		 final String sql = "insert into tarvikkeet( tarvikeid, tarvikenimi, yksikko, mitta, varastotilanne, sisaanottohinta, vero)" +
		                    " values(?,?,?,?,?,?,?)";
		 
		jdbcTemplate.update(sql, tarvikkeet. gettarvikeid(), tarvikkeet.gettarvikenimi(), tarvikkeet.getyksikko(),
		tarvikkeet.getmitta(), tarvikkeet.getvarastotilanne(), tarvikkeet.getsisaanottohinta(), tarvikkeet.getvero());
	}
	
	@Override
	public void updateTarvikkeet(Tarvikkeet tarvikkeet) {
		 final String sql = "update tarvikkeet set tarvikenimi=?, yksikko=?, mitta=?, "+
		                    "varastotilanne=?, sisaanottohinta=?, vero=? where tarvikeid=?";
				
		jdbcTemplate.update(sql, tarvikkeet.gettarvikenimi(), tarvikkeet.getyksikko(), tarvikkeet.getmitta(),
		tarvikkeet.getvarastotilanne(), tarvikkeet.getsisaanottohinta(), tarvikkeet.getvero(), tarvikkeet.gettarvikeid());
	
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
	public void deleteTarvikkeet(int tarvikeid) {
		 final String sql = "delete from tarvikkeet where tarvikeid=?";
		 jdbcTemplate.update(sql, tarvikeid); 
	}	
	@Override
	public Tarvikkeet findTarvikkeetById(int tarvikkeetid) {
		String query = "SELECT * FROM tarvikkeet WHERE tarvikeid = ?";
		RowMapper<Tarvikkeet> rowMapper = new BeanPropertyRowMapper<Tarvikkeet>(Tarvikkeet.class);
		Tarvikkeet tarvikkeet = jdbcTemplate.queryForObject(query, rowMapper, tarvikkeetid);
  
        return tarvikkeet;
	}	
}
