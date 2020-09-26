package home_work2309;


import home_work1009.Customer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainCollectorsExample {
    public static void main(String[] args) {
        Customer jeka = Customer.builder().name("Jeka").age(42).build();
        Stream<Customer> stream = Stream.of(
                Customer.builder().name("Shay Solomon").age(42).build(),
                jeka,
                Customer.builder().name("Avigal B").age(18).build(),
                Customer.builder().name("Pavel").age(39).build(),
                Customer.builder().name("Tamara").age(18).build()
        );

        //get map from the stream
        Map<String,Integer>customers = stream.collect(Collectors.toMap(Customer::getName, Customer::getAge));

        //group by value
        Map<Integer, List<String>> result =
                customers.entrySet()
                .stream()
                .collect(Collectors
                        .groupingBy(Map.Entry::getValue,
                                Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(result);

        //todo find a way to group not customers, but only their names against the same age
        // [(42=["Shay","Jeka"]),()]
    }
}

