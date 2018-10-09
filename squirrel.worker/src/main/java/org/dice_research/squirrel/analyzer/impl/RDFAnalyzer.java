package org.dice_research.squirrel.analyzer.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jena.graph.Triple;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RDFLanguages;
import org.apache.jena.riot.system.StreamRDF;
import org.apache.jena.riot.system.StreamRDFBase;
import org.apache.jena.sparql.core.Quad;
import org.apache.tika.Tika;
import org.apache.tika.io.IOUtils;
import org.dice_research.squirrel.Constants;
import org.dice_research.squirrel.analyzer.Analyzer;
import org.dice_research.squirrel.collect.UriCollector;
import org.dice_research.squirrel.data.uri.CrawleableUri;
import org.dice_research.squirrel.metadata.ActivityUtil;
import org.dice_research.squirrel.sink.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RDFAnalyzer implements Analyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RDFAnalyzer.class);

    private UriCollector collector;

    private List<Lang> listLangs = new ArrayList<Lang>();

    public RDFAnalyzer(UriCollector collector) {
        this.collector = collector;
        listLangs.add(Lang.NT);
        listLangs.add(Lang.NQUADS);
        listLangs.add(Lang.RDFJSON);
        listLangs.add(Lang.RDFTHRIFT);
        listLangs.add(Lang.RDFXML);
        listLangs.add(Lang.JSONLD);
        listLangs.add(Lang.TRIG);
        listLangs.add(Lang.TRIX);
        listLangs.add(Lang.TTL);
        listLangs.add(Lang.TURTLE);
    }

    @Override
    public Iterator<byte[]> analyze(CrawleableUri curi, File data, Sink sink) {
        FileInputStream fin = null;
        try {
            // First, try to get the language of the data
            Lang lang = null;
            String contentType = (String) curi.getData(Constants.URI_HTTP_MIME_TYPE_KEY);
            StreamRDF filtered = new FilterSinkRDF(curi, sink, collector);
            if (contentType != null) {
                lang = RDFLanguages.contentTypeToLang(contentType);
                RDFDataMgr.parse(filtered, data.getAbsolutePath(), lang);
            } else {
                for (Lang l : listLangs) {
                    try {
                        RDFDataMgr.parse(filtered, data.getAbsolutePath(), l);
                        break;
                    } catch (Exception e) {
                        LOGGER.warn("Could not parse file as " + l.getName());
                    }
                }
            }
            ActivityUtil.addStep(curi, getClass());
            return collector.getUris(curi);
        } catch (Exception e) {
            LOGGER.error("Exception while analyzing. Aborting. ", e);
            ActivityUtil.addStep(curi, getClass(), e.getMessage());
            return null;
        } finally {
            IOUtils.closeQuietly(fin);
        }
    }

    protected class FilterSinkRDF extends StreamRDFBase {

        private CrawleableUri curi;
        private Sink sink;
        private UriCollector collector;

        public FilterSinkRDF(CrawleableUri curi, Sink sink, UriCollector collector) {
            this.curi = curi;
            this.sink = sink;
            this.collector = collector;
        }

        @Override
        public void triple(Triple triple) {
            sink.addTriple(curi, triple);
            collector.addTriple(curi, triple);
        }

        @Override
        public void quad(Quad quad) {
            sink.addTriple(curi, quad.asTriple());
            collector.addTriple(curi, quad.asTriple());
        }

    }

//    @Override
    public boolean isElegible(CrawleableUri curi, File data) {
        Tika tika = new Tika();
        // Check the content type first
        String contentType = (String) curi.getData(Constants.URI_HTTP_MIME_TYPE_KEY);
        if ((contentType != null) && (contentType.equals("application/rdf+xml") || contentType.equals("text/plain")
                || contentType.equals("application/x-turtle"))) {
            return true;
        }
        // Try to get the tika mime type
        // TODO it might be better to do that once and add it to the URIs data
        try (InputStream is = new FileInputStream(data)) {
            String mimeType = tika.detect(is);
            if (mimeType.equals("application/rdf+xml") || mimeType.equals("text/plain")
                    || mimeType.equals("application/x-turtle")) {
                return true;
            }

        } catch (Exception e) {
            LOGGER.error("An error was found when trying to analyze ", e);
        }
        return false;
    }

}
