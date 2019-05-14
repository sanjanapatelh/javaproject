import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.Label;
/* <applet code="layout1" width=1500 height=810></applet>*/
public class layout1 extends Applet implements Runnable, ActionListener,ItemListener{
  String msg="";
  String str1,str2,str3;
  long f1,f2,f3;
  Graphics gc;
  
 /* Button requestbus;
  Button requestbus1;
  Button requestbus2;*/
  Checkbox checkbox1;
  Checkbox checkbox2;
  Checkbox checkbox3;
  TextField t1;
  TextField t2;
  TextField t3;
  Label timerequired;
  String str;
  Thread t=null;
  boolean stopFlag;
  long sleeptime=10000;

   public void init(){
   
   this.setLayout(null);
   /*requestbus=new Button("requestbus");
   requestbus1=new Button("requestbus1");
   requestbus2=new Button("requestbus2");*/
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
   
   timerequired.setBounds(260,400,260,30);
   t1.setBounds(350,400,100,30);
   t2.setBounds(550,400,100,30);
   t3.setBounds(750,400,100,30);
   checkbox1.setBounds(350,350,100,30);//450
   checkbox2.setBounds(550,350,100,30);
   checkbox3.setBounds(750,350,100,30);
  
   t1.addActionListener(this);
   t2.addActionListener(this);
   t3.addActionListener(this);
   checkbox1.addItemListener(this);
   checkbox2.addItemListener(this);
   checkbox3.addItemListener(this);

   // setForeground(Color.RED);
   //System.out.println("this is in init function");
   setBackground(Color.white);
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
 public void itemStateChanged(ItemEvent ie){
 
}



 
 public void actionPerformed(ActionEvent ae){
   	  
  
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
	 String work="";
    //setForeground(Color.RED);
	g.drawLine(200,450,800,450);
    g.setColor(Color.green);
    //g.drawString("Welcome ",50,50);
    g.drawLine(270,150,810,150);//busy line
	g.drawLine(365,150,365,250);//device busy1
	g.drawLine(565,150,565,250);//busy2
	g.drawLine(765,150,765,250);//busy3
	g.setColor(Color.black);
    g.drawLine(270,200,810,200);//request line.
    g.drawLine(270,250,350,250 );//bg1
    g.drawLine(410,250,550,250 );//bg2
    g.drawLine(610,250,750,250 );//bg3
 //for each device
    
    g.drawLine(395,200 ,395,250);//request1
    
    g.drawLine(595,200 ,595,250);//request2
    
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
	
	  
	  //when 3 device request
	if(checkbox1.getState()&&checkbox2.getState()&&checkbox3.getState())
	  {
		  work="3 devices request at same time.";
		  g.setColor(Color.black);
		  g.drawString(work,300,500);
		  g.setColor(Color.green);
		  g.drawLine(395,200,395,250);//request of device1
		  g.drawLine(595,200,595,250);//request of device2
		  g.drawLine(795,200,795,250);//request of device3
         try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work=" As 3 devices request at same time 3 request lines are made green ";
		  g.drawString(work,300,500);
		  g.setColor(Color.green);

		  g.drawLine(270,200,810,200);//request line
		  
		   try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="3 devices request  which make request line green which allow processor to select device to grant request";
		  g.drawString(work,300,500);
		  g.setColor(Color.green);
		  if(t.isAlive())
		  {
			   g.setColor(Color.red);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//device busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			    try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Line is busy by some device";
		  g.drawString(work,300,500);
		  g.setColor(Color.green);
			   
			   try{
			t.join();
			}
			catch(InterruptedException e){}
			   g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//device busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
    
		  }
		  
	  try{t.sleep(5000);}
      catch(InterruptedException e){}
	  g.setColor(Color.green);
	  g.drawLine(270,250,350,250);//bg1..granted
      
	  sleeptime=f1;//granted for device1
	  
	  try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
	  try{t.sleep(5000);}
      catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="processor granted for device 1 as it has high priority according to daisy chain.";
		  g.drawString(work,300,500);
		 g.setColor(Color.blue);  //device 1 making busy
		g.drawLine(365,150,365,250);//busy1
		 try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="device 1 making line .. busy for other device";
		  g.drawString(work,300,500);
		  
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(565,150,565,250);//busy2
         g.drawLine(765,150,765,250);//busy3
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Other devices get busy signal";
		  g.drawString(work,300,500);
		if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox1.setState(false);
			
			 
			
		}
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
			 g.setColor(Color.black);//bg1 relese
			 g.drawLine(270,250,350,250);
			 g.drawLine(395,200,395,250);
			try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="device one releasing request line as it doesn't need any more";
		  g.drawString(work,300,500); 
			 
	   try{t.sleep(5000);}
      catch(InterruptedException e){}	
		
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="As device 1 released request line and hence agian busy line is free";
		  g.drawString(work,300,500);
			try{t.sleep(5000);}
      catch(InterruptedException e){}
      checkbox1.setState(false);   	  
		//device release
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Now granting for device 2 as its priority is next";
		  g.drawString(work,300,500);
		
		//device 2 granting
		sleeptime=f2;
		try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request is being granted by processer";
		  g.drawString(work,300,500);
		g.setColor(Color.green);//making bg1 2 
		g.drawLine(270,250,350,250);
		g.drawLine(410,250,550,250);
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
	  try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 2 making line busy as it is using";
		  g.drawString(work,300,500);
	  g.setColor(Color.blue);  //device 2 making busy
		g.drawLine(565,150,565,250);//busy2
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="All other devices now recive busy signal as it is being used";
		  g.drawString(work,300,500);
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(765,150,765,250);//busy3
		
		if(t.isAlive())
		{
			try{
			t.join();
			
			
			checkbox2.setState(false);
			}catch(InterruptedException e){}
			try{t.sleep(5000);}
      catch(InterruptedException e){}
			
	    }
		
		  try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="After the device request completed it releases";
		  g.drawString(work,300,500);
		 g.setColor(Color.black);//bg2 release
			 g.drawLine(410,250,550,250);//bg2
			 g.drawLine(270,250,350,250);//bg1
			 g.drawLine(595,200,595,250);//request2
			 
			 try{t.sleep(5000);}
      catch(InterruptedException e){}
			 try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Now processor is free hence busy line is green";
		  g.drawString(work,300,500);
			g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
		
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}	
	  
	  checkbox2.setState(false);   
		//device 2 release	
		
		//device 3 start
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Now device3 gets the processor";
		  g.drawString(work,300,500);
		sleeptime=f3;
		try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request is being granted by processor for device3";
		  g.drawString(work,300,500);
		
		g.setColor(Color.green);//making bg1 2 3
		g.drawLine(270,250,350,250);
		g.drawLine(410,250,550,250);
		g.drawLine(610,250,750,250);
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work=" device 3 making line busy";
		 g.drawString(work,300,500);
	  g.setColor(Color.blue);  //device 3 making busy
		g.drawLine(765,150,765,250);//busy3
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(565,150,565,250);//busy2
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="All other devices receive busy signal";
		  g.drawString(work,300,500);
		if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox3.setState(false);
			
			 
		}	
		
