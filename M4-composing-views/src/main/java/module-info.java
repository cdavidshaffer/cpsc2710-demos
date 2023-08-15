module edu.au.cpsc.composingviews {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens edu.au.cpsc.composingviews to javafx.fxml;
    exports edu.au.cpsc.composingviews;
}