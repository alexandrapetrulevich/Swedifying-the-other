
function getAllMapSources(callback) {
    genericGetAll(
        "mapSources"
        , "mapSourceView"
        , function(data) {
            callback(data._embedded.mapSources);
        });
}

async function getAllMapSourcesAsync() {
    return await genericGetAllAsync("mapSources", "mapSourceView");
}

function getMapSourceById(id, callback, errorCallback) {
    genericGetById(id, "mapSources", callback, errorCallback, "mapSourceView");
}

function createOrEditMapSource(callback, mapSourceId) {
    var mapSourceDatingValue = document.getElementById("dating").value;
	var mapSheetValue = document.getElementById("mapSheet").value;
	var landSurveyorValue = document.getElementById("availableLandSurveyors").value;
	var mapSignatureValue = document.getElementById("availableMapSignatures").value;
	var mapSourceData = {
        sourceId:null
        , dating:mapSourceDatingValue
		, landSurveyor: landSurveyorValue
		, mapSheet: mapSheetValue
		, mapSignature: mapSignatureValue
		
    };
    if (mapSourceId === "") {
        genericCreate(mapSourceData, "mapSources", callback);
    } else {
		mapSourceData.sourceId = parseInt(mapSourceId);
        genericUpdate(mapSourceData, "mapSources", mapSourceId, "PATCH", callback);
    }
}

function doFilterMapSources(newHeaderText, callback) {
    var filterByMapSource = document.getElementById("filterByMapSource").value;
    var queryParams = "?projection=mapSourceView"
        + "&mapSourceFilter=" + encodeURIComponent(filterByMapSource);
    if (filterByMapSource != "") {
        newHeaderText = newHeaderText + " map source name " + filterByMapSource;
    } else {
        newHeaderText = "All map sources";
    }
	
	genericGet(
		"/api/mapSources/search/findByMapSourceContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.mapSources);
        });
}
