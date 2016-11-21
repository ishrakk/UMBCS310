import java.io.File;
import java.util.Scanner;

public class TermReport {

    private static final int NumberOfLines = 500;
    public static void main(String[] args) {
	// Read from stdin
        Scanner reader;
        try {
            reader = new Scanner(new File("C:\\Users\\Ishrak\\IdeaProjects\\CS310\\testdata.txt"));
        }catch( Exception e){
            return;
        }
//        Scanner reader  = new Scanner(System.in);
        // Initialize the linked lisr wrapper LineUsageData
        LineUsageData computerList = new LineUsageData("#HEAD#");

        // Loop to collect all the data
        while(reader.hasNextLine()){
            String currentLogLine = reader.nextLine();
            String[] userAndComputerID = currentLogLine.split(" ");
            String currentUser = userAndComputerID[1];
            String computerID = userAndComputerID[0];

            LineUsageData foundNode = computerList.getLineNodeByID(computerID);

            if (foundNode == null){
                // Add a new node to the list of computers
                LineUsageData newNode = computerList.addNewLineDataToList(new LineUsageData(computerID));
                foundNode = newNode;
            }
            foundNode.addObservation(currentUser);
        }
        reader.close();

        // Print header line
        System.out.println("Line" + "\t" + "Most Common User" + "\t" + "Count");

        // Loop and print max usage for each line

        for (int i = 0; i < NumberOfLines; i++){
            // Initialize the default line to be printed if the specific computer info was not found
            String currentLineID = Integer.toString(i+1);
            String maxUserName = "<NONE>";
            String maxUsageCount = "0";


            LineUsageData currentComputerNode = computerList.getLineNodeByID(Integer.toString(i + 1));
            if (currentComputerNode != null)
            {
                currentLineID = Integer.toString(Integer.valueOf(currentComputerNode.getLineID()));
                maxUsageCount = Integer.toString(currentComputerNode.getMaxUsage().getUsageCount());
                maxUserName = currentComputerNode.getMaxUsage().getUserName();
            }
            // Print the data
            System.out.println(currentLineID + "\t\t" + maxUserName + "\t\t\t\t" + maxUsageCount);
        }

    }
}
