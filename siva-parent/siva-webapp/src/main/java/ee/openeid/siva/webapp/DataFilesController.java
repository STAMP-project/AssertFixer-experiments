/*
 * Copyright 2017 Riigi Infosüsteemide Amet
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and limitations under the Licence.
 */

package ee.openeid.siva.webapp;

import ee.openeid.siva.proxy.DataFilesProxy;
import ee.openeid.siva.validation.document.report.DataFilesReport;
import ee.openeid.siva.webapp.request.JSONDataFilesRequest;
import ee.openeid.siva.webapp.transformer.DataFilesRequestToProxyDocumentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DataFilesController {

    private DataFilesProxy dataFilesProxy;
    private DataFilesRequestToProxyDocumentTransformer transformer;

    @RequestMapping(value = "/getDataFiles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public DataFilesReport getDataFiles(@Valid @RequestBody JSONDataFilesRequest dataFilesRequest) {
        return dataFilesProxy.getDataFiles(transformer.transform(dataFilesRequest));
    }

    @Autowired
    public void setDataFilesProxy(DataFilesProxy dataFilesProxy) {
        this.dataFilesProxy = dataFilesProxy;
    }

    @Autowired
    public void setDataFilesTransformer(DataFilesRequestToProxyDocumentTransformer transformer) {
        this.transformer = transformer;
    }
}
