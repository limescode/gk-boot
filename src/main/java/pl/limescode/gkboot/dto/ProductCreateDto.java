package pl.limescode.gkboot.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateDto {
    private String title;
    private BigDecimal price;
}
