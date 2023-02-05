function getAllAttestations(callback, page, pageSize) {
    genericGetAll(
        "attestations"
        , "attestationView"
        , function(data) {
            callback(data);
        }
		, typeof page !== "undefined" ? "&page=" + page + "&size=" + pageSize : null);
}

/*
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
*/