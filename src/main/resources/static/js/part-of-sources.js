
function getAllPartOfSources(callback) {
    genericGetAll(
        "partOfSources"
        , "partOfSourceView"
        , function(data) {
            callback(data._embedded.partOfSources);
        });
}

function getPartOfSourceById(id, callback, errorCallback) {
    genericGetById(id, "partOfSources", callback, errorCallback);
}

function createOrEditPartOfSource(callback, partOfSourceId) {
    var partOfSourceNameValue = $("#partOfSourceName").val();

    if (partOfSourceId === "") {
        var partOfSourceData = {partOfSourceName:partOfSourceNameValue};
        genericCreate(partOfSourceData, "partOfSources", callback);
    } else {
        var partOfSourceData = {
            partOfSourceId:parseInt(partOfSourceId)
            , partOfSourceName:partOfSourceNameValue
            };
        genericUpdate(partOfSourceData, "partOfSources", partOfSourceId, "PUT", callback);
    }
}

function doFilterPartOfSources(newHeaderText, callback) {
    var filterByName = $("#filterByName").val();
    var queryParams = "?projection=partOfSourceView"
        + "&partOfSourceNameFilter=" + encodeURIComponent(filterByName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    } else {
        newHeaderText = "All part of sources";
    }

    $.get("/api/partOfSources/search/findByPartOfSourceNameContains"
        + queryParams, function(data, status) {
                callback(newHeaderText, data._embedded.partOfSources);
            }, "json");
}
