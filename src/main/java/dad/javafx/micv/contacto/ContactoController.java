package dad.javafx.micv.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class ContactoController implements Initializable {

	private ObjectProperty<ContactoModel> contacto = new SimpleObjectProperty<>();

	public ContactoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/contactoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public SplitPane getView() {
		return root;
	}

	@FXML
	private SplitPane root;

	@FXML
	private TitledPane telefonoPane;

	@FXML
	private HBox telefonoBox;

	@FXML
	private TableView<Telefono> telefonoView;

	@FXML
	private TableColumn<Telefono, String> telNumeroColumn;

	@FXML
	private TableColumn<Telefono, TipoTelefono> telTipoColumn;

	@FXML
	private Button addTelButton;

	@FXML
	private Button deleteTelbutton;

	@FXML
	private TitledPane direccionPane;

	@FXML
	private HBox direccionBox;

	@FXML
	private TableView<Email> direccionView;

	@FXML
	private TableColumn<Email, String> emailColumn;

	@FXML
	private Button addDirButton;

	@FXML
	private Button deleteDirButton;

	@FXML
	private TitledPane webPane;

	@FXML
	private TableView<Web> webView;

	@FXML
	private TableColumn<Web, String> urlColumn;

	@FXML
	private Button addWebButton;

	@FXML
	private Button deleteWebButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void onAddDirAction(ActionEvent event) {

	}

	@FXML
	void onAddTelAction(ActionEvent event) {

	}

	@FXML
	void onAddWebAction(ActionEvent event) {

	}

	@FXML
	void onDeleteDirAction(ActionEvent event) {

	}

	@FXML
	void onDeleteTelAction(ActionEvent event) {

	}

	@FXML
	void onDeleteWebAction(ActionEvent event) {

	}

}
