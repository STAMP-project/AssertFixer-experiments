package io.github.caiwan.datasheet.decorator;

import io.github.caiwan.datasheet.SheetBlockDecorator;
import lombok.*;

import java.util.Properties;

@NoArgsConstructor
@RequiredArgsConstructor
public class PropertyDecorator implements SheetBlockDecorator{

    @Getter
    @Setter
    @NonNull
    private Properties properties;

    @Getter
    @Setter
    private String titleKeyPrefix;

    @Getter
    @Setter
    private String propertyKeyPrefix;


    @Override
    public String blockTitle(String name) {
        return null;
    }

    @Override
    public String propertyHeader(String name) {
        return null;
    }
}
