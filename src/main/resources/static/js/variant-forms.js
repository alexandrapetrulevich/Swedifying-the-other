
function getAllMapSignatures(callback) {
    genericGetAll(
        "mapSignatures"
        , "mapSignatureView"
        , function(data) {
            callback(data._embedded.mapSignatures);
        });
}

async function getAllMapSignaturesAsync() {
    return await genericGetAllAsync("mapSignatures", "mapSignatureView");
}

function getMapSignatureById(id, callback, errorCallback) {
    genericGetById(id, "mapSignatures", callback, errorCallback);
}

function createOrEditMapSignature(callback, mapSignatureId) {
    var mapSignatureNameValue = document.getElementById("mapSignatureName").value;
	var mapSignatureData = {
        mapSignatureId:null
        , mapSignature:mapSignatureNameValue
    };
    if (mapSignatureId === "") {
        genericCreate(mapSignatureData, "mapSignatures", callback);
    } else {
		mapSignatureData.mapSignatureId = parseInt(mapSignatureId);
        genericUpdate(mapSignatureData, "mapSignatures", mapSignatureId, "PUT", callback);
    }
}

function doFilterMapSignatures(newHeaderText, callback) {
    var filterByMapSignature = document.getElementById("filterByMapSignature").value;
    var queryParams = "?projection=mapSignatureView"
        + "&mapSignatureFilter=" + encodeURIComponent(filterByMapSignature);
    if (filterByMapSignature != "") {
        newHeaderText = newHeaderText + " map signature name " + filterByMapSignature;
    } else {
        newHeaderText = "All map signatures";
    }
	
	genericGet(
		"/api/mapSignatures/search/findByMapSignatureContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.mapSignatures);
        });
}
