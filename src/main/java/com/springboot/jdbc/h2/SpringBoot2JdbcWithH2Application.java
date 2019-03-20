//package com.in28minutes.springboot.jdbc.h2.example;
//
//import Car;
//import CarJdbcRepository;
//import CarDealer;
//import CarDealerJdbcRepository;
//import Dealer;
//import DealerJdbcRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.in28minutes.springboot.jdbc.h2.example.student.Student;
//import com.in28minutes.springboot.jdbc.h2.example.student.StudentJdbcRepository;
//
//@SpringBootApplication
//public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	StudentJdbcRepository studentJdbcRepository;
//
//	@Autowired
//	CarJdbcRepository carJdbcRepository;
//
//	@Autowired
//	DealerJdbcRepository dealerJdbcRepository;
//
//	@Autowired
//	CarDealerJdbcRepository carDealerJdbcRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		logger.info("Student id 10001 -> {}", studentJdbcRepository.findById(10001L));
//
//		logger.info("Inserting -> {}", studentJdbcRepository.insert(new Student(10010L, "John", "A1234657")));
//
//		logger.info("Update 10003 -> {}", studentJdbcRepository.update(new Student(10001L, "Name-Updated", "New-Passport")));
//
//		studentJdbcRepository.deleteById(10002L);
//
//		logger.info("All users -> {}", studentJdbcRepository.findAll());
//
//		carJdbcRepository.insert(new Car("make1", "name1", "color1"));
//		carJdbcRepository.insert(new Car("make2", "name2", "color2"));
//		carJdbcRepository.insert(new Car("make3", "name3", "color3"));
//
//		dealerJdbcRepository.insert(new Dealer("name1"));
//		dealerJdbcRepository.insert(new Dealer("name2"));
//
//		carDealerJdbcRepository.insert(new CarDealer(1, 1, 0, 0));
//		carDealerJdbcRepository.insert(new CarDealer(1, 2, 0, 0));
//		carDealerJdbcRepository.update(new CarDealer(1, 2, 0, 2));
//		carDealerJdbcRepository.deleteByCarIdDealerId(1,1);
////		carDealerJdbcRepository.findByCarIdDealerId(1,2);
//
//
//	}
//}
