package datawave.ingest.nyctlc;

import com.google.common.collect.Multimap;
import datawave.ingest.data.RawRecordContainer;
import datawave.ingest.data.config.NormalizedContentInterface;
import datawave.ingest.data.config.ingest.BaseIngestHelper;

public class NYCTLCIngestHelper extends BaseIngestHelper {
    @Override
    public Multimap<String,NormalizedContentInterface> getEventFields(RawRecordContainer value) {
        return null;
    }
}
