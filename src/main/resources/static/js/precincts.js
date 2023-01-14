
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
