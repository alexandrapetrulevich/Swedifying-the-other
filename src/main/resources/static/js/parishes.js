
function getAllParishes(callback) {
    genericGetAll(
        "parishes"
        , "parishView"
        , function(data) {
            callback(data._embedded.parishes);
        });
}

async function getAllParishesAsync() {
    const response = await fetch("/api/parishes?projection=parishView");
    return response.json();
}

function getParishById(id, callback, errorCallback) {
    genericGetById(id, "parishes", callback, errorCallback, "parishView");
}

function createOrEditParish(callback, parishId) {
	let parishNameValue = document.getElementById("parishName").value;
	let belongsToRegionValue = document.getElementById("availableRegions").value;
	let belongsToPrecinctValue = document.getElementById("availablePrecincts").value;
	var parishData = {
        subRegionId: null
        , name: parishNameValue
		, belongsToRegion: belongsToRegionValue
		, belongsToPrecinct: belongsToPrecinctValue
    };
    if (parishId === "") {
        genericCreate(parishData, "parishes", callback);
    } else {
		parishData.subRegionId = parseInt(parishId);
        genericUpdate(parishData, "parishes", parishId, "PATCH", callback);
    }
}