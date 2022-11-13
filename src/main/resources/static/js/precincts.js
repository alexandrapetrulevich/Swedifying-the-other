
function getAllPrecincts(callback) {
    genericGetAll(
        "precincts"
        , "precinctView"
        , function(data) {
            callback(data._embedded.districts, data._embedded.parishes, data._embedded.precincts);
        });
}

function getPrecinctById(id, callback, errorCallback) {
    genericGetById(id, "precincts", callback, errorCallback, "precinctView");
}
