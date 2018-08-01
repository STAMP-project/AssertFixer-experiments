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
import fr.esrf.Tango.DevFailed;
import org.omg.CORBA.Request;


class  AsyncCallObject implements ApiDefs, java.io.Serializable
{
	int			id = 0;
	Request		request;
	DeviceProxy	dev;
	int			cmd_type;
	CallBack	cb;
	int			reply_model;
	String[]	names;


	//===============================================================
	//===============================================================
	AsyncCallObject(Request request, DeviceProxy dev, int cmd_type, 
					String[] names, int reply_model)
	{
		this.request     = request;
		this.dev         = dev;
		this.cmd_type    = cmd_type;
		this.names       = names;
		this.reply_model = reply_model;
	}
	//===============================================================
	//===============================================================
	AsyncCallObject(Request request, DeviceProxy dev, int cmd_type, String[] names)
	{
		this(request, dev, cmd_type, names, POLLING);
	}
	//===============================================================
	//===============================================================
	void command_inout_reply(int timeout)
	{
		DevError[]	errors = null;
		DeviceData	argout = null;
		try
		{
			if (timeout==NO_TIMEOUT)
				argout = dev.command_inout_reply(this);
			else
				argout = dev.command_inout_reply(this, timeout);
		}
		catch(AsynReplyNotArrived e)
		{
			errors = e.errors;
		}
		catch(DevFailed e)
		{
			errors = e.errors;
		}
		cb.cmd_ended(new CmdDoneEvent(dev, names[0], argout, errors));
	}
	//===============================================================
	//===============================================================
	void read_attribute_reply(int timeout)
	{
		DevError[]			errors = null;
		DeviceAttribute[]	argout = null;
		try
		{
			if (timeout==NO_TIMEOUT)
				argout = dev.read_attribute_reply(id);
			else
				argout = dev.read_attribute_reply(id, timeout);
		}
		catch(AsynReplyNotArrived e)
		{
			errors = e.errors;
		}
		catch(DevFailed e)
		{
			errors = e.errors;
		}
		cb.attr_read(new AttrReadEvent(dev, names, argout, errors));
	}
	//===============================================================
	//===============================================================
	void write_attribute_reply(int timeout)
	{
		DevError[]	errors = null;
		try
		{
			if (timeout==NO_TIMEOUT)
				dev.write_attribute_reply(id);
			else
				dev.write_attribute_reply(id, 0);
		}
		catch(AsynReplyNotArrived e)
		{
			errors = e.errors;
		}
		catch(DevFailed e)
		{
			errors = e.errors;
		}
		cb.attr_written(new AttrWrittenEvent(dev, names, errors));
	}
	//===============================================================
	//===============================================================
	void manage_reply(int timeout)
	{
		switch (cmd_type)
		{
		case CMD:
			command_inout_reply(timeout);
			break;
		case ATT_R:
			read_attribute_reply(timeout);
			break;
		case ATT_W:
			write_attribute_reply(timeout);
			break;
		}
	}
	//===============================================================
	//===============================================================
	void manage_reply()
	{
		manage_reply(NO_TIMEOUT);	//	No Timeout
	}
	//===============================================================
	//===============================================================
}
