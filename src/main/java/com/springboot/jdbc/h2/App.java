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
    CarJdbcRepository carJdbcRepository;
    DealerJdbcRepository dealerJdbcRepository;
    CarDealerJdbcRepository carDealerJdbcRepository;

    private JButton addCarButton;
    private JPanel panelMain;
    private JTextArea carMakeText;
    private JTextArea carNameText;
    private JLabel carMakeLabel;
    private JLabel carNameLabel;
    private JButton updateCarButton;
    private JButton deleteCarByIdButton;
    private JLabel carIdLabel;
    private JTextArea carIdText;
    private JButton addDealerButton;
    private JButton updateDealerButton;
    private JButton deleteDealerByIdButton;
    private JLabel dealerNameLabel;
    private JTextField dealerNameText;
    private JTextField dealerIdText;
    private JButton addCarDealerButton;
    private JButton updateCarDealerButton;
    private JButton deleteByCarIdButton;
    private JButton deleteByDealerIdButton;
    private JButton deleteByDealerIdAndCarIdButton;
    private JButton requestCarIdFromDealerIdButton;
    private JTextArea carDealerCarIdText;
    private JTextArea carDealerDealerIdText;
    private JTextArea availableCountText;
    private JTextArea requestCountText;

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Sample data
        carJdbcRepository.insert(new Car("make1", "name1"));
        carJdbcRepository.insert(new Car("make2", "redName2"));

        dealerJdbcRepository.insert(new Dealer("name1"));
        dealerJdbcRepository.insert(new Dealer("name2"));

        carDealerJdbcRepository.insert(new CarDealer(1, 1, 0, 0));
        carDealerJdbcRepository.insert(new CarDealer(2, 2, 0, 0));
        carDealerJdbcRepository.update(new CarDealer(2, 2, 0, 2));

        createFrame();
    }

    public void createFrame() {
        JFrame jFrame = new JFrame("App");
        jFrame.setContentPane(new App(carJdbcRepository, dealerJdbcRepository, carDealerJdbcRepository).panelMain);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    @Autowired
    public App(CarJdbcRepository inputCarJdbcRepository, DealerJdbcRepository inputDealerJdbcRepository, CarDealerJdbcRepository inputCarDealerJdbcRepository) {
        this.carJdbcRepository = inputCarJdbcRepository;
        this.dealerJdbcRepository = inputDealerJdbcRepository;
        this.carDealerJdbcRepository = inputCarDealerJdbcRepository;
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carJdbcRepository.insert(new Car(carMakeText.getText(), carNameText.getText()));
            }
        });
        updateCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carJdbcRepository.update(new Car(Integer.valueOf(carIdText.getText()), carMakeText.getText(), carNameText.getText()));
            }
        });
        deleteCarByIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carJdbcRepository.deleteById(Integer.valueOf(carIdText.getText()));
            }
        });

        addDealerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealerJdbcRepository.insert(new Dealer(dealerNameText.getText()));
            }
        });
        updateDealerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealerJdbcRepository.update(new Dealer(Integer.valueOf(dealerIdText.getText()), dealerNameText.getText()));
            }
        });

        addCarDealerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDealerJdbcRepository.insert(new CarDealer(Integer.valueOf(carDealerCarIdText.getText()), Integer.valueOf(carDealerDealerIdText.getText()), Integer.valueOf(availableCountText.getText()), Integer.valueOf(requestCountText.getText())));
            }
        });
        updateCarDealerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDealerJdbcRepository.update(new CarDealer(Integer.valueOf(carDealerCarIdText.getText()), Integer.valueOf(carDealerDealerIdText.getText()), Integer.valueOf(availableCountText.getText()), Integer.valueOf(requestCountText.getText())));
            }
        });
        deleteByCarIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDealerJdbcRepository.deleteByCarId(Integer.valueOf(carDealerCarIdText.getText()));
            }
        });
        deleteByDealerIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDealerJdbcRepository.deleteByDealerId(Integer.valueOf(carDealerDealerIdText.getText()));
            }
        });
        deleteByDealerIdAndCarIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDealerJdbcRepository.deleteByCarIdDealerId(Integer.valueOf(carDealerCarIdText.getText()), Integer.valueOf(carDealerDealerIdText.getText()));
            }
        });
        requestCarIdFromDealerIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carDealerJdbcRepository.incrementRequestCount(Integer.valueOf(carDealerCarIdText.getText()), Integer.valueOf(carDealerDealerIdText.getText()));
            }
        });
    }
}
