
function getAllTextSources(callback) {
    genericGetAll(
        "textSources"
        , "textSourceView"
        , function(data) {
            callback(data._embedded.textSources);
        });
}

async function getAllTextSourcesAsync() {
    return await genericGetAllAsync("textSources", "textSourceView");
}

function getTextSourceById(id, callback, errorCallback) {
    genericGetById(id, "textSources", callback, errorCallback, "textSourceView");
}

function createOrEditTextSource(callback, textSourceId) {
    var datingValue = document.getElementById("dating").value;
	var landSurveyorValue = document.getElementById("availableLandSurveyors").value;
	var nameValue = document.getElementById("name").value;
	var subSectionValue = document.getElementById("subSection").value;
	var pageValue = document.getElementById("page").value;
	var textSourceData = {
        sourceId: null
        , dating: datingValue
		, landSurveyor: landSurveyorValue
		, name: nameValue
		, subSection: subSectionValue
		, page: parseInt(pageValue)
    };
    if (textSourceId === "") {
        genericCreate(textSourceData, "textSources", callback);
    } else {
		textSourceData.sourceId = parseInt(textSourceId);
        genericUpdate(textSourceData, "textSources", textSourceId, "PATCH", callback);
    }
}

function doFilterTextSources(newHeaderText, callback) {
    var filterByTextSource = document.getElementById("filterByTextSource").value;
    var queryParams = "?projection=textSourceView"
        + "&textSourceFilter=" + encodeURIComponent(filterByTextSource);
    if (filterByTextSource != "") {
        newHeaderText = newHeaderText + " map source name " + filterByTextSource;
    } else {
        newHeaderText = "All map sources";
    }
	
	genericGet(
		"/api/textSources/search/findByTextSourceContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.textSources);
        });
}
