package dad.javafx.micv.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import dad.javafx.micv.*;
import dad.javafx.micv.conocimiento.ConocimientoController;
import dad.javafx.micv.contacto.ContactoController;
import dad.javafx.micv.experiencia.ExperienciaController;
import dad.javafx.micv.formacion.FormacionController;
import dad.javafx.micv.personal.PersonalController;
import dad.javafx.micv.utils.JSONUtils;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable {

	// controllers

	private PersonalController personalController = new PersonalController();
	private ContactoController contactoController = new ContactoController();
	private FormacionController formacionController =  new FormacionController();
	private ExperienciaController experienciaController =  new ExperienciaController();
	private ConocimientoController conocimientoController =  new ConocimientoController();

	// model

	private ObjectProperty<CV> cv = new SimpleObjectProperty<>();

	// view

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public BorderPane getView() {
		return view;
	}

	@FXML
	private BorderPane view;

	@FXML
	private Tab personalTab;

	@FXML
	private Tab contactoTab;

	@FXML
	private Tab formacionTab;

	@FXML
	private Tab experienciaTab;

	@FXML
	private Tab conocimientosTab;

	@FXML
	void onAcercaDeAction(ActionEvent event) {

	}

	@FXML
	void onCerrarAction(ActionEvent event) {

	}

	@FXML
	void onGuardarAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		try {
			personalTab.setContent(personalController.getView());
			contactoTab.setContent(contactoController.getView());
			formacionTab.setContent(formacionController.getView());
			experienciaTab.setContent(experienciaController.getView());
			conocimientosTab.setContent(conocimientoController.getView());

			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Abrir curriculum");
				alert.setHeaderText("Error al cargar el curriculum");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		
		
		
		

		cv.addListener((o, ov, nv) -> onCVChanged(o, ov, nv));

		cv.set(new CV());

	}

	private void onCVChanged(ObservableValue<? extends CV> o, CV ov, CV nv) {

		if (ov != null) {

			personalController.personalProperty().unbind();
			contactoController.contactoProperty().unbind();
			formacionController.formacionProperty().unbind();
			experienciaController.experienciaProperty().unbind();
			conocimientoController.conocimientoProperty().unbind();

		}

		if (nv != null) {

			personalController.personalProperty().bind(nv.personalProperty()); 
			contactoController.contactoProperty().bind(nv.contactoProperty()); 
			formacionController.formacionProperty().bind(nv.formacionProperty()); 
			experienciaController.experienciaProperty().bind(nv.experienciaProperty()); 
			conocimientoController.conocimientoProperty().bind(nv.conocimientoProperty()); 

		
		}

	}

	@FXML
	void onAbrirAction(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Abrir un currículum");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum Vitae (*.cv)", "*.cv"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", "*.*"));
		File cvFile = fileChooser.showOpenDialog(App.getPrimaryStage());
		if (cvFile != null) {
			try {
				cv.set(JSONUtils.fromJson(cvFile, CV.class));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@FXML
	void onGuardarComoAction(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Guardar un currículum");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum Vitae (*.cv)", "*.cv"));
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos", "*.*"));
		File cvFile = fileChooser.showSaveDialog(App.getPrimaryStage());
		if (cvFile != null) {

			try {
				JSONUtils.toJson(cvFile, cv.get());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@FXML
	void onNuevoAction(ActionEvent event) {
		System.out.println("Has pulsado nuevo");
		cv.set(new CV());
	}

	@FXML
	void onSalirAction(ActionEvent event) {

	}

}
