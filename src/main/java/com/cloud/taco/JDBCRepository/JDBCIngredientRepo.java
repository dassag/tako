package com.cloud.taco.JDBCRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cloud.taco.POJO.Ingredients;
import com.cloud.taco.Repository.IngredientRepository;

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
	// query() returns a list of objects
	return jdbc.query("select id, name,type from Ingredient", this::mapRowToIngredient);
}


@Override
public Ingredients findOne(String id) {
	// queryForObject() returns a single object
	return jdbc.queryForObject("select id, name,type from Ingredient where id=?", 
			this::mapRowToIngredient, id);
}


//inserting a row
@Override
public Ingredients save(Ingredients ingredient) {
	// TODO Auto-generated method stub
	 jdbc.update("Insert into Ingredient(id,name,type) values(?,?,?)",
			 ingredient.getId(),
			 ingredient.getName(),
			 ingredient.getType().toString());
	 return ingredient;
	
}
//rowmapper to map each row in the resultset
//to a taco object
private Ingredients mapRowToIngredient(ResultSet rs, int rowNum)
	    throws SQLException {
	  return new Ingredients(
	      rs.getString("id"),
	      rs.getString("name"),
	      Ingredients.Type.valueOf(rs.getString("type")));
	}


}
