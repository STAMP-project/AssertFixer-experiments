//+======================================================================
// $Source$
//
// Project:   Tango
//
// Description:  java source code for the TANGO client/server API.
//
// $Author: pascal_verdier $
//
// Copyright (C) :      2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,
//						European Synchrotron Radiation Facility
//                      BP 220, Grenoble 38043
//                      FRANCE
//
// This file is part of Tango.
//
// Tango is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// 
// Tango is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License
// along with Tango.  If not, see <http://www.gnu.org/licenses/>.
//
// $Revision: 25297 $
//
//-======================================================================


package fr.esrf.TangoDs;

import org.apache.log4j.Level;


//TODO replace with slf4j
public class UtilPrint {
    /**
     * The logging level
     **/
    Level level;

//
// The constructor
//

    /**
     * Constructs a newly allocated UtilPrint object with a predefined
     * print level
     *
     * @param level The print level
     */
    public UtilPrint(Level level) {
        this.level = level;
    }

//
// Define all the println methods
//

    /**
     * Print a long.
     * <p>
     * This method prints a long data only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The long to be printed
     */

    public void println(long i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, String.valueOf(i));
    }

    /**
     * Print an aray of characters.
     * <p>
     * This method prints an array of characters only if the process trace level
     * is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The array to be printed
     */

    public void println(char i[]) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, i);
    }

    /**
     * Print a String.
     * <p>
     * This method prints a String only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The String to be printed
     */

    public void println(String i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, i);
    }

    /**
     * Print a boolean.
     * <p>
     * This method prints a boolean data only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The boolean to be printed
     */

    public void println(boolean i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, String.valueOf(i));
    }

    /**
     * Print a char.
     * <p>
     * This method prints a char data only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The char to be printed
     */

    public void println(char i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, String.valueOf(i));
    }

    /**
     * Print a double.
     * <p>
     * This method prints a double data only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The double to be printed
     */

    public void println(double i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, String.valueOf(i));
    }

    /**
     * Print a float.
     * <p>
     * This method prints a float data only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The float to be printed
     */

    public void println(float i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, String.valueOf(i));
    }

    /**
     * Print an Object.
     * <p>
     * This method prints an Object only if the process trace level is greater
     * or equal to the object print level. Otherwise, it does nothing
     *
     * @param i The Object to be printed
     */

    public void println(Object i) {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, i);
    }

    /**
     * Finish the line.
     */
    public void println() {
        if (Logging.core_logger() != null)
            Logging.core_logger().log(level, "\n");
    }
}
