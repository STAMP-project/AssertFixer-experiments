 CreateUserLayer allows users to upload a collection of features to be stored in the system.

 The uploaded file must be a ZIP file and must contain a set of valid files within.
 Currently supported file formats are:
 - GPX ({name}.gpx file must be found within the zip)
 - KML ({name}.kml)
 - MIF ({name}.mif)
 - SHP ({name}.shp)
 @see org.oskari.map.userlayer.input.FeatureCollectionParsers

 For some of the file formats (GPX, KML) the coordinate reference system is fixed
 (both use EPSG:4326,lon,lat coordinates). For MIF and SHP we try to detect the coordinate
 reference system automatically. If the detection fails (for example there's no .prj file
 in the SHP case) we use client submitted value ('sourceEpsg' parameter) as a fallback.
