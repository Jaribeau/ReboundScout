/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    Help
 */

/*The purpose of this class is to provide an easy to navigate container for the 
 * Help text file to be displayed. This class can be accessed from any of the 
 * GUI windows, and serves to help the user understand any functions they may 
 * not know how to use.
 */

package ReboundScout;

//Importing packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Help extends JFrame implements ActionListener
{
    //Declaring object
    JEditorPane a;	//Container to hold JScrollPane with help.txt loaded into it.

    //Creating a new GridLayout
    GridLayout layout;

    //Default constructor
    public Help() throws IOException
    {
    	//Adding components to the frame
    	a = new JEditorPane(getClass().getResource("help.txt"));

        //Adds the filled EditorPane to the screen
        this.add(new JScrollPane(a, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));

    	//Setting the frame colour
    	layout = new GridLayout();
    	getContentPane().setBackground(Color.blue);

    	//Setting the layout for the frame
    	this.getContentPane().setLayout(layout);

        //Adding the help message to the scroll pane
    	a.setPreferredSize(new Dimension(500, 200));

        //Set up the frame
        this.setSize(1000, 500);
        setLocationRelativeTo(null);
        setTitle("Help");
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//End of constructor method

    //Selects which action to perform and calls the appropriate method
    public void actionPerformed(ActionEvent evt)
    {
        System.out.println("Action Performed.");
    }//End of actionPerformed
}//End of Help class