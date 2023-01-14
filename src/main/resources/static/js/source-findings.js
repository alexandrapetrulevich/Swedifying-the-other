
function getAllSourceFindings(callback) {
    genericGetAll(
        "sourceFindings"
        , "sourceFindingView"
        , function(data) {
            callback(data._embedded.sourceFindings);
        });
}

async function getAllSourceFindingsAsync() {
    const response = await fetch("/api/sourceFindings?projection=sourceFindingView");
    return response.json();
}

function getSourceFindingById(id, callback, errorCallback) {
    genericGetById(id, "sourceFindings", callback, errorCallback, "sourceFindingView");
}

function createOrEditSourceFinding(callback, sourceFindingId) {
	let sourceFindingNameValue = document.getElementById("sourceFindingName").value;
	let belongsToRegionValue = document.getElementById("availableRegions").value;
	let belongsToPrecinctValue = document.getElementById("availablePrecincts").value;
	var sourceFindingData = {
        subRegionId: null
        , name: sourceFindingNameValue
		, belongsToRegion: belongsToRegionValue
		, belongsToPrecinct: belongsToPrecinctValue
    };
    if (sourceFindingId === "") {
        genericCreate(sourceFindingData, "sourceFindings", callback);
    } else {
		sourceFindingData.subRegionId = parseInt(sourceFindingId);
        genericUpdate(sourceFindingData, "sourceFindings", sourceFindingId, "PATCH", callback);
    }
}

function doFilterSourceFindings(newHeaderText, callback) {
    let errorMessage = "doFilterSourceFindings(...) not implemented yet. Ignoring...";
    console.log(errorMessage);
    alert(errorMessage);
}