
function getAllRegions(callback) {
    genericGetAll(
        "regions"
        , "regionView"
        , function(data) {
            callback(data._embedded.regions);
        });
}

function getRegionById(id, callback, errorCallback) {
    genericGetById(id, "regions", callback, errorCallback);
}

function createOrEditRegion(callback, regionId) {
    var regionNameValue = $("#regionName").val();

    if (regionId === "") {
        var regionData = {regionName:regionNameValue};
        genericCreate(regionData, "regions", callback);
    } else {
        var regionData = {
            regionId:parseInt(regionId)
            , regionName:regionNameValue
            };
        genericUpdate(regionData, "regions", regionId, "PUT", callback);
    }
}

function doFilterRegions(newHeaderText, callback) {
    var filterByRegionName = $("#filterByRegionName").val();
    var queryParams = "?projection=regionView"
        + "&regionNameFilter=" + encodeURIComponent(filterByRegionName);
    if (filterByRegionName != "") {
        newHeaderText = newHeaderText + " region name " + filterByRegionName;
    } else {
        newHeaderText = "All regions";
    }

    $.get("/api/regions/search/findByRegionNameContains"
        + queryParams, function(data, status) {
                callback(newHeaderText, data._embedded.regions);
            }, "json");
}
