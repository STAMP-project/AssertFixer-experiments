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
 
import fr.esrf.Tango.DevError;


/**
 *	Object defining result of an asynchronous call.
 */


public class  CmdDoneEvent
{
	public DeviceProxy 	device;
	public String		cmdname;
	public DeviceData	argout;
	public DevError[]	errors;
	public boolean		err;

	//===============================================================
	/**
	 *	Object constructor
	 */
	//===============================================================
	public CmdDoneEvent(DeviceProxy dev, String cmd, 
						DeviceData arg, DevError[] err_in)
	{
		device  = dev;
		cmdname = cmd;
		argout  = arg;
		errors  = err_in;
		if (errors==null)
			err = false;
		else
			err = (errors.length!=0) ;
	}
	//===============================================================
	//===============================================================
}
