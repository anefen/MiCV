package dad.javafx.micv.contacto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class ContactoController {
	

	    @FXML
	    private SplitPane root;

	    @FXML
	    private TitledPane telefonoPane;

	    @FXML
	    private HBox telefonoBox;

	    @FXML
	    private TableView<?> telefonoView;

	    @FXML
	    private TableColumn<?, ?> telNumeroColumn;

	    @FXML
	    private TableColumn<?, ?> telTipoColumn;

	    @FXML
	    private Button addTelButton;

	    @FXML
	    private Button deleteTelbutton;

	    @FXML
	    private TitledPane direccionPane;

	    @FXML
	    private HBox direccionBox;

	    @FXML
	    private TableView<?> direccionView;

	    @FXML
	    private TableColumn<?, ?> dirNumeroColumn;

	    @FXML
	    private TableColumn<?, ?> dirTipoColumn;

	    @FXML
	    private Button addDirButton;

	    @FXML
	    private Button deleteDirButton;

	    @FXML
	    private TitledPane webPane;

	    @FXML
	    private TableView<?> webView;

	    @FXML
	    private TableColumn<?, ?> urlColumn;

	    @FXML
	    private Button addWebButton;

	    @FXML
	    private Button deleteWebButton;

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


