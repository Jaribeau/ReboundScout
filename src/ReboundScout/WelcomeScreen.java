/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    WelcomeScreen
 */

/*
 * The purpose of this class is to be the starting GUI screen for the program.
 * From this screen the user can decide if they want to create a new file, open
 * and old one, read the help file, or close the program.
 */

package ReboundScout;

//Importing packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class WelcomeScreen extends JFrame implements ActionListener
{
    //Create instances of the GUI component.
    JButton cmdNew = new JButton();													//Creates a new file and opens Home screen
    JButton cmdOpen = new JButton();												//Opens an existing file and opens Home screen
    JButton cmdHelp = new JButton();												//Opens the help message
    JButton cmdClose = new JButton();												//Closes the program
    JLabel lblBackground = new JLabel(new ImageIcon("src/Images/WelcomeScreen.jpg"));	//The background image

    //Create an instance of the layout manager
    SpringLayout layout = new SpringLayout();

    public WelcomeScreen()
    {
    	//Adding components to the frame
	this.add(cmdNew);
	this.add(cmdOpen);
	this.add(cmdHelp);
	this.add(cmdClose);
	this.add(lblBackground);

    	//Naming the button
    	cmdNew.setActionCommand("New");
    	cmdOpen.setActionCommand("Open");
    	cmdHelp.setActionCommand("Help");
    	cmdClose.setActionCommand("Close");

	//Resize and make buttons invisible
        GUIHelper.setupButton(cmdNew, 105, 35, false, false);
        GUIHelper.setupButton(cmdOpen, 105, 35, false, false);
        GUIHelper.setupButton(cmdHelp, 105, 35, false, false);
        GUIHelper.setupButton(cmdClose, 105, 35, false, false);

    	//Add the action listener
    	cmdNew.addActionListener(this);
    	cmdOpen.addActionListener(this);
    	cmdHelp.addActionListener(this);
    	cmdClose.addActionListener(this);

    	//Setting the layout for the frame
    	this.getContentPane().setLayout(layout);

    	//Set the components positions
        GUIHelper.setLocation(cmdNew, layout, this.getContentPane(), 173, 292);
        GUIHelper.setLocation(cmdOpen, layout, this.getContentPane(), 173, 340);
        GUIHelper.setLocation(cmdHelp, layout, this.getContentPane(), 173, 388);
        GUIHelper.setLocation(cmdClose, layout, this.getContentPane(), 173, 436);
        GUIHelper.setLocation(lblBackground, layout, this.getContentPane(), 0, 0);

	//Set up the frame
	this.setSize(455,525);
	setLocationRelativeTo(null);
	setResizable(false);
	setTitle("ReboundScout | Welcome");
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }//End of constructor method

    //Method to display file browser to user and return the file path of the selected file
    public String getFileToOpen()
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

    //Opens the frame of HomeScreen and passes in a static Team object
    public void openHomeScreen(String filename)
    {
        //Create static team object
        Team team = new Team();
        try
        {
            Team.setFilename(filename);
            Team.importFromFile(filename);
        }
        catch (IOException ex)
        {
                System.out.println("Error importing data from file. " + ex
                        + "\nEnsure file is formatted properly.");
        }
        //Initialize home screen
        System.out.println("Opening home screen...");
        HomeScreen frame = new HomeScreen();
        this.setVisible(false);
    }//End of openHomeScreen method

    //Method to create a new, blank text database file
    private String createNewTextFile() throws IOException
    {
        //Create temp variables
        boolean fileCreated = false;    //Flag to indicate if the file exists already
        int x = 1;                      //Counter for file name modifier
        String filename = "";           //File name string

        //Create the blank file as database1.txt or database2.txt etc if taken
        do
        {
            //Set file name
            filename = ("database" + x + ".txt");

            //Create File object
            File file = new File(filename);

            //Create the file
            try
            {
                fileCreated = file.createNewFile();
            }
            catch(IOException ioe)
            {
                System.out.println("Error while creating a new empty file:" + ioe);
            }

            //Increment name modifier
            x++;
        }while(fileCreated == false);

        return filename;
    }//End of createNewTextFile()

    //Selects which action to perform
    public void actionPerformed(ActionEvent evt)
    {
    	try
    	{
            //Check if button has been selected
            if (evt.getActionCommand().equals("New"))
            {
                openHomeScreen(createNewTextFile());
            }
            else if (evt.getActionCommand().equals("Open"))
            {
                System.out.println("Opening file browser...");

                //Create temp filename string
                String file = getFileToOpen();
                if(!file.equals(""))
                    openHomeScreen(file);
            }
            else if (evt.getActionCommand().equals("Help"))
            {
                Help a = new Help();
                a.a.scrollToReference("Section 4.");
            }
            else if (evt.getActionCommand().equals("Close"))
            {
                System.exit(0);
            }
    	}//End of try
    	catch(Exception ex)
    	{
                System.out.println("Error opening file: " + ex);
    	}//End of catch
    }//End of actionPerformed
}//End of class