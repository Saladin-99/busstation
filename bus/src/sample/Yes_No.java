package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.stage.Modality.APPLICATION_MODAL;

public class Yes_No {


    public static void yesno(String title, String message,Main main,Tripscustomer trip)
    {
        Stage window = new Stage();

        window.initModality(APPLICATION_MODAL);
        window.setAlwaysOnTop(true);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(message);
        Button yes = new Button("Yes");
        Button no=new Button("No");
        yes.setOnAction(e -> {main.customertripdelete(trip);window.close(); });
        no.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yes,no);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }


}
