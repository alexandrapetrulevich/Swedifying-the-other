
function getAllSubRegions(callback) {
    genericGetAll(
        "subRegions"
        , "subRegionView"
        , function(data) {
            callback(data._embedded.districts, data._embedded.parishes, data._embedded.precincts);
        });
}

function getSubRegionById(id, callback, errorCallback) {
    genericGetById(id, "subRegions", callback, errorCallback, "subRegionView");
}
