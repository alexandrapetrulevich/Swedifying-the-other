function getAllLocalityTypes(callback) {
    console.log("getAllLocalityTypes!");
    $.get("/api/localityTypes?projection=localityTypeView", function(data, status) {
            callback(data._embedded.localityTypes);
        }, "json");
}

async function getAllLocalityTypes() {
    const response = await fetch("/api/localityTypes?projection=localityTypeView");
    return response.json();
}

function getLocalityTypeById(id, callback, errorCallback) {
    genericGetById(id, "localityTypes", callback, errorCallback);
}


function createOrEditLocalityType(callback, localityTypeId) {
    var localityTypeNameValue = $("#localityTypeName").val();

    if (localityTypeId === "") {
        var localityTypeData = {localityTypeName:localityTypeNameValue};
        $.post({
            url: "/api/localityTypes"
            , data: JSON.stringify(localityTypeData)
            , contentType: "application/json; charset=utf-8"
        }).done(function(data) {
            callback(data.localityTypeId);
        });
    } else {
        var localityTypeData = {localityTypeName:localityTypeNameValue, localityTypeId:parseInt(localityTypeId)};
        $.ajax({
           url: "/api/localityTypes/" + localityTypeId
           , type: 'PUT'
           , data: JSON.stringify(localityTypeData)
           , contentType: "application/json; charset=utf-8"
           , success: function(data) {
             callback(data.localityTypeId);
           }
        });
    }
}

function doFilterLocalityTypes(newHeaderText, callback) {
    var filterText = $("#filterLocalityTypesForm_filter").val();
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
    $.get("/api/localityTypes/search/findByLocalityTypeNameContains?filter="
        + encodeURIComponent(filterText) + "&projection=localityTypeView", function(data, status) {
                callback(newHeaderText, data._embedded.localityTypes);
            }, "json");
}