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
    var languageNameValue = $("#languageName").val();
    var languageCodeValue = $("#languageCode").val();

    if (languageId === "") {
        var languageData = {languageName:languageNameValue, languageCode:languageCodeValue};
        genericCreate(languageData, "languages", callback);
    } else {
        var languageData = {
            languageId:parseInt(languageId)
            , languageName:languageNameValue
            , languageCode:languageCodeValue
            };
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
    var filterByName = $("#filterByLanguageName").val();
    var filterByCode = $("#filterByLanguageCode").val();

    var queryHeaderResource = getQueryParamsAndHeaderTextAndSearchResource(newHeaderText, filterByName, filterByCode);

    $.get("/api/languages/search/" + queryHeaderResource.searchResource + queryHeaderResource.queryParams
        , function(data, status) {
            callback(queryHeaderResource.headerText, data._embedded.languages);
        }
        , "json");
}