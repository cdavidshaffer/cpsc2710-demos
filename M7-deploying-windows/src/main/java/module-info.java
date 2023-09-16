module edu.au.cpsc.jfxdeploydemo {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.au.cpsc.jfxdeploydemo to javafx.fxml;
    exports edu.au.cpsc.jfxdeploydemo;
}