		try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Release of request";		
		g.drawString(work,300,500);
		g.setColor(Color.BLACK);//bg3 release
			 g.drawLine(270,250,350,250);//bg1
		     g.drawLine(410,250,550,250);//bg2
			 g.drawLine(610,250,750,250);//bg3
			 g.drawLine(795,200,795,250);//request3
			 g.drawLine(270,200,810,200);//request line
		

	try{		 
		 Thread.sleep(5000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Releasing of busy line";		
		  g.drawString(work,300,500);
			g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			checkbox3.setState(false);   
		//device 3 release	
		
		
		}
		
		
		//only one device request..
		//device 1 start
		
		if(checkbox1.getState()&&!checkbox2.getState()&&!checkbox3.getState())
		{
         g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device one requesting";
		 g.drawString(work,300,500);
		 
		 //get request 1
			g.setColor(Color.green);
			g.drawLine(395,200,395,250);//r1
			g.drawLine(270,200,810,200);//request
			g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="As some device requesting request line turns green";
		 g.drawString(work,300,500);
			if(t.isAlive())
			{
				try{
			t.join();
			}catch(InterruptedException e){}
			}
			g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Now processor granting request for requested device.";
		 g.drawString(work,300,500);
			g.drawLine(270,250,350,250);//bg1
			sleeptime=f1;
			try{
				Thread.sleep(sleeptime);
			}
			catch(InterruptedException e){}
			g.setColor(Color.blue);  //device 1 making busy
		g.drawLine(365,150,365,250);//busy1
		g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Now device one making busy line red as it is using";
		 g.drawString(work,300,500);
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(565,150,565,250);//busy2
         g.drawLine(765,150,765,250);//busy3
			
			g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="All other devices get busy signal";
		 g.drawString(work,300,500);
			if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox1.setState(false);
			
			 
			
		}
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
			 g.setColor(Color.black);//bg1 relese
			 g.drawLine(270,250,350,250);
			 g.drawLine(395,200,395,250);
			 g.drawLine(270,200,810,200);
			 g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request being completed it releases busy line";
		 g.drawString(work,300,500);
			 
	   try{t.sleep(5000);}
      catch(InterruptedException e){}	
		
		g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="All devices allowed to request for bus";
		 g.drawString(work,300,500);
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
	  
	 checkbox1.setState(false);
	    } 
	  
		
		
