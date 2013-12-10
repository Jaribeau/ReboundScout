/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    Team
 */

/* 
 * Class Description:
 *  This class is intended to contain all of the information about a team, as 
 * well as take care of all functionality directly related to this data.
 */

package ReboundScout;

//Importing packages
import java.io.*;
import java.util.ArrayList;

public class Team
{
    //Declare class fields
    public static ArrayList <Team> teamList = new ArrayList <Team>();	//A list of all the Team objects
    public static String filename;										//The file being read

    //Declare private fields
    private String teamName;		//The name of the team
    private int teamNumber;			//The team number
    private String robotShape;		//The description of the shape
    private String launcherType;	//The description of the launcher type
    private String driveType;		//The description of the drive type
    private boolean showInTable;	//Whether or not the values will be omitted from the Home screen table
    public Stats stats;			//An object to contain all the team's stats.

  //Default Constructor
  public Team()
  {
      teamName = "";
      teamNumber = 0;
      robotShape = "";
      launcherType = "";
      driveType = "";
      showInTable = true;
      stats = new Stats();
  }//End of default/index constructor

  //Object constructor for a new team
  public Team(int teamNumber)
  {
        //Set team number
        this.teamNumber = teamNumber;
        showInTable = true;
        stats = new Stats();
  }//End of constructor method

  //Method to create a new team in the teamList array
  public static void addTeam(int teamNumber)
  {
        //Create new team object
        teamList.add(new Team(teamNumber));
   }//End of addTeam()

   //Adds a team to the arraylist without creating a new one
   public static void addNewTeam(Team a)
   {
        teamList.add(a);
   }//End of addNewTeam method

   //Removes a team from the arrayList
   public static void removeTeam(int teamNum)
   {
        //Declaring variables
        int index = 0;
        index = getTeamIndex(teamNum);
        teamList.remove(index);
   }//End of removeTeam method

   //Method to add data to the corresponding fields
   public void saveToProfile(int teamNumber, int gamesPlayed, int wins, int shotsMissed, int topShotsScored, int midShotsScored, int lowShotsScored, int numBumpCrossed, int numPenalties, int numDefenseMoves, int numSingleBalances, int numCoopBalances, int numDoubleBalances, int brokeDown, String comments)
   {
       //Find team's index in teamList array
       int index;
       index = getTeamIndex(teamNumber);

       //Add data to stats object
       teamList.get(index).stats.addToStats(gamesPlayed, wins, shotsMissed, topShotsScored, midShotsScored, lowShotsScored, numBumpCrossed, numPenalties, numDefenseMoves, numSingleBalances, numCoopBalances, numDoubleBalances, brokeDown, comments);
   }//End of saveToProfile()

   //Method to return a team's index in the teamList array
   public static int getTeamIndex(int teamNumber)
   {
       //Declare temp variables
       int index = -1;

       //Scan teamList array for team
       for(int x = 0; x < teamList.size(); x++)
       {
           if(teamList.get(x).getTeamNumber() == teamNumber)
           {
               index = x;
               break;
           }//End of if clause
       }//End of for loop

       return index;
   }//End of getTeamIndex

   //Method to write all data for each team to the file
   public static void saveToFile() throws IOException
   {
       //Print update
        System.out.println("Saving to " + filename);

        //Create print writer, no append
        PrintWriter output = new PrintWriter(new BufferedWriter (new FileWriter(filename)));

        //Write each team's data to file
        for(int x = 0; x < teamList.size(); x++)
            for(int n = 0; n < 19; n++)
            {
                output.println(teamList.get(x).toArray()[n]);
                System.out.println("Saving line:   " + teamList.get(x).toArray()[n]);
            }
        //Close file
        output.close();
   }//End of saveToFile()

   //Reads in data from a file and assigns it to the fields
   public static void importFromFile(String filename) throws IOException
   {
       //Creates new BufferedReader object
       System.out.println("Opening " + filename + "...");       //TEST********
       BufferedReader in = new BufferedReader(new FileReader(filename));

       //Declare and initialize temp variables
       int tempNum;
       int tempIndex;
       String input;

       //Loops through each object until end of file.
       System.out.println("Loading team data...");
       while(0 < 1)
       {
           //Read team number, break loop if end of file
           input = in.readLine();
           if(input == null)
               break;

           //Find team's index in list
           tempNum = Integer.parseInt(input);
           tempIndex = getTeamIndex(tempNum);

           //Create new team object if team does not exist
            if(tempIndex == -1)
            {
                addTeam(tempNum);
                tempIndex = getTeamIndex(tempNum);
            }//End of if statement

            //Get info and add stats from file
            teamList.get(tempIndex).assignFieldsFromFile(tempIndex, in);
       }//End of while loop

       //Sorts the team list based on team number for an organized database and default table order
       System.out.println("Sorting list...");
       sortList();

       //Closes the file
       in.close();
   }//End of readFromFile method

