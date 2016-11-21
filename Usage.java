/**
 * Created by Ishrak on 11/20/2016.
 */
public class Usage {

    private final String userName;
    private int count;

    public Usage(String uname) {
        userName = uname;
        count = 1;
    }

    public int getUsageCount(){
        return count;
    }

    public void incrementUsageCount(){
        count++;
    }

    public String getUserName(){
        return userName;
    }
}
