function removeTrialingProjection(string) {
    return string.replace(/\{\?projection\}/, "");
}

function getIdFromHref(href) {
    return removeTrialingProjection(href).split("/").pop();
}

function genericGetAll(resource, projection, callback) {
    genericGet("/api/" + resource + "?projection=" + projection, callback);
}

function genericGet(url, callback) {
    fetch(url)
        .then((response) => response.json())
        .then((result) => callback(result));
}

function genericGetById(id, resource, callback, errorCallback, projection) {
    var url = "/api/" + resource + "/" + id;
    if (projection != null) {
        url += "?projection=" + projection;
    }

    fetch(url)
        .then(async function(response) {
            if (!response.ok) {
                console.log("response nok, called GET " + url);
                throw new Error(response.status);
            } else {
                console.log("response ok, called GET " + url);
                var result = await response.json();
                console.log("Calling callback...");
                callback(result);
            }
        })
        .catch((error) => {
            console.log("Calling error callback...");
            errorCallback(error);
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
