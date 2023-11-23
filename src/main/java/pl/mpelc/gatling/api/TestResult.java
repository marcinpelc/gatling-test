package pl.mpelc.gatling.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestResult {
    List<String> results;
    Long count;
}
