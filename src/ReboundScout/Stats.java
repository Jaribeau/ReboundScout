/* Name:    Jared Baribeau and Carson Ennis
 * Date:    June 19,2012
 * Clas:    Stats
 */

/*The purpose of this class is to organise all the stat fields into one container. This is where the stats are updated when the user
 *submits the stats from the scout page. This is also where the values for the tables are read from.
 */

package ReboundScout;

//Importing packages
import java.text.NumberFormat;

public class Stats
{
    //Declaring private fields
    private int points;						//The number of points accrued by the team
    private int gamesPlayed;				//The number of games played
    private int wins;						//The number of wins accrued by the team
    private int shotsMissed;				//The number of missed shots
    private int topShotsScored;				//The number of shots that went in the top basket
    private int midShotsScored;				//The number of shots that went in the middle baskets
    private int lowShotsScored;				//The number of shots that went in the low baskets
    private int numBumpCrossed;				//The number of times the robot crossed the centre bump
    private int numPenalties;				//The number of penalties incurred by the robot
    private int numDefenseMoves;			//The number of defensive moves made by the robot
    private int numSingleBalances;			//The number of single balances made by the robot
    private int numCoopBalances;			//The number of co-op balances made by the robot
    private int numDoubleBalances;			//The number of double balances made by the robot
    private double shootingPercentage;		//The calculated shooting percentage of the robot
    private int numBreakdowns;				//The number of times the robot became disabled during match play
    private String comments;				//Any comments entered by the user

    //Default Constructor
    public Stats()
    {
        points = 0;
        gamesPlayed = 0;
        wins = 0;
        shotsMissed = 0;
        topShotsScored = 0;
        midShotsScored = 0;
        lowShotsScored = 0;
        numBumpCrossed = 0;
        numPenalties = 0;
        numDefenseMoves = 0;
        numSingleBalances = 0;
        numSingleBalances = 0;
        numCoopBalances = 0;
        numDoubleBalances = 0;
        shootingPercentage = 0.0;
        numBreakdowns = 0;
        comments = "";
    }//End of default constuctor method

    //Calculates the robots shooting percentage
    public double calculateShootingPercentage()
    {
        //Create decimalFormat and currencyFormat objects
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        nf.setMinimumFractionDigits(3);

        //Create temp variables
        int totalShots;
        double percent;

        totalShots = shotsMissed + topShotsScored + midShotsScored + lowShotsScored;
        percent = Double.parseDouble(nf.format((totalShots - shotsMissed * 1.0) / totalShots));

        return percent;
    }//End of calculateShootingPercentage method

   //Method to calculate rank of the team based on game and co-op balance pts
   public int calculatePoints()
   {
       points = (wins * 2) + (numCoopBalances * 2);

       return points;
   }//End of calculateRank()
   
   public double calculateBasketPtsPerMatch()
   {
        //Create decimalFormat and currencyFormat objects
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        nf.setMinimumFractionDigits(3);
        
       //Declare temp variables
       double ptsPerMatch;
       
       ptsPerMatch = Double.parseDouble(nf.format((topShotsScored * 3 + midShotsScored * 2 + lowShotsScored * 1) / gamesPlayed));
       
       return ptsPerMatch;
   }//End of calculatePtsPerMatch()

    //Method to add the stats to the corresponding fields
    public void addToStats(int gamesPlayed, int wins, int shotsMissed, int topShotsScored, int midShotsScored, int lowShotsScored, int numBumpCrossed, int numPenalties, int numDefenseMoves, int numSingleBalances, int numCoopBalances, int numDoubleBalances, int numBreakdowns, String comments)
    {
        //Incerement corresponding stats
        this.gamesPlayed += gamesPlayed;
        this.wins += wins;
        this.shotsMissed += shotsMissed;
        this.topShotsScored += topShotsScored;
        this.midShotsScored += midShotsScored;
        this.lowShotsScored += lowShotsScored;
        this.numBumpCrossed += numBumpCrossed;
        this.numPenalties += numPenalties;
        this.numDefenseMoves += numDefenseMoves;
        this.numSingleBalances += numSingleBalances;
        this.numCoopBalances += numCoopBalances;
        this.numDoubleBalances += numDoubleBalances;
        this.numBreakdowns += numBreakdowns;
        this.comments += comments;
    }//End of addToStats()

