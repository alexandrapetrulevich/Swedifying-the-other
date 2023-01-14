
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
	let sourceValue = document.getElementById("availableSources").value;
	let partOfSourceValue = document.getElementById("availablePartsOfSources").value;
	var sourceFindingData = {
        sourceFindingId: null
		, source: sourceValue
		, partOfSource: partOfSourceValue
    };
    if (sourceFindingId === "") {
        genericCreate(sourceFindingData, "sourceFindings", callback);
    } else {
		sourceFindingData.sourceFindingId = parseInt(sourceFindingId);
        genericUpdate(sourceFindingData, "sourceFindings", sourceFindingId, "PATCH", callback);
    }
}

function doFilterSourceFindings(newHeaderText, callback) {
    let errorMessage = "doFilterSourceFindings(...) not implemented yet. Ignoring...";
    console.log(errorMessage);
    alert(errorMessage);
}