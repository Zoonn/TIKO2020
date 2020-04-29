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

import com.sample.postgress.entity.Tarvikeluettelo;
import com.sample.postgress.mapper.TarvikeluetteloRowMapper;

@Repository
public class TarvikeluetteloDaoImpl implements TarvikeluetteloDao{
	
	public TarvikeluetteloDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Tarvikeluettelo> findAll() {
		return template.query("select * from tarvikeluettelo", new TarvikeluetteloRowMapper());
	}
	@Override
	public void insertTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		 final String sql = "insert into tarvikeluettelo( sopimusid, tarvikeid, maara, alennus, veroton_hinta)" +
		                    " values(?,?,?,?,?)";
		 
		jdbcTemplate.update(sql, tarvikeluettelo.getsopimusid(), tarvikeluettelo.gettarvikeid(), tarvikeluettelo.getmaara(),
		tarvikeluettelo.getalennus(), tarvikeluettelo.getveroton_hinta());
	}
	
	@Override
	public void updateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		 final String sql = "update tarvikeluettelo set tarvikeid=?, maara=?, "+
		                    "alennus=?, veroton_hinta=? where sopimusid=?";
		 
		jdbcTemplate.update(sql, tarvikeluettelo.gettarvikeid(), tarvikeluettelo.getmaara(),
		tarvikeluettelo.getalennus(), tarvikeluettelo.getveroton_hinta(), tarvikeluettelo.getsopimusid());
	}
	
	@Override
	public void executeUpdateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		 final String sql = "update tarvikeluettelo set sopimusid=:sopimusid, tarvikeid=:tarvikeid, maara=:maara, " +
		                    "alennus=:alennus, veroton_hinta=:veroton_hinta where sopimusid=:sopimusid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("sopimusid", tarvikeluettelo.getsopimusid());
		 map.put("maara", tarvikeluettelo.getmaara());
		 map.put("tarvikeid", tarvikeluettelo.gettarvikeid());
		 map.put("alennus", tarvikeluettelo.getalennus());
		 map.put("veroton_hinta", tarvikeluettelo.getveroton_hinta());
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
	public void deleteTarvikeluettelo(int sopimusid) {
		 final String sql = "delete from tarvikeluettelo where sopimusid=?";
		 jdbcTemplate.update(sql, sopimusid); 
	}	
	@Override
	public Tarvikeluettelo findTarvikeluetteloById(int tarvikeid) {
		String query = "SELECT * FROM tarvikeluettelo WHERE tarvikeid = ?";
		RowMapper<Tarvikeluettelo> rowMapper = new BeanPropertyRowMapper<Tarvikeluettelo>(Tarvikeluettelo.class);
		Tarvikeluettelo tarvikeluettelo = jdbcTemplate.queryForObject(query, rowMapper, tarvikeid);
  
        return tarvikeluettelo;
	}	
}
