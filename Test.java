import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics;

public class Test extends JPanel implements KeyListener {
	double turnRadius=2;//DO NOT EXCEED 2.9
	double turnSpeed=4;
JFrame frame;
JPanel panel;
double xtl = 250.0;
double ytl=50;
double xtr = 500.0;
double ytr=50;
double xbl = 250.0;
double ybl=200;
double xbr = 500.0;
double ybr=200;

public static void main(String[] args){
new Test();
}

public Test(){
constructAFrameForMePlease();
}

/*public*/ void constructAFrameForMePlease(){
frame = new JFrame();
frame.setDefaultCloseOperation(3);
frame.setSize(800, 500);
frame.add(this);
frame.addKeyListener(this);
frame.setVisible(true);
}

protected /*public*/ void paintComponent(Graphics whoNeedsSleep){
super.paintComponent(whoNeedsSleep);
Graphics2D myGraphics = (Graphics2D) whoNeedsSleep;
Graphics2D myOtherGraphics = (Graphics2D) whoNeedsSleep;
BasicStroke sidestroke = new BasicStroke(5.0f);
myGraphics.setStroke(sidestroke);
myGraphics.setPaint(Color.BLUE);
Line2D.Double myLine1 = new Line2D.Double(xtr,ytr,xbr,ybr); //Right Line
myGraphics.draw(myLine1);
myGraphics.setPaint(Color.GREEN);
Line2D.Double myOtherLine1 = new Line2D.Double(xtl, ytl, xbl, ybl);//left line
myGraphics.draw(myOtherLine1);
Line2D.Double myotherOtherLine1 = new Line2D.Double(xbl, ybl, xbr, ybr);//bottom line
myOtherGraphics.draw(myotherOtherLine1);
myGraphics.setPaint(Color.RED);
Line2D.Double myOtherOtherOtherLine1 = new Line2D.Double(xtl, ytl, xtr, ytr);//Top Line
myOtherGraphics.draw(myOtherOtherOtherLine1);
}

public void keyPressed(KeyEvent arg0) {
double l=Math.pow(turnRadius*(xtl-375)/375,2),r=Math.pow(turnRadius*(xtr-375)/375,2);
double lx=(l-1)*-1,rx=(r-1)*-1;
if(arg0.getKeyChar() == 'a' || arg0.getKeyChar() == 'A'){
if(xtl>=250){
xtl+=turnSpeed*lx;
xbl+=turnSpeed*lx;
xtr+=turnSpeed*rx;
xbr+=turnSpeed*rx;
}
else{
xtl+=turnSpeed*lx;
xbl+=turnSpeed*lx;
xtr+=turnSpeed*rx;
xbr+=turnSpeed*rx;
}
if(xtl>=375){ytl-=l;ybl+=l;}
else{ytl+=l;ybl-=l;}
if(xtr>=375){ytr-=r;ybr+=r;}
else{ytr+=r;ybr-=r;}
}

else if(arg0.getKeyChar() == 'd' || arg0.getKeyChar() == 'D'){
if(xtl>=250){xtl-=turnSpeed*lx;
xbl-=turnSpeed*lx;
xtr-=turnSpeed*rx;
xbr-=turnSpeed*rx;}
else{xtl-=turnSpeed*lx;
xbl-=turnSpeed*lx;
xtr-=turnSpeed*rx;
xbr-=turnSpeed*rx;}
if(xtl>=375){ytl+=l;ybl-=l;}
else{ytl-=l;ybl+=l;}
if(xtr>=375){ytr+=r;ybr-=r;}
else{ytr-=r;ybr+=r;}
}
super.repaint();
}

public void keyReleased(KeyEvent arg0) {
System.out.println("We don't need sleep");
}

public void keyTyped(KeyEvent arg0) {
}
}