    //Method to return an array of stats
    public Object [] statsArray(int x)
    {
        Object [] statsArray = new Object[18];

            //Create temp y index counter
            int y = 0;

            //Assign stats to array if team is set to be displayed
            if(Team.teamList.get(x).getShowInTable() == true)
            {
                statsArray[y] = new Integer(x + 1);
                y++;
                statsArray[y] = Team.teamList.get(x).getTeamNumber();
                y++;
                statsArray[y] = new Integer(gamesPlayed);
                y++;
                statsArray[y] = new Integer(wins);
                y++;
                statsArray[y] = new Integer(calculatePoints());
                y++;
                statsArray[y] = new Integer(shotsMissed);
                y++;
                statsArray[y] = new Integer(topShotsScored);
                y++;
                statsArray[y] = new Integer(midShotsScored);
                y++;
                statsArray[y] = new Integer(lowShotsScored);
                y++;
                statsArray[y] = new Double(calculateShootingPercentage());
                y++;
                statsArray[y] = new Integer(numBumpCrossed);
                y++;
                statsArray[y] = new Integer(numPenalties);
                y++;
                statsArray[y] = new Integer(numDefenseMoves);
                y++;
                statsArray[y] = new Integer(numSingleBalances);
                y++;
                statsArray[y] = new Integer(numCoopBalances);
                y++;
                statsArray[y] = new Integer(numDoubleBalances);
                y++;
                statsArray[y] = new Integer(numBreakdowns);
                y++;
                statsArray[y] = new Double(calculateBasketPtsPerMatch());
            }
            else    //Adds only the team number to the table if set to hidden
            {
                statsArray[y] = new Integer(x + 1);
                y++;
                statsArray[y] = Team.teamList.get(x).getTeamNumber();
                y++;
            }

        return statsArray;
    }//End of statsArray()

    //************************
    //*** ACCESSOR METHODS ***
    //************************

    //Returns the number of games played
    public int getGamesPlayed()
    {
        return gamesPlayed;
    }//End of getGamesPlayed method

    //Returns the number of missed shots
    public int getShotsMissed()
    {
        return shotsMissed;
    }//End of getShotsMissed method

    //Returns the number of top shots scored
    public int getTopShotsScored()
    {
        return topShotsScored;
    }//End of getTopShotsScored method

    //Returns the number of mid shots scored
    public int getMidShotsScored()
    {
        return midShotsScored;
    }//End of getMidShotsScored method

    //Returns the number of low shots scored
    public int getLowShotsScored()
    {
        return lowShotsScored;
    }//End of getLowShotsScored method

    //Returns the number of times the robot crosses the centre bump
    public int getNumBumpCrossed()
    {
        return numBumpCrossed;
    }//End of getNumBumpCrossed method

    //Returns the number of penalties
    public int getNumPenalties()
    {
        return numPenalties;
    }//End of getPenalties method

    //Returns the number of defensive moves made
    public int getNumDefenseMoves()
    {
        return numDefenseMoves;
    }//End of getNumDefenseMoves method

    //Returns the number of single balances made by the robot
    public int getNumSingleBalances()
    {
        return numSingleBalances;
    }//End of getNumSingleBalances method

    //Returns the number of coop balances made by the robot
    public int getNumCoopBalances()
    {
        return numCoopBalances;
    }//End of getNumCoopBalances method

    //Returns the number of double balances
    public int getNumDoubleBalances()
    {
        return numDoubleBalances;
    }//End of getNumDoubleBalances method

    //Returns the robot's shooting percentage
    public double getShootingPercentage()
    {
        return shootingPercentage;
    }//End of getShootingPercentage method

    //Returns the number of breakdowns
    public int getNumBreakdowns()
    {
        return numBreakdowns;
    }//End of getNumBreakdowns method

