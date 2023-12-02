package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UniversalRegion {
    UNKNOWN("unknown"),

    LOCAL("local"),

    AMSTERDAM("amsterdam"),

    ATLANTA("atlanta"),

    BANGALORE("bangalore"),

    DALLAS("dallas"),

    FRANKFURT("frankfurt"),

    LONDON("london"),

    MUMBAI("mumbai"),

    NEWARK("newark"),

    NEW_YORK_CITY("new_york_city"),

    SAN_FRANCISCO("san_francisco"),

    SINGAPORE("singapore"),

    SYDNEY("sydney"),

    TOKYO("tokyo"),

    TORONTO("toronto"),

    WASHINGTON_DC("washington_dc"),

    CHICAGO("chicago"),

    PARIS("paris"),

    SEATTLE("seattle"),

    SAO_PAULO("sao_paulo"),

    STOCKHOLM("stockholm"),

    CHENNAI("chennai"),

    OSAKA("osaka"),

    MILAN("milan"),

    MIAMI("miami"),

    JAKARTA("jakarta"),

    LOS_ANGELES("los_angeles");

    private final String value;

    UniversalRegion(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
