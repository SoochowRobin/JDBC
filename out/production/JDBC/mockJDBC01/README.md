# mockJDBC01 folder is to mock the essence of JDBC.

The essence of JDBC is an interface: And JavaProgrammer call the interface method. And SQL companies use Stream to
implement these interface Under the hood. Finally, They zip these class files to jar. We called it driver. For example, 
MySQL driver, Oracle driver. We could download these drivers from corresponding official website.<br>

***Content***
<li> JDBC interface: define abstract method need to be implemented by SQL companies
<li> MySQL, Oracle: implement JDBC interface
<li> JavaProgrammer: New JDBC(interface) object(choose MySQL, Oracle)

One further improvement is to use ResourceBundle, getString method to store 
everything in the property file and then use Reflection to new Object. It increases the
scalability and flexibility of this program. 
