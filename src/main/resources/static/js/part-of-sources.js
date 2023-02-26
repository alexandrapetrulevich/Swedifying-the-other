function getAllPartOfSources(callback) {
    genericGetAll(
        "partOfSources"
        , "partOfSourceView"
        , function(data) {
            callback(data._embedded.partOfSources);
        });
}

async function getAllPartOfSourcesAsync() {
    return await genericGetAllAsync("partOfSources", "partOfSourceView");
}

function getPartOfSourceById(id, callback, errorCallback) {
    genericGetById(id, "partOfSources", callback, errorCallback);
}

function createOrEditPartOfSource(callback, partOfSourceId) {
    var partOfSourceNameValue = document.getElementById("partOfSourceName").value;

	var partOfSourceData = {
		partOfSourceId:null
		, partOfSourceName:partOfSourceNameValue
	};
    if (partOfSourceId === "") {
        genericCreate(partOfSourceData, "partOfSources", callback);
    } else {
        partOfSourceData.partOfSourceId = parseInt(partOfSourceId);
        genericUpdate(partOfSourceData, "partOfSources", partOfSourceId, "PUT", callback);
    }
}

function doFilterPartOfSources(newHeaderText, callback) {
    var filterByName = document.getElementById("filterByName").value;
    var queryParams = "?projection=partOfSourceView"
        + "&partOfSourceNameFilter=" + encodeURIComponent(filterByName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    } else {
        newHeaderText = "All part of sources";
    }
	genericGet(
		"/api/partOfSources/search/findByPartOfSourceNameContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.partOfSources);
        });
}
