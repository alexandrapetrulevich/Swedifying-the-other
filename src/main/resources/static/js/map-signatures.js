
function getAllMapSignatures(callback) {
    genericGetAll(
        "mapSignatures"
        , "mapSignatureView"
        , function(data) {
            callback(data._embedded.mapSignatures);
        });
}

function getMapSignatureById(id, callback, errorCallback) {
    genericGetById(id, "mapSignatures", callback, errorCallback);
}

function createOrEditMapSignature(callback, mapSignatureId) {
    var mapSignatureNameValue = $("#mapSignatureName").val();

    if (mapSignatureId === "") {
        var mapSignatureData = {mapSignature:mapSignatureNameValue};
        genericCreate(mapSignatureData, "mapSignatures", callback);
    } else {
        var mapSignatureData = {
            mapSignatureId:parseInt(mapSignatureId)
            , mapSignature:mapSignatureNameValue
            };
        genericUpdate(mapSignatureData, "mapSignatures", mapSignatureId, "PUT", callback);
    }
}

function doFilterMapSignatures(newHeaderText, callback) {
    var filterByMapSignature = $("#filterByMapSignature").val();
    var queryParams = "?projection=mapSignatureView"
        + "&mapSignatureFilter=" + encodeURIComponent(filterByMapSignature);
    if (filterByMapSignature != "") {
        newHeaderText = newHeaderText + " map signature name " + filterByMapSignature;
    } else {
        newHeaderText = "All map signatures";
    }

    $.get("/api/mapSignatures/search/findByMapSignatureContains"
        + queryParams, function(data, status) {
                callback(newHeaderText, data._embedded.mapSignatures);
            }, "json");
}
