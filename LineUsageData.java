import javax.sound.sampled.Line;

/**
 * Created by Ishrak on 11/20/2016.
 */
public class LineUsageData {

    private SinglyLinkedList<LineUsageData> list;
    private SinglyLinkedList<Usage> usageList;
    private final String lineID;
    public LineUsageData(String id){
        lineID = id;
        list = new SinglyLinkedList<LineUsageData>();
        usageList = new SinglyLinkedList<Usage>();
    }

    public Usage getMaxUsage(){
        // Doesn't do anythign special for a tie in usage
        int maxUsage = 0;
        Usage maxUsageNode = null;
        for (int i = 0; i< usageList.size(); i++ ){
            Usage currentUsageNode = usageList.get(i);
            if (currentUsageNode.getUsageCount() > maxUsage){
                maxUsage = currentUsageNode.getUsageCount();
                maxUsageNode = currentUsageNode;
            }
        }
        return maxUsageNode;
    }

    public void addObservation(String username){
        // Try to find the username in the usage object list. If it doesn't exist, then add the user name
        Usage foundUserUsage = null;
        for (int i = 0; i< usageList.size(); i++ ){
            Usage currentNode = usageList.get(i);
            if (currentNode.getUserName().equals(username)){
                foundUserUsage = currentNode;
                break;
            }
        }

        if (foundUserUsage == null){
            Usage newUserUsage = new Usage(username);
            usageList.add(newUserUsage);
        }
        else{
            foundUserUsage.incrementUsageCount();
        }
    }

    public String getLineID(){
        return lineID;
    }

    public int getSize(){
        return list.size();
    }
    public LineUsageData get(int i){
        return list.get(i);
    }

    public LineUsageData addNewLineDataToList(LineUsageData node){
        this.list.add(node);
        return node;
    }

    public LineUsageData getLineNodeByID(String id){
        LineUsageData foundNode = null;
        for (int i = 0; i< list.size(); i++ ){
            LineUsageData currentNode = list.get(i);
            String currentLineID = currentNode.getLineID();
            if (currentLineID.equals(id)){
                foundNode = currentNode;
                break;
            }
        }
        return foundNode;
    }
}
