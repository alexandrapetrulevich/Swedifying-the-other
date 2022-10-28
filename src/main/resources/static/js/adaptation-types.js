function getAllAdaptationTypes(callback) {
    genericGetAll(
        "adaptationTypes"
        , "adaptationTypeView"
        , function(data) {
            callback(data._embedded.adaptationTypes);
        });
}

function getAdaptationTypeById(id, callback, errorCallback) {
    genericGetById(id, "adaptationTypes", callback, errorCallback);
}

function createOrEditAdaptationType(callback, adaptationTypeId) {
    var adaptationTypeNameValue = document.getElementById("adaptationTypeName").value;
    var adaptationTypeData = {adaptationTypeId:null,name:adaptationTypeNameValue};

    if (adaptationTypeId === "") {
        genericCreate(adaptationTypeData, "adaptationTypes", callback);
    } else {
        adaptationTypeData.adaptationTypeId = parseInt(adaptationTypeId);
        genericUpdate(adaptationTypeData, "adaptationTypes", adaptationTypeId, "PUT", callback);
    }
}

function doFilterAdaptationTypes(newHeaderText, callback) {
    var filterText = document.getElementById("filterAdaptationTypesForm_filter").value;
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
    genericGet("/api/adaptationTypes/search/findByNameContains?filter="
        + encodeURIComponent(filterText) + "&projection=adaptationTypeView"
        , function(result) {
            callback(newHeaderText, result._embedded.adaptationTypes);
        });
}