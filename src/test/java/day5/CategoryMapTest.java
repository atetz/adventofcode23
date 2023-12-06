package day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryMapTest {

    @Test
    void getDestination() {
        CategoryMap testCategorymap = new CategoryMap("seed-to-soil map");
        testCategorymap.addRoutes(new long[]{50, 98, 2});
        testCategorymap.addRoutes(new long[]{52, 50, 48});

        assertEquals(testCategorymap.getDestination(79), 81);
        assertEquals(testCategorymap.getDestination(14), 14);
        assertEquals(testCategorymap.getDestination(55), 57);
        assertEquals(testCategorymap.getDestination(13), 13);
    }
}