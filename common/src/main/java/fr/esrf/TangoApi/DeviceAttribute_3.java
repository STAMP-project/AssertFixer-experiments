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
// $Revision: 25296 $
//
//-======================================================================


package fr.esrf.TangoApi;

import fr.esrf.Tango.AttrDataFormat;
import fr.esrf.Tango.AttrQuality;
import fr.esrf.Tango.AttributeDim;
import fr.esrf.Tango.AttributeValue;
import fr.esrf.Tango.AttributeValue_3;
import fr.esrf.Tango.DevError;
import fr.esrf.Tango.DevFailed;
import fr.esrf.Tango.DevState;
import fr.esrf.Tango.TimeVal;
import fr.esrf.Tango.factory.TangoFactory;

/**
 * Class Description: This class manage data object for Tango device attribute
 * access. <Br>
 * <Br>
 * <Br>
 * <b> Usage example: </b> <Br>
 * <ul>
 * <i> DeviceAttribute devattr = dev.read_attribute("Current"); <Br>
 * if (devattr.hasFailed())<Br>
 * {
 * <ul>
 * Except.print_exception(devattr.getErrStack());
 * </ul>
 * else <Br>
 * {
 * <ul>
 * double current = devattr.extractDouble(); <Br>
 * System.out.println("Current : " + current);
 * </ul>
 * </ul> </i>
 * 
 * @author verdier
 * @version $Revision: 25296 $
 */

public class DeviceAttribute_3 {
    private IDeviceAttribute_3DAO deviceattribute_3DAO = null;

