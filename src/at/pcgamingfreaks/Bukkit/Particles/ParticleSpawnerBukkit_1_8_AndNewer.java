/*
 *   Copyright (C) 2016 GeorgH93
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package at.pcgamingfreaks.Bukkit.Particles;

import at.pcgamingfreaks.Bukkit.MCVersion;
import at.pcgamingfreaks.Bukkit.NMSReflection;

import org.apache.commons.lang3.Validate;
import org.bukkit.Location;

import java.lang.reflect.Constructor;

class ParticleSpawnerBukkit_1_8_AndNewer extends ParticleSpawnerBukkit
{
	private static final Constructor PACKET_CONSTRUCTOR = NMSReflection.getConstructor(NMSReflection.getNMSClass("PacketPlayOutWorldParticles"), NMSReflection.getNMSClass("EnumParticle"), boolean.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class, int[].class);

	@Override
	public void spawnParticle(Location location, Particle particle, double visibleRange, int count, float offsetX, float offsetY, float offsetZ, float speed)
	{
		spawnParticle(location, particle, visibleRange, count, offsetX, offsetY, offsetZ, speed, new int[0]);
	}

	@Override
	protected void spawnParticle(Location location, Particle particle, double visibleRange, int count, float offsetX, float offsetY, float offsetZ, float speed, int[] data)
	{
		Validate.notNull(particle.getEnum());
		Validate.isTrue(MCVersion.isNewerOrEqualThan(particle.getMinVersion()), "The %s particle is not available in your minecraft version!", particle.getName());
		try
		{
			//noinspection ConstantConditions
			spawnParticle(location, visibleRange, PACKET_CONSTRUCTOR.newInstance(particle.getEnum(), false, (float) location.getX(), (float) location.getY(), (float) location.getZ(), offsetX, offsetY, offsetZ, speed, count, data));
		}
		catch(Exception e)
		{
			System.out.println("Unable to spawn particle " + particle.getOldName() + ". (Version 1.8 and newer)");
			e.printStackTrace();
		}
	}
}