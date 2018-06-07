 Transforms coordinates from projection to another. Transformation class can be configured
 with property 'projection.library.class' (defaults to fi.nls.oskari.map.geometry.ProjectionHelper).

 Takes 'lan', 'lot', 'srs' and 'targetSRS' parameters and returns a JSONObject with transformed result:
 {
     lan: 123,
     lot : 456,
     srs : "EPSG:789"
 }
