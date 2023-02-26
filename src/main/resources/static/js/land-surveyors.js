function getAllLandSurveyors(callback) {
    genericGetAll(
        "landSurveyors"
        , "landSurveyorView"
        , function(data) {
            callback(data._embedded.landSurveyors);
        });
}

async function getAllLandSurveyorsAsync() {
    return await genericGetAllAsync("landSurveyors", "landSurveyorView");
}

function getLandSurveyorById(id, callback, errorCallback) {
    genericGetById(id, "landSurveyors", callback, errorCallback);
}

function createOrEditLandSurveyor(callback, landSurveyorId) {
    var landSurveyorNameValue = document.getElementById("landSurveyorName").value;
	var landSurveyorData = {name:landSurveyorNameValue, landSurveyorId:null};
    if (landSurveyorId === "") {
        genericCreate(landSurveyorData, "landSurveyors", callback);
    } else {
        landSurveyorData.landSurveyorId = parseInt(landSurveyorId);
        genericUpdate(landSurveyorData, "landSurveyors", landSurveyorId, "PUT", callback);
    }
}

function doFilterLandSurveyors(newHeaderText, callback) {
    var filterByName = document.getElementById("filterByName").value;
    var queryParams = "?projection=landSurveyorView"
        + "&nameFilter=" + encodeURIComponent(filterByName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    } else {
        newHeaderText = "All land surveyors";
    }
	
	genericGet(
		"/api/landSurveyors/search/findByNameContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.landSurveyors);
        });
}
