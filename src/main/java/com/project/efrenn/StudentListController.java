package com.project.efrenn;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.models.Student;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentListController {
    DataSingleton data  = DataSingleton.getInstance();

    private ObservableList<Student> studentList;

    @FXML private TableView studentsTableView;
    @FXML private TableColumn idCol;
    @FXML private TableColumn firstNameCol;
    @FXML private TableColumn lastNameCol;
    @FXML private TableColumn emailCol;
    @FXML private TableColumn ageCol;

    @FXML
    public void initialize() {
        // TODO Auto-generated method stub
        this.idCol.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("firstName"));
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("lastName"));
        this.emailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
        this.ageCol.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
        this.studentList = data.getStudents();
        this.studentsTableView.setItems(this.studentList);
        /*this.studentsTableView.setItems(data.getStudents());*/
    }

    @FXML
    private void displayStudentForm() throws IOException {
        App.setRoot("studentForm");
    }

    @FXML
    private void closeStudentForm() throws IOException {
        System.exit(0);
    }
}
