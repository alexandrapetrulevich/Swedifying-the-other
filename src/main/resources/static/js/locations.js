function loadLocations(callback) {
    $.get("/api/v1/locations/",  function(data, status) {
        if (status )
        callback(data);
    }, "json");
}