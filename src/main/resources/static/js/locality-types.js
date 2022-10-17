function getAllLocalityTypes(callback) {
    $.get("/api/v1/localityTypes", function(data, status) {
            callback(data);
        }, "json");
}

function createLocalityType(callback) {
    var localityTypeNameValue = $("#createLocalityTypeForm_localityTypeName").val();
    var localityTypeData = {localityTypeName:localityTypeNameValue};
    $.post({
        url: "/api/v1/localityTypes"
        , data: JSON.stringify(localityTypeData)
        , contentType: "application/json; charset=utf-8"
    }).done(function(data) {
        getAllLocalityTypes(callback);
    });
}

function doFilterLocalityTypes(newHeaderText, callback) {
    var filterText = $("#filterLocalityTypesForm_filter").val();
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
    $.get("/api/v1/localityTypes?filterText=" + encodeURIComponent(filterText), function(data, status) {
                callback(newHeaderText, data);
            }, "json");
}