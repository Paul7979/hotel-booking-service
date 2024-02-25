package at.technikum.hotelbookingservice.offer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OfferStrategyFactory {

    private final List<String> goldCustomers = List.of("John Doe", "Max Mustermann");

    private final List<String> platinumCustomers = List.of("Jane Doe", "Erika Musterfrau");
    private final OfferCalculationStrategy defaultStrategy;

    private final Map<String, OfferCalculationStrategy> strategyMap = new HashMap<>();

    public OfferStrategyFactory(List<OfferCalculationStrategy> strategies) {
        var gold = goldCustomers.stream().
          collect(Collectors.toMap(Function.identity(), __ ->
            strategies.stream()
            .filter(GoldOfferCalculationStrategy.class::isInstance)
            .map(s -> (GoldOfferCalculationStrategy) s).findAny().orElseThrow()));
        var platinum = platinumCustomers.stream().
          collect(Collectors.toMap(Function.identity(), __ ->
            strategies.stream()
              .filter(PlatinumOfferCalculationStrategy.class::isInstance)
              .map(s -> (PlatinumOfferCalculationStrategy) s).findAny().orElseThrow()));
        strategyMap.putAll(gold);
        strategyMap.putAll(platinum);
        defaultStrategy = strategies.stream()
          .filter(RegularOfferCalculationStrategy.class::isInstance)
          .map(s -> (RegularOfferCalculationStrategy) s).findFirst().orElseThrow();
    }

    public OfferCalculationStrategy getOfferCalculationStrategy(String guestName) {
        return strategyMap.getOrDefault(guestName, defaultStrategy);
    }
}
