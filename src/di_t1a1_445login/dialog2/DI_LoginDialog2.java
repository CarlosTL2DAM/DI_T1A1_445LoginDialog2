/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_445login.dialog2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_LoginDialog2 extends Application {
    
    @Override
    public void start(final Stage primaryStage) {
        //Añadimos titulo al dialog
        primaryStage.setTitle("Dialog");
        //Creamos nodo root de layout group
        Group root = new Group();
        //Creamos escena con el root
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        //Añadimos la escena a la ventana
        primaryStage.setScene(scene);
        //Mostramos la ventana
        primaryStage.show();
        
        //Creeamos una Stage con nombre myDialog que es instancia de la clase MyDialog
        //con parametro de entrada la ventana principal
        Stage myDialog = new MyDialog(primaryStage);
        //Ajustamos el tamaño de la escena y ventana a los componentes de myDialog
        myDialog.sizeToScene();
        //Mostramos myDialog
        myDialog.show();
  
    }
}

// Creamos clase MyDialog
class MyDialog extends Stage {
    //Constructor
    public MyDialog(Stage owner) {
        //Provocamos que la clase MyDialog herede los atributos de Stage
        super();
        //Decimos que la clase MyDialog pertence a "owner" (primaryStage)
        initOwner(owner);
        //Añadimos titulo a la ventana MyDialog
        setTitle("title");
        //Añadimos un root de la subventana de tipo de layout group
        Group root = new Group();
        //Creamos una escena con el root
        Scene scene = new Scene(root, 250, 150, Color.WHITE);
        setScene(scene);

        //Creamos un layout gridPane para los componentes
        //con paddin, Hgap y Vgap 5
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        //Creamos una etiqueta y la añadimos al grid pane
        Label userNameLbl = new Label("User Name: ");
        gridpane.add(userNameLbl, 0, 1);

        //Creamos una etiqueta y la añadimos al grid pane
        Label passwordLbl = new Label("Password: ");
        gridpane.add(passwordLbl, 0, 2);
        
        //Creamos un campo de texto y la añadimos al grid pane
        final TextField userNameFld = new TextField("Admin");
        gridpane.add(userNameFld, 1, 1);

        //Creamos un campo de cotraseña y la añadimos al grid pane
        final PasswordField passwordFld = new PasswordField();
        passwordFld.setText("password");
        gridpane.add(passwordFld, 1, 2);

        //Creamos un botón, el evento para que al pulsarlo cierre la ventana
        //y lo añadimos al gridPane
        Button login = new Button("Change");
        login.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });
        gridpane.add(login, 1, 3);
        //Deceimos que el botón "login" tenga una alineación horizontal RIGHT
        GridPane.setHalignment(login, HPos.RIGHT);
        //Añadimos el gridPane al root
        root.getChildren().add(gridpane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
