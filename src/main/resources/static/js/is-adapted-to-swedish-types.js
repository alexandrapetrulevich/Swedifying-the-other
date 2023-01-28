
function getAllIsAdaptedToSwedishTypes(callback) {
    genericGet(
        "/api/isAdaptedToSwedishTypes"
        , callback);
}

async function getAllIsAdaptedToSwedishTypesAsync() {
    return await genericGetAllAsync("isAdaptedToSwedishTypes");
}
