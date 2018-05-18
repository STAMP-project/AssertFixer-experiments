/**
 * @author Pavel Belov
 * Lab №1 Task 4
 * Minimizing  of numbers diapason. For exaple from 1,2,4,5,6,7,18,19,20,21 to 1,2,4-7,18-21
 */

class minimizeDiapasone {
    private String output = new String();
    boolean flag = false;

    //Minimize diapasone method
    public String minimize(String s) {
        String[] arr = s.split(",");
        //finding diapasone and forming the string
        for (int i = 1; i < arr.length; i++) {
            if ((Integer.parseInt(arr[i]) == Integer.parseInt(arr[i - 1]) + 1) && flag == false) {
                output += arr[i - 1] + "-";
                flag = true;
            } else if ((Integer.parseInt(arr[i]) == Integer.parseInt(arr[i - 1]) + 1) && flag == true) {
                if (i == arr.length - 1)
                    output += arr[i];
            continue;
            } else if ((Integer.parseInt(arr[i]) != Integer.parseInt(arr[i - 1]) + 1) && flag == true) {
                output += arr[i - 1] + ",";
                flag = false;
            } else
                output += arr[i - 1] + ",";
            if (i == arr.length - 1)
                output += arr[i];
    }
    return output;
}

    public static void main(String[] args){
        String str = args[0];
        minimizeDiapasone minString = new minimizeDiapasone();
        System.out.println(minString.minimize(str));
    }
}

