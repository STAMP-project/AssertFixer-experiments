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
// $Revision: 25723 $
//
//-======================================================================


package fr.esrf.TangoApi;

import fr.esrf.Tango.*;

/**
 *	Class Description:
 *	This class manage data object for Tango device attribute information.
 *	<Br><Br>
 *	<Br><b> Usage example: </b> <Br>
 *	<ul><i>
 *	AttributeInfo[]	ac = dev.get_attribute_info();	<Br>
 *	for (int i=0 ; i < ac.length ; i++) <Br>
 *	{	<Br><ul>
 *		System.out.println(ac[i].name + " . " + ac[i].description);	<Br>
 *		</ul>
 *	} <Br>
 *	</ul></i>
 *
 * @author  verdier
 * @version  $Revision: 25723 $
 */

public class AttributeInfo implements java.io.Serializable
{
	/**
	 *	Attribute name.
	 */
	public String name;
	/**
	 *	Attribute writable state.
	 */
	public AttrWriteType writable;
	/**
	 *	Attribute data format.
	 */
	public AttrDataFormat data_format;
	/**
	 *	Attribute data type.
	 */
	public int data_type;
	/**
	 *	Attribute maximum size for X dimention.
	 */
	public int max_dim_x;
	/**
	 *	Attribute maximum size for Y dimention.
	 */
	public int max_dim_y;
	/**
	 *	Attribute description..
	 */
	public String description;
	/**
	 *	Attribute label.
	 */
	public String label;
	/**
	 *	Attribute unit.
	 */
	public String unit;
	/**
	 *	Attribute standard unit.
	 */
	public String standard_unit;
	/**
	 *	Attribute display unit.
	 */
	public String display_unit;
	/**
	 *	Attribute display format.
	 */
	public String format;
	/**
	 *	Attribute minimum value.
	 */
	public String min_value;
	/**
	 *	Attribute maximum value.
	 */
	public String max_value;
	/**
	 *	Attribute minimum value before alarm.
	 */
	public String min_alarm;
	/**
	 *	Attribute maximum value before alarm.
	 */
	public String max_alarm;
	/**
	 *	Attribute writable associated.
	 */
	public String writable_attr_name;
	/**
	 *	Attribute display level. DispLevel.OPERATORb or DispLevel.EXPERT
	 */
	public DispLevel level = DispLevel.OPERATOR;
	/**
	 *	.For future usage.
	 */
	public String[] extensions;


