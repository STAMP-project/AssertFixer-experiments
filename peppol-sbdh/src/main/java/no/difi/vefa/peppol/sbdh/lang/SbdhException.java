/*
 * Copyright 2015-2017 Direktoratet for forvaltning og IKT
 *
 * This source code is subject to dual licensing:
 *
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 *
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 */

package no.difi.vefa.peppol.sbdh.lang;

import no.difi.vefa.peppol.common.lang.PeppolException;

import java.util.List;

public class SbdhException extends PeppolException {

    public SbdhException(String message) {
        super(message);
    }

    public SbdhException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void notNull(String message, Object... objects) throws SbdhException {
        for (Object o : objects) {
            if (o == null)
                throw new SbdhException(message);
            else if (o instanceof List && ((List) o).size() == 0)
                throw new SbdhException(message);
        }
    }
}
