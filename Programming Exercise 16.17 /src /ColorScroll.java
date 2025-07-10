import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

 public class ColorScroll extends Application { // Extend Application
   /**
    * A JavaFX application that displays a specified local image in a window.
    * <p>
    * The image is loaded from a relative path. Ensure that the image exists
    * at the specified location before running the application.
    * </p>
    * <p>
    * Dependencies: JavaFX libraries must be included in the project's build path.
    * </p>
    */

   // Select the colors for the text
   private Text coloredText;
   private Slider slRed, slGreen, slBlue, slOpacity;

   @Override
   public void start(Stage primaryStage) {
     // Text Element
     coloredText = new Text("Color Scroll!");
     coloredText.setFont(Font.font("Arial", 40));

     /** 
      * Sliders for RGB and Opacity:
      * 
      * slColor = createColorSlider();
      */
     slRed = createColorSlider();
     slGreen = createColorSlider();
     slBlue = createColorSlider();
     slOpacity = createColorSlider();
     slOpacity.setValue(1.0); // Default opacity to full

     /**
      * Add listeners to update the text color:
      *
      * slColor.valueProperty().addListener((obs, oldVal, newVal) -> setColor());
      */
     slRed.valueProperty().addListener((obs, oldVal, newVal) -> setColor());
     slGreen.valueProperty().addListener((obs, oldVal, newVal) -> setColor());
     slBlue.valueProperty().addListener((obs, oldVal, newVal) -> setColor());
     slOpacity.valueProperty().addListener((obs, oldVal, newVal) -> setColor());

     /**
      * Lay out the sliderPane:
      *
      * sliderPane.setAlignment(Pos.CENTER);
      * sliderPane.setHgap(x);
      * sliderPane.setVgap(y);
      * sliderPane.addRow(0, new Label("Color1:"), slColor1);
      * sliderPane.addRow(1, new Label("Color2:"), slColor2);
      * sliderPane.addRow(2, new Label("Color3:"), slColor3);
      */
     GridPane sliderPane = new GridPane();
       sliderPane.setAlignment(Pos.CENTER);
       sliderPane.setHgap(10);
       sliderPane.setVgap(10);
       sliderPane.addRow(0, new Label("Red:"), slRed);
       sliderPane.addRow(1, new Label("Green:"), slGreen);
       sliderPane.addRow(0, new Label("Blue:"), slBlue);
       sliderPane.addRow(0, new Label("Opacity:"), slOpacity);

     BorderPane root = new BorderPane();
       root.setTop(coloredText);
       BorderPane.setAlignment(coloredText, Pos.CENTER);
       root.setCenter(sliderPane);

     // Initial color setting
     setColor();

     /**
      * Scene and Stage:
      *
      * Scene scene = new Scene(root, x, y);
      * primaryStage.setTitle("Text Title");
      * primaryStage.setScene(scene);
      * primaryStage.show();
      */
     Scene scene = new Scene(root, 400, 300);
       primaryStage.setTitle("Color Scroll Sliders");
       primaryStage.setScene(scene);
       primaryStage.show();
   }
   /**
    * Set Tick Color Slider:
    * 
    * Slider slider = new Slider(min, max, initial value);
    */
   private Slider createColor() {
     Slider slider = new Slider(0, 1, 0); // min, max, initial value
       slider.setShowTickMarks(true);
       slider.setShowTickLabels(true);
       slider.setMajorTickUnit(0.25);
       slider.setMinorTickCount(4);
       return slider;
   }
   /**
    * Set Color:
    * 
    * double color1 = slColor1.getValue();
    * double color2 = slColor2.getValue();
    * double color3 = slColor3.getValue();
    * coloredText.setFill(new Color(color1, color2, color3));
    */
   private void setColor() {
     double red = slRed.getValue();
     double green = slGreen.getValue();
     double blue = slBlue.getValue();
     double opacity = slOpacity.getValue();
     coloredText.setFill(new Color(red, green, blue, opacity));
   }
  public static void main(String[] args) {
    launch(args);
}
