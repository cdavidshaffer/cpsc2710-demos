module edu.au.cpsc.composingviews {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens edu.au.cpsc.customevents to javafx.fxml;
    exports edu.au.cpsc.customevents;
}