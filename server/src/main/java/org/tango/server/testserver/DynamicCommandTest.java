/**
 * Copyright (C) :     2012
 *
 * 	Synchrotron Soleil
 * 	L'Orme des merisiers
 * 	Saint Aubin
 * 	BP48
 * 	91192 GIF-SUR-YVETTE CEDEX
 *
 * This file is part of Tango.
 *
 * Tango is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Tango is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tango.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.tango.server.testserver;

import org.tango.server.StateMachineBehavior;
import org.tango.server.command.CommandConfiguration;
import org.tango.server.command.ICommandBehavior;

import fr.esrf.Tango.DevFailed;

/**
 * To test dynamic commands
 * 
 * @author ABEILLE
 * 
 */
public final class DynamicCommandTest implements ICommandBehavior {
    private final CommandConfiguration configCmd = new CommandConfiguration();

    public DynamicCommandTest(final Class<?> clazz) throws DevFailed {
	configCmd.setName(clazz.getSimpleName() + "Dynamic");
	configCmd.setInType(clazz);
	configCmd.setOutType(clazz);
    }

    @Override
    public Object execute(final Object arg) throws DevFailed {
	return arg;
    }

    @Override
    public CommandConfiguration getConfiguration() throws DevFailed {
	return configCmd;
    }

    @Override
    public StateMachineBehavior getStateMachine() {
	return null;
    }

}
