function getAllLocations(callback) {
    $.get("/api/locations/",  function(data, status) {
        callback(data._embedded.locations);
    }, "json");
}