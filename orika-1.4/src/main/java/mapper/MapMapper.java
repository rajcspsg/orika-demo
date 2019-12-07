package mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class MapMapper extends CustomMapper<Map<String, String>, Map<String, String>> {

    private final Optional<Pattern> pattern;

    public MapMapper(String filterStr) {
        super();
        pattern = Optional.ofNullable(filterStr).map(str -> Pattern.compile(str));
    }

    @Override
    public void mapAtoB(Map<String, String> a, Map<String, String> b,
                        MappingContext context) {
        map(a, b);
    }

    @Override
    public void mapBtoA(Map<String, String> a, Map<String, String> b,
                        MappingContext context) {
        throw new UnsupportedOperationException();
    }

    private void map(Map<String, String> a, Map<String, String> b) {
        System.out.println("a is " + a);
        System.out.println("b is " + b);
        a.entrySet().stream()
                .filter( entry -> !pattern.map(p -> p.matcher(entry.getKey()).matches()).orElseGet(() -> false))
                .collect(Collectors.toMap(entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (u,v) -> u,
                        () -> b));
    }
}
