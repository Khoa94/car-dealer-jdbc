package com.springboot.jdbc.h2.dealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public Dealer findById(int id){
        return jdbcTemplate.queryForObject("select * from dealer where id=?", new Object[] {id},
                new BeanPropertyRowMapper<>(Dealer.class));
    }

    public List<Dealer> findAll(){
        return jdbcTemplate.query("select * from dealer",
                new BeanPropertyRowMapper<>(Dealer.class));
    }
}
