function getAllLocalityTypes(callback) {
    console.log("getAllLocalityTypes with callback!");
    genericGetAll(
            "localityTypes"
            , "localityTypeView"
            , function(data) {
                console.log("getAllLocalityTypes, calling callback");
                callback(data._embedded.localityTypes);
            });
}

async function getAllLocalityTypesAsync() {
    console.log("getAllLocalityTypes no callback!");
    const response = await fetch("/api/localityTypes?projection=localityTypeView");
    return response.json();
}

function getLocalityTypeById(id, callback, errorCallback) {
    genericGetById(id, "localityTypes", callback, errorCallback);
}


function createOrEditLocalityType(callback, localityTypeId) {
    var localityTypeNameValue = document.getElementById("localityTypeName").value;

    if (localityTypeId === "") {
        var localityTypeData = {localityTypeName:localityTypeNameValue};
        genericCreate(localityTypeData, "localityTypes", callback);
    } else {
        var localityTypeData = {localityTypeName:localityTypeNameValue, localityTypeId:parseInt(localityTypeId)};
        genericUpdate(localityTypeData, "localityTypes", localityTypeId, "PUT", callback);
    }
}

function doFilterLocalityTypes(newHeaderText, callback) {
    var filterText = document.getElementById("filterLocalityTypesForm_filter").value;
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
    fetch("/api/localityTypes/search/findByLocalityTypeNameContains?filter="
        + encodeURIComponent(filterText) + "&projection=localityTypeView")
        .then((response) => response.json())
        .then((result) => callback(newHeaderText, result._embedded.localityTypes));
}