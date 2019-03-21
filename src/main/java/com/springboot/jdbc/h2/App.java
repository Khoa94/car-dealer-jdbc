package com.springboot.jdbc.h2;

import com.springboot.jdbc.h2.car.Car;
import com.springboot.jdbc.h2.car.CarJdbcRepository;
import com.springboot.jdbc.h2.carDealer.CarDealer;
import com.springboot.jdbc.h2.carDealer.CarDealerJdbcRepository;
import com.springboot.jdbc.h2.dealer.Dealer;
import com.springboot.jdbc.h2.dealer.DealerJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    CarJdbcRepository carJdbcRepository;

    @Autowired
    DealerJdbcRepository dealerJdbcRepository;

    @Autowired
    CarDealerJdbcRepository carDealerJdbcRepository;

    private JButton addCarButton;
    private JPanel panelMain;

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        carJdbcRepository.insert(new Car("make1", "name1", "color1"));
        carJdbcRepository.insert(new Car("make2", "name2", "red"));

        dealerJdbcRepository.insert(new Dealer("name1"));
        dealerJdbcRepository.insert(new Dealer("name2"));

        carDealerJdbcRepository.insert(new CarDealer(1, 1, 0, 0));
        carDealerJdbcRepository.insert(new CarDealer(2, 2, 0, 0));
        carDealerJdbcRepository.update(new CarDealer(2, 2, 0, 2));

        createFrame();
    }


    public void createFrame() {
        JFrame jFrame = new JFrame("App");
        jFrame.setContentPane(new App().panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public App() {
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carJdbcRepository.insert(new Car("make3", "name3", "color3"));
            }
        });
    }
}
