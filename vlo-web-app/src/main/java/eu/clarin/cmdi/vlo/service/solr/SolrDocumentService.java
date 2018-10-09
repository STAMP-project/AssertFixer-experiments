/*
 * Copyright (C) 2014 CLARIN
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
package eu.clarin.cmdi.vlo.service.solr;

import eu.clarin.cmdi.vlo.pojo.QueryFacetsSelection;
import java.util.List;
import org.apache.solr.common.SolrDocument;

/**
 *
 * @author twagoo
 */
public interface SolrDocumentService {
    
    SolrDocument getDocument(String docId);
    
    SolrDocumentExpansionPair getDocumentWithExpansion(String docId, String collapseField, QueryFacetsSelection selection, int expansionFirst, int expansionCount);

    List<SolrDocument> getDocuments(QueryFacetsSelection selection, int first, int count);
    
    SolrDocumentExpansionList getDocumentsWithExpansion(QueryFacetsSelection selection, int first, int count, String collapseField);
    
    long getDocumentCount(QueryFacetsSelection selection);

}
