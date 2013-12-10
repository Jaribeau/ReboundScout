/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    Main
 */

/*
 * The purpose of this class is to form a start point for running the program.
 */

/*The ReboundScout program is a Java application that was designed to keep track
 * of statistics related to the First Robotics competition of 2011-2012. The 
 * program does this by giving the user an interface in which they can easily 
 * increment various stat counters and adjust other values. The application then
 * uses the collected data and displays it in an organized and sortable table 
 * for the user�s convenience. While the software has many functions, a brief 
 * outline of important features of the application would include:
 *	- An interface to accurately record the stats
 *	- Writing recorded stats to a file
 *      - Open those files organizing the data into a table
 *      - Manipulating the data through addition, deletion, and sorting.
 *      - Displaying a detailed description of each robot with its stats and 
 *          specs. 
 */


/*      NOTE: For netbeans, image source should be "src/Images/----.jpg"
 *       For JCreator it should be "Images/----.jpg"
 * 
 */

package ReboundScout;

import java.io.IOException;	//Importing necessary packages.

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //Initialize Welcome Screen
        WelcomeScreen a = new WelcomeScreen();
    }//End of main method
}//End of class
