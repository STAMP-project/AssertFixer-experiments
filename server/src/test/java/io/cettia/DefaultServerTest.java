/*
 * Copyright 2018 the original author or authors.
 *
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
 */
package io.cettia;

import io.cettia.DefaultServer.DefaultServerSocket;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Donghwan Kim
 */
public class DefaultServerTest {

  @Test
  public void find() {
    DefaultServer server = new DefaultServer();
    DefaultServerSocket socket1 = mock(DefaultServerSocket.class);
    when(socket1.id()).thenReturn("A");
    DefaultServerSocket socket2 = mock(DefaultServerSocket.class);
    when(socket2.id()).thenReturn("B");
    DefaultServerSocket socket3 = mock(DefaultServerSocket.class);
    when(socket3.id()).thenReturn("C");

    server.sockets.put("A", socket1);
    server.sockets.put("B", socket2);
    server.sockets.put("C", socket3);

    Set<ServerSocket> result = new LinkedHashSet<>();
    server.find(ServerSocketPredicates.all(), socket -> result.add(socket));
    assertEquals(new LinkedHashSet<>(Arrays.asList(socket1, socket2, socket3)), result);

    result.clear();
    server.find(ServerSocketPredicates.id("A"), socket -> result.add(socket));
    assertEquals(new LinkedHashSet<>(Arrays.asList(socket1)), result);

    result.clear();
    server.find(ServerSocketPredicates.id("A").negate(), socket -> result.add(socket));
    assertEquals(new LinkedHashSet<>(Arrays.asList(socket2, socket3)), result);
  }

}
