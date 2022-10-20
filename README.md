# Swedifying-the-other
Place-name database for the project Swedifying the other https://www.vr.se/english/swecris.html#/project/P20-0105_RJ

## Example output from GET /api/v1/attestations
```
[
  {
    "attestationId": 35,
    "originalForm": "Grosse Ernshoff[s] Åkermark Uthi Wolgasts District",
    "variantForm": {
      "variantFormId": 32,
      "variantForm": "Grosse Ernsthoff",
      "isAdaptedToSwedish": "NO",
      "adaptationTypes": [],
      "normalizedForm": {
        "normalizedFormId": 29,
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
      "locationId": 26,
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
      "sourceFindingId": 23,
      "source": {
        "sourceId": 22,
        "dating": "1694-06-19",
        "landSurveyor": {
          "landSurveyorId": 14,
          "name": "Simon Skragge"
        },
        "mapSignature": {
          "mapSignatureId": 21,
          "mapSignature": "BI"
        },
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
    "attestationId": 36,
    "originalForm": "Grosse Ernshoff[s] Åkermark Uthi Wolgasts District",
    "variantForm": {
      "variantFormId": 33,
      "variantForm": "Wolgasts distrikt",
      "isAdaptedToSwedish": "YES",
      "adaptationTypes": [
        {
          "adaptationTypeId": 15,
          "name": "morfologisk anpassning av förleden"
        }
      ],
      "normalizedForm": {
        "normalizedFormId": 30,
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
      "locationId": 27,
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
      "sourceFindingId": 24,
      "source": {
        "sourceId": 22,
        "dating": "1694-06-19",
        "landSurveyor": {
          "landSurveyorId": 14,
          "name": "Simon Skragge"
        },
        "mapSignature": {
          "mapSignatureId": 21,
          "mapSignature": "BI"
        },
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
    "attestationId": 37,
    "originalForm": "Wolgasts Stadz Grentz",
    "variantForm": {
      "variantFormId": 34,
      "variantForm": "Wolgast",
      "isAdaptedToSwedish": "NO",
      "adaptationTypes": [],
      "normalizedForm": null
    },
    "location": {
      "locationId": 28,
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
      "sourceFindingId": 25,
      "source": {
        "sourceId": 22,
        "dating": "1694-06-19",
        "landSurveyor": {
          "landSurveyorId": 14,
          "name": "Simon Skragge"
        },
        "mapSignature": {
          "mapSignatureId": 21,
          "mapSignature": "BI"
        },
        "mapSheet": 1
      },
      "partOfSource": null
    },
    "notes": "Eichler & Walther 1988:300"
  }
]
```