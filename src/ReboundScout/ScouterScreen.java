/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    ScouterScreen
 */

/* The purpose of this class is to allow the user to enter the number of a team, then increment and decrement stats as necessary.
 * The user will also be able to enter comments, and specify what type of balance occured if applicable, as well as # of defensive moves, penalties, and crosses.
 * The class interacts with Team and Stats objects. */

package ReboundScout;

//Importing packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class ScouterScreen extends JFrame implements ActionListener
{
    //Creating a font object
    Font big = new Font("Comic Sans MS", Font.BOLD, 20);	//A font designed to give emphasis to the team number

    //Create instances of the GUI component.
    //1st Team components
    private JLabel lblMissed1 = new JLabel("0");	//Holds the value of missed shots
    private JLabel lblTop1 = new JLabel("0");		//Holds the value of top shots
    private JLabel lblMid1 = new JLabel("0");		//Holds the value of mid shots
    private JLabel lblLow1 = new JLabel("0");		//Holds the value of low shots
    private JLabel lblAutonMissed1 = new JLabel("0");	//Holds the value of missed shots
    private JLabel lblAutonTop1 = new JLabel("0");		//Holds the value of top shots
    private JLabel lblAutonMid1 = new JLabel("0");		//Holds the value of mid shots
    private JLabel lblAutonLow1 = new JLabel("0");		//Holds the value of low shots
    

    private JLabel lblDef = new JLabel("0");		//Holds the value of the number of defensive moves
    private JLabel lblPen = new JLabel("0");		//Holds the number of penalties
    private JLabel lblCross = new JLabel("0");		//Holds the number of times the robot crossed the centre bump

    private JButton cmdTeam1Up1 = new JButton ();	//Increments stat
    private JButton cmdTeam1Up2 = new JButton ();	//Increments stat
    private JButton cmdTeam1Up3 = new JButton ();	//Increments stat
    private JButton cmdTeam1Up4 = new JButton ();	//Increments stat

    private JButton cmdTeam1Down1 = new JButton();	//Decrements stat
    private JButton cmdTeam1Down2 = new JButton();	//Decrements stat
    private JButton cmdTeam1Down3 = new JButton();	//Decrements stat
    private JButton cmdTeam1Down4 = new JButton();	//Decrements stat

    private JButton cmdTeam1DefUp = new JButton();	//Increments stat
    private JButton cmdTeam1PenUp = new JButton();	//Increments stat
    private JButton cmdTeam1CrossUp = new JButton();//Increments stat

    private JButton cmdTeam1DefDown = new JButton();	//Decrements stat
    private JButton cmdTeam1PenDown = new JButton();	//Decrements stat
    private JButton cmdTeam1CrossDown = new JButton();	//Decrements stat

    private JTextField team1Num = new JTextField(4);		//Contains the team number entered by the user
    private JTextField txtTeam1Comments = new JTextField();	//Contains the comments entered by the user
    private JCheckBox chkBroke = new JCheckBox();			//whether or not the robot became disabled during match play

    //Creating radio buttons for balance stats
    private ButtonGroup bg = new ButtonGroup();			//Groups all like option buttons together
    private JRadioButton single = new JRadioButton();	//Whether or not a single balance was achieved
    private JRadioButton dub = new JRadioButton();		//Whether or not a double balance was achieved
    private JRadioButton coop = new JRadioButton();		//Whether ot not a Co-op balance was achieved
    private JRadioButton na = new JRadioButton();		//Whether or not no balance was achieved

    //Creating radioButtons for win/loss stats
    private ButtonGroup wl = new ButtonGroup();			//Groups all like option buttons together
    private JRadioButton win = new JRadioButton();		//Whether or not the team won
    private JRadioButton loss = new JRadioButton();		//Whether or not the team lost
    
    //Create radio buttons and image for auton/teleop toggle
    private ButtonGroup modeToggle = new ButtonGroup();         //Groups toggles for auton mode 
    private JRadioButton teleop1 = new JRadioButton();		//Teleop mode
    private JRadioButton auton1 = new JRadioButton();		//Autonamous mode
    private JLabel lblauton1 = new JLabel ((new ImageIcon("src/Images/ScoutAutonModule.jpg")));
    

    //Team 2 components
    private JLabel lblMissed2 = new JLabel("0");
    private JLabel lblTop2 = new JLabel("0");
    private JLabel lblMid2 = new JLabel("0");
    private JLabel lblLow2 = new JLabel("0");

    private JLabel lblDef2 = new JLabel("0");
    private JLabel lblPen2 = new JLabel("0");
    private JLabel lblCross2 = new JLabel("0");

    private JButton cmdTeam2Up1 = new JButton ();
    private JButton cmdTeam2Up2 = new JButton ();
    private JButton cmdTeam2Up3 = new JButton ();
    private JButton cmdTeam2Up4 = new JButton ();

    private JButton cmdTeam2Down1 = new JButton();
    private JButton cmdTeam2Down2 = new JButton();
    private JButton cmdTeam2Down3 = new JButton();
    private JButton cmdTeam2Down4 = new JButton();

    private JButton cmdTeam2DefUp = new JButton();
    private JButton cmdTeam2PenUp = new JButton();
    private JButton cmdTeam2CrossUp = new JButton();

    private JButton cmdTeam2DefDown = new JButton();
    private JButton cmdTeam2PenDown = new JButton();
    private JButton cmdTeam2CrossDown = new JButton();

    private JTextField team2Num = new JTextField(4);
    private JTextField txtTeam2Comments = new JTextField();
    private JCheckBox chkBroke2 = new JCheckBox();

    //Creating radio buttons for balance stats
    private ButtonGroup bg2 = new ButtonGroup();
    private JRadioButton single2 = new JRadioButton();
    private JRadioButton dub2 = new JRadioButton();
    private JRadioButton coop2 = new JRadioButton();
    private JRadioButton na2 = new JRadioButton();

    //Creating radioButtons for win/loss stats
    private ButtonGroup wl2 = new ButtonGroup();
    private JRadioButton win2 = new JRadioButton();
    private JRadioButton loss2 = new JRadioButton();

    //Team 3 components
    private JLabel lblMissed3 = new JLabel("0");
    private JLabel lblTop3 = new JLabel("0");
    private JLabel lblMid3 = new JLabel("0");
    private JLabel lblLow3 = new JLabel("0");

    private JLabel lblDef3 = new JLabel("0");
    private JLabel lblPen3 = new JLabel("0");
    private JLabel lblCross3 = new JLabel("0");

    private JButton cmdTeam3Up1 = new JButton ();
    private JButton cmdTeam3Up2 = new JButton ();
    private JButton cmdTeam3Up3 = new JButton ();
    private JButton cmdTeam3Up4 = new JButton ();

    private JButton cmdTeam3Down1 = new JButton();
    private JButton cmdTeam3Down2 = new JButton();
    private JButton cmdTeam3Down3 = new JButton();
    private JButton cmdTeam3Down4 = new JButton();

    private JButton cmdTeam3DefUp = new JButton();
    private JButton cmdTeam3PenUp = new JButton();
    private JButton cmdTeam3CrossUp = new JButton();

    private JButton cmdTeam3DefDown = new JButton();
    private JButton cmdTeam3PenDown = new JButton();
    private JButton cmdTeam3CrossDown = new JButton();

    private JTextField team3Num = new JTextField(4);
    private JTextField txtTeam3Comments = new JTextField();
    private JCheckBox chkBroke3 = new JCheckBox();

    //Creating radio buttons for balance stats
    private ButtonGroup bg3 = new ButtonGroup();
    private JRadioButton single3 = new JRadioButton();
    private JRadioButton dub3 = new JRadioButton();
    private JRadioButton coop3 = new JRadioButton();
    private JRadioButton na3 = new JRadioButton();

    //Creating radioButtons for win/loss stats
    private ButtonGroup wl3 = new ButtonGroup();
    private JRadioButton win3 = new JRadioButton();
    private JRadioButton loss3 = new JRadioButton();

    //Buttons to submit stats to file
    private JButton cmdSubmit1 = new JButton();
    private JButton cmdSubmit2 = new JButton();
    private JButton cmdSubmit3 = new JButton();
    private JButton cmdHelp = new JButton();
    private JButton cmdCancel = new JButton();

    //The background image
    private JLabel lblBackground = new JLabel ((new ImageIcon("src/Images/ScoutScreen.jpg")));

    //Create an instance of the layout manager
    SpringLayout layout = new SpringLayout();

    //Contructs ScouterScreen
    public ScouterScreen()
    {
        //Adding components to the frame
        this.add(cmdSubmit1);
        this.add(cmdSubmit2);
        this.add(cmdSubmit3);

        //General Components
        this.add(cmdCancel);
        this.add(cmdHelp);
        this.add(chkBroke);
        this.add(chkBroke2);
        this.add(chkBroke3);

        //Shooting stat labels
        this.add(lblMissed1);
        this.add(lblTop1);
        this.add(lblMid1);
        this.add(lblLow1);
        this.add(lblAutonMissed1);
        this.add(lblAutonTop1);
        this.add(lblAutonMid1);
        this.add(lblAutonLow1);
        
        //Defualt to hidden teleop labels
        lblMissed1.setVisible(false);
        lblTop1.setVisible(false);
        lblMid1.setVisible(false);
        lblLow1.setVisible(false);

        //Other stat labels
        this.add(lblDef);
        this.add(lblPen);
        this.add(lblCross);

        //Radio buttons
        this.add(single);
        this.add(dub);
        this.add(coop);
        this.add(na);
        this.add(win);
        this.add(loss);
        this.add(teleop1);
        this.add(auton1);

        //Shooting stat labels
        this.add(lblMissed2);
        this.add(lblTop2);
        this.add(lblMid2);
        this.add(lblLow2);

        //Other stat labels
        this.add(lblDef2);
        this.add(lblPen2);
        this.add(lblCross2);

        //Radio Buttons
        this.add(single2);
        this.add(dub2);
        this.add(coop2);
        this.add(na2);
        this.add(win2);
        this.add(loss2);

        //Shooting stat labels
        this.add(lblMissed3);
        this.add(lblTop3);
        this.add(lblMid3);
        this.add(lblLow3);

        //Other stat labels
        this.add(lblDef3);
        this.add(lblPen3);
        this.add(lblCross3);

        //Radio Buttons
        this.add(single3);
        this.add(dub3);
        this.add(coop3);
        this.add(na3);
        this.add(win3);
        this.add(loss3);

        //Sets up the three team's components
        setUpFirst();
        setUpSecond();
        setUpThird();

        //Add background (after scout components are set up for order)
        this.add(lblauton1);
        this.add(lblBackground);

        //Setting the frame colour
        getContentPane().setBackground(Color.blue);

        //Naming the buttons
        cmdSubmit1.setActionCommand("SUBMIT1");
        cmdSubmit2.setActionCommand("SUBMIT2");
        cmdSubmit3.setActionCommand("SUBMIT3");
        cmdCancel.setActionCommand("CANCEL");
        cmdHelp.setActionCommand("HELP");

        //Adds the action listener to the object
        cmdSubmit1.addActionListener(this);
        cmdSubmit2.addActionListener(this);
        cmdSubmit3.addActionListener(this);
        cmdCancel.addActionListener(this);
        cmdHelp.addActionListener(this);

        //Setting the layout for the frame
        this.getContentPane().setLayout(layout);

        //Set the components position
        GUIHelper.setLocation(lblBackground, layout, this.getContentPane(), 0, 0);
        GUIHelper.setLocation(cmdSubmit1, layout, this.getContentPane(), 682, 113);
        GUIHelper.setLocation(cmdSubmit2, layout, this.getContentPane(), 682, 310);
        GUIHelper.setLocation(cmdSubmit3, layout, this.getContentPane(), 682, 505);
        GUIHelper.setLocation(cmdCancel, layout, this.getContentPane(), 14, 598);
        GUIHelper.setLocation(cmdHelp, layout, this.getContentPane(), 734, 598);
        GUIHelper.setLocation(lblauton1, layout, this.getContentPane(), 21, 35);

        //Eliminating borders on command buttons
        GUIHelper.setupButton(cmdSubmit1, 126, 45, false, false);
        GUIHelper.setupButton(cmdSubmit2, 126, 45, false, false);
        GUIHelper.setupButton(cmdSubmit3, 126, 45, false, false);
        GUIHelper.setupButton(cmdCancel, 105, 35, false, false);
        GUIHelper.setupButton(cmdHelp, 105, 35, false, false);

        //Set up the frame
        this.setSize(860, 680);
        this.setUndecorated(false);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setTitle("ReboundScout | Scout Match");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//End of constructor method

    //Sets up the first team for scouting
    public void setUpFirst()
    {
        //Adding components to frame
        this.add(team1Num);
        this.add(txtTeam1Comments);

        this.add(cmdTeam1Up1);
        this.add(cmdTeam1Up2);
        this.add(cmdTeam1Up3);
        this.add(cmdTeam1Up4);

        this.add(cmdTeam1Down1);
        this.add(cmdTeam1Down2);
        this.add(cmdTeam1Down3);
        this.add(cmdTeam1Down4);

        this.add(cmdTeam1DefUp);
        this.add(cmdTeam1PenUp);
        this.add(cmdTeam1CrossUp);

        this.add(cmdTeam1DefDown);
        this.add(cmdTeam1PenDown);
        this.add(cmdTeam1CrossDown);

        //Grouping radio buttons together
        bg.add(single);
        bg.add(dub);
        bg.add(coop);
        bg.add(na);

        //Grouping win/loss buttons together
        wl.add(win);
        wl.add(loss);

        //Grouping teleop/auton buttons together
        modeToggle.add(auton1);
        modeToggle.add(teleop1);
        auton1.setSelected(true);

        //Add the action listener
        cmdTeam1Down1.addActionListener(this);
        cmdTeam1Up1.addActionListener(this);
        cmdTeam1Down2.addActionListener(this);
        cmdTeam1Up2.addActionListener(this);
        cmdTeam1Down3.addActionListener(this);
        cmdTeam1Up3.addActionListener(this);
        cmdTeam1Up4.addActionListener(this);
        cmdTeam1Down4.addActionListener(this);

        cmdTeam1DefUp.addActionListener(this);
        cmdTeam1PenUp.addActionListener(this);
        cmdTeam1CrossUp.addActionListener(this);

        cmdTeam1DefDown.addActionListener(this);
        cmdTeam1PenDown.addActionListener(this);
        cmdTeam1CrossDown.addActionListener(this);

        //Naming the buttons
        cmdTeam1Up1.setActionCommand("UP11");
        cmdTeam1Down1.setActionCommand("DOWN11");
        cmdTeam1Up2.setActionCommand("UP12");
        cmdTeam1Down2.setActionCommand("DOWN12");
        cmdTeam1Up3.setActionCommand("UP13");
        cmdTeam1Down3.setActionCommand("DOWN13");
        cmdTeam1Up4.setActionCommand("UP14");
        cmdTeam1Down4.setActionCommand("DOWN14");

        cmdTeam1DefUp.setActionCommand("UP Def");
        cmdTeam1PenUp.setActionCommand("UP Pen");
        cmdTeam1CrossUp.setActionCommand("UP Cross");

        cmdTeam1DefDown.setActionCommand("DOWN Def");
        cmdTeam1PenDown.setActionCommand("DOWN Pen");
        cmdTeam1CrossDown.setActionCommand("DOWN Cross");

        //Sets the location of the components
        GUIHelper.setLocation(cmdTeam1Up1, layout, this.getContentPane(), 32, 81);
        GUIHelper.setLocation(cmdTeam1Down1, layout, this.getContentPane(), 32, 131);
        GUIHelper.setLocation(cmdTeam1Up2, layout, this.getContentPane(), 103, 81);
        GUIHelper.setLocation(cmdTeam1Down2, layout, this.getContentPane(), 103, 131);
        GUIHelper.setLocation(cmdTeam1Up3, layout, this.getContentPane(), 170, 81);
        GUIHelper.setLocation(cmdTeam1Down3, layout, this.getContentPane(), 170, 131);
        GUIHelper.setLocation(cmdTeam1Up4, layout, this.getContentPane(), 240, 81);
        GUIHelper.setLocation(cmdTeam1Down4, layout, this.getContentPane(), 240, 131);
        GUIHelper.setLocation(cmdTeam1DefUp, layout, this.getContentPane(), 311, 81);
        GUIHelper.setLocation(cmdTeam1DefDown, layout, this.getContentPane(), 311, 131);
        GUIHelper.setLocation(cmdTeam1PenUp, layout, this.getContentPane(), 382, 81);
        GUIHelper.setLocation(cmdTeam1PenDown, layout, this.getContentPane(), 382, 131);
        GUIHelper.setLocation(cmdTeam1CrossUp, layout, this.getContentPane(), 452, 81);
        GUIHelper.setLocation(cmdTeam1CrossDown, layout, this.getContentPane(), 452, 131);

        GUIHelper.setLocation(lblMissed1, layout, this.getContentPane(), 48, 110);
        GUIHelper.setLocation(lblTop1, layout, this.getContentPane(), 120, 110);
        GUIHelper.setLocation(lblMid1, layout, this.getContentPane(), 188, 110);
        GUIHelper.setLocation(lblLow1, layout, this.getContentPane(), 260, 110);
        GUIHelper.setLocation(lblAutonMissed1, layout, this.getContentPane(), 48, 110);
        GUIHelper.setLocation(lblAutonTop1, layout, this.getContentPane(), 120, 110);
        GUIHelper.setLocation(lblAutonMid1, layout, this.getContentPane(), 188, 110);
        GUIHelper.setLocation(lblAutonLow1, layout, this.getContentPane(), 260, 110);
        GUIHelper.setLocation(lblDef, layout, this.getContentPane(), 330, 110);
        GUIHelper.setLocation(lblPen, layout, this.getContentPane(), 402, 110);
        GUIHelper.setLocation(lblCross, layout, this.getContentPane(), 474, 110);
        GUIHelper.setLocation(team1Num, layout, this.getContentPane(), 86, 7);
        GUIHelper.setLocation(txtTeam1Comments, layout, this.getContentPane(), 104, 164);
        GUIHelper.setLocation(chkBroke, layout, this.getContentPane(), 609, 35);
        GUIHelper.setLocation(single, layout, this.getContentPane(), 596, 86);
        GUIHelper.setLocation(dub, layout, this.getContentPane(), 596, 103);
        GUIHelper.setLocation(coop, layout, this.getContentPane(), 596, 121);
        GUIHelper.setLocation(na, layout, this.getContentPane(), 596, 137);
        GUIHelper.setLocation(win, layout, this.getContentPane(), 723, 90);
        GUIHelper.setLocation(loss, layout, this.getContentPane(), 780, 90);
        GUIHelper.setLocation(auton1, layout, this.getContentPane(), 195, 40);
        GUIHelper.setLocation(teleop1, layout, this.getContentPane(), 270, 40);

        //Changing font
        team1Num.setFont(big);

        //Eliminating borders and panes around command buttons
        GUIHelper.setupButton(cmdTeam1Up1, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1Down1, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam1Up2, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1Down2, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam1Up3, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1Down3, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam1Up4, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1Down4, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam1DefUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1DefDown, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam1PenUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1PenDown, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam1CrossUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam1CrossDown, 39, 22, false, false);

        //Setup check boxes and radio buttons
        GUIHelper.setupButton(chkBroke, -1, -1, false, false);
        GUIHelper.setupButton(single, -1, -1, false, false);
        GUIHelper.setupButton(dub, -1, -1, false, false);
        GUIHelper.setupButton(coop, -1, -1, false, false);
        GUIHelper.setupButton(na, -1, -1, false, false);
        GUIHelper.setupButton(win, -1, -1, false, false);
        GUIHelper.setupButton(loss, -1, -1, false, false);
        GUIHelper.setupButton(teleop1, -1, -1, false, false);
        GUIHelper.setupButton(auton1, -1, -1, false, false);

        //Setup team number field
        team1Num.setPreferredSize(new Dimension(75, 26));
        txtTeam1Comments.setPreferredSize(new Dimension(540, 18));
                 
        //Create radio button action listener
        ActionListener sliceActionListener1 = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            AbstractButton radioAction1 = (AbstractButton) actionEvent.getSource();
            if(radioAction1.equals(auton1))
            {
                //Make auton only components visible
                lblAutonTop1.setVisible(true);
                lblAutonMid1.setVisible(true);
                lblAutonLow1.setVisible(true);
                lblAutonMissed1.setVisible(true);
                lblTop1.setVisible(false);
                lblMid1.setVisible(false);
                lblLow1.setVisible(false);
                lblMissed1.setVisible(false);
                lblauton1.setVisible(true);
            }
            else                
            {
                //Make teleop only components visible
                lblAutonTop1.setVisible(false);
                lblAutonMid1.setVisible(false);
                lblAutonLow1.setVisible(false);
                lblAutonMissed1.setVisible(false);
                lblTop1.setVisible(true);
                lblMid1.setVisible(true);
                lblLow1.setVisible(true);
                lblMissed1.setVisible(true);
                lblauton1.setVisible(false);
            }
        }
        };
        auton1.addActionListener(sliceActionListener1);
        teleop1.addActionListener(sliceActionListener1);
    }//End of setUpFirst method

    //Sets up the second team for scouting
    public void setUpSecond()
    {
        //Adding components to frame
        this.add(team2Num);
        this.add(txtTeam2Comments);

        this.add(cmdTeam2Up1);
        this.add(cmdTeam2Up2);
        this.add(cmdTeam2Up3);
        this.add(cmdTeam2Up4);

        this.add(cmdTeam2Down1);
        this.add(cmdTeam2Down2);
        this.add(cmdTeam2Down3);
        this.add(cmdTeam2Down4);

        this.add(cmdTeam2DefUp);
        this.add(cmdTeam2PenUp);
        this.add(cmdTeam2CrossUp);

        this.add(cmdTeam2DefDown);
        this.add(cmdTeam2PenDown);
        this.add(cmdTeam2CrossDown);

        //Grouping radio buttons
        bg2.add(single2);
        bg2.add(dub2);
        bg2.add(coop2);
        bg2.add(na2);
        wl2.add(win2);
        wl2.add(loss2);

        //Add the action listener
        cmdTeam2Down1.addActionListener(this);
        cmdTeam2Up1.addActionListener(this);
        cmdTeam2Down2.addActionListener(this);
        cmdTeam2Up2.addActionListener(this);
        cmdTeam2Down3.addActionListener(this);
        cmdTeam2Up3.addActionListener(this);
        cmdTeam2Up4.addActionListener(this);
        cmdTeam2Down4.addActionListener(this);

        cmdTeam2DefUp.addActionListener(this);
        cmdTeam2PenUp.addActionListener(this);
        cmdTeam2CrossUp.addActionListener(this);

        cmdTeam2DefDown.addActionListener(this);
        cmdTeam2PenDown.addActionListener(this);
        cmdTeam2CrossDown.addActionListener(this);

        //Naming the buttons
        cmdTeam2Up1.setActionCommand("UP21");
        cmdTeam2Down1.setActionCommand("DOWN21");
        cmdTeam2Up2.setActionCommand("UP22");
        cmdTeam2Down2.setActionCommand("DOWN22");
        cmdTeam2Up3.setActionCommand("UP23");
        cmdTeam2Down3.setActionCommand("DOWN23");
        cmdTeam2Up4.setActionCommand("UP24");
        cmdTeam2Down4.setActionCommand("DOWN24");

        cmdTeam2DefUp.setActionCommand("UP Def2");
        cmdTeam2PenUp.setActionCommand("UP Pen2");
        cmdTeam2CrossUp.setActionCommand("UP Cross2");

        cmdTeam2DefDown.setActionCommand("DOWN Def2");
        cmdTeam2PenDown.setActionCommand("DOWN Pen2");
        cmdTeam2CrossDown.setActionCommand("DOWN Cross2");

        //Sets the location of the components
        GUIHelper.setLocation(team2Num, layout, this.getContentPane(), 86, 200);
        GUIHelper.setLocation(txtTeam2Comments, layout, this.getContentPane(), 104, 361);
        GUIHelper.setLocation(cmdTeam2Up1, layout, this.getContentPane(), 32, 278);
        GUIHelper.setLocation(cmdTeam2Down1, layout, this.getContentPane(), 32, 328);
        GUIHelper.setLocation(cmdTeam2Up2, layout, this.getContentPane(), 103, 278);
        GUIHelper.setLocation(cmdTeam2Down2, layout, this.getContentPane(), 103, 328);
        GUIHelper.setLocation(cmdTeam2Up3, layout, this.getContentPane(), 170, 278);
        GUIHelper.setLocation(cmdTeam2Down3, layout, this.getContentPane(), 170, 328);
        GUIHelper.setLocation(cmdTeam2Up4, layout, this.getContentPane(), 240, 278);
        GUIHelper.setLocation(cmdTeam2Down4, layout, this.getContentPane(), 240, 328);
        GUIHelper.setLocation(cmdTeam2DefUp, layout, this.getContentPane(), 311, 278);
        GUIHelper.setLocation(cmdTeam2DefDown, layout, this.getContentPane(), 311, 328);
        GUIHelper.setLocation(cmdTeam2PenUp, layout, this.getContentPane(), 382, 278);
        GUIHelper.setLocation(cmdTeam2PenDown, layout, this.getContentPane(), 382, 328);
        GUIHelper.setLocation(cmdTeam2CrossUp, layout, this.getContentPane(), 452, 278);
        GUIHelper.setLocation(cmdTeam2CrossDown, layout, this.getContentPane(), 452, 328);

        GUIHelper.setLocation(lblMissed2, layout, this.getContentPane(), 48, 305);
        GUIHelper.setLocation(lblTop2, layout, this.getContentPane(), 120, 305);
        GUIHelper.setLocation(lblMid2, layout, this.getContentPane(), 188, 305);
        GUIHelper.setLocation(lblLow2, layout, this.getContentPane(), 260, 305);
        GUIHelper.setLocation(lblDef2, layout, this.getContentPane(), 330, 305);
        GUIHelper.setLocation(lblPen2, layout, this.getContentPane(), 402, 305);
        GUIHelper.setLocation(lblCross2, layout, this.getContentPane(), 474, 305);
        GUIHelper.setLocation(chkBroke2, layout, this.getContentPane(), 609, 230);
        GUIHelper.setLocation(single2, layout, this.getContentPane(), 596, 283);
        GUIHelper.setLocation(dub2, layout, this.getContentPane(), 596, 301);
        GUIHelper.setLocation(coop2, layout, this.getContentPane(), 596, 316);
        GUIHelper.setLocation(na2, layout, this.getContentPane(), 596, 332);
        GUIHelper.setLocation(win2, layout, this.getContentPane(), 723, 288);
        GUIHelper.setLocation(loss2, layout, this.getContentPane(), 780, 288);

        //Changing font
        team2Num.setFont(big);

        //Eliminating borders and panes around command buttons
        GUIHelper.setupButton(cmdTeam2Up1, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2Down1, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam2Up2, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2Down2, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam2Up3, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2Down3, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam2Up4, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2Down4, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam2DefUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2DefDown, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam2PenUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2PenDown, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam2CrossUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam2CrossDown, 39, 22, false, false);

        //Setup check boxes and radio buttons
        GUIHelper.setupButton(chkBroke2, -1, -1, false, false);
        GUIHelper.setupButton(single2, -1, -1, false, false);
        GUIHelper.setupButton(dub2, -1, -1, false, false);
        GUIHelper.setupButton(coop2, -1, -1, false, false);
        GUIHelper.setupButton(na2, -1, -1, false, false);
        GUIHelper.setupButton(win2, -1, -1, false, false);
        GUIHelper.setupButton(loss2, -1, -1, false, false);

        team2Num.setPreferredSize(new Dimension(75, 26));
        txtTeam2Comments.setPreferredSize(new Dimension(540, 18));
    }//End of setUpSecond method

    //Sets up the third team for scouting
    public void setUpThird()
    {
        //Adding components to frame
        this.add(team3Num);
        this.add(txtTeam3Comments);
        this.add(cmdTeam3Up1);
        this.add(cmdTeam3Up2);
        this.add(cmdTeam3Up3);
        this.add(cmdTeam3Up4);

        this.add(cmdTeam3Down1);
        this.add(cmdTeam3Down2);
        this.add(cmdTeam3Down3);
        this.add(cmdTeam3Down4);

        this.add(cmdTeam3DefUp);
        this.add(cmdTeam3PenUp);
        this.add(cmdTeam3CrossUp);

        this.add(cmdTeam3DefDown);
        this.add(cmdTeam3PenDown);
        this.add(cmdTeam3CrossDown);

        //Groups radio buttons together
        bg.add(single3);
        bg.add(dub3);
        bg.add(coop3);
        bg.add(na3);
        wl3.add(win3);
        wl3.add(loss3);

        //Add the action listener
        cmdTeam3Down1.addActionListener(this);
        cmdTeam3Up1.addActionListener(this);
        cmdTeam3Down2.addActionListener(this);
        cmdTeam3Up2.addActionListener(this);
        cmdTeam3Down3.addActionListener(this);
        cmdTeam3Up3.addActionListener(this);
        cmdTeam3Up4.addActionListener(this);
        cmdTeam3Down4.addActionListener(this);

        cmdTeam3DefUp.addActionListener(this);
        cmdTeam3PenUp.addActionListener(this);
        cmdTeam3CrossUp.addActionListener(this);

        cmdTeam3DefDown.addActionListener(this);
        cmdTeam3PenDown.addActionListener(this);
        cmdTeam3CrossDown.addActionListener(this);

        //Naming the buttons
        cmdTeam3Up1.setActionCommand("UP31");
        cmdTeam3Down1.setActionCommand("DOWN31");
        cmdTeam3Up2.setActionCommand("UP32");
        cmdTeam3Down2.setActionCommand("DOWN32");
        cmdTeam3Up3.setActionCommand("UP33");
        cmdTeam3Down3.setActionCommand("DOWN33");
        cmdTeam3Up4.setActionCommand("UP34");
        cmdTeam3Down4.setActionCommand("DOWN34");

        cmdTeam3DefUp.setActionCommand("UP Def3");
        cmdTeam3PenUp.setActionCommand("UP Pen3");
        cmdTeam3CrossUp.setActionCommand("UP Cross3");

        cmdTeam3DefDown.setActionCommand("DOWN Def3");
        cmdTeam3PenDown.setActionCommand("DOWN Pen3");
        cmdTeam3CrossDown.setActionCommand("DOWN Cross3");

        //Sets the location of the components 189px lower
        GUIHelper.setLocation(team3Num, layout, this.getContentPane(), 86, 400);
        GUIHelper.setLocation(txtTeam3Comments, layout, this.getContentPane(), 104, 555);
        GUIHelper.setLocation(cmdTeam3Up1, layout, this.getContentPane(), 32, 473);
        GUIHelper.setLocation(cmdTeam3Down1, layout, this.getContentPane(), 32, 523);
        GUIHelper.setLocation(cmdTeam3Up2, layout, this.getContentPane(), 103, 473);
        GUIHelper.setLocation(cmdTeam3Down2, layout, this.getContentPane(), 103, 523);
        GUIHelper.setLocation(cmdTeam3Up3, layout, this.getContentPane(), 170, 473);
        GUIHelper.setLocation(cmdTeam3Down3, layout, this.getContentPane(), 170, 523);
        GUIHelper.setLocation(cmdTeam3Up4, layout, this.getContentPane(), 240, 473);
        GUIHelper.setLocation(cmdTeam3Down4, layout, this.getContentPane(), 240, 523);
        GUIHelper.setLocation(cmdTeam3DefUp, layout, this.getContentPane(), 311, 473);
        GUIHelper.setLocation(cmdTeam3DefDown, layout, this.getContentPane(), 311, 523);
        GUIHelper.setLocation(cmdTeam3PenUp, layout, this.getContentPane(), 382, 473);
        GUIHelper.setLocation(cmdTeam3PenDown, layout, this.getContentPane(), 382, 523);
        GUIHelper.setLocation(cmdTeam3CrossUp, layout, this.getContentPane(), 452, 473);
        GUIHelper.setLocation(cmdTeam3CrossDown, layout, this.getContentPane(), 452, 523);

        GUIHelper.setLocation(lblMissed3, layout, this.getContentPane(), 48, 500);
        GUIHelper.setLocation(lblTop3, layout, this.getContentPane(), 120, 500);
        GUIHelper.setLocation(lblMid3, layout, this.getContentPane(), 188, 500);
        GUIHelper.setLocation(lblLow3, layout, this.getContentPane(), 260, 500);
        GUIHelper.setLocation(lblDef3, layout, this.getContentPane(), 330, 500);
        GUIHelper.setLocation(lblPen3, layout, this.getContentPane(), 402, 500);
        GUIHelper.setLocation(lblCross3, layout, this.getContentPane(), 474, 500);
        GUIHelper.setLocation(chkBroke3, layout, this.getContentPane(), 609, 425);
        GUIHelper.setLocation(single3, layout, this.getContentPane(), 596, 478);
        GUIHelper.setLocation(dub3, layout, this.getContentPane(), 596, 496);
        GUIHelper.setLocation(coop3, layout, this.getContentPane(), 596, 511);
        GUIHelper.setLocation(na3, layout, this.getContentPane(), 596, 527);
        GUIHelper.setLocation(win3, layout, this.getContentPane(), 723, 483);
        GUIHelper.setLocation(loss3, layout, this.getContentPane(), 780, 483);

        //Changing font
        team3Num.setFont(big);

        //Eliminating borders and panes around command buttons
        GUIHelper.setupButton(cmdTeam3Up1, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3Down1, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam3Up2, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3Down2, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam3Up3, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3Down3, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam3Up4, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3Down4, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam3DefUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3DefDown, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam3PenUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3PenDown, 39, 22, false, false);

        GUIHelper.setupButton(cmdTeam3CrossUp, 39, 22, false, false);
        GUIHelper.setupButton(cmdTeam3CrossDown, 39, 22, false, false);

        //Setup check boxes and radio buttons
        GUIHelper.setupButton(chkBroke3, -1, -1, false, false);
        GUIHelper.setupButton(single3, -1, -1, false, false);
        GUIHelper.setupButton(dub3, -1, -1, false, false);
        GUIHelper.setupButton(coop3, -1, -1, false, false);
        GUIHelper.setupButton(na3, -1, -1, false, false);
        GUIHelper.setupButton(win3, -1, -1, false, false);
        GUIHelper.setupButton(loss3, -1, -1, false, false);

        //Setting size of text field
        team3Num.setPreferredSize(new Dimension(75, 26));
        txtTeam3Comments.setPreferredSize(new Dimension(540, 18));
    }//End of setUpThird method

    //Increments stat
    public void up(String component)
    {
        //Declaring variables
        int num;
        String label;

        //Determining which component to increment
        if(component.equals("lblMissed1"))
        {
                //Gets current number from label
                num = Integer.parseInt(lblMissed1.getText());
                num++;	//Increments
                label = Integer.toString(num);	//Returns incremented number to a String

                lblMissed1.setText(label);	//Sets the text of the label to the incremented String
        }                    
        else if(component.equals("lblTop1"))
        {
                num = Integer.parseInt(lblTop1.getText());
                num++;
                label = Integer.toString(num);

                lblTop1.setText(label);
        }
        else if(component.equals("lblMid1"))
        {
                num = Integer.parseInt(lblMid1.getText());
                num++;
                label = Integer.toString(num);

                lblMid1.setText(label);
        }
        else if(component.equals("lblLow1"))
        {
                num = Integer.parseInt(lblLow1.getText());
                num++;
                label = Integer.toString(num);

                lblLow1.setText(label);
        }
        else if(component.equals("lblDef"))
        {
                num = Integer.parseInt(lblDef.getText());
                num++;
                label = Integer.toString(num);

                lblDef.setText(label);
        }
        else if(component.equals("lblPen"))
        {
                num = Integer.parseInt(lblPen.getText());
                num++;
                label = Integer.toString(num);

                lblPen.setText(label);
        }
        else if(component.equals("lblCross"))
        {
                num = Integer.parseInt(lblCross.getText());
                num++;
                label = Integer.toString(num);

                lblCross.setText(label);
        }
        else if(component.equals("lblMissed2"))
        {
                //Gets current number from label
                num = Integer.parseInt(lblMissed2.getText());
                num++;	//Increments
                label = Integer.toString(num);	//Returns incremented number to a String

                lblMissed2.setText(label);	//Sets the text of the label to the incremented String
        }
        else if(component.equals("lblTop2"))
        {
                num = Integer.parseInt(lblTop2.getText());
                num++;
                label = Integer.toString(num);

                lblTop2.setText(label);
        }
        else if(component.equals("lblMid2"))
        {
                        num = Integer.parseInt(lblMid2.getText());
                num++;
                label = Integer.toString(num);

                lblMid2.setText(label);
        }
        else if(component.equals("lblLow2"))
        {
                num = Integer.parseInt(lblLow2.getText());
                num++;
                label = Integer.toString(num);

                lblLow2.setText(label);
        }
        else if(component.equals("lblDef2"))
        {
                num = Integer.parseInt(lblDef2.getText());
                num++;
                label = Integer.toString(num);

                lblDef2.setText(label);
        }
        else if(component.equals("lblPen2"))
        {
                num = Integer.parseInt(lblPen2.getText());
                num++;
                label = Integer.toString(num);

                lblPen2.setText(label);
        }
        else if(component.equals("lblCross2"))
        {
                num = Integer.parseInt(lblCross2.getText());
                num++;
                label = Integer.toString(num);

                lblCross2.setText(label);
        }
        else if(component.equals("lblMissed3"))
        {
                //Gets current number from label
                num = Integer.parseInt(lblMissed3.getText());
                num++;	//Increments
                label = Integer.toString(num);	//Returns incremented number to a String

                lblMissed3.setText(label);	//Sets the text of the label to the incremented String
        }
        else if(component.equals("lblTop3"))
        {
                num = Integer.parseInt(lblTop3.getText());
                num++;
                label = Integer.toString(num);

                lblTop3.setText(label);
        }
        else if(component.equals("lblMid3"))
        {
                        num = Integer.parseInt(lblMid3.getText());
                num++;
                label = Integer.toString(num);

                lblMid3.setText(label);
        }
        else if(component.equals("lblLow3"))
        {
                num = Integer.parseInt(lblLow3.getText());
                num++;
                label = Integer.toString(num);

                lblLow3.setText(label);
        }
        else if(component.equals("lblDef3"))
        {
                num = Integer.parseInt(lblDef3.getText());
                num++;
                label = Integer.toString(num);

                lblDef3.setText(label);
        }
        else if(component.equals("lblPen3"))
        {
                num = Integer.parseInt(lblPen3.getText());
                num++;
                label = Integer.toString(num);

                lblPen3.setText(label);
        }
        else if(component.equals("lblCross3"))
        {
                num = Integer.parseInt(lblCross3.getText());
                num++;
                label = Integer.toString(num);

                lblCross3.setText(label);
        }
}//End of up method

