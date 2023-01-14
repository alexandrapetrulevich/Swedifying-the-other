
function getAllPrecincts(callback) {
    genericGetAll(
        "precincts"
        , "precinctView"
        , function(data) {
            callback(data._embedded.precincts);
        });
}

function getAllPrecinctsByBelongsToRegionId(regionId, callback) {
	genericGetAll(
        "precincts/search/findByBelongsToRegionRegionId"
        , "precinctView"
        , function(data) {
            callback(data._embedded.precincts);
        }
		, "&regionId=" + regionId);
}

async function getAllPrecinctsAsync() {
    return await genericGetAllAsync("precincts", "precinctView");
}

async function getAllPrecinctsByBelongsToRegionIdAsync(regionId) {
    return await genericGetAllAsync("precincts/search/findByBelongsToRegionRegionId?regionId=" + regionId + "&projection=precinctView");
}

function getPrecinctById(id, callback, errorCallback) {
    genericGetById(id, "precincts", callback, errorCallback, "precinctView");
}


function createOrEditPrecinct(callback, precinctId) {
	let precinctNameValue = document.getElementById("precinctName").value;
	let belongsToRegionValue = document.getElementById("availableRegions").value;
	var precinctData = {
        subRegionId: null
        , name: precinctNameValue
		, belongsToRegion: belongsToRegionValue
    };
    if (precinctId === "") {
        genericCreate(precinctData, "precincts", callback);
    } else {
		precinctData.subRegionId = parseInt(precinctId);
        genericUpdate(precinctData, "precincts", precinctId, "PATCH", callback);
    }
}

function doFilterPrecincts(newHeaderText, callback) {
    let errorMessage = "doFilterPrecincts(...) not implemented yet. Ignoring...";
    console.log(errorMessage);
    alert(errorMessage);
}
