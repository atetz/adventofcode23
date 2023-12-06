package day5;

import java.util.ArrayList;
import java.util.List;

public class CategoryMap {
    String name;
    List<long[]> routes = new ArrayList<>();

    public CategoryMap(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<long[]> getRoutes() {
        return routes;
    }

    public void addRoutes(long[] routes) {
        this.routes.add(routes);
    }

    public long getDestination(long source) {
        for (long[] route : routes) {
            long destinationStart = route[0];
            long sourceStart = route[1];
            long length = route[2];

            if (source >= sourceStart && source <= sourceStart + length - 1) {
                return destinationStart + (source - sourceStart);
            }
        }
        return source;
    }

}
