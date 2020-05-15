package com.uberallapi.converters

import com.uberallapi.model.Location

@FunctionalInterface
interface Converter {
    def convert(List<Location> locations)
}