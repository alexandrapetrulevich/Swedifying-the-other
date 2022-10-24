function getAllAdaptationTypes(callback) {
    console.log("getAllAdaptationTypes!");
    $.get("/api/adaptationTypes?projection=adaptationTypeView", function(data, status) {
            callback(data._embedded.adaptationTypes);
        }, "json");
}

function createOrEditAdaptationType(callback, adaptationTypeId) {
    var adaptationTypeNameValue = $("#adaptationTypeName").val();

    if (adaptationTypeId === "") {
        var adaptationTypeData = {name:adaptationTypeNameValue};
        $.post({
            url: "/api/adaptationTypes"
            , data: JSON.stringify(adaptationTypeData)
            , contentType: "application/json; charset=utf-8"
        }).done(function(data) {
            callback(data.adaptationTypeId);
        });
    } else {
        var adaptationTypeData = {name:adaptationTypeNameValue, adaptationTypeId:parseInt(adaptationTypeId)};
        $.ajax({
           url: "/api/adaptationTypes/" + adaptationTypeId
           , type: 'PUT'
           , data: JSON.stringify(adaptationTypeData)
           , contentType: "application/json; charset=utf-8"
           , success: function(data) {
             callback(data.adaptationTypeId);
           }
        });
    }
}

function doFilterAdaptationTypes(newHeaderText, callback) {
    var filterText = $("#filterAdaptationTypesForm_filter").val();
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
    $.get("/api/adaptationTypes/search/findByNameContains?filter="
        + encodeURIComponent(filterText) + "&projection=adaptationTypeView", function(data, status) {
                callback(newHeaderText, data._embedded.adaptationTypes);
            }, "json");
}