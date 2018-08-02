/**
 * This is the GA menu bar.
 * It contains navigation and function links at te left and a lay-long indicator at the right.
 */
Ext.define('ga.widgets.GAMenuBar', {
    extend : 'Ext.panel.Panel',
    alias: 'widget.gamenubar',

    map: null,
    knownLayerStore: null,
    layerFactory: null,
    
    statics : {
        instructionManager : Ext.create('portal.util.help.InstructionManager', {}),
    },

    constructor : function(config){   
        
        var me = this;
        me.map = config.map;
        me.knownLayerStore = config.knownLayerStore;
        me.layerFactory = config.layerFactory;
        
        // Create our Print Map handler         
        var printMapHandler = function() {   
            var heightPxNumber = Ext.get('center_region').getHeight() - 27;
            var widthPxNumber = Ext.get('center_region').getWidth();

            // create some print-only css rules to apply before printing
            var printCSS1 = 'html, body {\
                margin: 0 0 0 0 !important;\
                padding: 0 0 0 0 !important;\
                height: 99% !important;\
                background-color: #ffffff !important;\
            }\
            div {\
                border: none !important;\
                margin: 0 0 0 0 !important;\
                page-break-after: avoid !important;\
            }\
            .x-panel, .x-tip, .x-splitter {\
                display: none !important;\
                height: 0px !important;\
                width: 0px !important;\
                border: none !important;\
            }\
            #center_region {\
                display: block !important;\
                top: 0px !important;\
                left: 0px !important;\
                height: ';

            var printCSS2 = 'px !important;\
                width: ';

            var printCSS3 = 'px !important;\
            }\
            #center_region-body {\
                padding: 0 0 0 0 !important;\
            }\
            .olButton, .olAlphaImg {\
                display: none !important;\
            }\
            @media print\
            {\
                * {-webkit-print-color-adjust:exact;}\
            }';

            var printCSS = printCSS1 + heightPxNumber + printCSS2 + widthPxNumber + printCSS3;

            // use the browser print() function with the new styles applied
            Ext.util.CSS.createStyleSheet(printCSS, 'printCSSLink');            
            window.print();            
            Ext.util.CSS.removeStyleSheet('printCSSLink');    
            portal.util.GoogleAnalytic.trackevent('PrintMapHandlerClick', 'Print Map', 'http://portal.geoscience.gov.au');
        };        
    
        // Create our Clear Map handler
        // revert to the default zoom level, map extent and remove all our layers
        var clearMapHandler = function() {
            
            ActiveLayerManager.removeAllLayers(me.map);
            
            me.map.setZoom(4); 
            var center = new portal.map.Point({longitude:133.3, latitude: -26});
            me.map.setCenter(center);

            /* set the Base Layer for the map */ 
            Ext.each(me.map.layerSwitcher.baseLayers, function(baseLayer) {
                if (baseLayer.layer.name === "Google Satellite") {
                    me.map.map.setBaseLayer(baseLayer.layer);
                    return false;
                }
            });
            
            
            
            // if the browser supports local storage, clear the stored map state
            if(typeof(Storage) !== "undefined") {
                localStorage.removeItem("portalStorageApplicationState");
                localStorage.removeItem("portalStorageDefaultBaseLayer");
            }
            portal.util.GoogleAnalytic.trackevent('ClearMapHandlerClick', 'Clear Map', 'http://portal.geoscience.gov.au');
        };    
    
        // Create our Refresh Map handler
        var refreshMapHandler = function() {
            ActiveLayerManager.saveApplicationState(me.map);

            // Refresh the whole browser window
            portal.util.GoogleAnalytic.trackevent('RefreshMapHandlerClick', 'Refresh Map', 'http://portal.geoscience.gov.au');
            
        	window.location.reload();
        };
        
        var scannedMapsHandler = function() {
            
            clearMapHandler();
            var id = "250K-scanned-geological-maps";
                    
            var knownLayer = me.knownLayerStore.getById(id);
            var scannedMapsLayer = me.layerFactory.generateLayerFromKnownLayer(knownLayer);
            knownLayer.set('layer', scannedMapsLayer);

            var filterParams = {bbox: {"westBoundLongitude":"102","southBoundLatitude":"…157","northBoundLatitude":"-2","crs":"EPSG:4326"}, opacity: 1}
            var filterer = scannedMapsLayer.get('filterer');
            filterer.setParameters(filterParams);
            var renderer = scannedMapsLayer.get('renderer');
            renderer.displayData(scannedMapsLayer.getAllOnlineResources(),filterer,Ext.emptyFn);
            ActiveLayerManager.addLayer(scannedMapsLayer);
            portal.util.GoogleAnalytic.trackevent('ScannedMapsHandlerClick', id, id);
        }
        
        //Create our permalink generation handler
        var permalinkHandler = function() {
            var mss = Ext.create('portal.util.permalink.MapStateSerializer');
    
            mss.addMapState(me.map);
            mss.addLayers(me.map);
    
            mss.serialize(function(state, version) {
                var popup = Ext.create('portal.widgets.window.PermanentLinkWindow', {
                    state : state,
                    version : version,
                    mapStateSerializer: mss
                });
                portal.util.GoogleAnalytic.trackevent('PermanentLinkHandlerClick', 'Permanent Link', 'Map state: ' +state + '; version: '+version);
                
                popup.show();
                
            });
           
        };
        
        var helpHandler = function() {
            ga.widgets.GAMenuBar.instructionManager.showInstructions([Ext.create('portal.util.help.Instruction', {
                highlightEl : 'auscope-tabs-panel',
                title : 'Find data/layers',
                description : 'In this panel a list of all available datasets in the form of layers will be presented to you.  Select the layer you would like to visualise.<br><br>Selecting a layer will expand any advanced filter options. If you do not wish to filter your datasets, you can visualise the data by clicking "Add to Map".<br/><br/>Further information about the data behind each layer can be displayed by clicking the icons alongside the layer name.'
            }),Ext.create('portal.util.help.Instruction', {
                highlightEl : 'hh-searchfield-Featured',
                title : 'Search Layer',
                description : 'Allow you to filter through the layers via the layer\'s name. Enter a key and click the magnifying glass to filter'
            }),Ext.create('portal.util.help.Instruction', {
                highlightEl : 'latlng',
                anchor : 'left',
                title : 'Mouse Coordinate',
                description : 'Display the coordinate of the mouse on the map'
            }),Ext.create('portal.util.help.Instruction', {
                highlightEl : 'permanent-link',
                anchor : 'left',
                title : 'Permanent Link',
                description : 'Create a link that captures the current state of the user session.'
            }),Ext.create('portal.util.help.Instruction', {
                highlightEl : 'help-link',
                anchor : 'left',
                title : 'User guide',
                description : 'For more information, refer to the user guide.'
            })]);
        };
            
  
        Ext.apply(config, {
            height: '40px',
            items: [{
                xtype: 'box',
                id: 'menu-bar',                    
                autoEl: {
                    tag: 'div',
                    html: '<ul>\
                               <li data-qtip="AusGIN Home"><a id="home-link" href="http://www.geoscience.gov.au"><img src="img/home.png" width="16" height="16"/></a></li>\
                               <li data-qtip="Quick link for Scanned 250K Geological Maps"><a id="scanned-maps-link" href="javascript:void(0)">SCANNED 250K GEOLOGICAL MAPS</a></li>\
                               <li data-qtip="Print the current map"><a id="print-map-link" href="javascript:void(0)">PRINT MAP</a></li>\
                               <li data-qtip="Clear all active layers and recentre the map"><a id="clear-map-link" href="javascript:void(0)">CLEAR MAP</a></li>\
                    		   <li data-qtip="Reload the page. All active Featured Layers (but not Custom Layers) will be reloaded into the map at the last zoom level. Use this to reactivate any buttons or menus that have frozen or disappeared.">\
                               <a id="refresh-map-link" href="javascript:void(0)">REFRESH MAP</a></li>\
                               <li data-qtip="Save the current map layers and zoom position as a URL link. Only Featured Layers (not Custom Layers) are saved in this URL."> \
                               <a id="permanent-link" href="javascript:void(0)"> PERMANENT LINK </a> </li>\
                               <li><a id="help-link" href="javascript:void(0)"> HELP </a> </li>\
                               <span id="latlng"></span>\
                           </ul>'
               }                    
            }],

                
            listeners: {
                render: function (view) {
                	Ext.get('home-link').on('click', function() {
                		portal.util.GoogleAnalytic.trackevent('HomeClick',  'home', 'http://www.geoscience.gov.au');
                		});
                    Ext.get('print-map-link').on('click', printMapHandler);
                    Ext.get('scanned-maps-link').on('click', scannedMapsHandler); 
                    Ext.get('clear-map-link').on('click', clearMapHandler); 
                    Ext.get('refresh-map-link').on('click', refreshMapHandler);  
                    Ext.get('permanent-link').on('click', permalinkHandler); 
                    Ext.get('help-link').on('click', helpHandler); 
                }
            }
            
        });
    
        this.callParent(arguments);
    
    }    
    
});