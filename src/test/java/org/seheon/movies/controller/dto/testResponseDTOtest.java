package org.seheon.movies.controller.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class testResponseDTOtest {
    @Test
    public void test_lombok(){
        String name = "test";
        int amount = 10;

        testResponseDTO dto = new testResponseDTO(name, amount);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //lombok test pass
    }

}

