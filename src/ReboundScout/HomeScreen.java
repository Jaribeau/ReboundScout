/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    HomeScreen
 */

/*
 * Description:
 *  This class contains the main menu screen. This is the main navigation screen
 *  and is shown on startup.
 *
 */

package ReboundScout;

//Imports all necessary packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HomeScreen extends JFrame implements ActionListener
{
    //Create instances of the GUI components and initialize values
    private ImageIcon imgBackground = new ImageIcon("src/Images/HomeScreen.jpg");   //The image of the background
    private JLabel lblBackground = new JLabel(imgBackground);                       //The label to hold the background image
    private JButton cmdScout = new JButton();                                       //Opens the scouter screen
    private JButton cmdImport = new JButton();                                      //Starts the import process
    private JButton cmdExport = new JButton();                                      //Displays the Export message
    private JButton cmdSearch = new JButton();                                      //Starts the search process
    private JButton cmdSearchBox = new JButton();                                   //Allows user to quickly search, without hitting Search
    private JButton cmdHelp = new JButton();                                        //Opens the help message
    private JButton cmdBack = new JButton();                                        //Returns the user to WelcomeScreen
    private JTextField txtSearch = new JTextField("Team #", 9);                     //Contains entered team number for search process.

    //Table
    private JScrollPane scrollPane;	//Holds the table
    private JTable table;		//A table that holds all the stat values of each Team object

    //Create an instance of the layout manager
    private SpringLayout layout = new SpringLayout();	//A SpringLayout object

    //Home screen constructor
    public HomeScreen()
    {
        /***************TABLE**************/
        //Sort the team list based on rank
        Team.sortList();
        try
        {
            //Pull data for table into a 2D array
            Object [] columnNames = {"#", "Team", "GP","WINS","PTS",
                "Miss", "Top", "Mid", "Low", "Sh %",
                "Bump", "Pen", "Def", "S Bal",
                "C Bal", "D Bal", "Brkdwns"};
            Object [][] data = new Object [Team.teamList.size()][17];

            //Copy in data from each team
            System.out.println("Loading stats table...");
            for(int x = 0; x < Team.teamList.size(); x++)
            {
                //Gets an array of the teams stats
                data[x] = Team.teamList.get(x).stats.statsArray(x);
            }//End of for loop

            //Create new table
            System.out.println("Building table...");
            table = new JTable(data, columnNames);
            table.setBackground(new Color(255, 248, 180));
            table.setPreferredScrollableViewportSize(new Dimension(680, 510));
            table.setFillsViewportHeight(true);
            table.setRowSelectionAllowed(false);
            table.setAutoCreateRowSorter(true);

            //Set column and row sizes
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int [] sizes = {30, 50, 30, 40, 30, 40, 40, 40, 40, 50, 50, 40,
                35, 40, 40, 40, 45};
            setColumnWidths(table, sizes);

            //Create new scroll pane containing table
            scrollPane = new JScrollPane(this.table);
        }
        catch(Exception e)
        {
            //Displays a message to catch any unexpected errors
            JOptionPane.showMessageDialog(null, "Error building table.");
        }

        //Add the components to the frame
        this.add(cmdScout);
        this.add(cmdSearch);
        this.add(cmdSearchBox);
        this.add(cmdImport);
        this.add(cmdExport);
        this.add(cmdHelp);
        this.add(cmdBack);
        this.add(scrollPane);
        this.add(txtSearch);
        this.add(lblBackground);

        //Resize and make buttons invisible
        GUIHelper.setupButton(cmdScout, 105, 35, false, false);
        GUIHelper.setupButton(cmdSearch, 105, 25, false, false);
        GUIHelper.setupButton(cmdSearchBox, 80, 20, false, false);
        GUIHelper.setupButton(cmdImport, 105, 35, false, false);
        GUIHelper.setupButton(cmdExport, 105, 35, false, false);
        GUIHelper.setupButton(cmdHelp, 105, 35, false, false);
        GUIHelper.setupButton(cmdBack, 105, 35, false, false);

        //Name the active objects
        cmdScout.setActionCommand("Scout");
        cmdImport.setActionCommand("Import");
        cmdExport.setActionCommand("Export");
        cmdHelp.setActionCommand("Help");
        cmdBack.setActionCommand("Back");
        cmdSearch.setActionCommand("Search");
        cmdSearchBox.setActionCommand("SearchBox");
        txtSearch.setActionCommand("Search");

        //Add the action listener to the active objects
        cmdScout.addActionListener(this);
        cmdImport.addActionListener(this);
        cmdExport.addActionListener(this);
        cmdHelp.addActionListener(this);
        cmdBack.addActionListener(this);
        cmdSearch.addActionListener(this);
        cmdSearchBox.addActionListener(this);
        txtSearch.addActionListener(this);

        //Set the layout for the frame
        this.getContentPane().setLayout(layout);

        //Set the west and north positions of the components on the frame
        GUIHelper.setLocation(cmdScout, layout, this.getContentPane(), 734, 137);
        GUIHelper.setLocation(cmdImport, layout, this.getContentPane(), 734, 195);
        GUIHelper.setLocation(cmdExport, layout, this.getContentPane(), 734, 253);
        GUIHelper.setLocation(cmdHelp, layout, this.getContentPane(), 734, 555);
        GUIHelper.setLocation(cmdBack, layout, this.getContentPane(), 734, 604);
        GUIHelper.setLocation(scrollPane, layout, this.getContentPane(), 20, 80);
        GUIHelper.setLocation(cmdSearch, layout, this.getContentPane(), 734, 465);
        GUIHelper.setLocation(cmdSearchBox, layout, this.getContentPane(), 746, 435);
        GUIHelper.setLocation(txtSearch, layout, this.getContentPane(), 735, 435);

        //Call "set up" methods for the frame object
        this.setUndecorated(false);
        this.setSize(857,679);
        this.setResizable(false);
        setLocationRelativeTo(null);
        if(Team.filename != null)
            this.setTitle("ReboundScout | " + Team.filename);
        else
            this.setTitle("ReboundScout");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//End of HomeScreen()

    //Method to set column widths
    public static void setColumnWidths(JTable table, int [] sizes)
    {
        //Loop through columns, setting the respective sizes
        for(int x = 0; x < sizes.length; x++)
            table.getColumnModel().getColumn(x).setPreferredWidth(sizes[x]);

    }//End of setColumnWidths()

    //Method to clear the current team object of imported files
    private void clearCache()
    {
        Team.teamList = new ArrayList<Team>();
        Team.filename = new String();
    }//End of clearCache()

    //Method to import a file to the database
    private void importFile()
    {
        //Declare temp variables
        String importFile = "";

        //Display information on file importing
        if(JOptionPane.showConfirmDialog(null, "When you import a file, it appends "
                + " the stats from the file to the current database.\n\n "
                + "WARNING: You will not be able to undo this function." + "",
                "Import",
                JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0)
        {
            try
            {
                //Import data from new file selected via file browser
                importFile = getFileToOpen();
                Team.importFromFile(importFile);

                //Save updates
                Team.saveToFile();

            }catch (IOException ex)
            {
                if(!importFile.equals(""))
                    JOptionPane.showMessageDialog(null, "Error importing file.");
            }//End of try/catch
        }//End of if statement
    }//End of importFile()

    //Method to display file browser to user and return the file path of the selected file
    public String getFileToOpen() throws IOException
    {
        //Create temp variable
        String filename = "";

        //Create file chooser
        JFileChooser chooser = new JFileChooser();

        //Set file type filter
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
            filename = chooser.getSelectedFile().getPath();
        }

        return filename;
    }//End of getFileToOpen

    //Opens the selected team profile
    public void search()
    {
    	//Declaring variables
    	int teamSearch = 0;
    	boolean found = false;

    	//Finding team name
    	teamSearch = Integer.parseInt(txtSearch.getText());

    	//Checking if Team object exists
    	if(Team.getTeamIndex(teamSearch) != -1)
    	{
            TeamProfile frame = new TeamProfile(Team.teamList.get(Team.getTeamIndex(teamSearch)));
            this.setVisible(false);
    	}
    	else
            JOptionPane.showMessageDialog(null, "This team number not found.");
    }//End of search method

	//Determines which component has been selected and calls the appropriate method.
    public void actionPerformed(ActionEvent e)
    {
    	try
    	{
            if (e.getActionCommand().equals("Scout"))
                    {
                //Creates an instance of the scout frame
                ScouterScreen a = new ScouterScreen();

                //Hide the page
                this.setVisible(false);
                    }
            else if (e.getActionCommand().equals("Import"))
            {
                //Method call to import data from file
                importFile();

                //Reload the screen with updated table
                HomeScreen a = new HomeScreen();

                //Hide the old page
                this.setVisible(false);
            }
            else if (e.getActionCommand().equals("Export"))
            {
                JOptionPane.showMessageDialog(null, "To export stats for use of"
                        + " another computer: \n\n1. Copy the database text file to"
                        + " the new computer \n2. Open the database you wish to"
                        + " import into \n3. Click import and select the file");
            }
            else if (e.getActionCommand().equals("SearchBox"))
            {
                txtSearch.setText(null);
                txtSearch.grabFocus();
            }
            else if (e.getActionCommand().equals("Search"))
            {
                search();
            }
            else if (e.getActionCommand().equals("Help"))
            {
                Help a = new Help();
            }
            else if (e.getActionCommand().equals("Back"))
            {
                //Create a new instance of the welcome screen
                if( JOptionPane.showConfirmDialog(null, "Continuing will "
                        + "close your current file. Continue anyways?",
                        "Import", JOptionPane.CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE) == 0)
                {
                    //Clear cached database
                    clearCache();

                    WelcomeScreen a = new WelcomeScreen();
                }

                //Hide this page
                this.setVisible(false);
            }
    	}//End of try
    	catch(Exception ex)
    	{
            JOptionPane.showMessageDialog(null, "Please enter a valid team number.");
    	}
    }//End of actionPerformed()
}//End of class