package com.Calculate_Utils;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
class HammingUtlisTest {
    @Test
    void getHammingDistance(){
        int distance = Calculate_Similarity.getHammingDistance("0000000000000000000000000000000000000000000000000000000000000000", "0000000000000000000000000000000000000000000000000000000000000000");
        assertEquals(0, distance);
    }
    @Test
    void getSimilarity(){
        double delta = 1e-6;
        double similarity = Calculate_Similarity.getSimilarity("0000000000000000000000000000000000000000000000000000000000000000", "0000000000000000000000000000000000000000000000000000000000000000");
        assertEquals(100, similarity, delta);
    }

}
