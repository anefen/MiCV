package dad.javafx.micv.contacto;

import javafx.beans.property.*;

public class Web {

	private StringProperty url = new SimpleStringProperty();

	public Web() {
	}
	
	public Web(StringProperty url) {
		this.url = url;
	}

	public final StringProperty urlProperty() {
		return this.url;
	}

	public final String getUrl() {
		return this.urlProperty().get();
	}

	public final void setUrl(final String url) {
		this.urlProperty().set(url);
	}

}
