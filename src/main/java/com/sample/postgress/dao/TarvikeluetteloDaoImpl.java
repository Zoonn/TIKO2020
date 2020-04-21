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

import com.sample.postgress.entity.Tarvikeluettelo;
import com.sample.postgress.mapper.TarvikeluetteloRowMapper;

@Repository
public class TarvikeluetteloDaoImpl implements TarvikeluetteloDao{
	
	public TarvikeluetteloDaoImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
    }  
	NamedParameterJdbcTemplate template;  

	@Override
	public List<Tarvikeluettelo> findAll() {
		return template.query("select * from tarvikeluettelo", new TarvikeluetteloRowMapper());
	}
	@Override
	public void insertTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		 final String sql = "insert into tarvikeluettelo(, sopimusid, tarvikeid, maara, alennus, veroton_hinta)" +
		                    " values(:sopimusid,:tarvikeid,:maara, :alennus, :veroton_hinta)";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("sopimusid", tarvikeluettelo.getsopimusid())
					.addValue("maara", tarvikeluettelo.getmaara())
					.addValue("tarvikeid", tarvikeluettelo.gettarvikeid())
					.addValue("alennus", tarvikeluettelo.getalennus())
					.addValue("veroton_hinta", tarvikeluettelo.getveroton_hinta());
	        template.update(sql,param, holder);
	}
	
	@Override
	public void updateTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		 final String sql = "update tarvikeluettelo set sopimusid=:sopimusid, tarvikeid=:tarvikeid, maara=:maara, "+
		                    "alennus=:alennus, veroton_hinta=:veroton_hinta where sopimusid=:sopimusid";
		 
	        KeyHolder holder = new GeneratedKeyHolder();
	        SqlParameterSource param = new MapSqlParameterSource()
					.addValue("sopimusid", tarvikeluettelo.getsopimusid())
					.addValue("maara", tarvikeluettelo.getmaara())
					.addValue("tarvikeid", tarvikeluettelo.gettarvikeid())
					.addValue("alennus", tarvikeluettelo.getalennus())
					.addValue("veroton_hinta", tarvikeluettelo.getveroton_hinta());
	        template.update(sql,param, holder);
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
	public void deleteTarvikeluettelo(Tarvikeluettelo tarvikeluettelo) {
		 final String sql = "delete from tarvikeluettelo where sopimusid=:sopimusid";
			 
		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("sopimusid", tarvikeluettelo.getsopimusid());
	
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});  
	}	
}
