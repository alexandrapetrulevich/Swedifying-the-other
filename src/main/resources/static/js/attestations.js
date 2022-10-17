function getAllAttestations(callback) {
    $.get("/api/v1/attestations", function(data, status) {
            callback(data);
        }, "json");
}

function doFilterAttestations(newHeaderText, callback) {
    var morphNameTypeFilter = $("#filterAttestationsTextMorphNameType").val();
    var etymologyFilter = $("#filterAttestationsTextEtymology").val();
    newHeaderText = newHeaderText + "MorphNameType: \"" + morphNameTypeFilter
        + "\" and Etymology: \"" + etymologyFilter + "\"";
    $.get(
        "/api/v1/attestations?morphNameType="
        + encodeURIComponent(morphNameTypeFilter)
        + "&etymology="
        + encodeURIComponent(etymologyFilter), function(data, status) {
            callback(newHeaderText, data);
        }, "json");
}