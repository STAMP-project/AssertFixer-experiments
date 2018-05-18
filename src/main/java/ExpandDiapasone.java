/**
 * @author Pavel Belov
 * Lab №1 Task 3
 * Expand diapasone of numbers. For expample, '1,2,4-7,18-21'' to 1,2,4,5,6,7,18,19,20,21.
 */

class expandDiapasone {
    public String expand(String s)
    {
        String[] arr = s.split("-");
        String k = "";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                String[] arr1 = arr[i].split(",");
                String[] arr2 = arr[i + 1].split(",");
                //beginning of diapasone
                int a = Integer.parseInt(arr1[arr1.length - 1]);
                //endinging of diapasone
                int b = Integer.parseInt(arr2[0]);
                for (int j = a + 1; j < b; j++) {
                    arr[i] = arr[i] + "," + j;
                }
            }
            if (k != "")
                k = k + "," + arr[i];
            else
                k = k + arr[i];
        }
        //System.out.println(k);
        return k;
    }

    public static void main(String[] args){
        String str = args[0];
        expandDiapasone outputString = new expandDiapasone();
        System.out.println(outputString.expand(str));
    }
}
