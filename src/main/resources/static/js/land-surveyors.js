
function getAllLandSurveyors(callback) {
    genericGetAll(
        "landSurveyors"
        , "landSurveyorView"
        , function(data) {
            callback(data._embedded.landSurveyors);
        });
}

function getLandSurveyorById(id, callback, errorCallback) {
    genericGetById(id, "landSurveyors", callback, errorCallback);
}

function createOrEditLandSurveyor(callback, landSurveyorId) {
    var landSurveyorNameValue = $("#landSurveyorName").val();

    if (landSurveyorId === "") {
        var landSurveyorData = {name:landSurveyorNameValue};
        genericCreate(landSurveyorData, "landSurveyors", callback);
    } else {
        var landSurveyorData = {
            landSurveyorId:parseInt(landSurveyorId)
            , name:landSurveyorNameValue
            };
        genericUpdate(landSurveyorData, "landSurveyors", landSurveyorId, "PUT", callback);
    }
}

function doFilterLandSurveyors(newHeaderText, callback) {
    var filterByName = $("#filterByName").val();
    var queryParams = "?projection=landSurveyorView"
        + "&nameFilter=" + encodeURIComponent(filterByName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    } else {
        newHeaderText = "All land surveyors";
    }

    $.get("/api/landSurveyors/search/findByNameContains"
        + queryParams, function(data, status) {
                callback(newHeaderText, data._embedded.landSurveyors);
            }, "json");
}
