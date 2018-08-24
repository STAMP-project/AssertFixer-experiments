package com.github.funthomas424242.rades.fluentbuilder.infrastructure.text;

/*-
 * #%L
 * rades.fluent-builder
 * %%
 * Copyright (C) 2018 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TextConverterTest {

    @Test
    @DisplayName("Konstruktion gültiger Instanzen möglich")
    public void canCreateValidObjectInstanz() {
        final TextConverter converter = new TextConverter(" ");
        assertNotNull(converter);
    }

    @Test
    @DisplayName("Keine Konstruktion ungültiger Instanzen möglich")
    public void cantCreateInvalidObjectInstanz() {
        assertThrows(IllegalArgumentException.class, () -> new TextConverter(null));
    }

}
