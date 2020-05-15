package uberallapi

import com.uberallapi.model.Location
import com.uberallapi.model.SearchResponse
import com.uberallapi.rest.RestClient
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

@CompileStatic
class LocationService {

    @Autowired
    private RestClient restClient

    /**
     * This method is used to return the store locations.
     *
     * @return locations instance
     */
    public List<Location> getLocations() {
        final SearchResponse result = restClient.getData()
        log.info("Uberall sandbox result: "+result.status)
        final  List<Location> locations = result.response.locations
    }

}
