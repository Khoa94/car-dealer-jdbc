Plugins that this project use: Lombok, JFormDesigner


How to access the h2 console:
1) Run the application
2) Go to http://localhost:8080/h2-console
3) In JDBC URL, enter: jdbc:h2:mem:testdb
4) Hit "Connect".


Current issue:
Line 156 to line 162 in App.java: I set the data for the JTable but when I run the application, the data is not displayed.
For now, to see the data in the table, you'll need to use the h2 console.