module mp3.uf5.dam.tutorialfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens mp3.uf5.dam.tutorialfxml to javafx.fxml;
    exports mp3.uf5.dam.tutorialfxml;
    exports mp3.uf5.dam.tutorialfxml.control;
    opens mp3.uf5.dam.tutorialfxml.control to javafx.fxml;
}