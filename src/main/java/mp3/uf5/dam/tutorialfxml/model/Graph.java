package mp3.uf5.dam.tutorialfxml.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Graph {
    private final StringProperty idioma;
    private final IntegerProperty num;

    public Graph(String idioma, int num) {
        this.idioma = new SimpleStringProperty(idioma);
        this.num = new SimpleIntegerProperty(num);
    }

    public String getIdioma() {
        return idioma.get();
    }

    public StringProperty idiomaProperty() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma.set(idioma);
    }

    public int getNum() {
        return num.get();
    }

    public IntegerProperty numProperty() {
        return num;
    }

    public void setNum(int num) {
        this.num.set(num);
    }
}
