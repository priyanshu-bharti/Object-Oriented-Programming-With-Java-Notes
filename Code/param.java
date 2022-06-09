import java.awt.*;
import java.applet.*;

/*
<applet code="param" width=400 height=200>
  <param name="appname" value="Parameter Demo Applet">
</applet>
*/

public class param extends Applet {
  public void paint(Graphics g) {
    String param = this.getParameter("appname");
    g.drawString(("Parameter Passed : " + param), 20, 20);
  }
}