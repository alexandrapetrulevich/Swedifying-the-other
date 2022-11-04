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
        genericUpdate(locationData, "locations", locationId, "PATCH", callback);
    }
}

function doFilterLocations(newHeaderText, callback) {
    var filterByModernLookupForm = document.getElementById("filterByModernLookupForm").value;

    var queryHeaderResource = {
        queryParams:"?projection=locationView&filterByModernLookupForm=" + filterByModernLookupForm
        , headerText:newHeaderText + " modern lookup form " + filterByModernLookupForm
        , searchResource:"findByModernLookupFormContains"};

    genericGet(
		"/api/locations/search/" + queryHeaderResource.searchResource + queryHeaderResource.queryParams
		, function(result) {
            callback(queryHeaderResource.headerText, result._embedded.locations);
        });
}