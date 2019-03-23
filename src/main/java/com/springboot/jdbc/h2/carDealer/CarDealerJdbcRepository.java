package com.springboot.jdbc.h2.carDealer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDealerJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public CarDealer findByCarIdDealerId(int carId, int dealerId){
        return jdbcTemplate.queryForObject("select * from car_dealer where car_id=? and dealer_id=?", new Object[] {carId, dealerId},
                new BeanPropertyRowMapper<>(CarDealer.class));
    }

    public List<CarDealer> findByCarId(int carId){
        return jdbcTemplate.query("select * from car_dealer where car_id=?", new Object[] {carId},
                new BeanPropertyRowMapper<>(CarDealer.class));
    }

    public List<CarDealer> findByDealerId(int dealerId){
        return jdbcTemplate.query("select * from car_dealer where dealer_id=?", new Object[] {dealerId},
                new BeanPropertyRowMapper<>(CarDealer.class));
    }

    public List<CarDealer> findAll(){
        return jdbcTemplate.query("select * from car_dealer",
                new BeanPropertyRowMapper<>(CarDealer.class));
    }

    public int deleteByCarIdDealerId(int carId, int dealerId){
        return jdbcTemplate.update("delete from car_dealer where car_id=? and dealer_id=?", new Object[] {carId, dealerId});
    }

    public int deleteByCarId(int carId){
        return jdbcTemplate.update("delete from car_dealer where car_id=?", new Object[] {carId});
    }

    public int deleteByDealerId(int dealerId){
        return jdbcTemplate.update("delete from car_dealer where dealer_id=?", new Object[] {dealerId});
    }

    public int insert(CarDealer carDealer){
        return jdbcTemplate.update("insert into car_dealer (car_id, dealer_id, available_count, request_count) values(?, ?, ?, ?)",
                new Object[]{carDealer.getCarId(), carDealer.getDealerId(), carDealer.getAvailableCount(), carDealer.getRequestCount()});
    }

    public int update(CarDealer carDealer){
        return jdbcTemplate.update("update car_dealer set available_count=?, request_count=? where car_id=? and dealer_id=?",
                new Object[] {carDealer.getAvailableCount(), carDealer.getRequestCount(), carDealer.getCarId(), carDealer.getDealerId()});
    }

    public int incrementRequestCount(int carId, int dealerId){
        return jdbcTemplate.update("update car_dealer set request_count=request_count+1 where car_id=? and dealer_id=?",
                new Object[] {carId, dealerId});
    }
}
