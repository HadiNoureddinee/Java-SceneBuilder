package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class SampleController {

    @FXML
    private ComboBox<String> comboBoxDorm;
    
    @FXML
    private ComboBox<String> comboBoxMeals;
    
    @FXML
    private Label labelOutput;
    
    private String selectedMeal;
    private String selectedDorm;
    private int costMeal;
    private int costDorm;


    @FXML
    public void initialize() {

        //This adds the options to the ComboBox

        ObservableList<String> dormOptions = FXCollections.observableArrayList(
                "Snaggletooth Hall",
                "Bupkis Hall",
                "Dumptruck Hall",
                "University Suites"
        );

        comboBoxDorm.setItems(dormOptions);
        comboBoxDorm.setOnAction(this::ComboBoxDormSelection);
        
        
        ObservableList<String> mealOptions = FXCollections.observableArrayList(
                "7 meals per week",
                "14 meals per week",
                "Unlimited meals"
        );

        comboBoxMeals.setItems(mealOptions);
        comboBoxMeals.setOnAction(this::ComboBoxMealsSelection);
        
    }
    
    
    private void ComboBoxDormSelection(ActionEvent event) {
        // Get the selected item
    	selectedDorm = comboBoxDorm.getValue();
    	
    	//Sets the price of the Dorm depending on the plan
       if(selectedDorm.equals("Snaggletooth Hall")) {
    	   costDorm = 1500;
       }else if(selectedDorm.equals("Bupkis Hall")) {
    	   
    	   costDorm = 2500;
       }else if(selectedDorm.equals("Dumptruck Hall")) {
    	   
    	   costDorm = 1200;
       }else if(selectedDorm.equals("University Suites")) {
    	   
    	   costDorm = 3000;
       }

    }

    
    private void ComboBoxMealsSelection(ActionEvent event) {
        // Get the selected Meals
       selectedMeal = comboBoxMeals.getValue();
       
       //Sets the price of the meal depending on the plan
       if(selectedMeal.equals("7 meals per week")) {
    	   costMeal = 600;
       }else if(selectedMeal.equals("14 meals per week")) {
    	   
    	   costMeal = 1100;
       }else if(selectedMeal.equals("Unlimited meals")) {
    	   
    	   costMeal = 1800;
       }
       
    }
    
    @FXML
    private void Calculate(ActionEvent event) {
    	
    	int semesterTotal;
    	
        // First we have to make sure that an option is selected 
    	//then add the values of both meals and dorm cost for a semester
    	
        if ((costMeal != 0) && (costDorm != 0)) {
        	semesterTotal = costDorm + costMeal;
            labelOutput.setText("Semester Total: " + semesterTotal + "$");
           
        } else {
        	//only if one of the combo boxes isn't selected
            labelOutput.setText("One Item Missing!");
        }

 
    }

}
