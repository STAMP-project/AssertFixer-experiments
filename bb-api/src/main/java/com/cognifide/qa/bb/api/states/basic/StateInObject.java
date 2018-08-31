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
package com.cognifide.qa.bb.api.states.basic;

import java.util.function.Function;

import com.cognifide.qa.bb.api.actors.Actor;
import com.cognifide.qa.bb.api.actors.abilities.PerformBasicOperations;
import com.cognifide.qa.bb.api.states.State;

public class StateInObject<T, R> implements State<R> {

  private final Function<T, R> element;
  private Class<T> type;

  private StateInObject(Class<T> type, Function<T, R> element) {
    this.type = type;
    this.element = element;
  }

  @Override
  public R observedBy(Actor actor) {
    T object = actor.thatCan(PerformBasicOperations.class).instantiate(type);
    return element.apply(object);
  }

  public static <T, R> StateInObject<T, R> of(Class<T> type, Function<T, R> elementGetter) {
    return new StateInObject<>(type, elementGetter);
  }
}
