function getAllDistricts(callback) {
    genericGetAll(
        "districts"
        , "districtView"
        , function(data) {
            callback(data._embedded.districts);
        });
}

async function getAllDistrictsAsync() {
    return await genericGetAllAsync("districts", "districtView");
}

function getDistrictById(id, callback, errorCallback) {
    genericGetById(id, "districts", callback, errorCallback);
}

function createOrEditDistrict(callback, districtId) {
    var districtNameValue = document.getElementById("districtName").value;
    var districtBelongsToRegionValue = document.getElementById("availableRegions").value;

    var districtData = {
        subRegionId:null
        , name:districtNameValue
        , belongsToRegion:districtBelongsToRegionValue};
    if (districtId === "") {
        genericCreate(districtData, "districts", callback);
    } else {
        districtData.subRegionId = parseInt(districtId);
        genericUpdate(districtData, "districts", districtId, "PATCH", callback);
    }
}

function doFilterDistricts(newHeaderText, callback) {
    var filterByName = document.getElementById("filterByName").value;
    var filterByBelongsToRegionName = document.getElementById("filterByBelongsToRegionName").value;
    var queryParams = "?projection=districtView"
        + "&nameFilter=" + encodeURIComponent(filterByName)
        + "&belongsToRegionsNameFilter=" + encodeURIComponent(filterByBelongsToRegionName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    }
    if (filterByBelongsToRegionName != "") {
        newHeaderText = newHeaderText + " belongs to region name " + filterByBelongsToRegionName;
    }

    genericGet("/api/districts/search/findByNameContainsAndBelongsToRegionRegionNameContains"
        + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.districts);
        });
}