package com.amigoscode.examples;

import com.amigoscode.beans.Car;
import com.amigoscode.beans.Person;
import com.amigoscode.beans.PersonDTO;
import com.amigoscode.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> dtos = people.stream().map(p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge()))
                .filter(p -> p.getAge() < 10)
                .collect(Collectors.toList());

        List<PersonDTO> dtosStatic = people.stream().map(p -> PersonDTO.map(p))
                .filter(p -> p.getAge() > 60)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);
        dtosStatic.forEach(System.out::println);

        assertThat(people.size()).isNotEqualTo(dtosStatic.size());
    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    }
}

