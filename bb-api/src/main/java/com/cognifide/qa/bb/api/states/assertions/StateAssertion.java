/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2018 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.api.states.assertions;

import org.hamcrest.Matcher;
import org.junit.Assert;

import com.cognifide.qa.bb.api.actors.Actor;
import com.cognifide.qa.bb.api.states.Assertion;
import com.cognifide.qa.bb.api.states.State;

public class StateAssertion<T> implements Assertion {
  private final State<T> state;
  private final Matcher<T> matcher;

  public StateAssertion(State<T> state, Matcher<T> matcher) {
    this.state = state;
    this.matcher = matcher;
  }

  @Override
  public void assertedBy(Actor actor) {
    Assert.assertThat(state.observedBy(actor), matcher);
  }
}
