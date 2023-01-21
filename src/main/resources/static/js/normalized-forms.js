
function getAllNormalizedForms(callback) {
    genericGetAll(
        "normalizedForms"
        , "normalizedFormView"
        , function(data) {
            callback(data._embedded.normalizedForms);
        });
}

async function getAllNormalizedFormsAsync() {
    return await genericGetAllAsync("normalizedForms", "normalizedFormView");
}

function getNormalizedFormById(id, callback, errorCallback) {
    genericGetById(id, "normalizedForms", callback, errorCallback);
}

function createOrEditNormalizedForm(callback, normalizedFormId) {
    var normalizedFormNameValue = document.getElementById("normalizedFormName").value;
	var normalizedFormData = {
        normalizedFormId:null
        , normalizedForm:normalizedFormNameValue
    };
    if (normalizedFormId === "") {
        genericCreate(normalizedFormData, "normalizedForms", callback);
    } else {
		normalizedFormData.normalizedFormId = parseInt(normalizedFormId);
        genericUpdate(normalizedFormData, "normalizedForms", normalizedFormId, "PUT", callback);
    }
}

function doFilterNormalizedForms(newHeaderText, callback) {
    var filterByNormalizedForm = document.getElementById("filterByNormalizedForm").value;
    var queryParams = "?projection=normalizedFormView"
        + "&normalizedFormFilter=" + encodeURIComponent(filterByNormalizedForm);
    if (filterByNormalizedForm != "") {
        newHeaderText = newHeaderText + " normalized form name " + filterByNormalizedForm;
    } else {
        newHeaderText = "All normalized forms";
    }
	
	genericGet(
		"/api/normalizedForms/search/findByNormalizedFormContains" + queryParams
        , function(result) {
            callback(newHeaderText, result._embedded.normalizedForms);
        });
}
