function getAllLocations(callback) {
    genericGetAll(
        "locations"
        , "locationView"
        , function(data) {
            callback(data._embedded.locations);
        });
}

function getLocationById(id, callback, errorCallback) {
    genericGetById(id, "locations", callback, errorCallback, "locationView");
}

function createOrEditLocation(callback, locationId) {
    var longitudeValue = $("#longitude").val();
    var latitudeValue = $("#latitude").val();
    var modernLookupFormValue = $("#modernLookupForm").val();
    var districtOrParishValue = $("#districtOrParish").val();
    var localityTypeValue = $("#localityType").val();

    var locationData = {
        locationId:null
        , longitude:longitudeValue
        , latitude:latitudeValue
        , modernLookupForm:modernLookupFormValue
        , districtOrParish:districtOrParishValue
        , localityType:localityTypeValue
    };
    if (locationId === "") {
        genericCreate(locationData, "locations", callback);
    } else {
        locationData.locationId = parseInt(locationId);
        genericUpdate(locationData, "locations", locationId, "PUT", callback);
    }
}



function getQueryParamsAndHeaderTextAndSearchResource(origHeaderText, filterByName, filterByCode) {
    var queryParams = "?projection=locationView";
    var headerText = origHeaderText;
    var searchResource = "findByLocationNameContains";
    if (filterByName != "" && filterByCode != "") {
        queryParams += "&locationNameFilter=" + filterByName + "&locationCodeFilter=" + filterByCode;
        headerText += " location name " + filterByName + " and location code " + filterByCode;
        searchResource += "AndLocationCodeContains";
    } else if (filterByName != "") {
        queryParams += "&locationNameFilter=" + filterByName;
        headerText += " location name " + filterByName;
        // searchResource as default
    } else if (filterByCode != "") {
        queryParams += "&locationCodeFilter=" + filterByCode;
        headerText += " location code " + filterByName;
        searchResource = "findByLocationCodeContains";
    } else {
        // none set, search by name with empty query
        queryParams += "&locationNameFilter=" + filterByName;
        headerText = "All locations";
        // searchResource as default
    }

    return {queryParams:queryParams, headerText:headerText, searchResource:searchResource}
}

function doFilterLocations(newHeaderText, callback) {
    var filterByName = $("#filterByLocationName").val();
    var filterByCode = $("#filterByLocationCode").val();

    var queryHeaderResource = getQueryParamsAndHeaderTextAndSearchResource(newHeaderText, filterByName, filterByCode);

    $.get("/api/locations/search/" + queryHeaderResource.searchResource + queryHeaderResource.queryParams
        , function(data, status) {
            callback(queryHeaderResource.headerText, data._embedded.locations);
        }
        , "json");
}