function getAllLandSurveyors(callback) {
    $.get("/api/landSurveyors?projection=landSurveyorView", function(data, status) {
            callback(data._embedded.landSurveyors);
        }, "json");
}

function getLandSurveyorById(id, callback, errorCallback) {
    $.ajax({
       url: "/api/landSurveyors/" + id
       , type: 'GET'
       , contentType: "application/json; charset=utf-8"
       , success:
        function(data) {
            callback(data);
        }
       , error:
        function(jqXHR, textStatus, errorThrown) {
            console.log("getLandSurveyorById " + id + " error, jqXHR.status: " + jqXHR.status);
            errorCallback(jqXHR.status);
        }
    });
}

function createOrEditLandSurveyor(callback, landSurveyorId) {
    var landSurveyorNameValue = $("#landSurveyorName").val();

    if (landSurveyorId === "") {
        var landSurveyorData = {name:landSurveyorNameValue};
        $.post({
            url: "/api/landSurveyors"
            , data: JSON.stringify(landSurveyorData)
            , contentType: "application/json; charset=utf-8"
        }).done(function(data) {
            callback(data);
        });
    } else {
        var landSurveyorData = {
            landSurveyorId:parseInt(landSurveyorId)
            , name:landSurveyorNameValue
            };
        $.ajax({
           url: "/api/landSurveyors/" + landSurveyorId
           , type: 'PUT'
           , data: JSON.stringify(landSurveyorData)
           , contentType: "application/json; charset=utf-8"
           , success: function(data) {
             callback(data);
           }
        });
    }
}

function doFilterLandSurveyors(newHeaderText, callback) {
    var filterByName = $("#filterByName").val();
    var queryParams = "?projection=landSurveyorView"
        + "&nameFilter=" + encodeURIComponent(filterByName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    } else {
        newHeaderText = "No filter";
    }

    $.get("/api/landSurveyors/search/findByNameContains"
        + queryParams, function(data, status) {
                callback(newHeaderText, data._embedded.landSurveyors);
            }, "json");
}