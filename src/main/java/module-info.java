module swe.me.assigntwo {
    requires javafx.controls;
    requires javafx.fxml;


    opens swe.me.conversiontool to javafx.fxml;
    exports swe.me.conversiontool;
}