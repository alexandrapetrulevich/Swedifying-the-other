# Swedifying-the-other
Place-name database for the project Swedifying the other https://www.vr.se/english/swecris.html#/project/P20-0105_RJ

## Example output from GET /api/v1/attestations
```
[
  {
    "attestationId": 34,
    "originalForm": "Grosse Ernshoff[s] Åkermark Uthi Wolgasts District",
    "variantForm": {
      "variantFormId": 31,
      "variantForm": "Grosse Ernsthoff",
      "isAdaptedToSwedish": "NO",
      "adaptationType": [],
      "normalizedForm": {
        "normalizedFormId": 28,
        "normalizedForm": "Grosse Ernsthoff",
        "morphologicalNameType": "COMPOSITION",
        "morphologicalNameTypeIsShaky": false,
        "morphologicalData": {
          "determinationClauseInPhrase": null,
          "mainClauseInPhrase": null,
          "simpleRootMorpheme": null,
          "derivationBase": null,
          "derivationMorpheme": null,
          "determinationClauseInComposition": "Ernst",
          "jointMorphemeInComposition": null,
          "mainClauseInComposition": "hof"
        },
        "comparativeFormInformation": "1618 Ernsthoff, Lubinsche Karte",
        "etymology": {
          "languageId": 4,
          "languageName": "German",
          "languageCode": "de"
        },
        "mediatingLanguage": null
      }
    },
    "location": {
      "locationId": 25,
      "longitude": 0,
      "latitude": 0,
      "modernLookupForm": "Gross Ernsthof",
      "districtOrParish": {
        "subRegionId": 13,
        "name": "Wolgasts distrikt",
        "belongsToRegion": {
          "regionId": 10,
          "regionName": "Pommern"
        }
      },
      "localityType": {
        "localityTypeId": 7,
        "localityTypeName": "bebyggelse, by"
      }
    },
    "sourceFinding": {
      "sourceFindingId": 22,
      "source": {
        "sourceId": 21,
        "dating": "1694-06-19",
        "landSurveyor": {
          "landSurveyorId": 14,
          "name": "Simon Skragge"
        },
        "signature": "BI",
        "mapSheet": 1
      },
      "partOfSource": {
        "partOfSourceId": 17,
        "partOfSourceName": "Rubrik"
      }
    },
    "notes": "Niemeyer 2:32f."
  },
  {
    "attestationId": 35,
    "originalForm": "Grosse Ernshoff[s] Åkermark Uthi Wolgasts District",
    "variantForm": {
      "variantFormId": 32,
      "variantForm": "Wolgasts distrikt",
      "isAdaptedToSwedish": "YES",
      "adaptationType": [
        {
          "adaptationTypeId": 15,
          "name": "morfologisk anpassning av förleden"
        }
      ],
      "normalizedForm": {
        "normalizedFormId": 29,
        "normalizedForm": "Wolgasts distrikt",
        "morphologicalNameType": "PHRASE",
        "morphologicalNameTypeIsShaky": false,
        "morphologicalData": {
          "determinationClauseInPhrase": "Wolgasts",
          "mainClauseInPhrase": "distrikt",
          "simpleRootMorpheme": null,
          "derivationBase": null,
          "derivationMorpheme": null,
          "determinationClauseInComposition": null,
          "jointMorphemeInComposition": null,
          "mainClauseInComposition": null
        },
        "comparativeFormInformation": "Wolgastischer District, Amte Wolgast. Kahldensche Matrikel",
        "etymology": {
          "languageId": 4,
          "languageName": "German",
          "languageCode": "de"
        },
        "mediatingLanguage": null
      }
    },
    "location": {
      "locationId": 26,
      "longitude": 0,
      "latitude": 0,
      "modernLookupForm": "",
      "districtOrParish": {
        "subRegionId": 13,
        "name": "Wolgasts distrikt",
        "belongsToRegion": {
          "regionId": 10,
          "regionName": "Pommern"
        }
      },
      "localityType": {
        "localityTypeId": 8,
        "localityTypeName": "distrikt"
      }
    },
    "sourceFinding": {
      "sourceFindingId": 23,
      "source": {
        "sourceId": 21,
        "dating": "1694-06-19",
        "landSurveyor": {
          "landSurveyorId": 14,
          "name": "Simon Skragge"
        },
        "signature": "BI",
        "mapSheet": 1
      },
      "partOfSource": {
        "partOfSourceId": 17,
        "partOfSourceName": "Rubrik"
      }
    },
    "notes": "Distriktsnamnet är anpassat till sv dock ej bebyggelsenamnet Wolgast som har slavisk etymologi och som medierats via tyska. I notarum står inte sällan \"Wolgasts ampt\"."
  },
  {
    "attestationId": 36,
    "originalForm": "Wolgasts Stadz Grentz",
    "variantForm": {
      "variantFormId": 33,
      "variantForm": "Wolgast",
      "isAdaptedToSwedish": "NO",
      "adaptationType": [],
      "normalizedForm": null
    },
    "location": {
      "locationId": 27,
      "longitude": 0,
      "latitude": 0,
      "modernLookupForm": "Wolgast",
      "districtOrParish": {
        "subRegionId": 13,
        "name": "Wolgasts distrikt",
        "belongsToRegion": {
          "regionId": 10,
          "regionName": "Pommern"
        }
      },
      "localityType": {
        "localityTypeId": 9,
        "localityTypeName": "bebyggelse, stad"
      }
    },
    "sourceFinding": {
      "sourceFindingId": 24,
      "source": {
        "sourceId": 21,
        "dating": "1694-06-19",
        "landSurveyor": {
          "landSurveyorId": 14,
          "name": "Simon Skragge"
        },
        "signature": "BI",
        "mapSheet": 1
      },
      "partOfSource": null
    },
    "notes": "Eichler & Walther 1988:300"
  }
]
```