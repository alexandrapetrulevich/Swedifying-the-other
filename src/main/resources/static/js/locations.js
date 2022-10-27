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
    var longitudeValue = document.getElementById("longitude").value;
    var latitudeValue = document.getElementById("latitude").value;
    var modernLookupFormValue = document.getElementById("modernLookupForm").value;
    var districtOrParishValue = document.getElementById("districtOrParish").value;
    var localityTypeValue = document.getElementById("localityType").value;

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
    var filterByModernLookupForm = document.getElementById("filterByModernLookupForm").value;

    var queryHeaderResource = {
        queryParams:"?projection=locationView&filterByModernLookupForm=" + filterByModernLookupForm
        , headerText:newHeaderText + " modern lookup form " + filterByModernLookupForm
        , searchResource:"findByModernLookupFormContains"};

    fetch("/api/locations/search/" + queryHeaderResource.searchResource + queryHeaderResource.queryParams)
        .then((response) => response.json())
        .then((result) => callback(queryHeaderResource.headerText, result._embedded.locations));
}