import java.util.*;
import java.io.*;

class GameScoreboard{
    public static void main(String[] args){
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader bufReadInput = new BufferedReader(inStream);
        
        final int NUM_SCORES = 100;
        String names[] = new String[NUM_SCORES];
        String name = "", gameName = "", scoreStr = "", output = "";
        int scores[] = new int[NUM_SCORES];

        FileWriter fw = null;
        PrintWriter pw = null;

        FileReader fr = null;
        BufferedReader bufReadFile = null;

        try{
            fw = new FileWriter("gameData.txt");
            pw = new PrintWriter(fw);
            
            while(true){
                System.out.printf("What is the title of your game? \n");
                try{
                    gameName = bufReadInput.readLine();
                    pw.printf("\t\t\t\t\t%s\n\n", gameName);
                    break;
                }catch(Exception error){
                    System.out.printf("%s", error);
                }
            }

            pw.printf("\t\t\t\t\tHIGH SCORE\n\n");
            pw.printf("RANK\t\t\t\t\tNAME\t\t\t\tSCORE\n");

            for(int i = 0; i < NUM_SCORES; i++){
                pw.printf(printLine(i+1, "***", 0));
            }
            
            pw.close();

        }catch(Exception err){
            System.out.printf("%s", err);
        }   


        // Read all scores from the gameData.txt file all names AND scores into suitable arrays.
            // For the scores, this will involve parsing Strings into integers and using string methods
            // Use Try-Catch with parsing
            // See shared starter code ‘smallDemo’ for help with string methods 

        // Randomly generate an integer value between 0 – 999,999,999 to be used as the current player’s score. 

        // Based on the random value, determine if the current user has made one of the top 100 scores.  
            // If so, prompt the user to enter their three initials otherwise detail to the user that their score has not made the top 100. If there is a tie in the scores, the newest person goes last. Only make scoreboard if you have beaten a listed score. 
            // Be certain that only three CAPITALIZED initials or fewer are recorded (Use String methods) e.g. “AB” is an acceptable but not “AAAA”
            // Control that only letters A-Z can be used. e.g. “BEF” is an acceptable entry not “$$$”

        // Update the scoreboard:
            // Write to file the current user’s score in the correct location inside the gameData.txt file. 

        // Printout, in order, the top 11 scores to the screen including their rank, initials and score. (See image above and match this look. Include the game name)
    }

    public static String getRank(int place){
        switch(place%10){
            case 1: return "ST";
            case 2: return "ND";
            case 3: return "RD";
            default: return "TH";
        }
    }

    public static String printLine(int rank, String name, int score){
        if(rank < 10)
            return rank + getRank(rank) + "\t\t\t\t\t\t"  + name + "\t\t\t\t\t" + score + '\n';
        else
            return rank + getRank(rank) + "\t\t\t\t\t"  + name + "\t\t\t\t\t" + score + '\n';
    }
}