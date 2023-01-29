
function getAllVariantForms(callback) {
    genericGetAll(
        "variantForms"
        , "variantFormView"
        , function(data) {
            callback(data._embedded.variantForms);
        });
}

async function getAllVariantFormsAsync() {
    return await genericGetAllAsync("variantForms", "variantFormView");
}

function getVariantFormById(id, callback, errorCallback) {
    genericGetById(id, "variantForms", callback, errorCallback);
}

function createOrEditVariantForm(callback, variantFormId, addedAdaptationTypes) {
    const variantFormValue = document.getElementById("variantForm").value;
	const isAdaptedToSwedishValue = document.getElementById("availableIsAdaptedToSwedishTypes").value;
	const normalizedFormValue = document.getElementById("availableNormalizedForms").value;
	var variantFormData = {
        variantFormId: null
        , variantForm: variantFormValue
		, isAdaptedToSwedish: isAdaptedToSwedishValue
		, adaptationTypes: addedAdaptationTypes
		, normalizedForm: normalizedFormValue
    };
    if (variantFormId === "") {
        genericCreate(variantFormData, "variantForms", callback);
    } else {
		variantFormData.variantFormId = parseInt(variantFormId);
        genericUpdate(variantFormData, "variantForms", variantFormId, "PATCH", callback);
    }
}

function doFilterVariantForms(newHeaderText, callback) {
    var filterByVariantForm = document.getElementById("filterByVariantForm").value;
    var queryParams = "?projection=variantFormView"
        + "&variantFormFilter=" + encodeURIComponent(filterByVariantForm);
    if (filterByVariantForm != "") {
        newHeaderText = newHeaderText + " variant form name " + filterByVariantForm;
    } else {
        newHeaderText = "All variant forms";
    }
	
	genericGet(
		"/api/variantForms/search/findByVariantFormContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.variantForms);
        });
}
