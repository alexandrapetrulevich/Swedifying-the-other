function loadLocations(callback) {
    console.log("loadLocations");
    $.get("/api/locations/",  function(data, status) {
        callback(data._embedded.locations);
    }, "json");
}