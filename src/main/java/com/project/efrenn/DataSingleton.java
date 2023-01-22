package com.project.efrenn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.project.dbhandler.PostgresConnect;
import com.project.models.Student; 

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSingleton {
    
    private static final DataSingleton instance = new DataSingleton();

    /*private ObservableList<Student> studentList = FXCollections.observableArrayList(
      new Student("1726616483", "Efrenn", "Alba", LocalDate.of(1994,12,23), "epalba@puce.edu.ec", "0978632798", 2),
      new Student("1002187381", "Rosa", "Mugmal", LocalDate.of(1974,04,29), "rmugmal@puce.edu.ec", "0999000971", 1),
      new Student("1712267770", "Carlos", "Manosalvas", LocalDate.of(1950,11,26), "cmanosalvas@puce.edu.ec", "0999416913", 3)
    );*/

    private DataSingleton() {        
        loadStudents();
    }

    public static DataSingleton getInstance() { 
        return instance; 
    }

    /*public ObservableList<Student> getStudents () {
        return this.studentList;
    }*/

    public void addStudent (Student student) {
        this.studentList.add(student);
    }

    private ObservableList<Student> studentList =FXCollections.observableArrayList();
    
    private void loadStudents() {
        PostgresConnect pgConnect = new PostgresConnect();
        String sql = "SELECT student_id, student_firstname, student_lastname, student_birthdate, student_email, student_phone, student_level FROM students";
        try (Connection connection = pgConnect.getConnection(); Statement statement =connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()) {
                String id = resultSet.getString("student_id");
                String firstName = resultSet.getString("student_firstname");
                String lastName = resultSet.getString("student_lastname");
                LocalDate birthDate = resultSet.getDate("student_birthdate").toLocalDate();
                String email = resultSet.getString("student_email");
                String phone = resultSet.getString("student_phone");
                int level = resultSet.getInt("student_level");
                studentList.add(new Student(id, firstName, lastName, birthDate, email, phone, level));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public ObservableList<Student> getStudents () {
        return this.studentList;
    }
    
}
