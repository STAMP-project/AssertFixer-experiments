package io.caiwan.utils.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DummyTestDto {

    Long id;
    String kitten;
    String puppy;
    String giraffe;

}
