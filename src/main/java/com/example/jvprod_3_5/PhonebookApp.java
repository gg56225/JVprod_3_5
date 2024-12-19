package com.example.jvprod_3_5;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PhonebookApp extends Application {

    private TableView<Contact> tableView;
    private TextField nameField;
    private TextField phoneField;

    private ObservableList<Contact> data = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Инициализация данных (замените на загрузку из файла или базы данных)
        data.addAll(
                new Contact("Иван Иванов", "+79123456789"),
                new Contact("Петр Петров", "+79876543210")
        );

        // Создание элементов интерфейса
        tableView = new TableView<>();
        TableColumn<Contact, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Contact, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        tableView.getColumns().addAll(nameColumn, phoneColumn);
        tableView.setItems(data);

        nameField = new TextField();
        phoneField = new TextField();
        Button addButton = new Button("Добавить");
        addButton.setOnAction(event -> {
            Contact newContact = new Contact(nameField.getText(), phoneField.getText());
            data.add(newContact);
            nameField.clear();
            phoneField.clear();
        });

        // Размещение элементов на сцене
        HBox topBox = new HBox(10);
        topBox.setPadding(new Insets(10));
        topBox.getChildren().addAll(new Label("Имя:"), nameField, new Label("Телефон:"), phoneField, addButton);

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(tableView);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Телефонный справочник");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Класс для представления контакта
    public static class Contact {
        private String name;
        private String phoneNumber;

        public Contact(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        // Геттеры и сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}