    public DeviceAttribute_3() {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param attrval
     *            AttributeValue_3 IDL object.
     */
    // ===========================================
    public DeviceAttribute_3(final AttributeValue_3 attrval) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(attrval);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param attrval
     *            AttributeValue IDL object.
     */
    // ===========================================
    public DeviceAttribute_3(final AttributeValue attrval) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(attrval);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     */
    // ===========================================
    public DeviceAttribute_3(final String name) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final boolean value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final DevState value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final boolean[] value,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final byte value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final byte[] value,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final short value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param values
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final short[] values,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, values, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final int value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param values
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final int[] values,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, values, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final long value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param values
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final long[] values,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, values, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final float value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param values
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final float[] values,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, values, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final double value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param values
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final double[] values,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, values, dim_x, dim_y);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param value
     *            Attribute value.
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final String value) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, value);
    }

    // ===========================================
    /**
     * DeviceAttribute_3 class constructor.
     * 
     * @param name
     *            Attribute name.
     * @param values
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public DeviceAttribute_3(final String name, final String[] values,
	    final int dim_x, final int dim_y) {
	deviceattribute_3DAO = TangoFactory.getSingleton()
		.getDeviceAttribute_3DAO();
	deviceattribute_3DAO.init(name, values, dim_x, dim_y);
    }

    // ===========================================
    // ===========================================
    public boolean hasFailed() {
	return deviceattribute_3DAO.hasFailed();
    }

    // ===========================================
    /**
     * Returns the attribute errors list
     */
    // ===========================================
    public DevError[] getErrStack() {
	return deviceattribute_3DAO.getErrStack();
    }

    // ===========================================
    /**
     * Set the AttributeValue internal object with input one.
     * 
     * @param attrval
     *            AttributeValue_3 input object
     */
    // ===========================================
    public void setAttributeValue(final AttributeValue_3 attrval) {
	deviceattribute_3DAO.setAttributeValue(attrval);
    }

    // ===========================================
    /**
     * Set the AttributeValue internal object with input one.
     * 
     * @param attrval
     *            AttributeValue input object
     */
    // ===========================================
    public void setAttributeValue(final AttributeValue attrval) {
	deviceattribute_3DAO.setAttributeValue(attrval);
    }

    // ===========================================
    // Insert methods
    // ===========================================

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final DevState argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final DevState[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final DevState[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final boolean argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final boolean[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final boolean[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_uc(final byte argin) {
	deviceattribute_3DAO.insert_uc(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_uc(final byte[] argin) {
	deviceattribute_3DAO.insert_uc(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_uc(final short argin) {
	deviceattribute_3DAO.insert_uc(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_uc(final short[] argin) {
	deviceattribute_3DAO.insert_uc(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            nb data.in x direction
     * @param dim_y
     *            nb data.in y direction
     */
    // ===========================================
    public void insert_uc(final short[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_uc(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_uc(final byte[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_uc(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final short argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final short[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final short[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_us(final short argin) {
	deviceattribute_3DAO.insert_us(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_us(final int argin) {
	deviceattribute_3DAO.insert_us(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_us(final short[] argin) {
	deviceattribute_3DAO.insert_us(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_us(final int[] argin) {
	deviceattribute_3DAO.insert_us(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_us(final short[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_us(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_us(final int[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_us(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final int argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final int[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final int[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final long argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final long[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final long[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_ul(final int argin) {
	deviceattribute_3DAO.insert_ul(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values as unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_ul(final long argin) {
	deviceattribute_3DAO.insert_ul(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_ul(final int[] argin) {
	deviceattribute_3DAO.insert_ul(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_ul(final long[] argin) {
	deviceattribute_3DAO.insert_ul(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_ul(final int[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_ul(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute valuesas unsigned.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_ul(final long[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_ul(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_u64(final long argin) {
	deviceattribute_3DAO.insert_u64(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert_u64(final long[] argin) {
	deviceattribute_3DAO.insert_u64(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert_u64(final long[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert_u64(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final float argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final float[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final float[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final double argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final double[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final double[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final String argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     */
    // ===========================================
    public void insert(final String[] argin) {
	deviceattribute_3DAO.insert(argin);
    }

    // ===========================================
    /**
     * Insert method for attribute values.
     * 
     * @param argin
     *            Attribute values.
     * @param dim_x
     *            array dimention in X
     * @param dim_y
     *            array dimention in Y
     */
    // ===========================================
    public void insert(final String[] argin, final int dim_x, final int dim_y) {
	deviceattribute_3DAO.insert(argin, dim_x, dim_y);
    }

    // ===========================================
    /**
     * extract method for an DevState Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public DevState[] extractDevStateArray() throws DevFailed {
	return deviceattribute_3DAO.extractDevStateArray();
    }

    // ===========================================
    /**
     * extract method for an DevState.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public DevState extractDevState() throws DevFailed {
	return deviceattribute_3DAO.extractDevState();
    }

    // ===========================================
    /**
     * extract method for an boolean.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public boolean extractBoolean() throws DevFailed {
	return deviceattribute_3DAO.extractBoolean();
    }

    // ===========================================
    /**
     * extract method for an boolean Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public boolean[] extractBooleanArray() throws DevFailed {
	return deviceattribute_3DAO.extractBooleanArray();
    }

    // ===========================================
    /**
     * extract method for an unsigned char.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public short extractUChar() throws DevFailed {
	return deviceattribute_3DAO.extractUChar();
    }

    // ===========================================
    /**
     * extract method for an unsigned char Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public short[] extractUCharArray() throws DevFailed {
	return deviceattribute_3DAO.extractUCharArray();
    }

    // ===========================================
    /**
     * extract method for an unsigned char Array as a char array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public byte[] extractCharArray() throws DevFailed {
	return deviceattribute_3DAO.extractCharArray();
    }

    // ===========================================
    /**
     * extract method for a short.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public short extractShort() throws DevFailed {
	return deviceattribute_3DAO.extractShort();
    }

    // ===========================================
    /**
     * extract method for a short Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public short[] extractShortArray() throws DevFailed {
	return deviceattribute_3DAO.extractShortArray();
    }

    // ===========================================
    /**
     * extract method for an unsigned short.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public int extractUShort() throws DevFailed {
	return deviceattribute_3DAO.extractUShort();
    }

    // ===========================================
    /**
     * extract method for an unsigned short Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public int[] extractUShortArray() throws DevFailed {
	return deviceattribute_3DAO.extractUShortArray();
    }

    // ===========================================
    /**
     * extract method for a long.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public int extractLong() throws DevFailed {
	return deviceattribute_3DAO.extractLong();
    }

    // ===========================================
    /**
     * extract method for a long Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public int[] extractLongArray() throws DevFailed {
	return deviceattribute_3DAO.extractLongArray();
    }

    // ===========================================
    /**
     * extract method for a unsigned long.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public long extractULong() throws DevFailed {
	return deviceattribute_3DAO.extractULong();
    }

    // ===========================================
    /**
     * extract method for a unsigned long.array
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public long[] extractULongArray() throws DevFailed {
	return deviceattribute_3DAO.extractULongArray();
    }

    // ===========================================
    /**
     * extract method for a long.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public long extractLong64() throws DevFailed {
	return deviceattribute_3DAO.extractLong64();
    }

    // ===========================================
    /**
     * extract method for a long Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public long[] extractLong64Array() throws DevFailed {
	return deviceattribute_3DAO.extractLong64Array();
    }

    // ===========================================
    /**
     * extract method for a long.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public long extractULong64() throws DevFailed {
	return deviceattribute_3DAO.extractULong64();
    }

    // ===========================================
    /**
     * extract method for a long Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public long[] extractULong64Array() throws DevFailed {
	return deviceattribute_3DAO.extractULong64Array();
    }

    // ===========================================
    /**
     * extract method for a float.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public float extractFloat() throws DevFailed {
	return deviceattribute_3DAO.extractFloat();
    }

    // ===========================================
    /**
     * extract method for a float Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public float[] extractFloatArray() throws DevFailed {
	return deviceattribute_3DAO.extractFloatArray();
    }

    // ===========================================
    /**
     * extract method for a double.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public double extractDouble() throws DevFailed {
	return deviceattribute_3DAO.extractDouble();
    }

    // ===========================================
    /**
     * extract method for a double Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public double[] extractDoubleArray() throws DevFailed {
	return deviceattribute_3DAO.extractDoubleArray();
    }

    // ===========================================
    /**
     * extract method for a DevState (state attribute).
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public DevState extractState() throws DevFailed {
	return deviceattribute_3DAO.extractState();
    }

    // ===========================================
    /**
     * extract method for a String.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public String extractString() throws DevFailed {
	return deviceattribute_3DAO.extractString();
    }

    // ===========================================
    /**
     * extract method for a double Array.
     * 
     * @return the extracted value.
     * @throws DevFailed
     *             in case of read_attribute failed or if AttrQuality is
     *             ATTR_INVALID.
     */
    // ===========================================
    public String[] extractStringArray() throws DevFailed {
	return deviceattribute_3DAO.extractStringArray();
    }

    // ===========================================
    /**
     * Return attribute quality
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public AttrQuality getQuality() throws DevFailed {
	return deviceattribute_3DAO.getQuality();
    }

    // ===========================================
    /**
     * Return attribute data format (SCALR, . * SPECTRUM, IMAGE or FMT_UNKNOWN)
     * If device is older than Device_4Impl, FMT_UNKNOWN is returned.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public AttrDataFormat getDataFormat() throws DevFailed {
	return AttrDataFormat.FMT_UNKNOWN;
    }

    // ===========================================
    /**
     * Return attribute time value.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public TimeVal getTimeVal() throws DevFailed {
	return deviceattribute_3DAO.getTimeVal();
    }

    // ===========================================
    /**
     * Return attribute time value in seconds since EPOCH.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public long getTimeValSec() throws DevFailed {
	return deviceattribute_3DAO.getTimeValSec();
    }

    // ===========================================
    /**
     * Return attribute time value in seconds since EPOCH.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public long getTimeValMillisSec() throws DevFailed {
	return deviceattribute_3DAO.getTimeValMillisSec();
    }

    // ===========================================
    /**
     * Return attribute name.
     */
    // ===========================================
    public String getName() {
	return deviceattribute_3DAO.getName();
    }

    // ===========================================
    /**
     * Return number of data read.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public int getNbRead() throws DevFailed {
	return deviceattribute_3DAO.getNbRead();
    }

    // ===========================================
    /**
     * Return number data read object.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public AttributeDim getReadAttributeDim() throws DevFailed {
	return deviceattribute_3DAO.getReadAttributeDim();
    }

    // ===========================================
    /**
     * Return number of data wwrite object.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public AttributeDim getWriteAttributeDim() throws DevFailed {
	return deviceattribute_3DAO.getWriteAttributeDim();
    }

    // ===========================================
    /**
     * Return number of data written.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public int getNbWritten() throws DevFailed {
	return deviceattribute_3DAO.getNbWritten();
    }

    // ===========================================
    /**
     * Return attribute dim_x.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public int getDimX() throws DevFailed {
	return deviceattribute_3DAO.getDimX();
    }

    // ===========================================
    /**
     * Return attribute dim_y.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public int getDimY() throws DevFailed {
	return deviceattribute_3DAO.getDimY();
    }

    // ===========================================
    /**
     * Return attribute written dim_x.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public int getWrittenDimX() throws DevFailed {
	return deviceattribute_3DAO.getWrittenDimX();
    }

    // ===========================================
    /**
     * Return attribute written dim_y.
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public int getWrittenDimY() throws DevFailed {
	return deviceattribute_3DAO.getWrittenDimY();
    }

    // ===========================================
    /**
     * Return AttributeValue IDL object.
     */
    // ===========================================
    public AttributeValue getAttributeValueObject_2() {
	return deviceattribute_3DAO.getAttributeValueObject_2();
    }

    // ===========================================
    /**
     * Return AttributeValue IDL object.
     */
    // ===========================================
    public AttributeValue_3 getAttributeValueObject_3() {
	return deviceattribute_3DAO.getAttributeValueObject_3();
    }

    // ===========================================
    /**
     * return time in milliseconds since 1/1/70
     * 
     * @throws DevFailed
     *             in case of read_attribute failed
     */
    // ===========================================
    public long getTime() throws DevFailed {
	return deviceattribute_3DAO.getTime();
    }

    // ===========================================
    /**
     * @return the attribute data type
     * @throws DevFailed
     */
    // ===========================================
    public int getType() throws DevFailed {
	return deviceattribute_3DAO.getType();
    }

    // ===========================================
    /**
     * DeviceAttribute class set value.
     * 
     * @param devatt
     *            device attribute 4 object.
     * @throws DevFailed
     */
    // ===========================================
    public void setAttributeValue(final IDeviceAttributeDAO devatt)
	    throws DevFailed {
	deviceattribute_3DAO.setAttributeValue(devatt);
    }

    // ===========================================
    // ===========================================
    public IDeviceAttribute_3DAO getDeviceattributeDAO() {
	return deviceattribute_3DAO;
    }
}
