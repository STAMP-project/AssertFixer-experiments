/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.core.internal;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Throwables {
    private Throwables() {
        throw new UnsupportedOperationException("utility class");
    }

    /**
     * unchecked throws t. Returns a bogus exception for compiler satisfaction: always throw the return value even though you'll never get it.
     */
    public static RuntimeException sneakyThrow(Throwable t) {
        if (t instanceof Error) {
            throw (Error) t;
        }

        if (t instanceof RuntimeException) {
            throw (RuntimeException) t;
        }

        if (t instanceof IOException) {
            throw new UncheckedIOException((IOException) t);
        }

        throw new RuntimeException(t);
    }
}
