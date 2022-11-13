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
	var localityTypeData = {
		localityTypeName:localityTypeNameValue
		, localityTypeId:null};
    if (localityTypeId === "") {
        genericCreate(localityTypeData, "localityTypes", callback);
    } else {
        localityTypeData.localityTypeId = parseInt(localityTypeId);
        genericUpdate(localityTypeData, "localityTypes", localityTypeId, "PUT", callback);
    }
}

function doFilterLocalityTypes(newHeaderText, callback) {
    var filterText = document.getElementById("filterLocalityTypesForm_filter").value;
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
	
	genericGet(
		"/api/localityTypes/search/findByLocalityTypeNameContains?filter=" + encodeURIComponent(filterText) + "&projection=localityTypeView"
        , function(result) {
            callback(newHeaderText, result._embedded.localityTypes);
        });
}