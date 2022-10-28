
function getAllRegions(callback) {
    genericGetAll(
        "regions"
        , "regionView"
        , function(data) {
            callback(data._embedded.regions);
        });
}

async function getAllRegionsAsync() {
    return await genericGetAllAsync("regions", "regionView");
}

function getRegionById(id, callback, errorCallback) {
    genericGetById(id, "regions", callback, errorCallback);
}

function createOrEditRegion(callback, regionId) {
    var regionNameValue = document.getElementById("regionName").value;

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
    var filterByRegionName = document.getElementById("filterByRegionName").value;
    var queryParams = "?projection=regionView"
        + "&regionNameFilter=" + encodeURIComponent(filterByRegionName);
    if (filterByRegionName != "") {
        newHeaderText = newHeaderText + " region name " + filterByRegionName;
    } else {
        newHeaderText = "All regions";
    }

    genericGet("/api/regions/search/findByRegionNameContains"
        + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.regions);
        });
}
