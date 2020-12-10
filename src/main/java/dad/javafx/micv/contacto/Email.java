package dad.javafx.micv.contacto;

import javafx.beans.property.*;

public class Email {

	private StringProperty direccion = new SimpleStringProperty();

	public Email() {
	}
	
	public Email(StringProperty direccion) {
		this.direccion = direccion;
	}

	public final StringProperty direccionProperty() {
		return this.direccion;
	}

	public final String getDireccion() {
		return this.direccionProperty().get();
	}

	public final void setDireccion(final String direccion) {
		this.direccionProperty().set(direccion);
	}

}
