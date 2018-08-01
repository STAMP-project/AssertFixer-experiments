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

import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.DeviceProxy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EventListener;


/**
 *
 * @author  pascal_verdier
 */
public class TangoUser extends EventDispatcher implements java.io.Serializable {
    
    //=======================================================================
    /**
	 *	Creates a new instance of AttrPeriodicChange
     * @param device_proxy device proxy object.
     * @param attr_name    attribute name.
     * @param filters      filter array
	 */
    //=======================================================================
    public TangoUser(DeviceProxy device_proxy, String attr_name, String[] filters) {
        super(device_proxy);
        this.attr_name = attr_name;
        this.filters = filters;
        event_identifier = -1;
    }
    
    //=======================================================================
    //=======================================================================
    public void addTangoUserListener(ITangoUserListener listener, boolean stateless)
                throws DevFailed
    {
		event_listeners.add(ITangoUserListener.class, listener);
        event_identifier = subscribe_user_event(attr_name, filters, stateless);
    }
    

    //=======================================================================
    //=======================================================================
	public void removeTangoUserListener(ITangoUserListener listener) 
                throws DevFailed
    {
        event_listeners.remove(ITangoUserListener.class,listener);
        if ( event_listeners.size() == 0 )
           unsubscribe_event(event_identifier);

    }
    
    //=======================================================================
    //=======================================================================
    public void dispatch_event(final EventData eventData) {
        final TangoUser tangoUser = this;
        if (EventUtil.graphicAvailable()) {
            //   Causes doRun.run() to be executed asynchronously
            //      on the AWT event dispatching thread.
            Runnable do_work_later = new Runnable() {
                public void run() {
                    fireTangoUserEvent(tangoUser, eventData);
                }
            };
            SwingUtilities.invokeLater(do_work_later);
        }
        else
            fireTangoUserEvent(tangoUser , eventData);
    }

    //=======================================================================
    //=======================================================================
    private void fireTangoUserEvent(TangoUser tangoUser, EventData eventData) {
        TangoUserEvent tangoUserEvent = new TangoUserEvent(tangoUser, eventData);
        // Notifying those that are interested in this event
        ArrayList<EventListener> listeners = event_listeners.getListeners(ITangoUserListener.class);
        for (EventListener eventListener : listeners) {
            ((ITangoUserListener) eventListener).user(tangoUserEvent);
        }
    }
    
	//==============================================================
	//==============================================================

    String attr_name;
    int event_identifier;
    String[] filters;
}
