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

import fr.esrf.Tango.DevFailed;
import org.omg.CORBA.Any;
 
public class RestartServerCmd extends Command
{

//+-------------------------------------------------------------------------
//
// method : 		RestartServerCmd 
// 
// description : 	constructor for Command class Status
//
//--------------------------------------------------------------------------
 
	public RestartServerCmd(String name,int in,int out)
	{
		super(name,in,out);
	}

//+-------------------------------------------------------------------------
//
// method : 		execute 
// 
// description : 	restart the server. This means :
//			- destroys all the registered device classes
//			This is done by re-calling the init_method of the
//			DServer object
//
//--------------------------------------------------------------------------

	public Any execute(DeviceImpl device,Any in_any) throws DevFailed
	{

		Util.out4.println("RestartServer.execute(): arrived ");

		((DServer)(device)).restart_server();

		return Util.return_empty_any("RestartServer");
	}
}
