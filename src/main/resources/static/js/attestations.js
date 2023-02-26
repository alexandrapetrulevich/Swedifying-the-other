


function getAllAttestations(callback, page, pageSize) {
    genericGetAll(
        "attestations"
        , "attestationView"
        , function(data) {
            callback(data);
        }
		, typeof page !== "undefined" ? "&page=" + page + "&size=" + pageSize : null);
}


function getAttestationById(id, callback, errorCallback) {
    genericGetById(id, "attestations", callback, errorCallback, "attestationView");
}

function createOrEditAttestation(callback, attestationId) {
    const originalFormValue = document.getElementById("originalForm").value;
	const notesValue = document.getElementById("notes").value;
	const locationValue = document.getElementById("availableLocations").value;
	const sourceFindingValue = document.getElementById("availableSourceFindings").value;
	const variantFormValue = document.getElementById("availableVariantForms").value;
	var attestationData = {
        attestationId: null
		, originalForm: originalFormValue
        , notes: notesValue
		, location: locationValue
		, sourceFinding: sourceFindingValue
		, variantForm: variantFormValue
    };
    if (attestationId === "") {
        genericCreate(attestationData, "attestations", callback);
    } else {
		attestationData.attestationId = parseInt(attestationId);
        genericUpdate(attestationData, "attestations", attestationId, "PATCH", callback);
    }
}
