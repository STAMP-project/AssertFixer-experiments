/**
 *
 * This is the paging panel used for GA Search Results
 *
 */
Ext.define('ga.widgets.GASearchResultsPanel', {
    extend : 'Ext.grid.Panel',
    alias: 'widget.gasearchresultspanel',

    cswRecordStore : null,
    pageSize: 20,
    displayTemplate: null,
    map : null,
    layerFactory : null,
    layerStore : null,

    constructor : function(cfg) {
        var me = this;

        me.cswRecordStore = cfg.store;
       
        me.map = cfg.map;
        me.layerStore = cfg.layerStore;
        
        me.layerFactory = cfg.layerFactory;
        
        Ext.apply(cfg, {
            hideHeaders : true,
            height: 200,
            layout : 'fit',

            columns: [{
                //Title column
                dataIndex: 'onlineResource',
                sortable: false,
                cellWrap : true,
                flex: 1,
                xtype: 'componentcolumn', 
                autoWidthComponents : false,
                renderer: Ext.bind(me._cellRenderer, me)
            }],
            store : this.cswRecordStore,
            viewConfig : {
                forceFit : true,
                enableRowBody:true
            },

            loadMask : {msg : 'Performing CSW Filter...'},
            multiSelect: true,
            dockedItems: [{
                xtype: 'pagingtoolbar',
                pageSize: me.pageSize,
                store: me.cswRecordStore,
                dock: 'bottom',
                displayInfo: true
            }],
            listeners : {
                afterrender : function(grid,eOpts) {
                    grid.cswRecordStore.load();
                    
                },
                
                // when the view is fully loaded we need to check for availability of some features and update the DOM                    
                afterlayout: function(view) {

                    me.cswRecordStore.each(function(record,id){
                        var hasWMSResource = false;
                        var hasDownloadableData = false;

                        var onlineResources = record.data.onlineResources;

                        for (var i = 0; i < onlineResources.length; i++) {
                            var type = onlineResources[i].get('type');
                            if (type == portal.csw.OnlineResource.WMS) {
                                hasWMSResource = true;
                            } else if (type == portal.csw.OnlineResource.UNSUPPORTED || type == portal.csw.OnlineResource.WWW || type == portal.csw.OnlineResource.FTP) {
                                hasDownloadableData = true;
                            }
                        };
                        var uris = record.get('datasetURIs');
                        if (uris && uris.length > 0 && uris[0]) hasDownloadableData = true;

                        me._activateLinkForDisplay(record, hasDownloadableData, '_downloadDataLink', function() {me.displayFileDownloadWindow(record)})

                        me._activateLinkForDisplay(record, hasWMSResource, '_addWMSLink', function() {me.displayWMSLayers(record)})
                        
                    });
                   
                }
            }

        });

      this.callParent(arguments);
    },

    _activateLinkForDisplay : function(record, activateLink, linkIdSuffix, clickFunction) {
        var linkId = '_' + record.get('id').replace(/\W/g, '') + linkIdSuffix; 

        var element = Ext.get(linkId);

        if (!activateLink) {
            element.addCls('pretendLinkDisabled');
            element.removeCls('pretendLinkEnabled');
        } else {
            element.addCls('pretendLinkEnabled');
            element.removeCls('pretendLinkDisabled');
            element.addListener('click', clickFunction);
        };
    },

    /**
     * On single click, show a highlight of all BBoxes
     */
    showSpatialBounds : function(record) {
        var me = this;
        var spatialBoundsArray;
        if (record.internalId == 'portal-InSar-reports') {
            spatialBoundsArray = this.getWholeGlobeBounds();
        } else {
            spatialBoundsArray = this.getSpatialBoundsForRecord(record);
        }
        var nonPointBounds = [];

        //No point showing a highlight for bboxes that are points
        for (var i = 0; i < spatialBoundsArray.length; i++) {
            var bbox = spatialBoundsArray[i];
            if (bbox.southBoundLatitude !== bbox.northBoundLatitude ||
                bbox.eastBoundLongitude !== bbox.westBoundLongitude) {

                //VT: Google map uses EPSG:3857 and its maximum latitude is only 85 degrees
                // anything more will stretch the transformation
                if(bbox.northBoundLatitude>85){
                    bbox.northBoundLatitude=85;
                }
                if(bbox.southBoundLatitude<-85){
                    bbox.southBoundLatitude=-85;
                }
                nonPointBounds.push(bbox);
            }
        }

        me.map.highlightBounds(nonPointBounds);
    },    
    
    /**
     * Helper function.  Useful to define here for subclasses.
     *
     * Return the max bbox for insar layer as it is a dummy CSW.
     */
    getWholeGlobeBounds : function() {
        var bbox = new Array();
        bbox[0] = Ext.create('portal.util.BBox', {
            northBoundLatitude : 85,
            southBoundLatitude : -85,
            eastBoundLongitude : 180,
            westBoundLongitude : -180
        });
        return bbox;
    },
    
    getSpatialBoundsForRecord : function(record) {
        return record.data.geographicElements;
    },
        
    
    // renderer for the details of the resource (name, description, links)
    _cellRenderer : function(value, metaData, record, row, col, store) {        
        var me = this;       
        
        if (record) {
            var name = record.get('name');            
            
            //Ensure there is a title (even it is just '<Untitled>'
            if (!name || name.length === 0) {
                name = '&lt;Untitled&gt;';
            }
            
            var description = record.get('description');
            //Truncate description
            var maxLength = 300;
            if (description.length > maxLength) {
                description = description.substring(0, maxLength) + '...';
            }        
            
            var recordInfoUrl = record.get('recordInfoUrl');
            
            var downloadDataLinkId = '_' + record.get('id').replace(/\W/g, '') + '_downloadDataLink';
            var addWMSLinkId = '_' + record.get('id').replace(/\W/g, '') + '_addWMSLink';

            var elements = {
                xtype: 'panel',
                cls : 'gasearchresult',              
                items: [{
                    xtype: 'box',
                    cls: 'name',
                    autoEl: {
                      tag: 'div',
                      html: name
                    }  
                },{
                    xtype : 'displayfield',
                    value : Ext.util.Format.format('<span class="description">{0}</span>', description) 
                },{
                    xtype : 'panel',
                    cls : 'links', 
                    items : [{       
                        xtype: 'box',
                        autoEl: {
                          tag: 'a',
                          target : '_blank',
                          href: recordInfoUrl,
                          cn: 'Full metadata'
                        }                    
                    },
                    {
                        xtype: 'box',
                        listeners: {
                            render: function(component) {
                                component.getEl().on('click', function(e) {
                                    e.stopEvent();
                                    me.showSpatialBounds(record);
                                });    
                            }
                        },
                        autoEl: {
                          tag: 'a',
                          href: '#',
                          cn: 'Show extent'
                        }                      
                    },
                    {
                        xtype: 'box',
                        id: downloadDataLinkId,
                        autoEl: {
                          tag: 'span',
                          html: 'Download data'
                        }
                    },
                    {
                        xtype: 'box', 
                        id: addWMSLinkId,
                        autoEl: {                            
                          tag: 'span',                          
                          html: 'Add WMS to map'
                        }
                    }]
                }]
                
            }
            return elements;    
        }       
    },
    

    displayFileDownloadWindow : function(record){


        var links = [];

        var uris = record.get('datasetURIs');
        if (uris && uris.length > 0) {
            uris.forEach(function(item){
                links.push(item);
            });
        }
        var link_ids = [];

        var html = '';

        links.forEach(function(link) {
            var link_id = 'catalog-download-'+record.get('id').replace(/\./g,'-');
            link_ids.push(link_id)
            html += '<li><a target="_blank" id="'+ link_id +'" href="' + link + '">' + link + '</a></li>';
        });

        var onlineResources = record.data.onlineResources;
        if (onlineResources && onlineResources.length > 0) {
            onlineResources.forEach(function(onlineResource){
                var type = onlineResource.get('type');
                // Show only file downloads
                if (type == portal.csw.OnlineResource.UNSUPPORTED || type == portal.csw.OnlineResource.WWW || type == portal.csw.OnlineResource.FTP) {
                    var link = onlineResource.get('url');
                    var name = onlineResource.get('name');
                    var description  = onlineResource.get('description');

                    var text = this._generateDownloadName(name, description, link);

                    if (link.indexOf('file:/') < 0) {
                        var link_id = 'catalog-download-'+onlineResource.get('id').replace(/\./g,'-');
                        link_ids.push(link_id)
                        html += '<li><a target="_blank" id="'+ link_id +'" href="' + link + '">' + text + '</a></li>';
                    }
                }
            }, this);
        }

        html = '<ul>' + html + '</ul>';

        Ext.create('Ext.window.Window', {
            title: 'File Downloads',           
            maxHeight: 200,
            width: 600,
            autoScroll: true,
            html: html,
            listeners: {
                render: function(view) {
                    if (link_ids) {
                        link_ids.forEach(function (link_id) {
                            Ext.get(link_id).on('click', function () {
                                portal.util.GoogleAnalytic.trackevent('CatalogDownload', record.data.name, record.data.id, this.dom.href);
                            })
                        });
                    }
                }
            }
        }).show();


    },    

    // displays a popup window allowing the user to select layers to add to the map
    displayWMSLayers : function(record){   
        var me = this;     
        Ext.create('ga.widgets.GALayerSelectionWindow', {
            title : 'Add WMS Layers',
            map: me.map,
            layerFactory: me.layerFactory,
            layerStore: me.layerStore,
            cswRecord: record
        }).show();        
    },

    _generateDownloadName : function(name, description, url) {
        if (!name) {
            return url;
        }
        var FILE_PARTIAL = 'File download';
        var RELATED_PARTIAL = 'Related';

        if (name.indexOf(FILE_PARTIAL) > -1 || name.indexOf(RELATED_PARTIAL) > -1) {
            return name + ' - ' + description;
        }
        return name;
    }

});