import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Crear una imagen y un ImageView
		Image imagen = new Image("file:C://Users//alber//Desktop//Leslie//White_Camel_Logo.png");
		ImageView imageView = new ImageView(imagen);

		// Ajustar la altura de la imagen (cambia el valor según sea necesario)
		imageView.setFitHeight(400);

		// Crear dos títulos con un estilo más visible
		Text titulo1 = new Text("Usuario");
		titulo1.setFill(Color.WHITE);
		titulo1.setFont(Font.font(18));

		Text titulo2 = new Text("Contraseña");
		titulo2.setFill(Color.WHITE);
		titulo2.setFont(Font.font(18));

		// Crear dos cajas de texto
		TextField textField1 = new TextField();
		TextField textField2 = new TextField();

		// Establecer un ancho fijo (la mitad del tamaño original) para las cajas de
		// texto
		double fixedTextFieldWidth = 100;
		textField1.setPrefWidth(fixedTextFieldWidth);
		textField2.setPrefWidth(fixedTextFieldWidth);

		// Crear un botón de "Enter"
		Button botonEnter = new Button("Enter");
		botonEnter.setOnAction(event -> {
			// Aquí puedes manejar la lógica de inicio de sesión
			String usuario = textField1.getText();
			String contrasena = textField2.getText();
			System.out.println("Usuario: " + usuario + ", Contraseña: " + contrasena);
		});

		// Crear un contenedor VBox para la imagen, los títulos, las cajas de texto y el
		// botón de "Enter"
		VBox vbox = new VBox(20, imageView, titulo1, textField1, titulo2, textField2, botonEnter);
		vbox.setAlignment(Pos.CENTER);

		// Establecer un fondo de color azul oscuro para el VBox (ajustado a un tono más
		// oscuro)
		BackgroundFill backgroundFill = new BackgroundFill(Color.rgb(0, 0, 50), CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vbox.setBackground(background);

		// Agregar Padding al VBox para dejar espacio en los lados
		vbox.setPadding(new Insets(20, 20, 20, 20));

		// Crear la escena y establecer el VBox como su raíz
		Scene scene = new Scene(vbox, 600, 900);

		// Establecer la escena en el escenario (ventana principal)
		primaryStage.setScene(scene);

		// Establecer el título de la ventana
		primaryStage.setTitle("Ventana con Logo, Títulos, Cajas de Texto y Botón de Enter");

		// Mostrar la ventana
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
