package kz.bitlab.demo.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Magazine {
    private Long id;
    private String name;
    private String description;
    private double price;
}
