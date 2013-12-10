/*  Author: Jared Baribeau
 *  Date:   July 3, 2012
 *  Description:    
 *      The purpose of this class is to allow the resuse of the code for the 
 *      scout controls for each team on the scout page. These are split into
 *      modules. 
 */

package ReboundScout;

//Importing packages
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScoutModule extends JPanel implements ActionListener
{        
    //Create JFrame
    JFrame frame = new JFrame();
    
    //Creating a font object
    Font big = new Font("Comic Sans MS", Font.BOLD, 20);	//A font designed to give emphasis to the team number
    
    //Create instances of the GUI component.
    private JButton cmdSubmit = new JButton();
    private JLabel lblMissed = new JLabel("0");         //Holds the value of missed shots
    private JLabel lblTop = new JLabel("0");		//Holds the value of top shots
    private JLabel lblMid = new JLabel("0");		//Holds the value of mid shots
    private JLabel lblLow = new JLabel("0");		//Holds the value of low 
    private JLabel lblAutonMissed = new JLabel("0");    //Holds the value of missed shots
    private JLabel lblAutonTop = new JLabel("0");	//Holds the value of top shots
    private JLabel lblAutonMid = new JLabel("0");	//Holds the value of mid shots
    private JLabel lblAutonLow = new JLabel("0");	//Holds the value of low shots
    private JLabel lblDef = new JLabel("0");		//Holds the value of the number of defensive moves
    private JLabel lblPen = new JLabel("0");		//Holds the number of penalties
    private JLabel lblCross = new JLabel("0");		//Holds the number of times the robot crossed the centre bump

    private JButton cmdUp1 = new JButton ();
    private JButton cmdDown1 = new JButton();
    private JButton cmdUp2 = new JButton();
    private JButton cmdDown2 = new JButton();
    private JButton cmdUp3 = new JButton();
    private JButton cmdDown3 = new JButton();
    private JButton cmdUp4 = new JButton();
    private JButton cmdDown4 = new JButton();
    private JButton cmdDefUp = new JButton();
    private JButton cmdPenUp = new JButton();
    private JButton cmdCrossUp = new JButton();
    private JButton cmdDefDown = new JButton();
    private JButton cmdPenDown = new JButton();
    private JButton cmdCrossDown = new JButton();
    private JTextField txtTeamNum = new JTextField(4);      //Contains the team number entered by the user
    private JTextField txtComments = new JTextField();      //Contains the comments entered by the user
    private JCheckBox chkBroke = new JCheckBox();           //whether or not the robot became disabled during match play

    //Creating radio buttons for balance stats
    private ButtonGroup balance = new ButtonGroup();		//Groups all like option buttons together
    private JRadioButton single = new JRadioButton();           //Whether or not a single balance was achieved
    private JRadioButton dub = new JRadioButton();		//Whether or not a double balance was achieved
    private JRadioButton coop = new JRadioButton();		//Whether ot not a Co-op balance was achieved
    private JRadioButton na = new JRadioButton();		//Whether or not no balance was achieved

    //Creating radioButtons for win/loss stats
    private ButtonGroup wl = new ButtonGroup();			//Groups all like option buttons together
    private JRadioButton win = new JRadioButton();		//Whether or not the team won
    private JRadioButton loss = new JRadioButton();		//Whether or not the team lost
    
    //Creating radioButtons for auton/teleop toggle
    private ButtonGroup modeToggle = new ButtonGroup();		//Groups all like option buttons together
    private JRadioButton teleop = new JRadioButton();		//Whether or not the team won
    private JRadioButton auton = new JRadioButton();		//Whether or not the team lost
    private JLabel lblauton = new JLabel ((new ImageIcon("src/Images/ScoutAutonModule.jpg")));


    /******************ScouterScreen Constructor*****************/
    public ScoutModule()
    {
        //Create an instance of the layout manager
        SpringLayout layout = new SpringLayout();
        
        //Set pane preferences
        this.setSize(new Dimension(860,300));
        this.setPreferredSize(new Dimension(860,300));
        this.setMaximumSize(new Dimension(860,300));
        this.setVisible(true);
        this.setOpaque(false);
        
        //Adding components to the frame
        this.add(cmdSubmit);

        //General Components
        this.add(txtTeamNum);
        this.add(txtComments);
        this.add(chkBroke);

        //Shooting stat labels
        this.add(lblMissed);
        this.add(lblTop);
        this.add(lblMid);
        this.add(lblLow);
        this.add(lblAutonMissed);
        this.add(lblAutonTop);
        this.add(lblAutonMid);
        this.add(lblAutonLow);

        //Other stat labels
        this.add(lblDef);
        this.add(lblPen);
        this.add(lblCross);

        //Radio buttons
        //For balances
        this.add(single);
        this.add(dub);
        this.add(coop);
        this.add(na);
        this.add(win);
        this.add(loss);
        //For auton/teleop
        this.add(auton);
        this.add(teleop);
        
        //Grop radio buttons
        //Balance Group
        balance.add(single);
        balance.add(dub);
        balance.add(coop);
        balance.add(na);
        balance.add(win);
        //Teleop Toggle Group
        modeToggle.add(auton);
        modeToggle.add(teleop);
        //Win/Loss
        wl.add(win);
        wl.add(loss);
        
        //Control buttons
        this.add(cmdSubmit);
        this.add(cmdUp1);
        this.add(cmdDown1);
        this.add(cmdUp2);
        this.add(cmdDown2);
        this.add(cmdUp3);
        this.add(cmdDown3);
        this.add(cmdUp4);
        this.add(cmdDown4);
        this.add(cmdDefUp);
        this.add(cmdPenUp);
        this.add(cmdCrossUp);
        this.add(cmdDefDown);
        this.add(cmdPenDown);
        this.add(cmdCrossDown);
        
        this.add(lblauton);
                
        //Add action listener
        cmdSubmit.addActionListener(this);
        cmdUp1.addActionListener(this);
        cmdDown1.addActionListener(this);
        cmdUp2.addActionListener(this);
        cmdDown2.addActionListener(this);
        cmdUp3.addActionListener(this);
        cmdDown3.addActionListener(this);
        cmdUp4.addActionListener(this);
        cmdDown4.addActionListener(this);
        cmdDefUp.addActionListener(this);
        cmdDefDown.addActionListener(this);
        cmdPenUp.addActionListener(this);
        cmdPenDown.addActionListener(this);
        cmdCrossUp.addActionListener(this);
        cmdCrossDown.addActionListener(this);
        
        //Create radio button action listener
        ActionListener sliceActionListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton radioAction1 = (AbstractButton) actionEvent.getSource();
            if(radioAction1.equals(auton))
            {
                //Make auton only components visible
                lblAutonTop.setVisible(true);
                lblAutonMid.setVisible(true);
                lblAutonLow.setVisible(true);
                lblAutonMissed.setVisible(true);
                lblTop.setVisible(false);
                lblMid.setVisible(false);
                lblLow.setVisible(false);
                lblMissed.setVisible(false);
                lblauton.setVisible(true);
            }
            else                
            {
                //Make teleop only components visible
                lblAutonTop.setVisible(false);
                lblAutonMid.setVisible(false);
                lblAutonLow.setVisible(false);
                lblAutonMissed.setVisible(false);
                lblTop.setVisible(true);
                lblMid.setVisible(true);
                lblLow.setVisible(true);
                lblMissed.setVisible(true);
                lblauton.setVisible(false);
            }
        }
        };
        auton.addActionListener(sliceActionListener1);
        teleop.addActionListener(sliceActionListener1);
        
        //Set the action listener
        cmdSubmit.setActionCommand("Submit");
        cmdUp1.setActionCommand("Up1");
        cmdDown1.setActionCommand("Down1");
        cmdUp2.setActionCommand("Up2");
        cmdDown2.setActionCommand("Down2");
        cmdUp3.setActionCommand("Up3");
        cmdDown3.setActionCommand("Down3");
        cmdUp4.setActionCommand("Up4");
        cmdDown4.setActionCommand("Down4");
        cmdDefUp.setActionCommand("DefUp");
        cmdDefDown.setActionCommand("DefDown");
        cmdPenUp.setActionCommand("PenUp");
        cmdPenDown.setActionCommand("PenDown");
        cmdCrossUp.setActionCommand("CrossUp");
        cmdCrossDown.setActionCommand("CrossDown");
        
        //Setting the layout for the frame
        this.setLayout(layout);
        
        //Setup team text fields
        txtTeamNum.setPreferredSize(new Dimension(75, 26));
        txtComments.setPreferredSize(new Dimension(540, 18));        
        
        //Change team number font
        txtTeamNum.setFont(big);
        
        //Eliminating borders and panes around command buttons
        GUIHelper.setupButton(cmdSubmit, 126, 45, false, false);
        
        GUIHelper.setupButton(cmdUp1, 39, 22, false, false);
        GUIHelper.setupButton(cmdDown1, 39, 22, false, false);        
        GUIHelper.setupButton(cmdUp2, 39, 22, false, false);
        GUIHelper.setupButton(cmdDown2, 39, 22, false, false);
        GUIHelper.setupButton(cmdUp3, 39, 22, false, false);
        GUIHelper.setupButton(cmdDown3, 39, 22, false, false);
        GUIHelper.setupButton(cmdUp4, 39, 22, false, false);
        GUIHelper.setupButton(cmdDown4, 39, 22, false, false);
        GUIHelper.setupButton(cmdDefUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdDefDown, 39, 22, false, false);
        GUIHelper.setupButton(cmdPenUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdPenDown, 39, 22, false, false);
        GUIHelper.setupButton(cmdCrossUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdCrossDown, 39, 22, false, false);
        
        //Setup check boxes and radio buttons
        GUIHelper.setupButton(chkBroke, -1, -1, false, false);
        GUIHelper.setupButton(single, -1, -1, false, false);
        GUIHelper.setupButton(dub, -1, -1, false, false);
        GUIHelper.setupButton(coop, -1, -1, false, false);
        GUIHelper.setupButton(na, -1, -1, false, false);
        GUIHelper.setupButton(win, -1, -1, false, false);
        GUIHelper.setupButton(loss, -1, -1, false, false);
        GUIHelper.setupButton(teleop, -1, -1, false, false);
        GUIHelper.setupButton(auton, -1, -1, false, false);
        
        //Set the components position
        GUIHelper.setLocation(cmdSubmit, layout, this, 682, 113);        
        GUIHelper.setLocation(cmdUp1, layout, this, 32, 81);
        GUIHelper.setLocation(cmdDown1, layout, this, 32, 131);
        GUIHelper.setLocation(cmdUp2, layout, this, 103, 81);
        GUIHelper.setLocation(cmdDown2, layout, this, 103, 131);
        GUIHelper.setLocation(cmdUp3, layout, this, 170, 81);
        GUIHelper.setLocation(cmdDown3, layout, this, 170, 131);
        GUIHelper.setLocation(cmdUp4, layout, this, 240, 81);
        GUIHelper.setLocation(cmdDown4, layout, this, 240, 131);            
        GUIHelper.setLocation(cmdDefUp, layout, this, 311, 81);
        GUIHelper.setLocation(cmdDefDown, layout, this, 311, 131);        
        GUIHelper.setLocation(cmdPenUp, layout, this, 382, 81);
        GUIHelper.setLocation(cmdPenDown, layout, this, 382, 131);        
        GUIHelper.setLocation(cmdCrossUp, layout, this, 452, 81);
        GUIHelper.setLocation(cmdCrossDown, layout, this, 452, 131);
        
        GUIHelper.setLocation(lblMissed, layout, this, 48, 110);
        GUIHelper.setLocation(lblTop, layout, this, 120, 110);
        GUIHelper.setLocation(lblMid, layout, this, 188, 110);            
        GUIHelper.setLocation(lblLow, layout, this, 260, 110);
        GUIHelper.setLocation(lblAutonMissed, layout, this, 48, 110);        
        GUIHelper.setLocation(lblAutonTop, layout, this, 120, 110);
        GUIHelper.setLocation(lblAutonMid, layout, this, 188, 110);        
        GUIHelper.setLocation(lblAutonLow, layout, this, 260, 110);
        GUIHelper.setLocation(lblDef, layout, this, 330, 110);
        GUIHelper.setLocation(lblPen, layout, this, 402, 110);
        GUIHelper.setLocation(lblCross, layout, this, 474, 110);        
        GUIHelper.setLocation(lblauton, layout, this, 21, 35);
        
        GUIHelper.setLocation(txtTeamNum, layout, this, 86, 7);
        GUIHelper.setLocation(txtComments, layout, this, 104, 164);
        GUIHelper.setLocation(chkBroke, layout, this, 609, 35);
        
        GUIHelper.setLocation(single, layout, this, 596, 86);
        GUIHelper.setLocation(dub, layout, this, 596, 103);
        GUIHelper.setLocation(coop, layout, this, 596, 121);
        GUIHelper.setLocation(na, layout, this, 596, 137);
        GUIHelper.setLocation(win, layout, this, 723, 90);
        GUIHelper.setLocation(loss, layout, this, 780, 90);
        GUIHelper.setLocation(auton, layout, this, 195, 40);
        GUIHelper.setLocation(teleop, layout, this, 270, 40);
                       
        //Set defualt to auton mode
        auton.setSelected(true);
        lblTop.setVisible(false);
        lblMid.setVisible(false);
        lblLow.setVisible(false);
        lblMissed.setVisible(false);        

    }
    
    /******************Method to increment labels*****************/
    private void up(String label)
    {
        //Create instance variables
        int num;
        
        //Increments the count on the appropriate label
        if(label.equals("lblMissed"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonMissed.getText());
                num++;
                lblAutonMissed.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblMissed.getText());
                num++;
                lblMissed.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblTop"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonTop.getText());
                num++;
                lblAutonTop.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblTop.getText());
                num++;
                lblTop.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblMid"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonMid.getText());
                num++;
                lblAutonMid.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblMid.getText());
                num++;
                lblMid.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblLow"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonLow.getText());
                num++;
                lblAutonLow.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblLow.getText());
                num++;
                lblLow.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblDef"))
        {
                num = Integer.parseInt(lblDef.getText());
                num++;
                lblDef.setText(Integer.toString(num));            
        }
        else if(label.equals("lblPen"))
        {
                num = Integer.parseInt(lblPen.getText());
                num++;
                lblPen.setText(Integer.toString(num));            
        }
        else if(label.equals("lblCross"))
        {
                num = Integer.parseInt(lblCross.getText());
                num++;
                lblCross.setText(Integer.toString(num));            
        }
    }//End of up()
    
    /******************Method to decrement labels*****************/
    private void down(String label)
    {
        //Create instance variables
        int num;
        
        //Decrements the count on the appropriate label
        if(label.equals("lblMissed"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonMissed.getText());
                if(num > 0)
                    num--;
                lblAutonMissed.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblMissed.getText());
                if(num > 0)
                    num--;
                lblMissed.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblTop"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonTop.getText());
                if(num > 0)
                    num--;
                lblAutonTop.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblTop.getText());
                if(num > 0)
                    num--;
                lblTop.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblMid"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonMid.getText());
                if(num > 0)
                    num--;
                lblAutonMid.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblMid.getText());
                if(num > 0)
                    num--;
                lblMid.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblLow"))
        {
            if(auton.isSelected() == true)
            {
                num = Integer.parseInt(lblAutonLow.getText());
                if(num > 0)
                    num--;
                lblAutonLow.setText(Integer.toString(num)); 
            }
            else
            {
                num = Integer.parseInt(lblLow.getText());
                if(num > 0)
                    num--;
                lblLow.setText(Integer.toString(num)); 
            }
        }
        else if(label.equals("lblDef"))
        {
                num = Integer.parseInt(lblDef.getText());
                if(num > 0)
                    num--;
                lblDef.setText(Integer.toString(num));            
        }
        else if(label.equals("lblPen"))
        {
                num = Integer.parseInt(lblPen.getText());
                if(num > 0)
                    num--;
                lblPen.setText(Integer.toString(num));            
        }
        else if(label.equals("lblCross"))
        {
                num = Integer.parseInt(lblCross.getText());
                if(num > 0)
                    num--;
                lblCross.setText(Integer.toString(num));            
        }
    }//End of down()
    
    /***************Method to submit the stats to the database**************/
    public void submit()
    {
        
    }//End of submit()
    
    public static void main (String [] args)
    {
        ScoutModule module = new ScoutModule();        
    }//End of main

    /*******************ActionPerformed Method****************/
    public void actionPerformed(ActionEvent e) 
    {
        //Check if button has been selected
        if(e.getActionCommand().equals("Submit"))
        {
            //Insert submit code here
            
        }
        else if(e.getActionCommand().equals("Up1"))
            up("lblMissed");	//Increments missed shots
        else if(e.getActionCommand().equals("Down1"))
            down("lblMissed");	//Decrements missed shots
        else if(e.getActionCommand().equals("Up2"))
            up("lblTop");
        else if(e.getActionCommand().equals("Down2"))
            down("lblTop");
        else if(e.getActionCommand().equals("Up3"))
            up("lblMid");
        else if(e.getActionCommand().equals("Down3"))
            down("lblMid");
        else if(e.getActionCommand().equals("Up4"))
            up("lblLow");
        else if(e.getActionCommand().equals("Down4"))
            down("lblLow");
        else if(e.getActionCommand().equals("DefUp"))
            up("lblDef");
        else if(e.getActionCommand().equals("DefDown"))
            down("lblDef");
        else if(e.getActionCommand().equals("PenUp"))
            up("lblPen");
        else if(e.getActionCommand().equals("PenDown"))
            down("lblPen");
        else if(e.getActionCommand().equals("CrossUp"))
            up("lblCross");
        else if(e.getActionCommand().equals("CrossDown"))
            down("lblCross");
    }
}//End of class
