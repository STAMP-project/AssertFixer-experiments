/*
 * Copyright (C) 2018 CLARIN
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.clarin.cmdi.vlo.wicket.panels.search;

import eu.clarin.cmdi.vlo.FacetConstants;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.util.convert.IConverter;

/**
 * Converter that renders short versions of landing page links (handle or
 * hostname)
 *
 * @author Twan Goosen <twan@clarin.eu>
 */
class LandingPageShortLinkLabelConverter implements IConverter<String> {

    private static final Pattern URL_HOST_PATTERN = Pattern.compile("^https?:\\/\\/([^\\\\/]+)", Pattern.CASE_INSENSITIVE);

    @Override
    public String convertToObject(String value, Locale locale) throws ConversionException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String convertToString(String value, Locale locale) {
        final String lcValue = value.toLowerCase();
        if (lcValue.startsWith(FacetConstants.HANDLE_PREFIX)) {
            return value.substring(FacetConstants.HANDLE_PREFIX.length());
        }
        if (lcValue.startsWith(FacetConstants.HANDLE_PROXY)) {
            return value.substring(FacetConstants.HANDLE_PROXY.length());
        }
        if (lcValue.startsWith(FacetConstants.HANDLE_PROXY_HTTPS)) {
            return value.substring(FacetConstants.HANDLE_PROXY_HTTPS.length());
        }
        final Matcher matcher = URL_HOST_PATTERN.matcher(value);
        if (matcher.find() && matcher.groupCount() > 0) {
            return matcher.group(1);
        } else {
            return value;
        }
    }

}
