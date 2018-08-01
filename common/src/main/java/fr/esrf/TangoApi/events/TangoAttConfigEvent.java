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


package fr.esrf.TangoApi.events;


import fr.esrf.Tango.DevError;
import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.AttributeInfoEx;

import java.util.EventObject;

/**
 * @author pascal_verdier
 */
public class TangoAttConfigEvent extends EventObject implements java.io.Serializable {

    /**
     * Creates a new instance of TangoOnAttConfigEvent
     *
     * @param source     event source
     * @param event_data event data
     */
    public TangoAttConfigEvent(TangoAttConfig source, EventData event_data) {
        super(source);
        this.attr_config = event_data.attr_config;
        this.errors = event_data.errors;
        this.eventSource = event_data.event_source;
    }

    //-=============================================
    //-=============================================
    @SuppressWarnings({"UnusedDeclaration"})
    public AttributeInfoEx getValue() throws DevFailed {
        if (attr_config == null)
            throw new DevFailed(errors);
        return attr_config;
    }
    //-=============================================
    //-=============================================
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean isZmqEvent() {
        return (eventSource==EventData.ZMQ_EVENT);
    }

    private AttributeInfoEx attr_config;
    private DevError[]  errors;
    private int         eventSource;
}