		//device 1 completed
		
		
		
		//for device 2
		if(!checkbox1.getState()&&(checkbox2.getState())&&(!checkbox3.getState()))
		{
			
			
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 2 request for bus";		
		g.drawString(work,300,500);
			//get request 1
			g.setColor(Color.green);
			g.drawLine(595,200,595,250);//r2
			g.drawLine(270,200,810,200);//request
			
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device making request";		
		g.drawString(work,300,500);
			if(t.isAlive())
			{
				try{
			t.join();
			}catch(InterruptedException e){}
			}
			
			g.drawLine(270,250,350,250);//bg1
			g.drawLine(410,250,550,250);//bg2
			sleeptime=f2;
			try{
				Thread.sleep(sleeptime);
			}
			catch(InterruptedException e){}
			g.setColor(Color.blue);  //device 2 making busy
		g.drawLine(565,150,565,250);//busy2
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 2 making bus busy";		
		g.drawString(work,300,500);
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(765,150,765,250);//busy3
			
			
			if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox1.setState(false);
			
			 
			
		}
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
		 
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request being released by device";		
		g.drawString(work,300,500);
	  
			 g.setColor(Color.black);//bg2 relese
			 g.drawLine(270,250,350,250);//bg1
			 g.drawLine(410,250,550,250);//bg2
			 g.drawLine(595,200,595,250);//r2
			 g.drawLine(270,200,810,200);//request
			 
			 
	   try{t.sleep(5000);}
      catch(InterruptedException e){}	
	  
