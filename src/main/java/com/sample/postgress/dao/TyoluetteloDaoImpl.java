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

import com.sample.postgress.entity.Tyoluettelo;
import com.sample.postgress.mapper.TyoluetteloRowMapper;

@Repository
public class TyoluetteloDaoImpl implements TyoluetteloDao{
	
	public TyoluetteloDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Tyoluettelo> findAll() {
		return template.query("select * from tyoluettelo", new TyoluetteloRowMapper());
	}
	@Override
	public void insertTyoluettelo(Tyoluettelo tyoluettelo) {
		 final String sql = "insert into tyoluettelo(sopimusid, tyoid, maara, alennus)" +
		                    " values(?,?,?,?)";
		 
		jdbcTemplate.update(sql, tyoluettelo.getsopimusid(), tyoluettelo.gettyoid(), tyoluettelo.getmaara(), tyoluettelo.getalennus());
	}
	
	@Override
	public void updateTyoluettelo(Tyoluettelo tyoluettelo) {
		 final String sql = "update tyoluettelo set tyoid=?, maara=?, "+
		                    "alennus=? where sopimusid=?";
		 
		jdbcTemplate.update(sql, tyoluettelo.gettyoid(), tyoluettelo.getmaara(),
		tyoluettelo.getalennus(), tyoluettelo.getsopimusid());
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
	public void deleteTyoluettelo(int sopimusid) {
		 final String sql = "delete from tyoluettelo where sopimusid=?";
		 jdbcTemplate.update(sql, sopimusid); 
	}	
	@Override
	public Tyoluettelo findTyoluetteloById(int tyoid) {
		String query = "SELECT * FROM tyoluettelo WHERE tyoid = ?";
		RowMapper<Tyoluettelo> rowMapper = new BeanPropertyRowMapper<Tyoluettelo>(Tyoluettelo.class);
		Tyoluettelo tyoluettelo = jdbcTemplate.queryForObject(query, rowMapper, tyoid);
  
        return tyoluettelo;
	}	
}
