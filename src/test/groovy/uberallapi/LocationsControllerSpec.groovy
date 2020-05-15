package uberallapi

import com.uberallapi.converters.AcceptType
import com.uberallapi.model.Location
import com.uberallapi.model.StoreTimings
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


class LocationsControllerSpec extends Specification implements ControllerUnitTest<LocationsController> {

    void "test get locations response defulat format"(){
        given:
            Location location = new Location()
            location.city="Kempen"
            location.keywords=[]
            location.lng=56.2423423
            location.lng=57.83294
            location.streetAndNumber ="Kleinbahnstraße 32"
            StoreTimings time = new StoreTimings()
            time.dayOfWeek=1
            time.from1="08:00"
            time.to1="08:00"
            List<StoreTimings> li = new ArrayList<>()
            li.add(time)
            location.openingHours = li
            List<Location> sampleLocation = new ArrayList<>()
            sampleLocation.add(location)
            LocationService service = Mock()
            controller.locationService = service
            service.getLocations() >> sampleLocation
        when: 'The index action is executed'
            controller.getLocations()
        then: 'Response in default format json'
            println response.text
    }

    void "test get locations response in json"(){
        given:
            request.addHeader("Accept","application/json")
            Location location = new Location()
            location.city="Kempen"
            location.keywords=[]
            location.lng=56.2423423
            location.lng=57.83294
            location.streetAndNumber ="Kleinbahnstraße 32"
            StoreTimings time = new StoreTimings()
            time.dayOfWeek=1
            time.from1="08:00"
            time.to1="08:00"
            List<StoreTimings> li = new ArrayList<>()
            li.add(time)
            location.openingHours = li
            List<Location> sampleLocation = new ArrayList<>()
            sampleLocation.add(location)
            LocationService service = Mock()
            controller.locationService = service
            service.getLocations() >> sampleLocation
        when: 'The index action is executed'
            controller.getLocations()
        then: 'The response in json'
            response.mimeType.name.equals(AcceptType.APPLICATION_JSON.getAcceptType())
            println response.text
    }

    void "test get locations response in csv format"(){
        given:
            request.addHeader("Accept","text/csv")
            Location location = new Location()
            location.city="Kempen"
            location.keywords=[]
            location.lng=56.2423423
            location.lng=57.83294
            location.streetAndNumber ="Kleinbahnstraße 32"
            StoreTimings time = new StoreTimings()
            time.dayOfWeek=1
            time.from1="08:00"
            time.to1="08:00"
            List<StoreTimings> li = new ArrayList<>()
            li.add(time)
            location.openingHours = li
            List<Location> sampleLocation = new ArrayList<>()
            sampleLocation.add(location)
            LocationService service = Mock()
            controller.locationService = service
            service.getLocations() >> sampleLocation
        when: 'The index action is executed'
            controller.getLocations()
        then: 'Response in CSV'
            response.mimeType.name.equals(AcceptType.TEXT_CSV.getAcceptType())
            println response.text
    }

    void "test get locations response in xml format"(){
        given:
            request.addHeader("Accept","application/xml")
            Location location = new Location()
            location.city="Kempen"
            location.keywords=[]
            location.lng=56.2423423
            location.lng=57.83294
            location.streetAndNumber ="Kleinbahnstraße 32"
            StoreTimings time = new StoreTimings()
            time.dayOfWeek=1
            time.from1="08:00"
            time.to1="08:00"
            List<StoreTimings> li = new ArrayList<>()
            li.add(time)
            location.openingHours = li
            List<Location> sampleLocation = new ArrayList<>()
            sampleLocation.add(location)
            LocationService service = Mock()
            controller.locationService = service
            service.getLocations() >> sampleLocation
        when: 'get location executed'
            controller.getLocations()
        then: 'response in xml format'
            println response.mimeType.name.equals(AcceptType.APPLICATION_XML.getAcceptType())
            println response.text
    }
}
