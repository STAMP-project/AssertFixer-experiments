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

import fr.esrf.Tango.*;
import org.omg.CORBA.Any;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * This class is a class representing a command in the template command model
 * without input parameter but with output parameter
 *
 * @author $Author: pascal_verdier $
 * @version $Revision: 25297 $
 */
 
public class TemplCommandOut extends TemplCommand implements TangoConst
{

//+-------------------------------------------------------------------------
//
// method : 		TemplCommandOut 
// 
// description : 	constructors for class TemplCommandOut
//
//--------------------------------------------------------------------------

/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name, an execution method and a command allowed method.
 * This constructor set the command input and output type to Tango_DEV_VOID
 * The input and output parameter description are set to the default String
 * "Uninitialised".
 * The command display type is set to OPERATOR_CMD.
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	state_method 	The command allowed method name
 *
 */
 
	public TemplCommandOut(String name,String exe_method,String state_method)
	{
		super(name);
				
		exe_method_name = exe_method;
		state_method_name = state_method;
		template_cmd = true;		
	}

/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name and an execution method.
 * This constructor set the command input and output type to Tango_DEV_VOID.
 * The input and output parameter description are set to the default String
 * "Uninitialised".
 * The command display type is set to OPERATOR_CMD.
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 *
 */
 
	public TemplCommandOut(String name,String exe_method)
	{
		super(name);
		
		exe_method_name = exe_method;
		state_method_name = null;				
		template_cmd = true;				
	}

/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name, an execution method, a command allowed method and a description for the
 * input and output command parameters.
 * This constructor set the command input and output type to Tango_DEV_VOID
 * The command display type is set to OPERATOR_CMD.
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	state_method 	The command allowed method name
 * @param	in_desc	The command input parameter description
 * @param	out_desc	The command output parameter description
 *
 */
 			
	public TemplCommandOut(String name,String exe_method,String state_method,
			    String in_desc,String out_desc)
	{
		super(name,in_desc,out_desc,0.0);
				
		exe_method_name = exe_method;
		state_method_name = state_method;		
		template_cmd = true;		
	}
	
/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name, an execution method and a description for the
 * input and output command parameters
 * The command display type is set to OPERATOR_CMD.
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	in_desc	The command input parameter description
 * @param	out_desc	The command output parameter description
 *
 */
 
	public TemplCommandOut(String name,String exe_method,
			    String in_desc,String out_desc)
	{
		super(name,in_desc,out_desc,0.0);
		
		exe_method_name = exe_method;
		state_method_name = null;				
		template_cmd = true;				
	}

/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name, an execution method and a command allowed method.
 * This constructor set the command input and output type to Tango_DEV_VOID
 * The input and output parameter description are set to the default String
 * "Uninitialised".
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	state_method 	The command allowed method name
 * @param	disp	The command display type
 *
 */
 
	public TemplCommandOut(String name,String exe_method,String state_method,DispLevel disp)
	{
		super(name,disp);
				
		exe_method_name = exe_method;
		state_method_name = state_method;
		template_cmd = true;		
	}

/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name and an execution method.
 * This constructor set the command input and output type to Tango_DEV_VOID.
 * The input and output parameter description are set to the default String
 * "Uninitialised".
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	disp	The command display type
 *
 */
 
	public TemplCommandOut(String name,String exe_method,DispLevel disp)
	{
		super(name,disp);
		
		exe_method_name = exe_method;
		state_method_name = null;				
		template_cmd = true;				
	}

/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name, an execution method, a command allowed method and a description for the
 * input and output command parameters.
 * This constructor set the command input and output type to Tango_DEV_VOID
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	state_method 	The command allowed method name
 * @param	in_desc	The command input parameter description
 * @param	out_desc	The command output parameter description
 * @param	disp	The command display type
 *
 */
 			
	public TemplCommandOut(String name,String exe_method,String state_method,
			    String in_desc,String out_desc,DispLevel disp)
	{
		super(name,in_desc,out_desc,disp,0.0);
				
		exe_method_name = exe_method;
		state_method_name = state_method;		
		template_cmd = true;		
	}
	
/**
 * Constructs a newly allocated TemplCommandOut object for a command with a
 * name, an execution method and a description for the
 * input and output command parameters
 *
 * @param 	name	The command name
 * @param	exe_method	The command execution method name
 * @param	in_desc	The command input parameter description
 * @param	out_desc	The command output parameter description
 * @param	disp	The command display type
 *
 */
 
	public TemplCommandOut(String name,String exe_method,
			    String in_desc,String out_desc,DispLevel disp)
	{
		super(name,in_desc,out_desc,disp,0.0);
		
		exe_method_name = exe_method;
		state_method_name = null;				
		template_cmd = true;				
	}
	
//+----------------------------------------------------------------------------
//
// method : 		analyse_methods
// 
// description : 	Analyse the method given at object creation time if
//			they fullfill the needs for command execution method.
//			It is not possible to do this in the constructor
//			because the class name is not known at object 
//			creation name
//
//-----------------------------------------------------------------------------

/**
 * Analyse the method given at construction time.
 *
 * This method check if the method(s) given at construction time fulfill the
 * required specification. It always analyse the execution method and eventually 
 * the command allowed method. The analysis of the command execution method will
 * also set the command output type to the correct value depending on the
 * execution method output parameter type
 *
 * @exception DevFailed If one of the method does not fulfill the requirements
 * Click <a href="../../tango_basic/idl_html/Tango.html#DevFailed">here</a> to read
 * <b>DevFailed</b> exception specification
 */
 
