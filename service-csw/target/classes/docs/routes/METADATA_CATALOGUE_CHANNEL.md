 Search channel for making CSW queries.

 Configurable by properties:
 - Server: search.channel.METADATA_CATALOGUE_CHANNEL.metadata.catalogue.server (defaults to "http://geonetwork.nls.fi")
 - QueryPath: search.channel.METADATA_CATALOGUE_CHANNEL.metadata.catalogue.path (defaults to "/geonetwork/srv/en/csw")
 - localized urls for images: search.channel.METADATA_CATALOGUE_CHANNEL.image.url.[lang code] (as contentURL in conjunction with resourceId)
 - localized urls for service: search.channel.METADATA_CATALOGUE_CHANNEL.fetchpage.url.[lang code] (as actionURL in conjunction with resourceId)
 - advanced filter fields (dropdowns) that are available on form based on the service:
      search.channel.METADATA_CATALOGUE_CHANNEL.fields (Note! Uses GetDomain Operation on CSW to populate values for fields)
 - per field processing definitions (each property prefixed with "search.channel.METADATA_CATALOGUE_CHANNEL.field.[field name]."):
      - isMulti: true to allow multiple values, defaults to false
      - dependencies: comma-separated list of dependent value pairs, for example "type.dependencies=service|serviceType" means that if type has
          value 'service' add to the same filter operation any serviceType parameters as single AND-operation
      - filter: maps the field to a property when creating query filter for example type.filter=gmd:hierarchyLevel maps the type value to gmd:hierarchyLevel when creating the query (defaults to field name)
      - shownIf: information for UI of a dependent field for example serviceType.shownIf=[{"type":"service"}] means that serviceType field should only be activate in UI if field "type" has value "service"
          showIf is closely related to dependencies field
      - filterOp: used for creating query and mapped in code to Deegree filter operations (defaults to LIKE operations)
      - mustMatch: true means the field will be treated as AND filter instead of OR when creating query filter (defaults to false)
      - blacklist: is a list of response values that will be filtered out

