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


package fr.esrf.TangoApi.Group;

//- Import TANGO stuffs
import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.DeviceData;

/**
 * TANGO group reply for command
 */
public class GroupCmdReply extends GroupReply implements java.io.Serializable {

    /**
     * The command reply data
     */
    private DeviceData data;
    
    /** Creates a new instance of GroupCmdReply */
    public GroupCmdReply() {
        super();
    }
    
    /** Creates a new instance of GroupCmdReply */
    public GroupCmdReply(String _dev_name, String _obj_name, DeviceData _data) {
        super(_dev_name, _obj_name);
        data = _data;
    }
    
    /** Creates a new instance of GroupCmdReply */
    public GroupCmdReply(String _dev_name, String _obj_name, DevFailed _ex) {
        super(_dev_name, _obj_name, _ex);
        data = null;
    }
    
    /** Returns the associated data - returns null if has_failed set to true */
    public DeviceData get_data() throws DevFailed {
        if (exception_enabled && has_failed) {
          throw exception;
        }
        return data;
    }
}
