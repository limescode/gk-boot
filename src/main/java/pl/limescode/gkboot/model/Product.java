package pl.limescode.gkboot.model;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Setter(AccessLevel.NONE)
    private final Long id;
    private String title;
    private BigDecimal price;
}
