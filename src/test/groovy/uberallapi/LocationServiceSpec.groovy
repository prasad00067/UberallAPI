package uberallapi

import com.uberallapi.model.Location
import com.uberallapi.model.ResponseMetadata
import com.uberallapi.model.SearchResponse
import com.uberallapi.model.StoreTimings
import com.uberallapi.rest.RestClient
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

import javax.naming.directory.SearchResult

class LocationServiceSpec extends Specification implements ServiceUnitTest<LocationService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test get locations method"() {
        given:
            LocationService service = new LocationService()
            service.restClient = Mock(RestClient)
            SearchResponse searchResponse = new SearchResponse()
            ResponseMetadata metadata = new ResponseMetadata()
            List<Location> locations = new ArrayList<>()
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
            locations.add(location)
            metadata.locations = locations
            searchResponse.status= "SUCCESS"
            searchResponse.response = metadata
            service.restClient.getData() >> searchResponse
        when:
            List<Location> list= service.getLocations()
        then:
            !list.isEmpty()
    }
}
