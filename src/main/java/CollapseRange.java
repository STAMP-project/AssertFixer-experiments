import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Nasibulin
 * Date: 18.09.18
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class CollapseRange {
    public static void main(String args[]) {
        // String to be scanned to find the pattern.
        String line = "1,2,3,4,5,6,7,8,9,10,11,12,14,17,19,20,21,22,23,25,26,30,35,41";
        //String line = "1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,20";

        String pattern = "(\\d+)(,*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        Matcher n = r.matcher(line);
        Matcher o = r.matcher(line);
        StringBuffer result = new StringBuffer();
        int check = 0;
        while (m.find() & n.find() & o.find()) {
            int i = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(n.group(1));
            int k = Integer.parseInt(o.group(1));
            String s = "";
            if (n.find(m.end()) & o.find(n.end())) {
                //    String s = "";
                //System.out.println(i + "\t" + j + "\t " + k);
                if ((i == j) & (j == k)) {
                    s += "" + i;
                } else if ((i + 1 == j) & (j + 1 == k)) {
                    s += "";
                } else if ((i + 1 == j) & (j + 1 != k) & (check + 1 == i)) {
                    s += "-" + j;
                } else if ((i + 1 == j) & (j + 1 != k) & (check + 1 != i)) {
                    s += "," + j;
                } else if (i + 1 != j) {
                    s += "," + j;
                }
                //System.out.println(i+" "+j+" "+k+" "+check);

                //    m.appendReplacement(result, s);
            }

            if (o.end() == line.length() & j + 1 == k) s += "-" + k;
            if (o.end() == line.length() & j + 1 != k) s += "," + k;
            m.appendReplacement(result, s);
            check = i;

            //System.out.println(result.toString());
        }
        //System.out.println(result.toString());
        //m.appendTail(result);
        System.out.println(result.toString());
    }

    public static String CollapseRange(String line){
        String pattern = "(\\d+)(,*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        Matcher n = r.matcher(line);
        Matcher o = r.matcher(line);
        StringBuffer result = new StringBuffer();
        int check = 0;
        while (m.find() & n.find() & o.find()) {
            int i = Integer.parseInt(m.group(1));
            int j = Integer.parseInt(n.group(1));
            int k = Integer.parseInt(o.group(1));
            String s = "";
            if (n.find(m.end()) & o.find(n.end())) {
                //    String s = "";
                //System.out.println(i + "\t" + j + "\t " + k);
                if ((i == j) & (j == k)) {
                    s += "" + i;
                } else if ((i + 1 == j) & (j + 1 == k)) {
                    s += "";
                } else if ((i + 1 == j) & (j + 1 != k) & (check + 1 == i)) {
                    s += "-" + j;
                } else if ((i + 1 == j) & (j + 1 != k) & (check + 1 != i)) {
                    s += "," + j;
                } else if (i + 1 != j) {
                    s += "," + j;
                }
                //System.out.println(i+" "+j+" "+k+" "+check);

                //    m.appendReplacement(result, s);
            }

            if (o.end() == line.length() & j + 1 == k) s += "-" + k;
            if (o.end() == line.length() & j + 1 != k) s += "," + k;
            m.appendReplacement(result, s);
            check = i;

            //System.out.println(result.toString());
        }
        //System.out.println(result.toString());
        //m.appendTail(result);
        return result.toString();


    }

}