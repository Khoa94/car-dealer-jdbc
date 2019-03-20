package com.springboot.jdbc.h2.dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DealerJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int deleteById(int id){
        return jdbcTemplate.update("delete from dealer where id=?", new Object[] {id});
    }

    public int insert(Dealer dealer){
        return jdbcTemplate.update("insert into dealer(name) values(?)",
                new Object[]{dealer.getName()});
    }

    public int update(Dealer dealer){
        return jdbcTemplate.update("update dealer set name=? where id=?",
                new Object[] {dealer.getName(), dealer.getId()});
    }
}
