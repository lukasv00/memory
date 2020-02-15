package Memory;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuButtons {

    public static FlowPane getFlowPaneButton(Scene scene, Stage primaryStage, String buttonText) {
        FlowPane buttonPane = new FlowPane(Orientation.HORIZONTAL);
        Button button = new Button(buttonText);
        button.setPrefSize(100, 50);
        button.setPrefSize(100, 50);
        button.setFont(new Font("Arial", 18));
        button.setTextFill(Color.BLACK);
        button.setOnAction((e) ->
                primaryStage.setScene(scene));
        buttonPane.getChildren().add(button);
        return buttonPane;
    }
}
