package com.softwaremagico.tm.character.equipment;

/*-
 * #%L
 * Think Machine (Core)
 * %%
 * Copyright (C) 2017 Softwaremagico
 * %%
 * This software is designed by Jorge Hortelano Otero. Jorge Hortelano Otero
 * <softwaremagico@gmail.com> Valencia (Spain).
 *  
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *  
 * You should have received a copy of the GNU General Public License along with
 * this program; If not, see <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.softwaremagico.tm.Element;

public class Shield extends Element<Shield> {
	private final int impact;
	private final int force;
	private final int hits;

	public Shield(String name, int impact, int force, int hits) {
		super(null, name);
		this.impact = impact;
		this.force = force;
		this.hits = hits;
	}

	public int getImpact() {
		return impact;
	}

	public int getForce() {
		return force;
	}

	public int getHits() {
		return hits;
	}

}
