 This interface gives the relevant information for one indicator to the frontend.
 This information can be subsequently used to query the actual indicator data.
 
 - action_route=GetIndicatorMetadataHandler
 
 eg.
 OSKARI_URL?action_route=GetIndicatorSelectorMetadata?datasource=1&indicator=2
 Response is in JSON, and contains the indicator selector metadata for one indicator.
