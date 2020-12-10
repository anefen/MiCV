package dad.javafx.micv.contacto;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.*;
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

	public final ObjectProperty<ContactoModel> contactoProperty() {
		return this.contacto;
	}

	public final ContactoModel getContacto() {
		return this.contactoProperty().get();
	}

	public final void setContacto(final ContactoModel contacto) {
		this.contactoProperty().set(contacto);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		telNumeroColumn.setCellValueFactory(v -> v.getValue().numeroProperty());
		telTipoColumn.setCellValueFactory(v -> v.getValue().tipoTelefonoProperty());
		emailColumn.setCellValueFactory(v -> v.getValue().direccionProperty());
		urlColumn.setCellValueFactory(v -> v.getValue().urlProperty());

		telNumeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		telTipoColumn.setCellFactory(ComboBoxTableCell.forTableColumn(TipoTelefono.values()));
		emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		urlColumn.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	@FXML
	void onAddDirAction(ActionEvent event) {

		TextInputDialog dialog = new TextInputDialog("");
		dialog.setTitle("Nuevo e-mail");
		dialog.setHeaderText("Añadir una nueva dirección de correo.");
		dialog.setContentText("E-mail:");

		Optional<String> resultado = dialog.showAndWait();
		if (resultado.isPresent()) {
			Email email = new Email();
			email.setDireccion(resultado.get());
			contacto.getValue().getEmail().add(email);
		}

	}

	@FXML
	void onAddTelAction(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Nuevo Teléfono");
		dialog.setHeaderText("Añadir un nuevo teléfono.");

		Optional<String> resultado = dialog.showAndWait();
		if (resultado.isPresent()) {
			Telefono telefono = new Telefono();
			telefono.setNumero(resultado.get());
			contacto.getValue().getTelefono().add(telefono);
		}
	}

	@FXML
	void onAddWebAction(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog("http://");
		dialog.setTitle("Nueva web");
		dialog.setHeaderText("Añadir una nueva dirección web.");
		dialog.setContentText("URL:");

		Optional<String> resultado = dialog.showAndWait();
		if (resultado.isPresent()) {
			Web web = new Web();
			web.setUrl(resultado.get());
			contacto.getValue().getWeb().add(web);
		}
	}

	@FXML
	void onDeleteDirAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación");
		alert.setHeaderText("¿Estás seguro?");
		alert.setContentText("¿Desea elimnar este email?");

		Optional<ButtonType> resultado = alert.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			direccionView.getItems().removeAll(direccionView.getSelectionModel().getSelectedItem());

			direccionView.getSelectionModel().clearSelection();
		}
	}

	@FXML
	void onDeleteTelAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación");
		alert.setHeaderText("¿Estás seguro?");
		alert.setContentText("¿Desea elimnar este teléfono?");

		Optional<ButtonType> resultado = alert.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			telefonoView.getItems().removeAll(telefonoView.getSelectionModel().getSelectedItem());

			telefonoView.getSelectionModel().clearSelection();
		}
	}

	@FXML
	void onDeleteWebAction(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación");
		alert.setHeaderText("¿Estás seguro?");
		alert.setContentText("¿Desea elimnar esta web?");

		Optional<ButtonType> resultado = alert.showAndWait();
		if (resultado.get() == ButtonType.OK) {
			webView.getItems().removeAll(webView.getSelectionModel().getSelectedItem());

			webView.getSelectionModel().clearSelection();
		}
	}

	private void onContactoChanged(ObservableValue<? extends ContactoModel> o, ContactoModel ov, ContactoModel nv) {

		if (ov != null) {
			telefonoView.itemsProperty().unbindBidirectional(ov.telefonoProperty());
			direccionView.itemsProperty().unbindBidirectional(ov.emailProperty());
			webView.itemsProperty().unbindBidirectional(ov.webProperty());

		}

		if (nv != null) {
			telefonoView.itemsProperty().bindBidirectional(nv.telefonoProperty());
			direccionView.itemsProperty().bindBidirectional(nv.emailProperty());
			webView.itemsProperty().bindBidirectional(nv.webProperty());
		}

		deleteDirButton.disableProperty().bind(Bindings.isEmpty(getContacto().emailProperty()));
		deleteTelbutton.disableProperty().bind(Bindings.isEmpty(getContacto().telefonoProperty()));
		deleteWebButton.disableProperty().bind(Bindings.isEmpty(getContacto().webProperty()));
	}

}
