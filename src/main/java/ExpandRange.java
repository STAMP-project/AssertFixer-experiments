import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 17.09.18
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class ExpandRange {

    public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "1,2,3,4-12,14,17,19-23,25,26,30,35,41";
        String pattern = "(\\d+)(-{1})(\\d+)(,{1})";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            int k = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(m.group(3));
            String s="";
            while (k<=j)
            {
                s+=k+",";
                k++;
            }
            m.appendReplacement(result,s);
        }
        //System.out.println(result.toString());
        m.appendTail(result);
        System.out.println(result.toString());

    }

    public static String ExpandRange(String line){

        String pattern = "(\\d+)(-{1})(\\d+)(,{1})";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            int k = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(m.group(3));
            String s="";
            while (k<=j)
            {
                s+=k+",";
                k++;
            }
            m.appendReplacement(result,s);
        }
        //System.out.println(result.toString());
        m.appendTail(result);
        return result.toString();


    }


}
