Plugins that this project use: Lombok, JFormDesigner

How to run h2 console:
1) Run the application
2) Go to http://localhost:8080/h2-console
3) In JDBC URL, enter: jdbc:h2:mem:testdb
4) Hit Connect.

Current issue:
Line 65 in App.java:
carJdbcRepository.insert(new Car("make3", "name3", "color3"));

carJdbcRepository is null. One possible reason: App() is run before @Autowired is run. We need to find a way to make @Autowired run before App().