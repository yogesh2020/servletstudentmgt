/*
 * package com.decipher.controller;
 * 
 * import java.sql.PreparedStatement; import java.sql.ResultSet; import
 * java.sql.SQLException; import java.sql.Statement; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import com.mongodb.DB; import com.mongodb.DBCollection; import
 * com.mongodb.MongoClient; import com.mongodemo.mongoproject.ConnectionMongodb;
 * 
 * public class displayy {
 * 
 * private PreparedStatement statement = null;
 * 
 * public List<Employee> display() {
 * 
 * Employee employee; List<Employee> studentList = new ArrayList<Employee>();
 * 
 * Connection conn = new Connection(); DBCollection connection =
 * conn.getCollection();
 * 
 * // DBCollection col = db.getCollection("employee");
 * 
 * try {
 * 
 * // PreparedStatement statement = con.PreparedStatement();
 * 
 * Connection connObj = new Connection(); DBCollection collection =
 * connObj.getCollection(); PreparedStatement
 * stmt=collection.prepareStatement("insert into Emp values(?,?)");
 * 
 * 
 * DBCollection collection = new Connection().getCollection(); Statement stmt =
 * conn.createStatement(); stmt.executeUpdate("select * from student");
 * 
 * 
 * //= collection.statement("select * from student"); ResultSet rs =
 * statement.executeQuery();
 * 
 * while (rs.next()) { employee = new Employee();
 * employee.setRollNumber(rs.getString(0));
 * employee.setUsername(rs.getString(0)); employee.setAddress(rs.getString(0));
 * 
 * studentList.add(employee); } return studentList; } catch (SQLException e) {
 * // TODO: handle exception // log.error(e.getMessage(), e); } return null;
 * }//method end
 * 
 * 
 * 
 * 
 * }
 */