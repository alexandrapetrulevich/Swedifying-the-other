
function getAllMorphologicalNameTypes(callback) {
    genericGet(
        "/api/morphologicalNameTypes"
        , callback);
}

async function getAllMorphologicalNameTypesAsync() {
    return await genericGetAllAsync("morphologicalNameTypes");
}
