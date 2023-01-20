package exercise.demo;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class Item {
    @NonNull
    private Integer id;
    private String name;
    private Double price;
}
