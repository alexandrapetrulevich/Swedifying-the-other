function getAllLanguages(callback) {
    genericGetAll(
            "languages"
            , "languageView"
            , function(data) {
                callback(data._embedded.languages);
            });
}

function getLanguageById(id, callback, errorCallback) {
    genericGetById(id, "languages", callback, errorCallback);
}

function createOrEditLanguage(callback, languageId) {
    var languageNameValue = document.getElementById("languageName").value;
    var languageCodeValue = document.getElementById("languageCode").value;
	var languageData = {
		languageId:null
		, languageName:languageNameValue
		, languageCode:languageCodeValue};
    if (languageId === "") {
        genericCreate(languageData, "languages", callback);
    } else {
        languageData.languageId = parseInt(languageId);
        genericUpdate(languageData, "languages", languageId, "PUT", callback);
    }
}

function getQueryParamsAndHeaderTextAndSearchResource(origHeaderText, filterByName, filterByCode) {
    var queryParams = "?projection=languageView";
    var headerText = origHeaderText;
    var searchResource = "findByLanguageNameContains";
    if (filterByName != "" && filterByCode != "") {
        queryParams += "&languageNameFilter=" + filterByName + "&languageCodeFilter=" + filterByCode;
        headerText += " language name " + filterByName + " and language code " + filterByCode;
        searchResource += "AndLanguageCodeContains";
    } else if (filterByName != "") {
        queryParams += "&languageNameFilter=" + filterByName;
        headerText += " language name " + filterByName;
        // searchResource as default
    } else if (filterByCode != "") {
        queryParams += "&languageCodeFilter=" + filterByCode;
        headerText += " language code " + filterByName;
        searchResource = "findByLanguageCodeContains";
    } else {
        // none set, search by name with empty query
        queryParams += "&languageNameFilter=" + filterByName;
        headerText = "All languages";
        // searchResource as default
    }

    return {queryParams:queryParams, headerText:headerText, searchResource:searchResource}
}

function doFilterLanguages(newHeaderText, callback) {
    var filterByName = document.getElementById("filterByLanguageName").value;
    var filterByCode = document.getElementById("filterByLanguageCode").value;

    var queryHeaderResource = getQueryParamsAndHeaderTextAndSearchResource(newHeaderText, filterByName, filterByCode);

	genericGet(
		"/api/languages/search/" + queryHeaderResource.searchResource + queryHeaderResource.queryParams
        , function(result) {
            callback(queryHeaderResource.headerText, result._embedded.languages);
        });
}