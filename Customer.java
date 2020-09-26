package home_work1009;

import lombok.*;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@With
@Builder
public class Customer {
    private String name;
    private String lastName;
    private int age;
    private String address;

}