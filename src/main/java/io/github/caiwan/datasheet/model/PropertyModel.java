package io.github.caiwan.datasheet.model;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PropertyModel {

    @Getter
    @Setter
    @NonNull
    String name;

    @Getter
    @Setter
    @NonNull
    Integer id;

    @Getter
    @Setter
    Object defaultValue;
}