   //Helper method to set fields from a file
   private void assignFieldsFromFile(int tempIndex, BufferedReader in) throws IOException
   {
        //Reading in team info fields
        teamList.get(tempIndex).teamName = in.readLine();
        teamList.get(tempIndex).robotShape = in.readLine();
        teamList.get(tempIndex).launcherType = in.readLine();
        teamList.get(tempIndex).driveType = in.readLine();

        //Reading in stats field and save to profile
        String tempComments = in.readLine();
        int gamesPlayed = Integer.parseInt(in.readLine());
        int wins = Integer.parseInt(in.readLine());
        int tempShotsMissed = Integer.parseInt(in.readLine());
        int tempTopShotsScored = Integer.parseInt(in.readLine());
        int tempMidShotsScored = Integer.parseInt(in.readLine());
        int tempLowShotsScored = Integer.parseInt(in.readLine());
        int tempNumBumpCrossed = Integer.parseInt(in.readLine());
        int tempNumPenalties = Integer.parseInt(in.readLine());
        int tempNumDefenseMoves = Integer.parseInt(in.readLine());
        int tempNumSingleBalances = Integer.parseInt(in.readLine());
        int tempNumCoopBalances = Integer.parseInt(in.readLine());
        int tempNumDoubleBalances = Integer.parseInt(in.readLine());
        int tempNumBreakdowns = Integer.parseInt(in.readLine());

        //Add to profile
        saveToProfile(teamNumber, gamesPlayed, wins, tempShotsMissed, tempTopShotsScored, tempMidShotsScored, tempLowShotsScored, tempNumBumpCrossed, tempNumPenalties, tempNumDefenseMoves, tempNumSingleBalances, tempNumCoopBalances, tempNumDoubleBalances, tempNumBreakdowns, tempComments);
   }//End of assignFieldsFromFile()

   //Method to sort the team list by rank
   public static void sortList()
   {
    	//Declare temp variables
    	int max;
        Team temp;

        //Traverse array until sorted
        for(int index = 0; index < teamList.size(); index++)
        {
            max = index;
            for(int scan = index + 1; scan < teamList.size(); scan++)
                if(teamList.get(scan).stats.calculatePoints() > (teamList.get(max).stats.calculatePoints()))
                    max = scan;

            //Swap the teams
            temp = teamList.get(max);
            teamList.set(max, teamList.get(index));
            teamList.set(index, temp);
        }//End of for loop
   }//End of sortList()


   //************************
   //*** ACCESSOR METHODS ***
   //************************

   //Returns the team's name
   public String getTeamName()
   {
       return teamName;
   }//End of getTeamName method

   //Returns the team's number
   public int getTeamNumber()
   {
       return teamNumber;
   }//End of getTeamNumber method

   //Returns a description of the robot's shape
   public String getRobotShape()
   {
       return robotShape;
   }//End of getRobotShape method

   //Returns a description of the robot's launcher mechanism
   public String getLauncherType()
   {
       return launcherType;
   }//End of getLauncherType method

   //Returns a description of the robot's drive mechanism
   public String getDriveType()
   {
       return driveType;
   }//End of getDriveType method

   public boolean getShowInTable()
   {
   		return showInTable;
   }//End of getShowInTable()

   //Returns the robot's stats
   public Stats getStats()
   {
       return stats;
   }//End of getStats method

   //Returns the file location
   public static String getFilename()
   {
       return filename;
   }//End of getFilename method

   //*****************************
   //***** MUTATOR METHODS *******
   //*****************************

   //Changes the team's name
   public void setTeamName(String newTeamName)
   {
       teamName = newTeamName;
   }//End of setTeamName method

   //Changes the team's number
   public void setTeamNumber(int newTeamNum)
   {
       teamNumber = newTeamNum;
   }//End of setTeamNumber method

   //Changes the description of the robot's shape
   public void setRobotShape(String newDesc)
   {
       robotShape = newDesc;
   }//End of setRobotShape method

   //Changes the description of the launcher
   public void setLauncherType(String newDesc)
   {
       launcherType = newDesc;
   }//End of setLauncherType method

   //Changes the description of the robot's drive mechanism
   public void setDriveType(String newDesc)
   {
       driveType = newDesc;
   }//End of setDriveType method

   //Method to set showInTable
   public void setShowInTable(boolean b)
   {
        showInTable = b;
   }//End of setShowInTable()

   //Changes the robot's stat line to a new set of Stats
   public void setStats(Stats newStats)
   {
       stats = newStats;
   }//End of setStats method

   //Changes the file location
   public static void setFilename(String newFilename)
   {
       filename = newFilename;
   }//End of setStats method

   //Method to print the state of the object
   public String [] toArray()
   {
   	//Create temp output variable
   	String output[] = new String[19];

        //Add data to output String
        int x = 0;
   	output[x] = teamNumber + "";
        x++;
   	output[x] = teamName + "";
        x++;
   	output[x] = robotShape + "";
        x++;
        output[x] = launcherType + "";
        x++;
   	output[x] = driveType + "";
        x++;
        System.arraycopy(stats.toArray(), 0, output, x, stats.toArray().length);

   	return output;
   }//End of toString()

   //Method to print the state of the object
   @Override
   public String toString()
   {
   	//Create temp output variable
   	String output = "";

        //Add data to output String
   	output += teamNumber + ", ";
   	output += teamName + ", ";
   	output += robotShape + ", ";
        output += launcherType + ", ";
   	output += driveType + ", ";
   	output += stats.toString();

        System.out.println(output);
   	return output;
   }//End of toString()
}//End of class