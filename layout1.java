import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Label;
/* <applet code="layout1" width=1500 height=810></applet>*/
public class layout1 extends Applet implements Runnable, ActionListener,ItemListener{
  String msg="";
  String str1,str2,str3;
  long f1,f2,f3;
  Graphics gc;
  Button requestbus;
  Button requestbus1;
  Button requestbus2;
  Checkbox checkbox1;
  Checkbox checkbox2;
  Checkbox checkbox3;
  TextField t1;
  TextField t2;
  TextField t3;
  Label timerequired;
  String str;
  Thread t=null;
  //boolean stopFlag;
  long sleeptime=10000;

   public void init(){
   
   this.setLayout(null);
   requestbus=new Button("requestbus");
   requestbus1=new Button("requestbus1");
   requestbus2=new Button("requestbus2");
   timerequired =new Label("timerequired");
   t1=new TextField(10);
   t2=new TextField(10);
   t3=new TextField(10);
   add(t1);
   add(t2);
   add(t3);
   add(timerequired);
   checkbox1=new Checkbox("checkbox1",null,false);
   checkbox2=new Checkbox("checkbox2");
   checkbox3=new Checkbox("checkbox3");
   add(checkbox1);
   add(checkbox2);
   add(checkbox3);
   add(requestbus);
   add(requestbus1);
   add(requestbus2);
   timerequired.setBounds(260,400,260,30);
   t1.setBounds(350,400,100,30);
   t2.setBounds(550,400,100,30);
   t3.setBounds(750,400,100,30);
   checkbox1.setBounds(350,350,100,30);//450
   checkbox2.setBounds(550,350,100,30);
   checkbox3.setBounds(750,350,100,30);
   requestbus.setBounds(350,450,100,30);
   requestbus1.setBounds(550,450,100,30);
   requestbus2.setBounds(750,450,100,30);
   requestbus.addActionListener(this);
   requestbus1.addActionListener(this);
   requestbus2.addActionListener(this); 
   t1.addActionListener(this);
   t2.addActionListener(this);
   t3.addActionListener(this);
   checkbox1.addItemListener(this);
   checkbox2.addItemListener(this);
   checkbox3.addItemListener(this);

   // setForeground(Color.RED);
   //System.out.println("this is in init function");
   setBackground(Color.WHITE);
}
//start function for thread

// thread functions

public void start()
{
	t=new Thread(this,"mainthread");
	t.start();
}
public void run()
{
repaint();   
}
 public void itemStateChanged(ItemEvent ie){
 
}



 
 public void actionPerformed(ActionEvent ae){
    /*str=ae.getActionCommand();
	
	
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
      */requestbus2.setBackground(Color.pink);}
	  
  
	if(t1.getText()!=null||t2.getText()!=null||t3.getText()!=null)
	{
		  //textfeild
	str1=t1.getText();
   f1=Long.valueOf(str1);
  
   str2=t2.getText();
   f2=Long.valueOf(str2);
   
   str3=t3.getText();
  f3=Long.valueOf(str3);
	
	}
	
	
	
	  
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

if(!checkbox1.getState()&&checkbox2.getState()&&checkbox3.getState()){
try{
	g.setColor(Color.green);
	g.drawLine(595,200 ,595,250);//request2
	t.sleep(1000);
	 g.drawLine(795,200 ,795,250);//request3
t.sleep(1000);
	 g.drawLine(270,200,810,200);//request line.
t.sleep(1000);
	g.drawLine(270,250,350,250 );//bg1
t.sleep(1000);
	g.setColor(Color.BLACK);
	g.drawLine(270,250,350,250 );//bg1	
	g.setColor(Color.green);
	 g.drawLine(410,250,550,250 );//bg2
t.sleep(2000);
	g.setColor(Color.blue);
	g.drawLine(565,150,565,250);//busy2
	t.sleep(1000);
	g.setColor(Color.red);
	g.drawLine(270,150,810,150);//busy line
	g.drawLine(365,150,365,250);//device busy1
	g.drawLine(565,150,565,250);//busy2
	g.drawLine(765,150,765,250);//busy3
	checkbox2.setState(false);
	t.sleep(f2);
	t.join();
	g.setColor(Color.black);
	g.drawLine(595,200 ,595,250);//request2
	g.drawLine(410,250,550,250 );//bg2
	g.setColor(Color.green);
	g.drawLine(610,250,750,250 );//bg3
t.sleep(5000);
	g.setColor(Color.blue);
	
	g.drawLine(765,150,765,250);//busy3
t.sleep(5000);
	g.setColor(Color.red);
	g.drawLine(270,150,810,150);//busy line
	g.drawLine(365,150,365,250);//device busy1
	g.drawLine(565,150,565,250);//busy2
	g.drawLine(765,150,765,250);//busy3
	
	g.setColor(Color.black);
	
	 g.drawLine(795,200 ,795,250);//request3
	g.drawLine(270,200,810,200);//request line
	t.sleep(f3);
	g.drawLine(610,250,750,250 );//bg3
	checkbox3.setState(false);
}catch(InterruptedException e){}
if((checkbox1.getState()&&(!checkbox2.getState())&&checkbox3.getState()){
	try{
	g.setColor(Color.green);
	g.drawLine(395,200,395,250);//request1
t.sleep(5000);
	g.drawLine(795,200 ,795,250);//request3
t.sleep(5000);
	g.drawLine(270,200,810,200);//request line
	g.setColor(Color.blue);
	g.drawLine(365,150,365,250);//device busy1
t.sleep(5000);
	g.setColor(Color.green);
	g.drawLine(270,250,350,250 );//bg1
t.sleep(5000);
	g.setColor(Color.red);
	g.drawLine(270,150,810,150);//busy line
	g.drawLine(565,150,565,250);//busy2
	g.drawLine(765,150,765,250);//busy3
t.sleep(f1);
	checkbox1.setState(false);
	g.setColor(Color.black);
	g.drawLine(270,150,810,150);//busy line
g.setColor(Color.green);
	g.drawLine(610,250,750,250 );//bg3
t.sleep(5000);
	g.setColor(Color.blue);

	g.drawLine(765,150,765,250);//busy3
t.sleep(5000);
	g.setColor(Color.red);
	g.drawLine(270,150,810,150);//busy line
	g.drawLine(365,150,365,250);//device busy1
	g.drawLine(565,150,565,250);//busy2
	t.sleep(f3);
	g.setColor(Color.black);
	g.drawLine(610,250,750,250 );//bg3
	g.drawLine(270,150,810,150);//busy line
	g.drawLine(365,150,365,250);//device busy1
	g.drawLine(565,150,565,250);//busy2
	g.drawLine(765,150,765,250);//busy3
}catch(InterruptedException e){}
}



























	
	/*if(str.equals("requestbus1")){
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
    }*/

}


//stop applet

public void stop()
{
	//stopFlag=true;
	t=null;
}

}
