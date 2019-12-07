package mapper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class ListMapper extends CustomMapper<Map<String, List<String>>, Map<String, String>> {

    final Optional<Pattern> pattern;

    public ListMapper(String filterStr) {
        super();
        pattern = Optional.ofNullable(filterStr).map(str -> Pattern.compile(str));
    }

    @Override
    public void mapBtoA(Map<String, String> b, Map<String, List<String>> a,
                        MappingContext context) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void mapAtoB(Map<String, List<String>> a, Map<String, String> b,
                        MappingContext context) {
        map(a, b);
    }

    private void map(Map<String, List<String>> a, Map<String, String> b) {
        a.entrySet().stream()
                .filter( entry -> !pattern.map(p -> p.matcher(entry.getKey()).matches()).orElseGet(() -> true))
                .collect(Collectors.toMap(entry -> entry.getKey(),
                        entry -> entry.getValue().get(0),
                        (u,v) -> u,
                        () -> b));
    }
}