    //Returns the comments about the robot
    public String getComments()
    {
        return comments;
    }//End of getComments method

    //*************************
    //**** MUTATOR METHODS ****
    //*************************

    //Sets the value of games played
    public void setGamesPlayed(int newgp)
    {
        gamesPlayed = newgp;
    }//End of setGamesPlayed method

    //Sets the value of missed shots
    public void setMissedShots(int newMiss)
    {
        shotsMissed = newMiss;
    }//End of setMissedShots method

    //Sets the value of low shots
    public void setLowShotsScored(int newLow)
    {
        lowShotsScored = newLow;
    }//End of setLowShotsScored method

    //Sets the value of midShotsScored
    public void setMidShotsScored(int newMid)
    {
        midShotsScored = newMid;
    }//End of setMidShotsScored method

    //Sets the value of topShotsScored
    public void setTopShotsScored(int newTop)
    {
        topShotsScored = newTop;
    }//End of setTopShotsScored method

    //Sets the value of numBumpCrossed
    public void setNumBumpCrosses(int newNum)
    {
        numBumpCrossed = newNum;
    }//End of setNumBumpCrosses method

    //Sets the value of numDefenseMoves
    public void setNumDefenseMoves(int newNum)
    {
        numDefenseMoves = newNum;
    }//End of setNumDefenseMoves method

    //Sets the value of numPenalties
    public void setNumPenalties(int newNum)
    {
        numPenalties = newNum;
    }//End of setNumPenalties method

    //Sets the value of setSingleBalances
    public void setSingleBalances(int newNum)
    {
        numSingleBalances = newNum;
    }//End of setSingleBalances method

    //Sets the value of setCoopBalances
    public void setCoopBalances(int newNum)
    {
        numCoopBalances = newNum;
    }//End of setSingleBalances method

     //Sets the value of setDoubleBalances
    public void setNumDoubleBalances(int newNum)
    {
        numDoubleBalances = newNum;
    }//End of setTopShotsScored method

    //Sets the value of shootingPercentage
    public void setShootingPercentage(double newShoot)
    {
        shootingPercentage = newShoot;
    }//End of setShootingPercentage method

    //Sets the comments
    public void setComments(String newComments)
    {
        comments = newComments;
    }//End of setComments method

    //Sets the number of breakdowns experienced by the robot
    public void setNumBreakdowns(int newNum)
    {
        numBreakdowns = newNum;
    }//End of setNumBreakdowns method

    //Creates a String representation of the Stats object
    @Override
    public String toString()
    {
        //Create temp output field
        String state;

        state = comments + ", ";
        state += shotsMissed + ", ";
        state += topShotsScored + ", ";
        state += midShotsScored + ", ";
        state += lowShotsScored + ", ";
        state += numBumpCrossed + ", ";
        state += numPenalties + ", ";
        state += numDefenseMoves + ", ";
        state += numSingleBalances + ", ";
        state += numCoopBalances + ", ";
        state += numDoubleBalances + ", ";
        state += numBreakdowns;

        return state;
    }//End of toString

    //Creates an array representation of the stats data
    public String [] toArray()
    {
        //Create temp output field
        String state [] = new String[14];
        int x = 0;

        state[x] = comments;
        x++;
        state[x] = gamesPlayed + "";
        x++;
        state[x] = wins + "";
        x++;        
        state[x] = shotsMissed + "";
        x++;
        state[x] = topShotsScored + "";
        x++;
        state[x] = midShotsScored + "";
        x++;
        state[x] = lowShotsScored + "";
        x++;
        state[x] = numBumpCrossed + "";
        x++;
        state[x] = numPenalties + "";
        x++;
        state[x] = numDefenseMoves + "";
        x++;
        state[x] = numSingleBalances + "";
        x++;
        state[x] = numCoopBalances + "";
        x++;
        state[x] = numDoubleBalances + "";
        x++;
        state[x] = numBreakdowns + "";

        return state;
    }//End of toString
}//End of class