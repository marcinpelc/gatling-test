import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class GatlingTestScenarion extends Simulation {

    HttpProtocolBuilder httpProtocol = http // 4
            .baseUrl("http://localhost:8220") // 8220-reactive;8222-not reactive
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
            .doNotTrackHeader("1")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0");

    ScenarioBuilder scn = scenario("GatlingTestScenarion")
            .exec(http("request_1")
                    .get("/books"));
//            .pause(5);

    {
        setUp(
                scn.injectOpen(atOnceUsers(100000))
        ).protocols(httpProtocol);
    }
}

