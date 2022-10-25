function getAllRegions(callback) {
    $.get("/api/regions?projection=regionView", function(data, status) {
            callback(data._embedded.regions);
        }, "json");
}

/*
function createOrEditDistrict(callback, districtId) {
    var districtNameValue = $("#districtName").val();
    var districtBelongsToRegionValue = $("#availableRegions").val();

    if (districtId === "") {
        var districtData = {name:districtNameValue, belongsToRegion:districtBelongsToRegionValue};
        $.post({
            url: "/api/districts"
            , data: JSON.stringify(districtData)
            , contentType: "application/json; charset=utf-8"
        }).done(function(data) {
            callback(data);
        });
    } else {
        var districtData = {
            subRegionId:parseInt(districtId)
            , name:districtNameValue
            , belongsToRegion:districtBelongsToRegionValue
            };
        $.ajax({
           url: "/api/districts/" + districtId
           , type: 'PUT'
           , data: JSON.stringify(districtData)
           , contentType: "application/json; charset=utf-8"
           , success: function(data) {
             callback(data);
           }
        });
    }
}

function doFilterDistricts(newHeaderText, callback) {
    var filterText = $("#filterDistrictsForm_filter").val();
    newHeaderText = newHeaderText + " \"" + filterText + "\"";
    $.get("/api/districts/search/findByNameContains?filter="
        + encodeURIComponent(filterText) + "&projection=districtView", function(data, status) {
                callback(newHeaderText, data._embedded.district);
            }, "json");
}
*/