/*
 * Copyright (c) 2018 Dann Ryan Hilario
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.dhilar.phzip;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonStates;
import io.dhilar.phzip.core.NoStateFoundException;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.States;
import io.dhilar.phzip.core.model.State;


public class StatesTest {

  private States jsonStates;

  @BeforeEach
  public void setup() throws IOException {

    jsonStates = new JsonStates(CountryCodes.US);
  }

  @Test
  @DisplayName("Returned list of US states are unmodifiable")
  public void getAllStates_UnmodifiableList() throws IOException {

    assertThrows(UnsupportedOperationException.class, () -> {
      List<State> states = jsonStates.getAllStates(SortDirection.ASC);
      states.add(new State());
    });
  }

  @Test
  public void getAllStates_Ascending() throws IOException {

    List<State> states = jsonStates.getAllStates(SortDirection.ASC);

    assertAll("states", () -> assertEquals(55, states.size()),
        () -> assertEquals(new Integer(10001), states.get(1).getId()),
        () -> assertEquals("Arizona", states.get(1).getName()),
        () -> assertEquals("AZ", states.get(1).getAbbreviation()),
        () -> assertEquals("District of Columbia", states.get(7).getName()),
        () -> assertEquals("Washington DC", states.get(7).getAlt().get(0)),
        () -> assertEquals("Washington D.C.", states.get(7).getAlt().get(1)),
        () -> assertEquals("Wyoming", states.get(54).getName()));
  }

  @Test
  public void getAllStates_Descending() throws IOException {

    List<State> states = jsonStates.getAllStates(SortDirection.DESC);

    assertAll("states", () -> assertEquals(55, states.size()),
        () -> assertEquals("Wyoming", states.get(0).getName()),
        () -> assertEquals("District of Columbia", states.get(47).getName()),
        () -> assertEquals("Arizona", states.get(53).getName()));
  }

  @Test
  public void getAllStates_ProvinceNotSupported() throws IOException {

    assertThrows(NoStateFoundException.class, () -> {
      jsonStates = new JsonStates(CountryCodes.PH);
      jsonStates.getAllStates(SortDirection.DESC);
    });
  }

  @Test
  public void getStateById() throws IOException {

    State state = jsonStates.getStateById(10006);

    assertEquals(new Integer(10006), state.getId());
    assertEquals("District of Columbia", state.getName());
    assertEquals("Washington DC", state.getAlt().get(0));
  }

  @Test
  public void getStateById_ProvinceNotSupported() throws IOException {

    assertThrows(NoStateFoundException.class, () -> {
      jsonStates = new JsonStates(CountryCodes.PH);
      jsonStates.getStateById(10006);
    });
  }
}
