
function getAllParishes(callback) {
    genericGetAll(
        "parishes"
        , "parishView"
        , function(data) {
            callback(data._embedded.parishes);
        });
}
