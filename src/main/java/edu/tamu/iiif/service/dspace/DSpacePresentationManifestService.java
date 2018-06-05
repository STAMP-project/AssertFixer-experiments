package edu.tamu.iiif.service.dspace;

import static edu.tamu.iiif.constants.Constants.DSPACE_HAS_COLLECTION_PREDICATE;
import static edu.tamu.iiif.constants.Constants.DSPACE_HAS_ITEM_PREDICATE;
import static edu.tamu.iiif.model.ManifestType.PRESENTATION;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.jena.rdf.model.NodeIterator;
import org.springframework.stereotype.Service;

import de.digitalcollections.iiif.presentation.model.api.v2.Canvas;
import de.digitalcollections.iiif.presentation.model.api.v2.Image;
import de.digitalcollections.iiif.presentation.model.api.v2.Manifest;
import de.digitalcollections.iiif.presentation.model.api.v2.Metadata;
import de.digitalcollections.iiif.presentation.model.api.v2.Sequence;
import de.digitalcollections.iiif.presentation.model.api.v2.Thumbnail;
import de.digitalcollections.iiif.presentation.model.impl.v2.ManifestImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.PropertyValueSimpleImpl;
import de.digitalcollections.iiif.presentation.model.impl.v2.ThumbnailImpl;
import edu.tamu.iiif.model.ManifestType;
import edu.tamu.iiif.model.rdf.RdfResource;

@Service
public class DSpacePresentationManifestService extends AbstractDSpaceManifestService {

    public String generateManifest(String handle) throws IOException, URISyntaxException {

        RdfResource rdfResource = getDSpaceRdfModel(handle);

        URI id = buildId(handle);

        PropertyValueSimpleImpl label = getTitle(rdfResource);

        Manifest manifest = new ManifestImpl(id, label);

        manifest.setDescription(getDescription(rdfResource));

        List<Sequence> sequences = getSequences(rdfResource);

        manifest.setSequences(sequences);

        manifest.setLogo(getLogo(rdfResource));

        List<Metadata> metadata = getDublinCoreMetadata(rdfResource);

        metadata.addAll(getDublinCoreTermsMetadata(rdfResource));

        manifest.setMetadata(metadata);

        Optional<Thumbnail> thumbnail = getThumbnail(sequences);
        if (thumbnail.isPresent()) {
            manifest.setThumbnail(thumbnail.get());
        }

        Optional<String> license = getLicense(rdfResource);
        if (license.isPresent()) {
            manifest.setLicense(license.get());
        }

        return mapper.writeValueAsString(manifest);
    }

    private List<Sequence> getSequences(RdfResource rdfResource) throws IOException, URISyntaxException {
        List<Sequence> sequences = new ArrayList<Sequence>();

        // NOTE: flattening all sequence canvases into a single canvas, feature parity with Fedora presentation
        List<Sequence> broadSequences = aggregateSequences(rdfResource);

        if (broadSequences.size() > 0) {
            Sequence sequence = broadSequences.get(0);

            List<Canvas> canvases = sequence.getCanvases();

            broadSequences.remove(0);

            broadSequences.forEach(seq -> {
                seq.getCanvases().forEach(canvas -> {
                    canvases.add(canvas);
                });
            });

            sequence.setCanvases(canvases);
            sequences.add(sequence);
        }

        return sequences;
    }

    private List<Sequence> aggregateSequences(RdfResource rdfResource) throws IOException, URISyntaxException {
        List<Sequence> sequences = new ArrayList<Sequence>();
        if (isTopLevelCommunity(rdfResource.getModel()) || isSubcommunity(rdfResource.getModel())) {

            NodeIterator collectionIterator = rdfResource.getAllNodesOfPropertyWithId(DSPACE_HAS_COLLECTION_PREDICATE);
            while (collectionIterator.hasNext()) {
                String uri = collectionIterator.next().toString();
                String handle = getHandle(uri);
                sequences.addAll(aggregateSequences(getDSpaceRdfModel(handle)));
            }

        } else if (isCollection(rdfResource.getModel())) {

            NodeIterator collectionIterator = rdfResource.getAllNodesOfPropertyWithId(DSPACE_HAS_ITEM_PREDICATE);
            while (collectionIterator.hasNext()) {
                String uri = collectionIterator.next().toString();
                String handle = getHandle(uri);
                sequences.addAll(aggregateSequences(getDSpaceRdfModel(handle)));
            }

        } else if (isItem(rdfResource.getModel())) {
            sequences.add(generateSequence(rdfResource));
        } else {

        }
        return sequences;
    }

    private Optional<Thumbnail> getThumbnail(List<Sequence> sequences) throws URISyntaxException {
        Optional<Thumbnail> optionalThumbnail = Optional.empty();
        exit: for (Sequence sequence : sequences) {
            for (Canvas canvas : sequence.getCanvases()) {
                for (Image image : canvas.getImages()) {
                    if (Optional.ofNullable(image.getResource()).isPresent()) {
                        URI serviceURI = image.getResource().getServices().get(0).getId();
                        Thumbnail thubmnail = new ThumbnailImpl(serviceUrlToThumbnailUri(serviceURI));
                        thubmnail.setServices(image.getResource().getServices());
                        optionalThumbnail = Optional.of(thubmnail);
                        continue exit;
                    }
                }
            }
        }
        return optionalThumbnail;
    }

    @Override
    protected ManifestType getManifestType() {
        return PRESENTATION;
    }

}
