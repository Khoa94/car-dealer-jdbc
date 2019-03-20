Plugins that this project use: Lombok, JFormDesigner

Current issue:
Line 65 in App.java:
carJdbcRepository.insert(new Car("make3", "name3", "color3"));
carJdbcRepository is null. One possible reason: App() is run before @Autowired is run. We need to find a way to make @Autowired run before App().