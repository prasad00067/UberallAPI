package uberallapi

import com.uberallapi.converters.AcceptType
import com.uberallapi.converters.CSVConverter
import com.uberallapi.converters.Converter
import static com.uberallapi.converters.AcceptType.APPLICATION_XML
import static com.uberallapi.converters.AcceptType.APPLICATION_JSON
import static com.uberallapi.converters.AcceptType.TEXT_CSV
import grails.converters.JSON
import grails.converters.XML
import com.uberallapi.model.Location
import groovy.transform.CompileStatic

@CompileStatic
class LocationsController {

    LocationService locationService

    /**
     * This controller method is used to fetch the store location details from uberall sandbox api.
     * @return store location data in requested format
     */
    def getLocations() {
        Converter converter = null
        final AcceptType type = AcceptType.fromString(request.getHeader("Accept"))
        final List<Location> locations = locationService.getLocations()
        switch (type) {
            case APPLICATION_JSON:
                log.debug "Requested location response in json format."
                render locations as JSON
                break
            case TEXT_CSV:
                log.debug "Requested location response in CSV format."
                converter = new CSVConverter()
                String csvContent = converter.convert(locations)
                response.setHeader("Content-disposition", "attachment; filename=locations.csv")
                render(contentType: 'text/csv', text: csvContent)
                break
            case APPLICATION_XML:
                log.debug "Requested response in xml format."
                render locations as XML
                break
            default:
                log.debug "Requested unsupported format so returning data in json."
                render locations as JSON
        }
    }
}
