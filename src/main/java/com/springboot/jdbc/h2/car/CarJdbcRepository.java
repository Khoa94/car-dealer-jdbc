package com.springboot.jdbc.h2.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Car findById(int id){
        return jdbcTemplate.queryForObject("select * from car where id=?", new Object[] {id},
                new BeanPropertyRowMapper<>(Car.class));
    }

    public List<Car> findAll(){
        return jdbcTemplate.query("select * from car",
                new BeanPropertyRowMapper<>(Car.class));
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from car where id=?", new Object[] {id});
    }

    public int insert(Car car){
        return jdbcTemplate.update("insert into car (make, name) values(?, ?)",
                new Object[]{car.getMake(), car.getName()});
    }

    public int update(Car car){
        return jdbcTemplate.update("update car set make=?, name=? where id=?",
                new Object[] {car.getMake(), car.getName(), car.getId()});
    }
}
