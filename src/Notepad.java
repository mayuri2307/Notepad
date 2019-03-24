import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.border.*;
import javax.swing.text.*;  //importing java libraries
public class Notepad extends JFrame implements ActionListener, FocusListener
{
    JFrame f2=new JFrame(); //creating JFrame object
     StyledEditorKit st=new StyledEditorKit();
     StyledDocument doc= new DefaultStyledDocument();
                       MouseMagic Moma= new MouseMagic();
                       shapes pb=new shapes();
                        static int i=-1; //initialising variables
                        static int x1=200,x2=400,y1=200,y2=400;
                        String tatext="Enter text here...";
			JLabel l=new JLabel("Font:");
			JLabel l2=new JLabel("Font Style:");
			JLabel l3=new JLabel("Font Size:");
			JLabel l4=new JLabel("Sample:");
			JLabel l5=new JLabel("XxYyZz");
			JButton bb1=new JButton("OK");
			JButton bb2=new JButton("Cancel");
                        JButton bb3=new JButton("Preview");
                        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    String[] fontNames = e.getAvailableFontFamilyNames();           
		    JList fontList = new JList(fontNames); //creating list
                    JComboBox chooseFont = new JComboBox(fontNames);
                    String [] fontstyle={"Regular","Italic","Bold"};
		    JComboBox c=new JComboBox(fontstyle);
                    String [] size={"8","9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
		    JComboBox size1=new JComboBox(size);
    JLabel fx=new JLabel("Find What:");
    JTextArea tt=new JTextArea();
    JButton b2 = new JButton("Find");
    JButton fn= new JButton("Find Next");
    JButton b3= new JButton("Cancel");
    JFrame f1=new JFrame("Find Dialog");
 LinkedList<Integer> w=new LinkedList<Integer>();
int currentIndex; //declaring data members
String path,file;
   JTextPane ta=new JTextPane();
  JScrollPane p1=new JScrollPane(ta);
   JMenuBar mb = new JMenuBar(); 
    JMenu m1 = new JMenu("File"); //creating menu
    JMenuItem i1= new JMenuItem("New");
     JMenuItem i2 = new JMenuItem("Open"); 
     JMenuItem i3 = new JMenuItem("Save"); 
      JMenuItem i4 = new JMenuItem("Cut"); 
       JMenuItem i5 = new JMenuItem("Copy"); 
       JMenuItem i6 = new JMenuItem("Paste"); 
      JMenuItem i8 = new JMenuItem("Find");  //creating menu items
      JMenuItem i9 = new JMenuItem("Replace"); 
      JMenuItem i10 = new JMenuItem("Replace-All"); 
    JMenu m2 = new JMenu("Edit"); 
   JMenu m3 = new JMenu("Format");
    JMenu m4 = new JMenu("Case");
JMenuItem i7 = new JMenuItem("Font");
JMenuItem i11 = new JMenuItem("Lowercase");
JMenuItem i12 = new JMenuItem("Uppercase");
 Font f=new Font("Arial",Font.PLAIN,16);
JPanel pa= new JPanel(); //creating JPanel
JButton b1=new JButton("Calculate");
JButton sh1=new JButton("Rectangle");
JButton sh2=new JButton("Oval");
JButton sh3 =new JButton("Cone");
JButton sh4=new JButton("Arc");
JButton sh5=new JButton("Round Rectangle");
JButton sh6=new JButton("Clear");
Border bor = BorderFactory.createLineBorder(Color.black, 5);
Border bor1 = BorderFactory.createLineBorder(Color.red, 5);
KeyTrap kt = new KeyTrap();
String s;
            Notepad() //constructor
     {

	super("Untitled-Text Editor");
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.width,d.height);
	setLayout(null);
        setResizable(false);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setBackground(new Color(200,200,255));
	setResizable(false);
                //setting text
               pa.setLayout(null);
                pa.setBackground(Color.white);
                b1.setBounds(0,0,d.width/7,d.height/25);
                sh1.setBounds(d.width/7,0,d.width/7,d.height/25);
                sh2.setBounds(2*d.width/7,0,d.width/7,d.height/25);
                sh3.setBounds(3*d.width/7,0,d.width/7,d.height/25);
                sh4.setBounds(4*d.width/7,0,d.width/7,d.height/25);
                sh5.setBounds(5*d.width/7,0,d.width/7,d.height/25);
                sh6.setBounds(6*d.width/7,0,d.width/7,d.height/25);
                ta.setBounds(0,0,d.width-5,d.height/2);
                pa.setBounds(0,0,d.width,d.height/25);
                pb.setBounds(0,d.height/25 + d.height/2,d.width-5,d.height/3+d.height/14);
                p1.setBounds(0,d.height/25,d.width-5,d.height/2);
                ta.setStyledDocument(doc);
                ta.setEditorKit(st);
                ta.setText(tatext);
                pa.add(b1); //adding components
                pa.add(sh1);
                pa.add(sh2);
                pa.add(sh3);
                pa.add(sh4);
                pa.add(sh5);
                pa.add(sh6);
	ta.setFont(f); //setting initial font
	addWindowListener(new CloseWindow());
        m1.add(i1);
        m1.add(i2); 
        m1.add(i3); 
        m2.add(i4); 
        m2.add(i5); 
        m2.add(i6); 
       m2.add(i8); 
        m2.add(i9); 
        m2.add(i10); 
        m3.add(i7);
        m4.add(i11);
        m4.add(i12);
        mb.add(m1); 
        mb.add(m2); 
       mb.add(m3);
       mb.add(m4);
     i1.addActionListener(this);
     i2.addActionListener(this);
     i3.addActionListener(this);
     i4.addActionListener(this);
     i5.addActionListener(this);
     i6.addActionListener(this);
     i7.addActionListener(this);
     i8.addActionListener(this);
     i9.addActionListener(this);
    i10.addActionListener(this);
    i11.addActionListener(this);
   i12.addActionListener(this);
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   fn.addActionListener(this);
   bb1.addActionListener(this);
   bb2.addActionListener(this);
   bb3.addActionListener(this);
   sh1.addActionListener(this);
   sh2.addActionListener(this);
   sh3.addActionListener(this);
   sh4.addActionListener(this);
   sh5.addActionListener(this);
   sh6.addActionListener(this);
   ta.addFocusListener(this);
   ta.setBorder(bor); //setting border
   ta.setForeground(Color.BLACK);
   pb.addMouseMotionListener(Moma);
       setJMenuBar(mb); //setting menubar
      add(pa);
     add(pb);
     pb.setBackground(Color.white);
     pb.setBorder(bor1);
     add(p1);
     seFrame();
     se1Frame();
        setVisible(true);
  }
              public void focusGained(FocusEvent fe)
  {
	if(fe.getSource()==ta)
	{
	  if((ta.getText()).equals(tatext))
          {
	    ta.setText("");
            ta.setForeground(Color.BLACK);
          }
	}
      
  }
  public void focusLost(FocusEvent fe){}
            public void se1Frame()
            {
                //creating seperate frame for Selecting font
                        
			f2.setLayout(null);
                        f2.setResizable(false);
			f2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			f2.setLocationRelativeTo(null);
			l.setBounds(10, 10, 50, 50);
			l2.setBounds(170,10,100,50);
			l3.setBounds(330, 10, 100, 50);
			l4.setBounds(200, 150, 50, 50);
			l5.setBounds(250, 180, 350, 100);
			bb1.setBounds(250,350,100,30);
			bb2.setBounds(370, 350, 100, 30);
                        bb3.setBounds(130,350,100,30);
			f2.add(l);
			f2.add(l2);
			f2.add(l3);
			f2.add(l4);
			f2.add(l5);
			f2.add(bb1);
			f2.add(bb2);
                        f2.add(bb3);                        
		    fontList.setValueIsAdjusting(true);                          
		    fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    chooseFont.setBounds(10,50,130,20);
		    c.setBounds(170, 50, 130, 20);
		    size1.setBounds(330, 50, 130, 20);
		    f2.add(chooseFont);
		    f2.add(c);
		    f2.add(size1);
		    f2.setSize(500, 500);
		    f2.setVisible(false);
            }
 class KeyTrap extends KeyAdapter
  {
    public void keyPressed(KeyEvent ke)
    {
	if(ke.getSource()==tt)
	{
	  b2.setEnabled(true); //to enable JButton

	}
    }   
        
      }
            public void seFrame()
            {
                //creating a seperate frame to find words
       f1.setLayout(null);
       f1.setLocationRelativeTo(null);
       fx.setBounds(10,5,150,50);
       tt.setBounds(80,20,250,20);
       b2.setBounds(20,70,70,20);
       fn.setBounds(140,70,90,20);
       b3.setBounds(280,70,75,20);
       f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       tt.addKeyListener(kt);
       b2.setEnabled(false);
       fn.setEnabled(false);
       f1.add(fx);
       f1.add(tt);
       f1.add(b2);
       f1.add(fn);
       f1.add(b3);
       f1.setSize(400,150);
            }
public void findWord(String s)throws Exception
{
  w.clear(); //clearing contents of list
   char ch1;
   String s3;
   char ch = s.charAt(0); //extracting first character
   String s2=ta.getText();
   for(int i=0;i<s2.length();i++)
      {
          ch1=s2.charAt(i);
          if(ch1==ch)
                {
                    s3 = s2.substring(i,(i+s.length()<=s2.length()?i+s.length():s2.length()));
                    if(s.compareTo(s3)==0)
                           { 
                              w.add(new Integer(i)); //adding to the list                              
                            }
                     
                 }
      }
   if(w.isEmpty())
       JOptionPane.showMessageDialog(null,"No Word Found!");
   else
   {
 int a =(w.getFirst()).intValue();
Highlighter h = ta.getHighlighter();
h.removeAllHighlights(); //removing highlights
h.addHighlight(a ,a+ s.length(), DefaultHighlighter.DefaultPainter);
w.removeFirst();
   }
}
public void findNext()
{
           if(w.isEmpty())
               JOptionPane.showMessageDialog(null,"Not Found!");
           else
           {
           int a =(w.getFirst()).intValue();
           Highlighter h = ta.getHighlighter();
           h.removeAllHighlights();
           try{
           h.addHighlight(a ,a+ s.length(), DefaultHighlighter.DefaultPainter);
           }
           catch(Exception e)
           {}
           w.removeFirst();
           }
}
public void actionPerformed(ActionEvent evt)
{
    if(evt.getSource()==i4)
     {
          ta.cut();
     }
     else if(evt.getSource()==i5)
     {
          ta.copy();
     }
       else if(evt.getSource()==i6)
     {
          ta.paste();
     }
      else if(evt.getSource()==i8)
        { 
            f1.setVisible(true); //displaying frame

   
         }
  else if(evt.getSource()==i10)
  {
      //it replaces the text with given word
       s=JOptionPane.showInputDialog("Replace:");
String k=JOptionPane.showInputDialog("With:");
   String s2=ta.getText();
   String s3=s2.replaceAll(s,k);
  ta.setText(s3);
  s="";
  }
  else if(evt.getSource()==i9)
     {
  s=JOptionPane.showInputDialog("Replace:");
  if(!(s.equals("")))
  {
String k=JOptionPane.showInputDialog("With:");
   String s2=ta.getText();
   String s3=s2.replaceFirst(s,k);
  ta.setText(s3);
  s="";
    }
     }
 else if(evt.getSource()==i11)
   { 
     String s2= ta.getText();
     int a=ta.getSelectionStart();
     int b=ta.getSelectionEnd();
    String s3= (s2.substring(a,b)).toLowerCase(); //to change case of selected string
    if(b>=s2.length())
        ta.setText(s2.substring(0,a)+s3);
    else
     ta.setText(s2.substring(0,a)+s3+s2.substring(b));
   }
 else if(evt.getSource()==i12)
   { 
     String s2= ta.getText();
     int a=ta.getSelectionStart();
     int b=ta.getSelectionEnd();
    String s3= (s2.substring(a,b)).toUpperCase();
    if(b>=s2.length())
        ta.setText(s2.substring(0,a)+s3);
    else
     ta.setText(s2.substring(0,a)+s3+s2.substring(b));
     
   }
 else if(evt.getSource()==b1)
 {
     String s2=ta.getSelectedText(); //to extract selected string
     if(s2==null)
         JOptionPane.showMessageDialog(null,"No Selected Text Found!");
     else
     {
     char ch;
     int c=0;
     for(int i=0;i<s2.length();i++)
     {
         ch=s2.charAt(i);
         if(ch==' ')
             c++;
     }
    JOptionPane.showMessageDialog(null,"No. of words= "+(c+1)+ "\n"+ "No. of characters= "+s2.length());
     }
 }
 else if(evt.getSource()==b2)
       {
           fn.setEnabled(true);
           s=tt.getText(); //getting text
           if(!(s.equals("")))
           {
                    try{
         findWord(s); //function to find word
              }
       catch(Exception e){} 
           }
       }
else if(evt.getSource()==fn)
       {
           if((!(s.equals("")))&& (tt.getText()).equals(s) )
           findNext(); // to get the next occurence

       }
else if(evt.getSource()==b3)
{
    f1.setVisible(false);
    tt.setText("");
    fn.setEnabled(false);
    b2.setEnabled(false); //disabling buttons
    Highlighter h = ta.getHighlighter();
    h.removeAllHighlights();
}
else if(evt.getSource()==i7)
{
    f2.setVisible(true);                   
}
else if(evt.getSource()==bb1)
{
    String name=String.valueOf(chooseFont.getSelectedItem());
    Action typeAction = new StyledEditorKit.FontFamilyAction(String.valueOf(name),name);
    typeAction.actionPerformed(evt); //to set font of the given text
    
    String name1=String.valueOf(size1.getSelectedItem());
    Action typeAction1 = new StyledEditorKit.FontSizeAction(String.valueOf(name1),Integer.parseInt((String)size1.getSelectedItem()) );
    typeAction1.actionPerformed(evt);
    
    StyledDocument doc=(StyledDocument)ta.getDocument(); //getting document
    Style logicalStyle=doc.getLogicalStyle(ta.getSelectionStart());
    Element element =doc.getCharacterElement(ta.getSelectionStart());
    AttributeSet as=element.getAttributes();
    boolean isBold=StyleConstants.isBold(as); //to check if text is bold
    boolean isItalic=StyleConstants.isItalic(as);
    if(c.getSelectedItem()=="Bold")
    {

     if(!isBold&&isItalic){
         Action typeAction2 = new StyledEditorKit.BoldAction();
     typeAction2.actionPerformed(evt);
     Action typeAction3 = new StyledEditorKit.ItalicAction();
     typeAction3.actionPerformed(evt);
     }
     else if(!isBold&&!isItalic)
     {
         Action typeAction2 = new StyledEditorKit.BoldAction();
     typeAction2.actionPerformed(evt);
     }
    } 
    else if(c.getSelectedItem()=="Italic"){
        if(!isItalic&&isBold){
            Action typeAction2 = new StyledEditorKit.BoldAction();
     typeAction2.actionPerformed(evt);
     Action typeAction3 = new StyledEditorKit.ItalicAction();
     typeAction3.actionPerformed(evt);
        }
        else if(!isBold&&!isItalic){
            Action typeAction3 = new StyledEditorKit.ItalicAction();
     typeAction3.actionPerformed(evt);
        }
    }
    else if(c.getSelectedItem()=="Regular"){
        if(isBold){
            Action typeAction2 = new StyledEditorKit.BoldAction();
     typeAction2.actionPerformed(evt);
        }
        else if(isItalic){
            Action typeAction3 = new StyledEditorKit.ItalicAction();
     typeAction3.actionPerformed(evt);
        }
    }
}
else if(evt.getSource()==bb2)
{
    f2.setVisible(false); //to hide the JFrame
}
else if(evt.getSource()==bb3)
{
    //to preview font by changing sample text font
    String fontN = (String)chooseFont.getSelectedItem();
    int fontS = Integer.parseInt((String)size1.getSelectedItem());
    String fontSt = (String)c.getSelectedItem(); //getting selected item from list
    int fontSs=0;
    if(fontSt.equals("Regular"))
        fontSs=Font.PLAIN;
    else if(fontSt.equals("Italic"))
        fontSs=Font.ITALIC;
    else if(fontSt.equals("Bold"))
        fontSs=Font.BOLD;
    Font ff=new Font(fontN,fontSs,fontS);
     l5.setFont(ff); //setting font of the label
}
else if(evt.getSource()==sh1)
{        
           i = 1;
           x1=200; x2=400; y1=200;y2=400; //setting initial coordinates
           pb.repaint();
            
}
else if(evt.getSource()==sh2)
{           
           i = 2;
           x1=200; x2=400; y1=200;y2=400;
           pb.repaint();
            
}
else if(evt.getSource()==sh3)
{          
           i = 3;  
           x1=200; x2=400; y1=200;y2=400;
           pb.repaint();
             
}
else if(evt.getSource()==sh4)
{ 
           i = 4;
           x1=200; x2=400; y1=200;y2=400;
           pb.repaint();
            
}
else if(evt.getSource()==sh5)
{           i = 5; 
           x1=200; x2=400; y1=200;y2=400;
           pb.repaint();
               
}
else if(evt.getSource()==sh6)
{
           x1=200; x2=400; y1=200;y2=400;
            i = 6;
           pb.repaint();
}
    try
      {
	if(evt.getSource()==i3)
	{
 	  if(getTitle().equals("Untitled-Text Editor"))
	  {
	     FileDialog fd=new FileDialog(this); //creating fileDialog
	     fd.setMode(1);
	     fd.setVisible(true);
	     file=fd.getFile(); 
	     path=fd.getDirectory()+file; //to get current directory
	     if(file!=null)
	     {
	      		DefaultStyledDocument doc = (DefaultStyledDocument)ta.getDocument();
			
			try (OutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				
				oos.writeObject(doc);
			}
                        //catching exception
			catch (IOException ex) { 

				throw new RuntimeException(ex);
			}
			
			setTitle(path+"-Text Editor"); //setting title
	     }
	  }
	  else
	  {
	       	      		DefaultStyledDocument doc = (DefaultStyledDocument)ta.getDocument();
			
			try (OutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				
				oos.writeObject(doc);
			}
			catch (IOException ex) {

				throw new RuntimeException(ex);
			}
	  }
	} 
	else if(evt.getSource()==i2)
	{
	  
	  FileDialog fd=new FileDialog(this);
	  fd.setVisible(true);
	  file=fd.getFile();
	  path=fd.getDirectory()+file;
	  RandomAccessFile ras=new RandomAccessFile(path,"rw");
	  if(file!=null)
	  {

              		StyledDocument doc = null;
	
			try (InputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis)) {
			
				doc = (DefaultStyledDocument)ois.readObject();
			}
			catch (FileNotFoundException ex) {

				JOptionPane.showMessageDialog(null, "Input file was not found!");
				return;
			}
			catch (ClassNotFoundException | IOException ex) {

				throw new RuntimeException(ex);
			}
			
			ta.setDocument(doc);
                        setTitle(path+" - Text Editor");
	   }
	} 
        else if(evt.getSource()==i1)
        {
            ta.setText(""); //removing the current text
            this.setTitle("Untitled-Text Editor");
            file=null;
            path="";
        }
      }
      catch(Exception ex)
      {
	System.out.println(ex);
      }
 
}
class MouseMagic extends MouseAdapter
{
            public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY(); //getting coordinates
            pb.repaint();
            
            
}
}
 class shapes extends JPanel
{
    int x1,y1,x2,y2,xm,ym;
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
 //to create shapes
        if(i == 1)
        {
             x1=Notepad.x1;
             x2=Notepad.x2;
             y1=Notepad.y1;
             y2=Notepad.y2;
            g.setColor(Color.red);
            xm=Math.abs(x2-x1);
            ym=Math.abs(y2-y1);
            if((x2-x1)>=0 &&(y2-y1)>=0)
            g.fillRect(x1,y1,xm,ym);
            else if((x2-x1)<0 &&(y2-y1)>0)
            	g.fillRect(x1-xm,y1,xm,ym); //creating rectangle
            else if((x2-x1)<0 &&(y2-y1)<0)
            	g.fillRect(x1-xm,y1-ym,xm,ym);
            else 
            	g.fillRect(x1,y1-ym,xm,ym);
        }
        else if (Notepad.i == 2)
        {
             x1=Notepad.x1;
             x2=Notepad.x2;
             y1=Notepad.y1;
             y2=Notepad.y2;
            g.setColor(Color.CYAN);
                        xm=Math.abs(x2-x1);
            ym=Math.abs(y2-y1);
            if((x2-x1)>=0 &&(y2-y1)>=0)
            g.fillOval(x1,y1,xm,ym);
            else if((x2-x1)<0 &&(y2-y1)>0)
            	g.fillOval(x1-xm,y1,xm,ym);
            else if((x2-x1)<0 &&(y2-y1)<0)
            	g.fillOval(x1-xm,y1-ym,xm,ym);
            else 
            	g.fillOval(x1,y1-ym,xm,ym);
            
        }
        else if (i ==3)
        {
             x1=Notepad.x1;
             x2=Notepad.x2;
             y1=Notepad.y1;
             y2=Notepad.y2;
            g.setColor(Color.CYAN);
                        xm=Math.abs(x2-x1);
            ym=Math.abs(y2-y1);
            if((x2-x1)>=0 &&(y2-y1)>=0)
            g.fillArc(x1,y1,xm,ym,75,30);
            else if((x2-x1)<0 &&(y2-y1)>0)
            	g.fillArc(x1-xm,y1,xm,ym,75,30);
            else if((x2-x1)<0 &&(y2-y1)<0)
            	g.fillArc(x1-xm,y1-ym,xm,ym,75,30);
            else 
            	g.fillArc(x1,y1-ym,xm,ym,75,30);
        }
        else if (i ==4)
        {
             x1=Notepad.x1;
             x2=Notepad.x2;
             y1=Notepad.y1;
             y2=Notepad.y2;
            g.setColor(Color.CYAN);
                        xm=Math.abs(x2-x1);
            ym=Math.abs(y2-y1);
            if((x2-x1)>=0 &&(y2-y1)>=0)
            g.fillArc(x1,y1,xm,ym,30,120);
            else if((x2-x1)<0 &&(y2-y1)>0)
            	g.fillArc(x1-xm,y1,xm,ym,30,120);
            else if((x2-x1)<0 &&(y2-y1)<0)
            	g.fillArc(x1-xm,y1-ym,xm,ym,30,120);
            else 
            	g.fillArc(x1,y1-ym,xm,ym,30,120);
        }
        else if(i==5)
        {
             x1=Notepad.x1;
             x2=Notepad.x2;
             y1=Notepad.y1;
             y2=Notepad.y2;
            g.setColor(Color.red);
                        xm=Math.abs(x2-x1);
            ym=Math.abs(y2-y1);
            if((x2-x1)>=0 &&(y2-y1)>=0)
            g.fillRoundRect(x1,y1,xm,ym,xm/5,ym/5);
            else if((x2-x1)<0 &&(y2-y1)>0)
            	g.fillRoundRect(x1-xm,y1,xm,ym,xm/5,ym/5);
            else if((x2-x1)<0 &&(y2-y1)<0)
            	g.fillRoundRect(x1-xm,y1-ym,xm,ym,xm/5,ym/5);
            else 
            	g.fillRoundRect(x1,y1-ym,xm,ym,xm/5,ym/5);            
        }
        else if(i==6)
        {
            repaint();
        }
    }
}
  public static void main(String []s) //main method
  {
	new Notepad(); //creating object of class
  }
}
class CloseWindow extends WindowAdapter
{
    public void windowClosing(WindowEvent we)
    {
	System.exit(0);
    }
}
