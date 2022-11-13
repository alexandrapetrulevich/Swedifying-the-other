
function getAllParishes(callback) {
    genericGetAll(
        "parishes"
        , "parishView"
        , function(data) {
            callback(data._embedded.parishes);
        });
}

async function getAllParishesAsync() {
    const response = await fetch("/api/parishes?projection=parishView");
    return response.json();
}
