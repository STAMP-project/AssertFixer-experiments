package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description: local class
 * Date: 2018/3/29
 */
public class LocalClass {

    /**
     * regular expression
     */
    private static String REGULAR_EXPRESSION = "[^0-9]";

    public static void validateNumber(String number1, String number2, int count) {

        // final local variable
//        final int numberLength = 10;
        int numberLength = 10;

        /**
         * inner class(help class)
         */
        class PhoneNumber {

            private String formattedPhoneNumber;

            private PhoneNumber(String number) {
                // local class can access class field of its enclosing class
                String currentNumber = number.replaceAll(REGULAR_EXPRESSION, "");
                // local class can access final local variable
                if (currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }

            private String getNumber() {
                return this.formattedPhoneNumber;
            }

            // valid in JDK 8 and above
            // local class can access parameter of method in enclosing class
            private void foo() {
                System.out.println(number1);
                System.out.println(number2);
                System.out.println(count);
            }

        }

        PhoneNumber phoneNumber1 = new PhoneNumber(number1);
        PhoneNumber phoneNumber2 = new PhoneNumber(number2);

        if (phoneNumber1.getNumber() == null) {
            System.out.println(number1 + " is not a valid phone number");
        }
        if (phoneNumber2.getNumber() == null) {
            System.out.println(number2 + " is not a valid phone number");
        }

    }

}
