package Draw_Map;
import java.awt.*;
import javax.swing.JFrame;

public interface IDisplay {

    void createDisplay();
    Canvas getCanvas();
    JFrame getFrame();

}