	public void analyse_methods() throws DevFailed
	{
	
//
// Analyse the execution method given by the user
//

		this.exe_method = analyse_method_exe(device_class_name,exe_method_name);		

//
// Analyse the state method if one is given by the user
//

		if (state_method_name != null)
			this.state_method = analyse_method_state(device_class_name,state_method_name);

	}
	
//+----------------------------------------------------------------------------
//
// method : 		analyse_method_exe
// 
// description : 	Try to find the method to be executed when the command
//			arrived (in the device class) and check it input and
//			output parameter
//
// in :			String cl_name : The device class name
//			String exe_method : The method name
//
//-----------------------------------------------------------------------------
		
	private Method analyse_method_exe(String cl_name,String exe_method) throws DevFailed
	{
		Method meth = null;
	
		try
		{
		
//
// Get the class object for the device class
//

			StringBuffer str = new StringBuffer(cl_name);
			str.append(".");
			str.append(cl_name);
					
			Class cl = Class.forName(str.toString());

//
// Get the device object method list
//
			
			Method[] meth_list = cl.getDeclaredMethods();
			if (meth_list.length == 0)
			{
				StringBuffer mess = new StringBuffer("Command ");
				mess.append(name);
				mess.append(": Can't find method ");
				mess.append(exe_method);

				Except.throw_exception("API_MethodNotFound",
						     mess.toString(),
				  	  	     "TemplCommandOut.analyse_method_exe()");
			}

//
// Find the execute method in method list
//

			meth = find_method(meth_list,exe_method);

//
// Check if it is public
//

			if (Modifier.isPublic(meth.getModifiers()) != true)
			{
				StringBuffer mess = new StringBuffer("Command ");
				mess.append(name);
				mess.append(": The method ");
				mess.append(exe_method);
				mess.append(" is not public");

				Except.throw_exception("API_MethodArgument",
						     mess.toString(),
				  	  	     "TemplCommandOut.analyse_method_exe()");
			}
			
//
// Check its argument
//
					
			Class[] param_type = meth.getParameterTypes();
			if (param_type.length != 0)
			{
				StringBuffer mess = new StringBuffer("Command ");
				mess.append(name);
				mess.append(": Some argument(s) are defined for method ");
				mess.append(exe_method);

				Except.throw_exception("API_MethodArgument",
						     mess.toString(),
				  	  	     "TemplCommandOut.analyse_method_exe()");
			}


						
//
// Get method return type
//

			Class ret_type = meth.getReturnType();
			if (ret_type.equals(Void.TYPE) == true)
			{
				StringBuffer mess = new StringBuffer("Command ");
				mess.append(name);
				mess.append(": Return type not defined for method ");
				mess.append(exe_method);

				Except.throw_exception("API_MethodArgument",
						     mess.toString(),
				  	  	     "TemplCommandOut.analyse_method_exe()");
			}
			
//
// Analyse return type
//

			out_type = get_tango_type(ret_type);
										
		}
		catch (ClassNotFoundException ex)
		{
			StringBuffer mess = new StringBuffer("Command ");
			mess.append(name);
			mess.append(": Can't find class ");
			mess.append(cl_name);

			Except.throw_exception("API_ClassNotFound",
					     mess.toString(),
				  	     "TemplCommandOut.analyse_method_exe()");
		}
		catch (SecurityException ex)
		{
			StringBuffer mess = new StringBuffer("Command ");
			mess.append(name);
			mess.append(": Security violation when trying to retrieve method list for class ");
			mess.append(cl_name);
			
			Except.throw_exception("API_JavaRuntimeSecurityException",
					     mess.toString(),
				  	     "TemplCommandOut.analyse_method_exe()");
		}
		
//
// Return method reference for later use
//

		return meth;
	}
		
//+-------------------------------------------------------------------------
//
// method : 		is_allowed
// 
// description : 	Check if the command is allowed. If the refrence to 
//			the method object "state_method" is null, the 
//			default mode id used (command always executed). 
//			Otherwise, the method is invoked
//
// input : - dev : reference to the device on which the command must be
//		   executed
//	   - data_in : Incoming command data
//
// This method returns a boolean set to true if the command is allowed
//
//--------------------------------------------------------------------------

/**
 * Invoke the command allowed method given at object creation time.
 *
 * This method is automtically called by the TANGO core classes when the
 * associated command is requested by a client to check if the command is allowed
 * in the actual device state. If the user give a command allowed method
 * at object creation time, this method will be invoked.
 *
 * @param dev The device on which the command must be executed
 * @param data_in The incoming data still packed in a CORBA Any object. For
 * command created with this TemplCommandOut class, this Any object does not
 * contain data
 * @return A boolean set to true is the command is allowed. Otherwise, the
 * return value is false. This return value is always set to true if the user
 * does not supply a method to be excuted. If a method has been supplied, the 
 * return value is the value returned by the user supplied mehod.
 */
 
