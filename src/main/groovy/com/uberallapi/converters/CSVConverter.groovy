package com.uberallapi.converters

import com.uberallapi.model.Location
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVPrinter

class CSVConverter implements Converter {

    @Override
    def convert(List<Location> locations) {
        def results = []
        results << ["Name","City","Zip","StreetAndNumber","Keywords","Opening Hours","Lat","Lng"]
        for(d in locations) {
            def r= [d.name, d.city,d.zip,d.streetAndNumber,d.keywords.join(","),d.openingHours.toString(),d.lat,d.lng]
            results << r
        }
        StringWriter stringWriter = new StringWriter();
        CSVPrinter printer = new CSVPrinter(stringWriter, CSVFormat.EXCEL);
        printer.printRecords( results )
        printer.flush()
        printer.close()
        return stringWriter.toString()
    }
}
