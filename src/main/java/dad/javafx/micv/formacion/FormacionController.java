package dad.javafx.micv.formacion;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FormacionController implements Initializable {

	
	private ListProperty<FormacionModel> formacion = new SimpleListProperty<FormacionModel>(FXCollections.observableArrayList());
	
	
	
	public FormacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/formacionView.fxml"));
		loader.setController(this);
		loader.load();
	}

	public Pane getView() {
		return root;
	}

	@FXML
	private Pane root;

	@FXML
	private TableView<FormacionModel> formacionView;

	@FXML
	private TableColumn<FormacionModel, LocalDate> desdeColumn;

	@FXML
	private TableColumn<FormacionModel, LocalDate> hastaColumn;

	@FXML
	private TableColumn<FormacionModel, String> denomColumn;

	@FXML
	private TableColumn<FormacionModel, String> orgColumn;

	@FXML
	private VBox formBox;

	@FXML
	private Button addFormButton;

	@FXML
	private Button deleteFormButton;

	@FXML
	void onAddFormAction(ActionEvent event) {
		
	}

	@FXML
	void onDeleteFormAction(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public final ListProperty<FormacionModel> formacionProperty() {
		return this.formacion;
	}
	

	public final ObservableList<FormacionModel> getFormacion() {
		return this.formacionProperty().get();
	}
	

	public final void setFormacion(final ObservableList<FormacionModel> formacion) {
		this.formacionProperty().set(formacion);
	}
	

}