	  try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus is now free ";		
		g.drawString(work,300,500);
		
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
			checkbox2.setState(false);
		}
		//device 2 completed
		
		
		
	  
     //device3 start
	 
	 
	  if(!checkbox1.getState()&&(!checkbox2.getState())&&(checkbox3.getState()))
		{
			
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="device 3 requesting for bus";		
		g.drawString(work,300,500);
			//get request 3
			g.setColor(Color.green);
			g.drawLine(795,200,795,250);//r3
			g.drawLine(270,200,810,200);//request
			
			if(t.isAlive())
			{
				try{
			t.join();
			}catch(InterruptedException e){}
			}
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request being granted";		
		g.drawString(work,300,500);
			g.drawLine(270,250,350,250);//bg1
			g.drawLine(410,250,550,250);//bg2
			g.drawLine(610,250,750,250);//bg3
			sleeptime=f3;
			try{
				Thread.sleep(sleeptime);
			}
			catch(InterruptedException e){}
			g.setColor(Color.blue);  //device 3 making busy
		g.drawLine(765,150,765,250);//busy3
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 3 making bus busy ";		
		g.drawString(work,300,500);
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(565,150,565,250);//busy2
			
			
			if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox1.setState(false);
			
			 
			
		}
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Releasing request";		
		g.drawString(work,300,500);
			 g.setColor(Color.black);//bg3 relese
			 g.drawLine(270,250,350,250);//bg1
			 g.drawLine(410,250,550,250);//bg2
			 g.drawLine(610,250,750,250);//bg3
			 g.drawLine(795,200,795,250);//r3
			 g.drawLine(270,200,810,200);//request
			 
			 
	   try{t.sleep(5000);}
      catch(InterruptedException e){}	
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus is now free for other devices ";		
		g.drawString(work,300,500);
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
			
			checkbox3.setState(false);
		}
	  //device 3 finish
		
	//......................................
	//two devices at a time 2 and 3
	if(!checkbox1.getState()&&checkbox2.getState()&&checkbox3.getState())
	{
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 2 and 3 requesting at same time";		
		g.drawString(work,300,500);
		g.setColor(Color.green);//requestig
		g.drawLine(595,200,595,250);//r2
		g.drawLine(795,200,795,250);//r3
		g.drawLine(270,200,810,200);//requestline
		
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
		
		if(t.isAlive())
		{
			g.setColor(Color.red);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			   try{
				   t.join();
			   }catch(InterruptedException e){}
		}
		
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
	  try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus now free any device can use";		
		g.drawString(work,300,500);
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			   
try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Rquest being granted by processor";		
		g.drawString(work,300,500);
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
		       g.drawLine(270,250,350,250);//bg1
			   
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
               g.drawLine(410,250,550,250);//bg2
			   
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
                g.setColor(Color.blue);
				
				g.drawLine(565,150,565,250);//busy2 making busy
				try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 2 making bus busy";		
		g.drawString(work,300,500);
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
				g.setColor(Color.red);
				
				 g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               
               g.drawLine(765,150,765,250);//busy3
			   
			   try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="All other devices get bus busy signal";		
		g.drawString(work,300,500);
			   try{
				   Thread.sleep(f2);
			   }catch(InterruptedException e){}
			   
			try{t.sleep(5000);}
      catch(InterruptedException e){}	
			   //release request
			   	
		g.drawString(work,300,500);
			   g.setColor(Color.black);
				g.drawLine(595,200,595,250);
				if(t.isAlive())
				{
					try{
						t.join();
						
					}catch(InterruptedException e){}
				}
				
				//release busy
				try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Releasing bus";	
		  g.drawString(work,300,500);
				 try{t.sleep(5000);}
            catch(InterruptedException e){}	
		
		       g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			
			try{t.sleep(5000);}
            catch(InterruptedException e){}	
			checkbox2.setState(false);
			
			//releasd by device 2
			
			//device three gets
			
			
			//device 3 start
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 3 getting bus ";
        g.drawString(work,300,500);		  
		sleeptime=f3;
		try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
		g.setColor(Color.green);//making bg1 2 3
		g.drawLine(270,250,350,250);
		g.drawLine(410,250,550,250);
		g.drawLine(610,250,750,250);
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
	  g.setColor(Color.blue);  //device 3 making busy
		g.drawLine(765,150,765,250);//busy3
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 3 making bus busy";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(565,150,565,250);//busy2
		 
		 try{t.sleep(1000);}
      catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="All other device get bus busy signal";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}
		
		if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			
			
			 
		}	
		
		g.setColor(Color.BLACK);//bg3 release
			 g.drawLine(270,250,350,250);//bg1
		     g.drawLine(410,250,550,250);//bg2
			 g.drawLine(610,250,750,250);//bg3
			 g.drawLine(795,200,795,250);//request3
			 g.drawLine(270,200,810,200);//request line
			 
			 try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Releasing bus ";
        g.drawString(work,300,500);	
			g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			checkbox3.setState(false);   
		//device 3 release	
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Now other devices can use bus";
        g.drawString(work,300,500);	
			
		}
		
		
		
		//device 1 and 2 requesting
		if(checkbox1.getState()&&checkbox2.getState()&&!checkbox3.getState())
		{
			
			//requesting all
			
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 1 and 2 requesting at same time";
        g.drawString(work,300,500);	
			g.setColor(Color.green);
		  g.drawLine(395,200,395,250);//request of device1
		  g.drawLine(595,200,595,250);//request of device2
		  
		  g.drawLine(270,200,810,200);//request line
		  if(t.isAlive())
		  {
			   g.setColor(Color.red);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//device busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			   
			   try{
			t.join();
			}
			catch(InterruptedException e){}
			   g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//device busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
    
		  }
		  
	  try{t.sleep(5000);}
      catch(InterruptedException e){}
	  g.setColor(Color.green);
	  g.drawLine(270,250,350,250);//bg1..granted
      try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request granted for device1 ";
        g.drawString(work,300,500);	
	  sleeptime=f1;//granted for device1
	  
	  try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
	  try{t.sleep(5000);}
      catch(InterruptedException e){}
		g.setColor(Color.blue);  //device 1 making busy
		g.drawLine(365,150,365,250);//busy1
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 1 making bus busy";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(565,150,565,250);//busy2
         g.drawLine(765,150,765,250);//busy3
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus busy";
        g.drawString(work,300,500);	
		if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox1.setState(false);
			
			 
			
		}
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
			 g.setColor(Color.black);//bg1 relese
			 g.drawLine(270,250,350,250);
			 g.drawLine(395,200,395,250);
			 try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="As request completed it releases bus";
        g.drawString(work,300,500);	
			 
	   try{t.sleep(5000);}
      catch(InterruptedException e){}	
		
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			
			try{t.sleep(5000);}
      catch(InterruptedException e){}
      checkbox1.setState(false);   	  
		//device release
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request being granted for device 2";
        g.drawString(work,300,500);	
		
		//device 2 granting
		sleeptime=f2;
		try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
		g.setColor(Color.green);//making bg1 2 
		g.drawLine(270,250,350,250);
		g.drawLine(410,250,550,250);
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
	  g.setColor(Color.blue);  //device 2 making busy
		g.drawLine(565,150,565,250);//busy2
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 2 making bus busy";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(765,150,765,250);//busy3
		
		if(t.isAlive())
		{
			try{
			t.join();
			
			
			checkbox2.setState(false);
			}catch(InterruptedException e){}
			try{t.sleep(5000);}
      catch(InterruptedException e){}
			
	    }
		 g.setColor(Color.black);//bg2 release
			 g.drawLine(410,250,550,250);//bg2
			 g.drawLine(270,250,350,250);//bg1
			 g.drawLine(270,200,810,200);//request full
			 g.drawLine(595,200,595,250);//request2
			 try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Requesting being released";
        g.drawString(work,300,500);	
			 try{t.sleep(5000);}
      catch(InterruptedException e){}
			 
			g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
		
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus free for other devices to use";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}	
	  
	  checkbox2.setState(false);   
		//device 2 release	
			
			
			
		}
		
		//end of device 1 and 2
		
		//two device 1 and 3
		
		if(checkbox1.getState()&&checkbox3.getState()&&!checkbox2.getState())
			
			{
				try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 1 and 3 requesting for bus";
        g.drawString(work,300,500);	
				//device one geting
				
				
				g.setColor(Color.green);
		  g.drawLine(395,200,395,250);//request of device1
		  
		  g.drawLine(795,200,795,250);//request of device3
		  g.drawLine(270,200,810,200);//request line
		  if(t.isAlive())
		  {
			   g.setColor(Color.red);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//device busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			   
			   try{
			t.join();
			}
			catch(InterruptedException e){}
			   g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//device busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
    
		  }
		  
	  try{t.sleep(5000);}
      catch(InterruptedException e){}
	  g.setColor(Color.green);
	  g.drawLine(270,250,350,250);//bg1..granted
      try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request granted for device 1";
        g.drawString(work,300,500);	
	  sleeptime=f1;//granted for device1
	  
	  try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
	  try{t.sleep(5000);}
      catch(InterruptedException e){}
		g.setColor(Color.blue);  //device 1 making busy
		g.drawLine(365,150,365,250);//busy1
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 1 making bus busy";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(565,150,565,250);//busy2
         g.drawLine(765,150,765,250);//busy3
		
		if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			checkbox1.setState(false);
			
			 
			
		}
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
			 g.setColor(Color.black);//bg1 relese
			 g.drawLine(270,250,350,250);
			 g.drawLine(395,200,395,250);
			 try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request completed hence device  release bus";
        g.drawString(work,300,500);	
			 
	   try{t.sleep(5000);}
      catch(InterruptedException e){}	
		
		g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			
			
			try{t.sleep(5000);}
      catch(InterruptedException e){}
      checkbox1.setState(false);  
