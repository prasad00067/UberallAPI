package com.uberallapi.converters

enum AcceptType {
    APPLICATION_JSON("application/json"),
    APPLICATION_XML("application/xml"),
    TEXT_CSV("text/csv");

    private String acceptType;

    String getAcceptType(){
        return this.acceptType;
    }
    private AcceptType(String acceptType){
        this.acceptType = acceptType;
    }

    static AcceptType fromString(String acceptType) {
        for (AcceptType type : AcceptType.values()) {
            if (acceptType != null && type.getAcceptType().equalsIgnoreCase(acceptType)) {
                return type;
            }
        }
        return null;
    }
}