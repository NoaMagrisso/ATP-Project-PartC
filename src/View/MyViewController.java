package View;

import ViewModel.MyViewModel;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MyViewController extends AController{

    public Button button;
    public AnchorPane pane;
    private MyViewModel myViewModel;

    public void initialize(Stage primaryStage, MyViewModel viewModel, MediaPlayer startMusic) {
        this.stage = primaryStage;
        this.myViewModel = viewModel;
        this.startMusic = startMusic;
    }



    public void Start(ActionEvent actionEvent) {
        try {

            FXMLLoader sizeOfMazeFXMLLoader = new FXMLLoader();
            Parent sizeOfMaze = sizeOfMazeFXMLLoader.load(getClass().getResource("SizeOfMaze.fxml").openStream());
            Scene sizeOfMazeScene = new Scene(sizeOfMaze);
            sizeOfMazeScene.getStylesheets().add(getClass().getResource("SizeOfMaze.css").toExternalForm());
            stage.setScene(sizeOfMazeScene);

            SizeOfMazeController sizeOfMazeController = sizeOfMazeFXMLLoader.getController();
            sizeOfMazeController.initialize(this.stage, this.myViewModel, null, null, this.startMusic);
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setResizeEvent(Scene scene) {

        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            button.setPrefWidth(scene.getWidth()*0.17);

        });


        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            button.setPrefHeight(scene.getHeight()*0.0725);

        });
        button.setLayoutX(button.getLayoutX()*1.05);
        button.setLayoutY(button.getLayoutY()*1.05);
    }



}
