function removeTrialingProjection(string) {
    return string.replace(/\{\?projection\}/, "");
}

function genericGetAll(resource, projection, callback) {
    $.get("/api/" + resource + "?projection=" + projection, function(data, status) {
        callback(data);
    }, "json");
}

function genericGetById(id, resource, callback, errorCallback) {
    $.ajax({
       url: "/api/" + resource + "/" + id
       , type: 'GET'
       , contentType: "application/json; charset=utf-8"
       , success:
        function(data) {
            callback(data);
        }
       , error:
        function(jqXHR, textStatus, errorThrown) {
            console.log("Get by ID " + id + " on resource " + resource + " returned error, jqXHR.status: " + jqXHR.status);
            errorCallback(jqXHR.status);
        }
    });
}

function genericCreate(dataToSend, resource, callback) {
    $.post({
        url: "/api/" + resource
        , data: JSON.stringify(dataToSend)
        , contentType: "application/json; charset=utf-8"
    }).done(function(returnedData) {
        callback(returnedData);
    });
}

// We need to use PATCH sometimes due to the "problem" when updating referenced types mentioned in
// https://stackoverflow.com/questions/45620195/spring-data-rest-put-request-does-not-work-properly-since-v-2-5-7
function genericUpdate(dataToSend, resource, id, putOrPath, callback) {
    $.ajax({
       url: "/api/" + resource + "/" + id
       , type: putOrPath
       , data: JSON.stringify(dataToSend)
       , contentType: "application/json; charset=utf-8"
       , success: function(returnedData) {
            callback(returnedData);
       }
    });
}
