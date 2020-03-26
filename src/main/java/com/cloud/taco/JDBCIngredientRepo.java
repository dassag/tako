package com.cloud.taco;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCIngredientRepo
    implements IngredientRepository {

  private JdbcTemplate jdbc;


  @Autowired
  public JDBCIngredientRepo(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }


@Override
public Iterable<Ingredients> findAll() {
	// TODO Auto-generated method stub
	return jdbc.query("select id, name,type from Ingredients", this::mapRowToIngredient);
}


@Override
public Ingredients findOne(String id) {
	// TODO Auto-generated method stub
	return jdbc.queryForObject("select id, name,type from Ingredients where id=?", this::mapRowToIngredient, id);
}


@Override
public Ingredients save(Ingredients ingredient) {
	// TODO Auto-generated method stub
	 jdbc.update("Insert into Ingredients(id,name,type) values(?,?,?)",
			 ingredient.getId(),
			 ingredient.getName(),
			 ingredient.getType().toString());
	 return ingredient;
	
}

private Ingredients mapRowToIngredient(ResultSet rs, int rowNum)
	    throws SQLException {
	  return new Ingredients(
	      rs.getString("id"),
	      rs.getString("name"),
	      Ingredients.Type.valueOf(rs.getString("type")));
	}


}