try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus free to use";
        g.drawString(work,300,500);	 	  
		//device1 release
				
			//	device 3 geting
			
			
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Request being granted for device 3";
        g.drawString(work,300,500);	
				//device 3 start
		
		sleeptime=f3;
		try{
		Thread.sleep(sleeptime);
		}catch(InterruptedException e){}
		g.setColor(Color.green);//making bg1 2 3
		g.drawLine(270,250,350,250);
		g.drawLine(410,250,550,250);
		g.drawLine(610,250,750,250);
		
		try{t.sleep(5000);}
      catch(InterruptedException e){}
	  
	  g.setColor(Color.blue);  //device 3 making busy
		g.drawLine(765,150,765,250);//busy3
		
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Device 3 making bus busy";
        g.drawString(work,300,500);	
		try{t.sleep(5000);}
      catch(InterruptedException e){}
        g.setColor(Color.red);//making busy
		g.drawLine(270,150,810,150);//busy line
		
         g.drawLine(365,150,365,250);//busy1
         g.drawLine(565,150,565,250);//busy2
		try{t.sleep(5000);}
      catch(InterruptedException e){}
		try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus busy for other devices";
        g.drawString(work,300,500);	
		if(t.isAlive())
		{
			try{
			t.join();
			}
			catch(InterruptedException e){}
			
			
			 
		}	
		
		g.setColor(Color.BLACK);//bg3 release
			 g.drawLine(270,250,350,250);//bg1
		     g.drawLine(410,250,550,250);//bg2
			 g.drawLine(610,250,750,250);//bg3
			 g.drawLine(795,200,795,250);//request3
			 g.drawLine(270,200,810,200);//request line
			 try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Releasing of request as it complets";
        g.drawString(work,300,500);	
			 
			g.setColor(Color.green);
			   g.drawLine(270,150,810,150);//busy line
			   g.drawLine(365,150,365,250);//busy1
               g.drawLine(565,150,565,250);//busy2
               g.drawLine(765,150,765,250);//busy3
			checkbox3.setState(false);   
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Bus free to use";
        g.drawString(work,300,500);	
		//device 3 release	
			
				
		}
		
			try{		 
		 Thread.sleep(1000);}
		 catch(InterruptedException e){}
		  g.setColor(Color.white);
		  g.drawString(work,300,500);
		  g.setColor(Color.black);
		  work="Any device can request bus";
        g.drawString(work,300,500);		
				
				
	}
		
		
		
            		
			   
	
	
		
		

		
	  
	  
	  
    




//stop applet

public void stop()
{
	stopFlag=true;
	t=null;
}

}