package com.uberallapi.model

class Location {
    String name
    String city
    String zip
    String streetAndNumber
    List<String> keywords
    List<StoreTimings> openingHours
    float lat
    float lng

    @Override
    String toString() {
        return String.format("%s,%s,%s,%s,%s,%s",name,city,zip,streetAndNumber,keywords.join(","),openingHours.toString(),lat,lng)
    }
}
