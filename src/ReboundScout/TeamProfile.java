/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    TeamProfile
 */

/*
 * The purpose of this class is to create a way to display and manage individual
 * teams' data. This includes displaying a team photo and stats, and allowing
 * the user to delete the team from the database or hide the team's stats from 
 * the main table 
 */

package ReboundScout;

//Importing packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TeamProfile extends JFrame implements ActionListener
{
    //Create instances of the GUI component.
    private Team team;	//The passed in team object

    private JLabel lblNumber = new JLabel();				//Contains the team's number
    private JLabel lblTeamNameHeader = new JLabel("TEAM NAME:");	//Display of the team name section header
    private JLabel lblDriveHeader = new JLabel("DRIVE TYPE:");		//Display of the drive type section header
    private JLabel lblShapeHeader = new JLabel("ROBOT SHAPE:");		//Display of the shape section header
    private JLabel lblLauncherHeader = new JLabel("LAUNCHER TYPE:");	//Display of the launcher section header

    private JLabel lblTeamName = new JLabel();  //Entered team name
    private JLabel lblDrive = new JLabel();	//Entered description of the drive
    private JLabel lblShape = new JLabel();	//Entered description of the shape
    private JLabel lblLauncher = new JLabel();	//Entered description of the launcher

    private JButton cmdTeamName = new JButton();    //Allows entry of a new team name
    private JButton cmdDrive = new JButton();       //Allows entry of a new drive description
    private JButton cmdShape = new JButton();       //Allows entry of a new shape description
    private JButton cmdLauncher = new JButton();    //Allows entry of a new launcher description

    private JLabel lblPicture = new JLabel();       //A container for the robot's picture
    private ImageIcon robotPhoto;															//The robot's picture
    private JLabel lblBackground = new JLabel(new ImageIcon("src/Images/ProfileScreen.jpg"));	//Background image for the screen

    private JButton cmdBack = new JButton();		//Returns user to Home screen
    private JButton cmdHelp = new JButton();		//Opens help message
    private JButton cmdSaveComments = new JButton();	//Saves entered comments
    private JButton cmdDelete = new JButton("DELETE");	//Deletes team from record

    private JCheckBox chkBox = new JCheckBox("Hide stats from home page");  //Omits stats from JTable

    private JTextArea txtComments = new JTextArea();	//Allows entry of new comments
    private JTable table;				//Stat line table

    //Create an instance of the layout manager
    SpringLayout layout = new SpringLayout();

    public TeamProfile(Team tempTeam)
    {
        //Set team equal to param in object
        team = tempTeam;

        //Initialize objects
        txtComments.setText(team.stats.getComments());

        /***************SETUP TABLE**************/
        //Pull data for table into a 2D array
        Object [] columnNames = {"#", "Team", "GP","WINS","PTS",
            "Miss", "Top", "Mid", "Low", "Sh %",
            "Bump", "Pen", "Def", "S Bal",
            "C Bal", "D Bal", "Brkdwns", "pt/match"};
        Object [][] data = new Object [1][18];

        //Copy in data for team
        int index = Team.getTeamIndex(team.getTeamNumber());    //Gets team's index for table stats import
        data[0] = Team.teamList.get(index).stats.statsArray(index);
        System.out.println(data[0].length);

        //Create new table
        table = new JTable(data, columnNames);
        table.setBackground(new Color(255, 248, 180));
        table.setPreferredScrollableViewportSize(new Dimension(680, 100));
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(false);

        //Set column and row sizes
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        int [] sizes = {30, 50, 40, 40, 30, 45, 45, 45, 45, 55, 40, 40, 35, 45, 45, 45, 50, 50};
        HomeScreen.setColumnWidths(table, sizes);

        //Adding components to the frame
        this.add(chkBox);
        this.add(table);
        this.add(table.getTableHeader());
        this.add(txtComments);
    	this.add(cmdSaveComments);
    	this.add(cmdBack);
    	this.add(cmdHelp);
        this.add(lblTeamNameHeader);
        this.add(lblTeamName);
        this.add(lblNumber);
        this.add(lblDriveHeader);
        this.add(lblShapeHeader);
        this.add(lblLauncherHeader);
        this.add(lblDrive);
        this.add(lblShape);
        this.add(lblLauncher);
        this.add(cmdTeamName);
        this.add(cmdDrive);
        this.add(cmdShape);
        this.add(cmdLauncher);
        this.add(lblPicture);
        this.add(lblBackground);
        this.add(cmdDelete);

    	//Setting the frame colour
    	getContentPane().setBackground(Color.white);

        //Naming the button
        cmdSaveComments.setActionCommand("SAVE COMMENTS");
        cmdBack.setActionCommand("BACK");
        cmdHelp.setActionCommand("HELP");
        cmdTeamName.setActionCommand("TEAMNAME");
        cmdDrive.setActionCommand("DRIVE");
        cmdShape.setActionCommand("SHAPE");
        cmdLauncher.setActionCommand("LAUNCHER");
        cmdDelete.setActionCommand("DELETE");
        chkBox.setActionCommand("OMIT");

    	//Add the action listener and mouse listener
    	cmdSaveComments.addActionListener(this);
    	cmdBack.addActionListener(this);
    	cmdHelp.addActionListener(this);
        cmdTeamName.addActionListener(this);
        cmdDrive.addActionListener(this);
        cmdShape.addActionListener(this);
        cmdLauncher.addActionListener(this);
        cmdDelete.addActionListener(this);
        chkBox.addActionListener(this);

    	//Setting the layout for the frame
    	this.getContentPane().setLayout(layout);

    	//Set the components positions
        GUIHelper.setLocation(chkBox, layout, this.getContentPane(), 340, 580);
        GUIHelper.setLocation(cmdDelete, layout, this.getContentPane(), 320, 600);
        GUIHelper.setLocation(cmdSaveComments, layout, this.getContentPane(), 62, 521);
        GUIHelper.setLocation(txtComments, layout, this.getContentPane(), 255, 492);
        GUIHelper.setLocation(cmdBack, layout, this.getContentPane(), 9, 603);
        GUIHelper.setLocation(cmdHelp, layout, this.getContentPane(), 733, 603);
        GUIHelper.setLocation(lblNumber, layout, this.getContentPane(), 460, 62);
        GUIHelper.setLocation(lblTeamNameHeader, layout, this.getContentPane(), 350, 165);
        GUIHelper.setLocation(lblTeamName, layout, this.getContentPane(), 420, 185);
        GUIHelper.setLocation(cmdTeamName, layout, this.getContentPane(), 738, 170);
        GUIHelper.setLocation(lblDriveHeader, layout, this.getContentPane(), 350, 230);
        GUIHelper.setLocation(lblDrive, layout, this.getContentPane(), 420, 250);
        GUIHelper.setLocation(cmdDrive, layout, this.getContentPane(), 738, 235);
        GUIHelper.setLocation(lblShapeHeader, layout, this.getContentPane(), 350, 295);
        GUIHelper.setLocation(lblShape, layout, this.getContentPane(), 420, 315);
        GUIHelper.setLocation(cmdShape, layout, this.getContentPane(), 738, 300);
        GUIHelper.setLocation(lblLauncherHeader, layout, this.getContentPane(), 350, 360);
        GUIHelper.setLocation(lblLauncher, layout, this.getContentPane(), 420, 380);
        GUIHelper.setLocation(cmdLauncher, layout, this.getContentPane(), 738, 364);
        GUIHelper.setLocation(lblPicture, layout, this.getContentPane(), 49, 67);
        GUIHelper.setLocation(lblBackground, layout, this.getContentPane(), 0, 0);
        GUIHelper.setLocation(table.getTableHeader(), layout, this.getContentPane(), 47, 428);
        GUIHelper.setLocation(table, layout, this.getContentPane(), 47, 444);

        //Hide borders and panes around command buttons
        GUIHelper.setupButton(cmdSaveComments, 160, 25, false, false);
        GUIHelper.setupButton(cmdTeamName, 76, 24, false, false);
        GUIHelper.setupButton(cmdDrive, 76, 24, false, false);
        GUIHelper.setupButton(cmdShape, 76, 24, false, false);
        GUIHelper.setupButton(cmdLauncher, 76, 24, false, false);
        GUIHelper.setupButton(cmdBack, 105, 35, false, false);
        GUIHelper.setupButton(cmdHelp, 105, 35, false, false);
        GUIHelper.setupButton(cmdDelete, 200, 35, false, false);
        GUIHelper.setupSelector(chkBox, false, false);

        //Creating a font object
        Font big = new Font("Comic Sans MS", Font.BOLD, 30);
        Font impact = new Font("Charlemagne Std", Font.BOLD, 15);
        Font curly = new Font("Times New Roman", Font.ITALIC, 12);

        //Format comments text area
        txtComments.setPreferredSize(new Dimension(559, 58));
        txtComments.setBackground(new Color(255, 247, 255));

        //Adding team photo
        robotPhoto = new ImageIcon("src/Robot Photos/" + team.getTeamNumber() + ".jpg");
        robotPhoto.setImage(robotPhoto.getImage().getScaledInstance(257, 337, 1));
        lblPicture.setIcon(robotPhoto);

        //Changing fonts of labels
        lblTeamNameHeader.setFont(impact);
        lblShapeHeader.setFont(impact);
        lblLauncherHeader.setFont(impact);
        lblDriveHeader.setFont(impact);
        lblNumber.setFont(big);
        lblTeamName.setFont(curly);
        lblShape.setFont(curly);
        lblDrive.setFont(curly);
        lblLauncher.setFont(curly);

        //Loading team info
        lblNumber.setText(Integer.toString(team.getTeamNumber()));
        if(!team.getTeamName().equals("null"))
            lblTeamName.setText(team.getTeamName());
        if(!team.getDriveType().equals("null"))
            lblDrive.setText(team.getDriveType());
        if(!team.getRobotShape().equals("null"))
            lblShape.setText(team.getRobotShape());
        if(!team.getLauncherType().equals("null"))
            lblLauncher.setText(team.getLauncherType());

        //Checks if checkbox is selected
        if(!team.getShowInTable())
                chkBox.setSelected(true);

        //Set up the main frame
        this.setUndecorated(false);
        this.setSize(860,680);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setTitle("ReboundScout | " + team.getTeamNumber());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//End of constructor method

	//Opens up the home screen
    public void openHomeScreen()
    {
        HomeScreen frame = new HomeScreen();
        this.setVisible(false);
    }//End of openHomeScreen method

    //Method to refresh page
    private void refreshPage()
    {
        System.out.println("Refreshing page.");
        TeamProfile frame = new TeamProfile(team);
        this.setVisible(false);
    }//End of refreshPage()

    //Removes the team from the teamList
    public void delete()
    {
        //Display information on file importing
        if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this robot from file? This CANNOT be undone.", "Delete From File.",
            JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0)
        {
            //Remove team from database
            Team.removeTeam(team.getTeamNumber());

            //Popup status update message
            JOptionPane.showMessageDialog(null, "Team has been removed from the records.");

            //Open home screen
            openHomeScreen();
        }//End of if statement
    }//End of delete method

    //Checks to see which component has been selected and performs the appropriate action.
    public void actionPerformed(ActionEvent evt)
    {
        //Check if button has been selected
        try
        {
            if (evt.getActionCommand().equals("BACK"))
                openHomeScreen();
            else if (evt.getActionCommand().equals("SAVE COMMENTS"))
            {
                team.stats.setComments(txtComments.getText());
                System.out.println(txtComments.getText());
                Team.saveToFile();
                JOptionPane.showMessageDialog(null, "Saved.");
            }
            else if (evt.getActionCommand().equals("TEAMNAME"))
            {
                String input = JOptionPane.showInputDialog("Enter Team Name", "ex. RamFerno");
                if(!input.equals(""))
                    team.setTeamName(input);
                Team.saveToFile();
                refreshPage();
            }
            else if (evt.getActionCommand().equals("DRIVE"))
            {
                String input = JOptionPane.showInputDialog("Enter Robot Drive Type", "ex. 6w tank");
                if(!input.equals(""))
                    team.setDriveType(input);
                Team.saveToFile();
                refreshPage();
            }
            else if (evt.getActionCommand().equals("SHAPE"))
            {
                String input = JOptionPane.showInputDialog("Enter Robot Shape", "ex. long");
                if(!input.equals(""))
                    team.setRobotShape(input);
                Team.saveToFile();
                refreshPage();
            }
            else if (evt.getActionCommand().equals("LAUNCHER"))
            {
                String input = JOptionPane.showInputDialog("Enter Robot Launcher Type", "ex. one wheel turret");
                if(!input.equals(""))
                    team.setLauncherType(input);
                Team.saveToFile();
                refreshPage();
            }
            else if (evt.getActionCommand().equals("DELETE"))
            {
                delete();
            }
             else if (evt.getActionCommand().equals("OMIT"))
            {
                if(team.getShowInTable())
                        team.setShowInTable(false);
                else if(!team.getShowInTable())
                        team.setShowInTable(true);
            }
        } catch (IOException ex)
            {
                System.out.println("Error saving to file. " + ex);
                Logger.getLogger(TeamProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//End of actionPerformed
}//End of class