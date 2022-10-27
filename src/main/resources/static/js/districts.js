function getAllDistricts(callback) {
    $.get("/api/districts?projection=districtView", function(data, status) {
            callback(data._embedded.districts);
        }, "json");
}

async function getAllDistrictsAsync() {
    const response = await fetch("/api/districts?projection=districtView");
    return response.json();
}

function getDistrictById(id, callback, errorCallback) {
    $.ajax({
       url: "/api/districts/" + id
       , type: 'GET'
       , contentType: "application/json; charset=utf-8"
       , success:
        function(data) {
            callback(data);
        }
       , error:
        function(jqXHR, textStatus, errorThrown) {
            console.log("getDistrictById " + id + " error, jqXHR.status: " + jqXHR.status);
            errorCallback(jqXHR.status);
        }
    });
}

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
           , type: 'PATCH' // Has to use PATH due to updating ref type, see https://stackoverflow.com/questions/45620195/spring-data-rest-put-request-does-not-work-properly-since-v-2-5-7
           , data: JSON.stringify(districtData)
           , contentType: "application/json; charset=utf-8"
           , success: function(data) {
             callback(data);
           }
        });
    }
}

function doFilterDistricts(newHeaderText, callback) {
    var filterByName = $("#filterByName").val();
    var filterByBelongsToRegionName = $("#filterByBelongsToRegionName").val();
    var queryParams = "?projection=districtView"
        + "&nameFilter=" + encodeURIComponent(filterByName)
        + "&belongsToRegionsNameFilter=" + encodeURIComponent(filterByBelongsToRegionName);
    if (filterByName != "") {
        newHeaderText = newHeaderText + " name " + filterByName;
    }
    if (filterByBelongsToRegionName != "") {
        newHeaderText = newHeaderText + " belongs to region name " + filterByBelongsToRegionName;
    }

    $.get("/api/districts/search/findByNameContainsAndBelongsToRegionRegionNameContains"
        + queryParams, function(data, status) {
                callback(newHeaderText, data._embedded.districts);
            }, "json");
}