package com.cloud.taco.JDBCRepository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.cloud.taco.POJO.*;
import com.cloud.taco.Repository.TacoRepository;


@Repository
public class JDBCTacoRepository implements TacoRepository {

  private JdbcTemplate jdbc;

  public JDBCTacoRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Taco save(Taco taco) {
    long tacoId = saveTacoInfo(taco);
    taco.setId(tacoId);
    for (Ingredients ingredient : taco.getListOfIngredients()) {
      saveIngredientToTaco(ingredient, tacoId);
    }

    return taco;
  }

  private long saveTacoInfo(Taco taco) {
    taco.setCreatedAt(new Date());
    
    PreparedStatementCreator psc =new PreparedStatementCreatorFactory(
    							"insert into Taco (name, createdAt) values (?, ?)",
    							Types.VARCHAR, Types.TIMESTAMP)
    							.newPreparedStatementCreator(Arrays.asList(
    							taco.getName(),new Timestamp(taco.getCreatedAt().getTime())));
                

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbc.update(psc, keyHolder);

    return keyHolder.getKey().longValue();
  }

  private void saveIngredientToTaco(Ingredients ingredient, long tacoId) {     
    jdbc.update(
        "insert into Taco_Ingredients (taco, ingredient) values (?, ?)",
        tacoId, ingredient.getId());
  }

}