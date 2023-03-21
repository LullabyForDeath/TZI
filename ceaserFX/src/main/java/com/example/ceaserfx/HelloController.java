package com.example.ceaserfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextField textField;
    @FXML
    private TextArea textArea;
    @FXML
    private TextArea textArea1;
    @FXML
    private Label label;
    @FXML
    protected void Button2(){
        try{
            FileChooser FC = new FileChooser();
            FC.setTitle("File:");
            File file = FC.showOpenDialog(null);

            String shohoch = file.getAbsolutePath();
            label.setText(shohoch);
        }catch (Exception e){
            label.setText("Choose File:");
        }
    }
    @FXML
    protected void Button1(){
        int error = 0;

        String text = "";

        if (label.getText().isEmpty()){
            label.setText("File:");
            error ++;
        }
        String newtext = "";


        if (error == 0){
            try(Scanner reader = new Scanner(new FileReader(label.getText()))) {
                while (reader.hasNextLine()){
                    text += reader.nextLine();
                }
                for(int i = 0; i<text.length(); i++){
                    char c = text.charAt(i);
                    c += -9;
                    newtext += c;
                }

                textArea1.setText(newtext);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
    @FXML
    protected void Button(){
        String text = textField.getText();
        String text1 = "";

        for(int i=0; i<text.length(); i++){
            char c= text.charAt(i);
            c += 9;
            text1 += c;
        }

        textArea.setText(text1);

        try(FileWriter writer = new FileWriter ("C:\\Users\\Lenovo\\Desktop\\Новый текстовый документ.txt")){
            writer.write(text1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}