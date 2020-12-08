package dad.javafx.micv.conocimiento;

import javafx.beans.property.*;

public class Idioma {
	private StringProperty certificacion = new SimpleStringProperty();

	public Idioma(StringProperty certificacion) {
		this.certificacion = certificacion;
	}

	public final StringProperty certificacionProperty() {
		return this.certificacion;
	}

	public final String getCertificacion() {
		return this.certificacionProperty().get();
	}

	public final void setCertificacion(final String certificacion) {
		this.certificacionProperty().set(certificacion);
	}

}