//Decrements a stat
public void down(String component)
{
        //Declaring variables
        int num;
        String label;

        //Determines which stat to decrement
        if(component.equals("lblMissed1"))
        {
                num = Integer.parseInt(lblMissed1.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblMissed1.setText(label);
        }
        else if(component.equals("lblTop1"))
        {
                num = Integer.parseInt(lblTop1.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblTop1.setText(label);
        }
        else if(component.equals("lblMid1"))
        {
                num = Integer.parseInt(lblMid1.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblMid1.setText(label);
        }
        else if(component.equals("lblLow1"))
        {
                num = Integer.parseInt(lblLow1.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblLow1.setText(label);
        }
                else if(component.equals("lblDef"))
        {
                num = Integer.parseInt(lblDef.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblDef.setText(label);
        }
        else if(component.equals("lblPen"))
        {
                num = Integer.parseInt(lblPen.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblPen.setText(label);
        }
        else if(component.equals("lblCross"))
        {
                num = Integer.parseInt(lblCross.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblCross.setText(label);
        }
        else if(component.equals("lblMissed2"))
        {
                num = Integer.parseInt(lblMissed2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblMissed2.setText(label);
        }
        else if(component.equals("lblTop2"))
        {
                num = Integer.parseInt(lblTop2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblTop2.setText(label);
        }
        else if(component.equals("lblMid2"))
        {
                num = Integer.parseInt(lblMid2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblMid2.setText(label);
        }
        else if(component.equals("lblLow2"))
        {
                num = Integer.parseInt(lblLow2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblLow2.setText(label);
        }
        else if(component.equals("lblDef2"))
        {
                num = Integer.parseInt(lblDef2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblDef2.setText(label);
        }
        else if(component.equals("lblPen2"))
        {
                num = Integer.parseInt(lblPen2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblPen2.setText(label);
        }
        else if(component.equals("lblCross2"))
        {
                num = Integer.parseInt(lblCross2.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblCross2.setText(label);
        }
        else if(component.equals("lblMissed3"))
        {
                num = Integer.parseInt(lblMissed3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblMissed3.setText(label);
        }
        else if(component.equals("lblTop3"))
        {
                num = Integer.parseInt(lblTop3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblTop3.setText(label);
        }
        else if(component.equals("lblMid3"))
        {
                num = Integer.parseInt(lblMid3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblMid3.setText(label);
        }
        else if(component.equals("lblLow3"))
        {
                num = Integer.parseInt(lblLow3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblLow3.setText(label);
        }
        else if(component.equals("lblDef3"))
        {
                num = Integer.parseInt(lblDef3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblDef3.setText(label);
        }
        else if(component.equals("lblPen3"))
        {
                num = Integer.parseInt(lblPen3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblPen3.setText(label);
        }
        else if(component.equals("lblCross3"))
        {
                num = Integer.parseInt(lblCross3.getText());
                if((num - 1) >= 0)
                        num--;
                label = Integer.toString(num);

                lblCross3.setText(label);
        }
    }//End of down method

    //Saves stats to file
    public void submit1()
    {
        //Declaring variables
        int num = 0;
        int index = 0;
        boolean won = false;
        Team temp;
        Exception wl = new Exception();

        //Check if valid team number is entered
        try
        {
            //Pull number from label, throwing exception if invalid
            num = Integer.parseInt(team1Num.getText());
            if(!win.isSelected() && !loss.isSelected())
                throw wl;

            //Finds the team with the corresponding number
            if(Team.getTeamIndex(num) != -1)
            {
                temp = Team.teamList.get(Team.getTeamIndex(num));
                index = Team.getTeamIndex(num);
                updateStats1(temp, num);
            }
            else
                createNewTeam1(num);
        }
        catch(Exception invalid)
        {
            if(invalid == wl)
                JOptionPane.showMessageDialog(null, "Please select win or loss.");
            else
                JOptionPane.showMessageDialog(null, "Please enter a valid team number.");
        }
        
        //Save updated stats to file
        try 
        {
            Team.saveToFile();
        } catch (IOException ex) 
        {
                JOptionPane.showMessageDialog(null, "Error saving stats to file.");            
        }
    }//End of submit1 method

    //Saves stats to file
    public void submit2()
    {
        //Declaring variables
        int num = 0;
        int index = 0;
        boolean won = false;
        Team temp;
        Exception wl = new Exception();

        //Check if valid team number is entered
        try
        {
            //Pull number from label, throwing exception if invalid
            num = Integer.parseInt(team2Num.getText());
            if(!win2.isSelected() && !loss2.isSelected())
                throw wl;

            //Finds the team with the corresponding number
            if(Team.getTeamIndex(num) != -1)
            {
                temp = Team.teamList.get(Team.getTeamIndex(num));
                index = Team.getTeamIndex(num);
                updateStats2(temp, num);
            }
            else
                createNewTeam2(num);
        }
        catch(Exception invalid)
        {
            if(invalid == wl)
                JOptionPane.showMessageDialog(null, "Please select win or loss.");
            else
                JOptionPane.showMessageDialog(null, "Please enter a valid team number.");
        }
        
        //Save updated stats to file
        try 
        {
            Team.saveToFile();
        } catch (IOException ex) 
        {
                JOptionPane.showMessageDialog(null, "Error saving stats to file.");            
        }
    }//End of submit2 method

    //Saves stats to file
    public void submit3()
    {
        //Declaring variables
        int num = 0;
        int index = 0;
        boolean won = false;
        Team temp;
        Exception wl = new Exception();

        //Check if valid team number is entered
        try
        {
            //Pull number from label, throwing exception if invalid
            num = Integer.parseInt(team3Num.getText());
            if(!win3.isSelected() && !loss3.isSelected())
                throw wl;

            //Finds the team with the corresponding number
            if(Team.getTeamIndex(num) != -1)
            {
                temp = Team.teamList.get(Team.getTeamIndex(num));
                index = Team.getTeamIndex(num);
                updateStats3(temp, num);
            }
            else
                createNewTeam3(num);
        }
        catch(Exception invalid)
        {
            if(invalid == wl)
                JOptionPane.showMessageDialog(null, "Please select win or loss.");
            else
                JOptionPane.showMessageDialog(null, "Please enter a valid team number.");
        }
        
        //Save updated stats to file
        try 
        {
            Team.saveToFile();
        } catch (IOException ex) 
        {
                JOptionPane.showMessageDialog(null, "Error saving stats to file.");            
        }
    }//End of submit3 method

    //Updates a team's stats
    private void updateStats1(Team a, int num)
    {
        //Declaring variables
        int newGP = 0;
        int numWins = 0;
        int newMiss = 0;
        int newTop = 0;
        int newMid = 0;
        int newLow = 0;
        int newCross = 0;
        int newPen = 0;
        int newDef = 0;
        int numSingle = 0;
        int numDouble = 0;
        int numCoop = 0;
        int numBreak = 0;
        String comments = "";

        //Incrementing games played stat
        newGP = 1;

        //Updating shooting stats
        newMiss = Integer.parseInt(lblMissed1.getText());
        newTop = Integer.parseInt(lblTop1.getText());
        newMid = Integer.parseInt(lblMid1.getText());
        newLow = Integer.parseInt(lblLow1.getText());

        //Updating other stats
        newCross = Integer.parseInt(lblCross.getText());
        newPen = Integer.parseInt(lblPen.getText());
        newDef = Integer.parseInt(lblDef.getText());

        //Incrementing number of balances
        if(single.isSelected())
                numSingle = 1;
        else if(dub.isSelected())
                numDouble = 1;
        else if(coop.isSelected())
                numCoop = 1;

        //Checks if the robot broke down
        if(chkBroke.isSelected())
                numBreak = 1;

        //Adds comments
        comments = txtTeam1Comments.getText();

        //Checks if the robot won or lost
        if(win.isSelected())
                numWins = 1;

        //Updates stats
        a.saveToProfile(num, newGP, numWins, newMiss, newTop, newMid, newLow, newCross, newPen, newDef, numSingle, numCoop, numDouble, numBreak, comments);

        //Alerting user that they've submitted the stats
        JOptionPane.showMessageDialog(null, "Team " + num + "'s stats have been submitted.");

        //Resetting labels
        lblMissed1.setText("0");
        lblTop1.setText("0");
        lblMid1.setText("0");
        lblLow1.setText("0");

        lblCross.setText("0");
        lblPen.setText("0");
        lblDef.setText("0");

        //Resetting radio buttons and check boxes
        if(single.isSelected())
                single.setSelected(false);
        else if(dub.isSelected())
                dub.setSelected(false);
        else if (coop.isSelected())
                coop.setSelected(false);
        else if(na.isSelected())
                na.setSelected(false);

        if(chkBroke.isSelected())
                chkBroke.setSelected(false);

        if(win.isSelected())
                win.setSelected(false);
        else if(loss.isSelected())
                loss.setSelected(false);

        //Resetting textfields
        team1Num.setText("");
        txtTeam1Comments.setText("");

        System.out.println("SUBMITTED!");
    }//End of updateStats method

    //Updates a team's stats
    private void updateStats2(Team a, int num)
    {
        System.out.println("Updating");

        //Declaring variables
        int newGP = 0;
        int numWins = 0;
        int newMiss = 0;
        int newTop = 0;
        int newMid = 0;
        int newLow = 0;
        int newCross = 0;
        int newPen = 0;
        int newDef = 0;
        int numSingle = 0;
        int numDouble = 0;
        int numCoop = 0;
        int numBreak = 0;
        String comments = "";

        //Incrementing games played stat
        newGP = 1;

        //Updating shooting stats
        newMiss = Integer.parseInt(lblMissed2.getText());
        newTop = Integer.parseInt(lblTop2.getText());
        newMid = Integer.parseInt(lblMid2.getText());
        newLow = Integer.parseInt(lblLow2.getText());

        //Updating other stats
        newCross = Integer.parseInt(lblCross2.getText());
        newPen = Integer.parseInt(lblPen2.getText());
        newDef = Integer.parseInt(lblDef2.getText());

        //Incrementing number of balances
        if(single2.isSelected())
                numSingle = 1;
        else if(dub2.isSelected())
                numDouble = 1;
        else if(coop2.isSelected())
                numCoop = 1;

        //Checks if the robot broke down
        if(chkBroke2.isSelected())
                numBreak = 1;

        //Adds comments
        comments = txtTeam2Comments.getText();

        //Checks if the robot won or lost
        if(win2.isSelected())
                numWins = 1;

        //Updates stats
        a.saveToProfile(num, newGP, numWins, newMiss, newTop, newMid, newLow, newCross, newPen, newDef, numSingle, numCoop, numDouble, numBreak, comments);

        //Alerting user that they've submitted the stats
        JOptionPane.showMessageDialog(null, "Team " + num + "'s stats have been submitted.");

        //Resetting labels
        lblMissed2.setText("0");
        lblTop2.setText("0");
        lblMid2.setText("0");
        lblLow2.setText("0");

        lblCross2.setText("0");
        lblPen2.setText("0");
        lblDef2.setText("0");

        //Resetting radio buttons and check boxes
        if(single2.isSelected())
                single2.setSelected(false);
        else if(dub2.isSelected())
                dub2.setSelected(false);
        else if (coop2.isSelected())
                coop2.setSelected(false);
        else if(na.isSelected())
                na2.setSelected(false);

        if(chkBroke2.isSelected())
                chkBroke2.setSelected(false);

        if(win2.isSelected())
                win2.setSelected(false);
        else if(loss2.isSelected())
                loss2.setSelected(false);

        //Resetting textfields
        team2Num.setText("");
        txtTeam2Comments.setText("");

        System.out.println("SUBMITTED!");
    }//End of updateStats method

    //Updates a team's stats
    private void updateStats3(Team a, int num)
    {
        //Declaring variables
        int newGP = 0;
        int numWins = 0;
        int newMiss = 0;
        int newTop = 0;
        int newMid = 0;
        int newLow = 0;
        int newCross = 0;
        int newPen = 0;
        int newDef = 0;
        int numSingle = 0;
        int numDouble = 0;
        int numCoop = 0;
        int numBreak = 0;
        String comments = "";

        //Incrementing games played stat
        newGP = 1;

        //Updating shooting stats
        newMiss = Integer.parseInt(lblMissed3.getText());
        newTop = Integer.parseInt(lblTop3.getText());
        newMid = Integer.parseInt(lblMid3.getText());
        newLow = Integer.parseInt(lblLow3.getText());

        //Updating other stats
        newCross = Integer.parseInt(lblCross3.getText());
        newPen = Integer.parseInt(lblPen3.getText());
        newDef = Integer.parseInt(lblDef3.getText());

        //Incrementing number of balances
        if(single3.isSelected())
                numSingle = 1;
        else if(dub3.isSelected())
                numDouble = 1;
        else if(coop3.isSelected())
                numCoop = 1;

        //Checks if the robot broke down
        if(chkBroke3.isSelected())
                numBreak = 1;

        //Adds comments
        comments = txtTeam3Comments.getText();

        //Checks if the robot won or lost
        if(win3.isSelected())
                numWins = 1;

        //Updates stats
        a.saveToProfile(num, newGP, numWins, newMiss, newTop, newMid, newLow, newCross, newPen, newDef, numSingle, numCoop, numDouble, numBreak, comments);

        //Alerting user that they've submitted the stats
        JOptionPane.showMessageDialog(null, "Team " + num + "'s stats have been submitted.");

        //Resetting labels
        lblMissed3.setText("0");
        lblTop3.setText("0");
        lblMid3.setText("0");
        lblLow3.setText("0");

        lblCross3.setText("0");
        lblPen3.setText("0");
        lblDef3.setText("0");

        //Resetting radio buttons and check boxes
        if(single3.isSelected())
                single3.setSelected(false);
        else if(dub3.isSelected())
                dub3.setSelected(false);
        else if (coop3.isSelected())
                coop3.setSelected(false);
        else if(na3.isSelected())
                na3.setSelected(false);

        if(chkBroke3.isSelected())
                chkBroke3.setSelected(false);

        if(win3.isSelected())
                win3.setSelected(false);
        else if(loss3.isSelected())
                loss3.setSelected(false);

        //Resetting textfields
        team3Num.setText("");
        txtTeam3Comments.setText("");
    }//End of updateStats method

    //Creates a new team and adds it to the Team ArrayList
    private void createNewTeam1(int num)
    {
        Team temp = new Team();

        temp.setTeamNumber(num);

        Team.addNewTeam(temp);

        updateStats1(temp, num);
    }//End of createNewTeam method

    //Creates a new team and adds it to the Team ArrayList
    private void createNewTeam2(int num)
    {
        System.out.println("Creating!");
        Team temp = new Team();

        temp.setTeamNumber(num);

        Team.addNewTeam(temp);

        updateStats2(temp, num);
    }//End of createNewTeam method

    //Creates a new team and adds it to the Team ArrayList
    private void createNewTeam3(int num)
    {
        Team temp = new Team();

        temp.setTeamNumber(num);

        Team.addNewTeam(temp);

        updateStats3(temp, num);
    }//End of createNewTeam method

        //Method to set button size, content fill, border
    private void setupCheckBox(JCheckBox chkBox, int x, int y, boolean filled, boolean border)
    {
        //Set dimensions
        chkBox.setPreferredSize(new Dimension(x, y));

        //Set up fill
        if(filled == true)
            chkBox.setContentAreaFilled(true);
        else
            chkBox.setContentAreaFilled(false);

        //Set border painted
        if(border == true)
            chkBox.setBorderPainted(true);
        else
            chkBox.setBorderPainted(false);
    }//End of setUpButton()

    //Returns to the homescreen
    public void cancel()
    {
        //Checks to ensure the user wants to return to the Home screen.
        if( JOptionPane.showConfirmDialog(null, "Are you sure you'd like to return to the Home screen? Any unsubmitted data will be lost.", "Confirm.",
    JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0)
    {
        HomeScreen frame = new HomeScreen();
            this.setVisible(false);
    }
    }//End of cancel method

    //Opens help menu
    public void help() throws IOException
    {
        Help a = new Help();
    }//End of help method


    //Checks which component has been selected and performs the appropriate action
    public void actionPerformed(ActionEvent evt)
    {
            //Check if button has been selected
            if (evt.getActionCommand().equals("UP11"))
                    up("lblMissed1");	//Increments missed shots

            else if (evt.getActionCommand().equals("DOWN11"))
                    down("lblMissed1");

            else if (evt.getActionCommand().equals("UP12"))
                    up("lblTop1");

            else if (evt.getActionCommand().equals("DOWN12"))
                    down("lblTop1");

            else if (evt.getActionCommand().equals("UP13"))
                    up("lblMid1");

            else if (evt.getActionCommand().equals("DOWN13"))
                    down("lblMid1");

            else if (evt.getActionCommand().equals("UP14"))
                    up("lblLow1");

            else if (evt.getActionCommand().equals("DOWN14"))
                    down("lblLow1");

            else if (evt.getActionCommand().equals("UP Def"))
                    up("lblDef");

            else if (evt.getActionCommand().equals("DOWN Def"))
                    down("lblDef");

            else if (evt.getActionCommand().equals("UP Pen"))
                    up("lblPen");

            else if (evt.getActionCommand().equals("DOWN Pen"))
                    down("lblPen");

            else if (evt.getActionCommand().equals("UP Cross"))
                    up("lblCross");

            else if (evt.getActionCommand().equals("DOWN Cross"))
                    down("lblCross");

            else if (evt.getActionCommand().equals("UP21"))
                    up("lblMissed2");	//Increments missed shots

            else if (evt.getActionCommand().equals("DOWN21"))
                    down("lblMissed2");

            else if (evt.getActionCommand().equals("UP22"))
                    up("lblTop2");

            else if (evt.getActionCommand().equals("DOWN22"))
                    down("lblTop2");

            else if (evt.getActionCommand().equals("UP23"))
                    up("lblMid2");

            else if (evt.getActionCommand().equals("DOWN23"))
                    down("lblMid2");

            else if (evt.getActionCommand().equals("UP24"))
                    up("lblLow2");

            else if (evt.getActionCommand().equals("DOWN24"))
                    down("lblLow2");

            else if (evt.getActionCommand().equals("UP Def2"))
                    up("lblDef2");

            else if (evt.getActionCommand().equals("DOWN Def2"))
                    down("lblDef2");

            else if (evt.getActionCommand().equals("UP Pen2"))
                    up("lblPen2");

            else if (evt.getActionCommand().equals("DOWN Pen2"))
                    down("lblPen2");

            else if (evt.getActionCommand().equals("UP Cross2"))
                    up("lblCross2");

            else if (evt.getActionCommand().equals("DOWN Cross2"))
                    down("lblCross2");

            else if (evt.getActionCommand().equals("UP31"))
                    up("lblMissed3");	//Increments missed shots

            else if (evt.getActionCommand().equals("DOWN31"))
                    down("lblMissed3");

            else if (evt.getActionCommand().equals("UP32"))
                    up("lblTop3");

            else if (evt.getActionCommand().equals("DOWN32"))
                    down("lblTop3");

            else if (evt.getActionCommand().equals("UP33"))
                    up("lblMid3");

            else if (evt.getActionCommand().equals("DOWN33"))
                    down("lblMid3");

            else if (evt.getActionCommand().equals("UP34"))
                    up("lblLow3");

            else if (evt.getActionCommand().equals("DOWN34"))
                    down("lblLow3");

            else if (evt.getActionCommand().equals("UP Def3"))
                    up("lblDef3");

            else if (evt.getActionCommand().equals("DOWN Def3"))
                    down("lblDef3");

            else if (evt.getActionCommand().equals("UP Pen3"))
                    up("lblPen3");

            else if (evt.getActionCommand().equals("DOWN Pen3"))
                    down("lblPen3");

            else if (evt.getActionCommand().equals("UP Cross3"))
                    up("lblCross3");

            else if (evt.getActionCommand().equals("DOWN Cross3"))
                    down("lblCross3");

            else if (evt.getActionCommand().equals("SUBMIT1"))
                    submit1();

            else if (evt.getActionCommand().equals("SUBMIT2"))
                    submit2();

            else if (evt.getActionCommand().equals("SUBMIT3"))
                    submit3();

            else if (evt.getActionCommand().equals("CANCEL"))
                    cancel();

            else if (evt.getActionCommand().equals("HELP"))
            {
                try
                {
                    help();
                }
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(null, "An unexpected error has occurred.");
                }
            }
    }//End of actionPerformed method
}//End of ScouterScreen class