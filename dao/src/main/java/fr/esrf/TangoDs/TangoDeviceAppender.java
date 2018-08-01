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

// log4j stuffs

import fr.esrf.Tango.DevFailed;
import fr.esrf.TangoApi.DeviceData;
import fr.esrf.TangoApi.DeviceProxy;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;


/**
 * A class to log to a (remote) logconsumer device.
 */
 
public class TangoDeviceAppender extends AppenderSkeleton implements TangoAppender
{ 
 /**
  * The TANGO logconsumer device proxy
  */
  private DeviceProxy lc_dev_proxy = null;
 
  /**
  * The TANGO device name
  */
  private String dev_name = null;
  
 /**
  * Construct a newly allocated TangoDeviceAppender object.
  *
  * @param  appender_name  This appender name
  * @param  lcd_name  The logconsumer device name
  */
  public TangoDeviceAppender(String device_name, String appender_name, String lcd_name) throws DevFailed {
    setName(appender_name);
    //- remember device name
    dev_name = device_name;
    //- instanciate the device proxy (may throw DevFailed)
    lc_dev_proxy = new DeviceProxy(lcd_name);
    try {
      DeviceData dd = new DeviceData();
      dd.insert(dev_name);
      lc_dev_proxy.command_inout_asynch("Register", dd, true);
    }
    catch (DevFailed dv) {
       //Ignore: some old LogViewer may not support the Register cmd
    }
  }
  
 /**
  * Tells log4j that this appender does not require a layout.
  */
  public boolean requiresLayout () {
    return false;   
  }
  
 /**
  * Release any resources allocated within the appender.
  */  
  public void close () {
    if (lc_dev_proxy != null) {
      try {
        DeviceData dd = new DeviceData();
        dd.insert(dev_name);
        lc_dev_proxy.command_inout_asynch("UnRegister", dd, true);
      }
      catch (DevFailed dv) {
        //Ignore: some old LogViewer may not support the Unregister cmd
      }
    }
    lc_dev_proxy = null; 
    dev_name = null;
  }

 /**
  * Performs actual logging.
  */  
  public void append (LoggingEvent evt) {
    if (lc_dev_proxy == null) {
      return;
    }
    try {
      String[] dvsa = new String[6];
      dvsa[0] = String.valueOf(evt.timeStamp);
      dvsa[1] = evt.getLevel().toString();     
      dvsa[2] = evt.getLoggerName(); 
      dvsa[3] = evt.getRenderedMessage();       
      dvsa[4] = "";
      dvsa[5] = evt.getThreadName();  
      DeviceData dd = new DeviceData();
      dd.insert(dvsa);
      lc_dev_proxy.command_inout_asynch("Log", dd, true);
    }
    catch (DevFailed dv) {
      close();
    }
  }
 
 /** 
  * Returns true if the appender is (still) valid, false otherwise.
  */
  public boolean isValid() {
    if (lc_dev_proxy == null) {
      return false;
    }
    try {
      lc_dev_proxy.ping();
    }
    catch (DevFailed dv) {
      close();
      return false;
    }
    return true;
  }
  
}
