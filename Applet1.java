import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Graphics;
import javax.swing.*;
/* <applet code="Applet1" width=1500 height=810></applet>*/
public class Applet1 extends Applet implements Runnable, ActionListener{
  String msg="";
  Graphics gc;
  Button requestbus;
  Button requestbus1;
  Button requestbus2;
  
  String str;
  Thread t=null;
  boolean stopFlag;
  long sleeptime=10000;

   public void init(){
   
this.setLayout(null);
   requestbus=new Button("requestbus");
   requestbus1=new Button("requestbus1");
   requestbus2=new Button("requestbus2");
 
   add(requestbus);
   add(requestbus1);
   add(requestbus2);
   requestbus.setBounds(350,350,100,30);
   requestbus1.setBounds(550,350,100,30);
   requestbus2.setBounds(750,350,100,30);
   requestbus.addActionListener(this);
   requestbus1.addActionListener(this);
   requestbus2.addActionListener(this); 
   // setForeground(Color.RED);
   //System.out.println("this is in init function");
   setBackground(Color.WHITE);
}
//start function for thread

// thread functions

public void start()
{
	t=new Thread(this,"mainthread");
	stopFlag=false;
	t.start();
}
public void run()
{
    for( ; ;)
  {	
	try{
	if(sleeptime==0)
       break;  		
	Thread.sleep(sleeptime);
	sleeptime=0;
	repaint();
	if(stopFlag)
		break;
	}
	catch(InterruptedException e){}
  }
}




 
 public void actionPerformed(ActionEvent ae){
    str=ae.getActionCommand();
	
    if(str.equals("requestbus")){
      //setBackground(Color.blue);
      msg="Bus request by DMA1";
	 
    }
   
    if(str.equals("requestbus2")) {
      msg="Bus request by DMA3";
      //gc.drawLine(270,200,810,200);
      //setBackground(Color.blue);
    }
    if(ae.getSource()==requestbus){
     
      
    requestbus.setBackground(Color.pink);
      requestbus1.setBackground(Color.lightGray);
      requestbus2.setBackground(Color.lightGray);}
     if(ae.getSource()==requestbus1){
      
      requestbus.setBackground(Color.lightGray);
      requestbus1.setBackground(Color.pink);
      requestbus2.setBackground(Color.lightGray);}
    if(ae.getSource()==requestbus2){
 
     
     requestbus.setBackground(Color.lightGray);
      requestbus1.setBackground(Color.lightGray);
      requestbus2.setBackground(Color.pink);}
    repaint();
}
 
 public void paint(Graphics g){
    //setForeground(Color.RED);
    g.setColor(Color.BLACK);
    //g.drawString("Welcome ",50,50);
    g.drawLine(270,150,810,150);//busy line
    g.drawLine(270,200,810,200);//request line.
    g.drawLine(270,250,350,250 );//bg1
    g.drawLine(410,250,550,250 );//bg2
    g.drawLine(610,250,750,250 );//bg3
 //for each device
    g.drawLine(365,150,365,250);//device busy1
    g.drawLine(395,200 ,395,250);//request1
    g.drawLine(565,150,565,250);//busy2
    g.drawLine(595,200 ,595,250);//request2
    g.drawLine(765,150,765,250);//busy3
    g.drawLine(795,200 ,795,250);//request3
   
  // g.drawRect(300,250,40,40);
    g.fillRect(200,140,70,130);//processer
    g.fillRect(350,230,60,60);//device1
    g.fillRect(550,230,60,60);//device2
    g.fillRect(750,230,60,60);//device3
    //g.fillRect(950,230,60,60);
    g.setColor(Color.WHITE);
    g.drawString("proc",220,210);
    g.drawString("DMA1",370,260);
    g.drawString("DMA2",570,260);
    g.drawString("DMA3",770,260);
    g.setColor(Color.BLACK);
    g.drawString("BBSY",810,140);
    g.drawString("BR",810,190);
    g.drawString("BG1",310,270);
    g.drawString("BG2",450,270);
    g.drawString("BG3",650,270);
    g.drawString(msg,370,320);
	
	 //for device 2
	 
	 if(str.equals("requestbus1")){
      msg="Bus request by DMA2";
	  
	  g.setColor(Color.green);
      g.drawLine(270,200,810,200);
	  g.drawLine(595,200,595,250);
      
	  if(t.isAlive())
	  {
		  g.setColor(Color.red);
		  g.drawLine(270,150,810,150);
		  g.drawLine(565,150,565,250);
		 try{ t.join();}
		 catch(InterruptedException e){}
		  
	  }
	  
	  g.setColor(Color.green);
	  g.drawLine(270,250,350,250);//bg1
	  
	  try{t.sleep(1000);}
      catch(InterruptedException e){}	
	  
	  
	  g.drawLine(410,250,550,250);//bg2
	   
	   try{t.sleep(1000);}
      catch(InterruptedException e){}	  
	  
	  g.setColor(Color.black);//request2
	  g.drawLine(270,200,810,200);
	  g.drawLine(595,200 ,595,250);
	 
	  try{t.sleep(1000);}
      catch(InterruptedException e){}	  
	  g.setColor(Color.red);
	  g.drawLine(270,150,810,150);
	  try{t.sleep(1000);}
      catch(InterruptedException e){}
	  g.drawLine(365,150,365,250);
	  g.drawLine(565,150,565,250);
	  g.drawLine(765,150,765,250);
    }

}


//stop applet

public void stop()
{
	stopFlag=true;
	t=null;
}

}

