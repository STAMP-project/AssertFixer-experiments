//+======================================================================
// $Source$
//
// Project:   Tango
//
// Description:  java source code for the TANGO client/server API.
//
// $Author$
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
// $Revision$
//
//-======================================================================


package fr.esrf.TangoDs;



public class PollThCmd
{
	/**
	 *	The new command flag
	 */
	boolean		cmd_pending;
	/**
	 *	The command code
	 */
	int			cmd_code;
	/**
	 *	The device pointer (servant)
	 */
	DeviceImpl	dev;
	/**
	 *	Index in the device poll_list
	 */
	int			index;
	/**
	 *	Object name
	 */
	String		name;
	/**
	 *	Object type (cmd/attr)
	 */
	int			type;
	/**
	 *	New update period (For upd period com.)
	 */
	int			new_upd;
	/**
	 *	is a trigger ?
	 */
	boolean		trigger = false;
}