	public boolean is_allowed(DeviceImpl dev,Any data_in)
	{
		if (state_method == null)
			return true;
		else
		{

//
// If the Method reference is not null, execute the method with the invoke
// method
//

			try
			{
				java.lang.Object[] meth_param = new java.lang.Object[1];
				meth_param[0] = data_in;
				java.lang.Object obj = state_method.invoke(dev,meth_param);
				return (Boolean) obj;
			}
			catch(InvocationTargetException e)
			{
				return false;
			}
			catch(IllegalArgumentException e)
			{
				return false;
			}
			catch (IllegalAccessException e)
			{
				return false;
			}
		}
	}
	
//+-------------------------------------------------------------------------
//
// method : 		execute
// 
// description : 	Execute the method associated with the command
//			(stored in the exe_method reference)
//
// input : - dev : Reference to the device on which the command must be
//		   executed
//	   - in_any : Incoming command data
//
// This method returns a reference to an Any object with the command outing
// data.
//
//--------------------------------------------------------------------------

/**
 * Invoke the command execution method given at object creation time.
 *
 * This method is automtically called by the TANGO core classes when the
 * associated command is requested by a client. It invokes the user supplied 
 * command execution method and packs the returned data into the outgoing
 * CORBA Any object
 *
 * @param dev The device on which the command must be executed
 * @param in_any The incoming data still packed in a CORBA Any object. For
 * command created with this TemplCommandOut class, this Any object does not
 * contain usefull data
 * @return The CORBA Any object returned to the client.
 * @exception DevFailed If the execution method failed
 * Click <a href="../../tango_basic/idl_html/Tango.html#DevFailed">here</a> to read
 * <b>DevFailed</b> exception specification
 */
 
	public Any execute(DeviceImpl dev,Any in_any) throws DevFailed
	{

//
// Execute the command associated method
//

		Any returned_data = null;
		try
		{
		
//
// Execute the method
//

			java.lang.Object[] meth_param = new java.lang.Object[0];
			java.lang.Object obj = exe_method.invoke(dev,meth_param);
			
//
// Insert data into the any according to command parameter type
//

			switch (out_type)
			{
			case Tango_DEV_BOOLEAN:
				returned_data = insert((Boolean) obj);
				break;
				
			case Tango_DEV_SHORT:
				returned_data = insert(((Short)obj).shortValue());
				break;
				
			case Tango_DEV_LONG:
				returned_data = insert(((Integer)obj).intValue());
				break;
				
			case Tango_DEV_LONG64:
				returned_data = insert(((Integer)obj).longValue());
				break;
				
			case Tango_DEV_FLOAT:
				returned_data = insert(((Float)obj).floatValue());
				break;
				
			case Tango_DEV_DOUBLE:
				returned_data = insert((Double) obj);
				break;
				
			case Tango_DEV_STRING:
				returned_data = insert((String)obj);
				break;
				
			case Tango_DEVVAR_CHARARRAY:
				returned_data = insert((byte[])obj);
				break;
				
			case Tango_DEVVAR_SHORTARRAY:
				returned_data = insert((short[])obj);
				break;
				
			case Tango_DEVVAR_LONGARRAY:
				returned_data = insert((int[])obj);
				break;
				
			case Tango_DEVVAR_LONG64ARRAY:
				returned_data = insert((long[])obj);
				break;
				
			case Tango_DEVVAR_FLOATARRAY:
				returned_data = insert((float[])obj);
				break;
				
			case Tango_DEVVAR_DOUBLEARRAY:
				returned_data = insert((double[])obj);
				break;
				
			case Tango_DEVVAR_STRINGARRAY:
				returned_data = insert((String[])obj);
				break;
				
			case Tango_DEVVAR_LONGSTRINGARRAY:
				returned_data = insert((DevVarLongStringArray)obj);
				break;
				
			case Tango_DEVVAR_DOUBLESTRINGARRAY:
				returned_data = insert((DevVarDoubleStringArray)obj);
				break;
				
			case Tango_DEV_STATE:
				returned_data = insert((DevState)obj);
				break;
			}				
				
		}
		catch(InvocationTargetException e)
		{
			throw (DevFailed)(e.getTargetException());
		}
		catch(IllegalArgumentException e)
		{
			StringBuffer mess = new StringBuffer("Argument error when trying to invoke method ");
			mess.append(exe_method);

			Except.throw_exception("API_MethodArgument",
					       mess.toString(),
				  	       "TemplCommandOut.execute()");
		}
		catch(IllegalAccessException e)
		{
			StringBuffer mess = new StringBuffer("Argument error when trying to invoke method ");
			mess.append(exe_method);

			Except.throw_exception("API_MethodArgument",
					       mess.toString(),
				  	       "TemplCommandOut.execute()");
		}
			
//
// Return the Any
//

		return returned_data;
	}			
}