	//====================================================================
	/**
	 *	Constructor as an IDL AttributeConfig object
	 */
	//====================================================================
	public AttributeInfo(String name,
						AttrWriteType writable,
						AttrDataFormat data_format,
						int data_type,
						int max_dim_x,
						int max_dim_y,
						String description,
						String label,
						String unit,
						String standard_unit,
						String display_unit,
						String format,
						String min_value,
						String max_value,
						String min_alarm,
						String max_alarm,
						String writable_attr_name,
						String[] extensions)
	{
		this.name = name;
		this.writable = writable;
		this.data_format = data_format;
		this.data_type = data_type;
		this.max_dim_x = max_dim_x;
		this.max_dim_y = max_dim_y;
		this.description = description;
		this.label = label;
		this.unit = unit;
		this.standard_unit = standard_unit;
		this.display_unit = display_unit;
		this.format = format;
		this.min_value = min_value;
		this.max_value = max_value;
		this.min_alarm = min_alarm;
		this.max_alarm = max_alarm;
		this.writable_attr_name = writable_attr_name;
		this.extensions = extensions;
	}
	//====================================================================
	/**
	 *	Constructor as an IDL AttributeConfig_2 object
	 */
	//====================================================================
	public AttributeInfo(String name,
						AttrWriteType writable,
						AttrDataFormat data_format,
						int data_type,
						int max_dim_x,
						int max_dim_y,
						String description,
						String label,
						String unit,
						String standard_unit,
						String display_unit,
						String format,
						String min_value,
						String max_value,
						String min_alarm,
						String max_alarm,
						String writable_attr_name,
						DispLevel level,
						String[] extensions)
	{
		this.name = name;
		this.writable = writable;
		this.data_format = data_format;
		this.data_type = data_type;
		this.max_dim_x = max_dim_x;
		this.max_dim_y = max_dim_y;
		this.description = description;
		this.label = label;
		this.unit = unit;
		this.standard_unit = standard_unit;
		this.display_unit = display_unit;
		this.format = format;
		this.min_value = min_value;
		this.max_value = max_value;
		this.min_alarm = min_alarm;
		this.max_alarm = max_alarm;
		this.writable_attr_name = writable_attr_name;
		this.level = level;
		this.extensions = extensions;
	}
	//==============================================================
	/**
	 *	Constructor from IDL AttributeConfig object
	 */
	//==============================================================
    public AttributeInfo(AttributeConfig info)
	{
		this.name = info.name;
		this.writable = info.writable;
		this.data_format = info.data_format;
		this.data_type = info.data_type;
		this.max_dim_x = info.max_dim_x;
		this.max_dim_y = info.max_dim_y;
		this.description = info.description;
		this.label = info.label;
		this.unit = info.unit;
		this.standard_unit = info.standard_unit;
		this.display_unit = info.display_unit;
		this.format = info.format;
		this.min_value = info.min_value;
		this.max_value = info.max_value;
		this.min_alarm = info.min_alarm;
		this.max_alarm = info.max_alarm;
		this.writable_attr_name = info.writable_attr_name;
		this.extensions = info.extensions;
	}
	//==============================================================
	/**
	 *	Constructor from IDL AttributeConfig_2 object
	 */
	//==============================================================
    public AttributeInfo(AttributeConfig_2 info)
	{
		this.name = info.name;
		this.writable = info.writable;
		this.data_format = info.data_format;
		this.data_type = info.data_type;
		this.max_dim_x = info.max_dim_x;
		this.max_dim_y = info.max_dim_y;
		this.description = info.description;
		this.label = info.label;
		this.unit = info.unit;
		this.standard_unit = info.standard_unit;
		this.display_unit = info.display_unit;
		this.format = info.format;
		this.min_value = info.min_value;
		this.max_value = info.max_value;
		this.min_alarm = info.min_alarm;
		this.max_alarm = info.max_alarm;
		this.writable_attr_name = info.writable_attr_name;
		this.level = info.level;
		this.extensions = info.extensions;
	}
	//==============================================================
	/**
	 *	Constructor from IDL AttributeConfig_3 object
	 */
	//==============================================================
    public AttributeInfo(AttributeConfig_3 info)
	{
		this.name = info.name;
		this.writable = info.writable;
		this.data_format = info.data_format;
		this.data_type = info.data_type;
		this.max_dim_x = info.max_dim_x;
		this.max_dim_y = info.max_dim_y;
		this.description = info.description;
		this.label = info.label;
		this.unit = info.unit;
		this.standard_unit = info.standard_unit;
		this.display_unit = info.display_unit;
		this.format = info.format;
		this.min_value = info.min_value;
		this.max_value = info.max_value;
		this.min_alarm = info.att_alarm.min_alarm;
		this.max_alarm = info.att_alarm.max_alarm;
		this.writable_attr_name = info.writable_attr_name;
		this.level = info.level;
		this.extensions = info.extensions;
	}
	//==============================================================
	/**
	 *	Constructor from IDL AttributeConfig_3 object
	 */
	//==============================================================
    public AttributeInfo(AttributeConfig_5 info)
	{
		this.name = info.name;
		this.writable = info.writable;
		this.data_format = info.data_format;
		this.data_type = info.data_type;
		this.max_dim_x = info.max_dim_x;
		this.max_dim_y = info.max_dim_y;
		this.description = info.description;
		this.label = info.label;
		this.unit = info.unit;
		this.standard_unit = info.standard_unit;
		this.display_unit = info.display_unit;
		this.format = info.format;
		this.min_value = info.min_value;
		this.max_value = info.max_value;
		this.min_alarm = info.att_alarm.min_alarm;
		this.max_alarm = info.att_alarm.max_alarm;
		this.writable_attr_name = info.writable_attr_name;
		this.level = info.level;
		this.extensions = info.extensions;
	}

	//==============================================================
	/**
	 *	Build and return Attributeconfig IDL object 
	 *	from AttributeInfo object
	 */
	//==============================================================
 	public AttributeConfig get_attribute_config_obj()
	{
		return new AttributeConfig(name, writable, data_format, data_type,
									max_dim_x, max_dim_y, description, label,
									unit, standard_unit, display_unit, format,
									min_value, max_value,
									min_alarm, max_alarm, writable_attr_name,
									extensions);

	}
	//==============================================================
	/**
	 *	Build and return Attributeconfig_2 IDL 2  object 
	 *	from AttributeInfo object
	 */
	//==============================================================
 	public AttributeConfig_2 get_attribute_config_2_obj()
	{
		return new AttributeConfig_2(name, writable, data_format, data_type,
									max_dim_x, max_dim_y, description, label,
									unit, standard_unit, display_unit, format,
									min_value, max_value,
									min_alarm, max_alarm, writable_attr_name,
									level, extensions);

	}


	//==========================================================================
	//==========================================================================
	public String toString()
	{
		return
		"Name:                " + name + "\n" +
		"data_type:           " + fr.esrf.TangoDs.TangoConst.Tango_CmdArgTypeName[data_type] + "\n" +
		"max_dim_x:           " + max_dim_x + "\n" +
		"max_dim_y:           " + max_dim_y + "\n" +
		"description:         " + description + "\n" +
		"label:               " + label + "\n" +
		"unit:                " + unit + "\n" +
		"standard_unit:       " + standard_unit + "\n" +
		"display_unit:        " + display_unit + "\n" +
		"format:              " + format + "\n" +
		"min_value:           " + min_value + "\n" +
		"max_value:           " + max_value + "\n" +
		"min_alarm:           " + min_alarm + "\n" +
		"max_alarm:           " + max_alarm + "\n" +
		"writable_attr_name:  " + writable_attr_name + "\n" +
		"level:               " + ((level==DispLevel.OPERATOR)? "Operator" : "Expert");
	}
}
