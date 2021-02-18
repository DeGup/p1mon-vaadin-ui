package nl.degup.spring.p1monui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class P1Poller {
    private final WebClient client;
    private final ObjectMapper objectMapper;

    public P1Poller(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        client = WebClient.builder()
                .baseUrl("http://www.p1mon.nl/api/v1/smartmeter?limit=1")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @PostConstruct
    public void subscribe() {
        poll().subscribe();
    }

    public Flux<Map> poll() {
        Flux<Map> map = Flux.interval(Duration.ofSeconds(10))
                .flatMap((n) -> client.get().retrieve().bodyToMono(String.class).map(r -> {
                    var mapped = new HashMap<>();
                    var keys = List.of("timestamp", "timestampUtc", "isProcessed", "consumptionKwhLow", "consmptionKwtHigh", "productionKwhLow", "productionKwhHigh", "tarif", "consumptionW", "productionW", "consumptionGas");
                    var splitted = r.replaceAll("\\[", "").replaceAll("]", "").split(",");
                    for (int i = 0; i < splitted.length; i++) {
                        mapped.put(keys.get(i), splitted[i]);
                    }
                    // TODO: map to object; mapstruct on map?
                    return mapped;
                }));
        return map;


    }

}
