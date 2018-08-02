/**
 * layerSearchCtrl class handles searching layers based on user keywords
 * @module controllers
 * @class layerSearchCtrl
 * 
 */
allControllers.controller('layerSearchCtrl', ['$rootScope', '$scope', 'RenderStatusService', 'GetCSWRecordService', function ($rootScope,$scope,RenderStatusService,GetCSWRecordService) {
    
    $scope.showClearGlyph=false;
    /**
     * This is triggered after the user types inside the search text field and press enter.
     * It will search through all known layers CSW records name and description that matches the keywords.
     * It will then show the layer panel with search results or all layers if no keyword is entered.
     * @method submit
     */
    this.submit = function() {
        // search layers that matches keywords and flag them
        GetCSWRecordService.searchLayers($scope.keywords); 
        $scope.showClearGlyph=true;      
    }; 
    
    /**
     * This will clear all search selection
     * @method submit
     */
    this.clear = function() {
        // search layers that matches keywords and flag them
        $scope.keywords ="";
        GetCSWRecordService.searchLayers("");
        $scope.showClearGlyph=false;
              
    }; 
    
    /**
     * This will filter data record
     * @method filterDataRecord
     */
    this.filterDataRecord = function(){
        $scope.keywords ="Display Data Layer";
        $scope.showClearGlyph=true;    
        GetCSWRecordService.filterDataRecord();
    };
    
    /**
     * This will filter image record
     * @method filterImageRecord
     */
    this.filterImageRecord = function(){
        $scope.keywords ="Display Image Layer";
        $scope.showClearGlyph=true;
        GetCSWRecordService.filterImageRecord();
    };
    
    /**
     * This will filter active record
     * @method filterActiveRecord
     */
    this.filterActiveRecord = function(){
        $scope.keywords ="Display Active Layer";
        $scope.showClearGlyph=true;
        GetCSWRecordService.filterActiveRecord();

        var renderStatus = RenderStatusService.getRenderStatus();
        $rootScope.activeCswRecords=[];

        var tmpCswRecords={};
        tmpCswRecords = GetCSWRecordService.getSearchedLayers();

        var statusSize = 0;
        for (var key in renderStatus) {
            statusSize = statusSize + 1;
        }

        for (var layerOrder = 1; layerOrder <= statusSize; layerOrder++) {
            for (var key in renderStatus) {
                if (renderStatus[key].order == layerOrder) {
                    for ( var i in tmpCswRecords) {
                        var layerGroup = tmpCswRecords[i];
                        for ( var j in layerGroup) {
                            var layer = layerGroup[j];
                            if (layer.id === key) {
                                $rootScope.activeCswRecords.push(layer);
                            }
                        }
                    }
                }
            }
        }
    };

    /**
     * This will filter active record
     * @method filterActiveRecord
     */
    this.filterAnalyticRecord = function(){
        $scope.keywords ="Display Analytic Layer";
        $scope.showClearGlyph=true;
        GetCSWRecordService.filterAnalyticRecord();
    };
    
    this.toggleMenu = function() {       
        $scope.$parent.showlayerPanel = true;
    }; 
    
}]);