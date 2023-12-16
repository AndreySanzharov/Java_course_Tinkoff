package edu.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTests {
    Tasks tasks = new Tasks();
    List<Animal> animals = createAnimals();

    List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Vasyaa", DOG, M, 10, 32, 364, true));
        animals.add(new Animal("Petya", FISH, F, 32, 53, 243, false));
        animals.add(new Animal("Jora", Animal.Type.BIRD, M, 53, 352, 53, false));
        animals.add(new Animal("Liza", Animal.Type.CAT, F, 30, 90, 432, true));
        return animals;
    }

    //task1
    @Test
    void sortedByHeightTest() {

        List<Animal> sortedAnimals = new ArrayList<>();

        sortedAnimals.add(new Animal("Vasyaa", DOG, M, 10, 32, 364, true));
        sortedAnimals.add(new Animal("Petya", FISH, F, 32, 53, 243, false));
        sortedAnimals.add(new Animal("Liza", Animal.Type.CAT, F, 30, 90, 432, true));
        sortedAnimals.add(new Animal("Jora", Animal.Type.BIRD, M, 53, 352, 53, false));

        assertThat(tasks.sortByHeight(animals)).isEqualTo(sortedAnimals);
    }

    //task2
    @Test
    void reverseSortByWeightAndChooseKTest() {
        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(new Animal("Liza", Animal.Type.CAT, F, 30, 90, 432, true));
        expectedList.add(new Animal("Vasyaa", DOG, M, 10, 32, 364, true));

        assertThat(tasks.lightToHeavyWeight(animals, 2)).isEqualTo(expectedList);
    }

    //task3
    @Test
    void typesCountTest() {
        Map<Animal.Type, Integer> expectedMap = new HashMap<>();
        expectedMap.put(DOG, 1);
        expectedMap.put(Animal.Type.CAT, 1);
        expectedMap.put(Animal.Type.BIRD, 1);
        expectedMap.put(FISH, 1);
        assertThat(tasks.countTypes(animals)).isEqualTo(expectedMap);
    }

    //task4
    @Test
    void longestNameTest() {
        Animal lion = new Animal("Lion", DOG, M, 10, 32, 364, true);
        Animal elephant = new Animal("Elephant", DOG, M, 10, 32, 364, true);
        Animal giraffe = new Animal("Giraffe", DOG, M, 10, 32, 364, true);
        List<Animal> animals = Arrays.asList(lion, elephant, giraffe);
        Animal longestNameAnimal = new Tasks().longestName(animals);

        assertEquals(elephant, longestNameAnimal);

    }

    //task5
    @Test
    void maleOrFemaleTest() {
        animals.add(new Animal("wef", DOG, M, 10, 20, 30, true));
        assertThat(tasks.maleOrFemale(animals)).isEqualTo(M);
    }

    //task6
    @Test
    void heaviestAnimalOfTypes() {
        animals.add(new Animal("wef", Animal.Type.DOG, Animal.Sex.M, 10, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 10, 20, 1000, true));
        Map<Animal.Type, Animal> expectedMap = new HashMap<>();
        expectedMap.put(Animal.Type.DOG, new Animal("wef", Animal.Type.DOG, Animal.Sex.M, 10, 20, 1000, true));
        expectedMap.put(Animal.Type.BIRD, new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 10, 20, 1000, true));
        expectedMap.put(Animal.Type.FISH, new Animal("Petya", Animal.Type.FISH, Animal.Sex.F, 32, 53, 243, false));
        expectedMap.put(Animal.Type.CAT, new Animal("Liza", Animal.Type.CAT, Animal.Sex.F, 30, 90, 432, true));
        assertThat(tasks.heaviestAnimalOfTypes(animals)).isEqualTo(expectedMap);
    }

    //task7
    @Test
    void oldestKTest() {
        animals.add(new Animal("wef", Animal.Type.BIRD, M, 100, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, M, 324, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, M, 543, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, M, 23, 20, 1000, true));
        assertThat(tasks.oldestK(animals, 3)).isEqualTo(new Animal(
            "wef",
            Animal.Type.BIRD,
            M,
            100,
            20,
            1000,
            true
        ));
    }

    //task8
    @Test
    void heaviestAndBelowKTest() {
        assertThat(tasks.haviestAnimalBelowK(animals, 100)).isEqualTo(Optional.of(new Animal(
            "Liza",
            Animal.Type.CAT,
            F,
            30,
            90,
            432,
            true
        )));
    }

    //task9
    @Test
    void countPawsTest() {
        assertThat(tasks.countPaws(animals)).isEqualTo(10);
    }

    //task10
    @Test
    void animalsWithAgeNotEqualsPawsTest() {
        animals.add(new Animal("wef", Animal.Type.BIRD, M, 2, 20, 1000, true));

        List<Animal> expectedAnimals = createAnimals();
        assertThat(tasks.animalsWithAgeNotEqualsPaws(animals)).isEqualTo(expectedAnimals);
    }

    //task11
    @Test
    void canBiteAndHigher100() {
        animals.add(new Animal("wef", Animal.Type.BIRD, M, 2, 200, 1000, true));
        animals.add(new Animal("wesfdf", Animal.Type.BIRD, M, 2, 300, 1000, true));
        List<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(new Animal("wef", Animal.Type.BIRD, M, 2, 200, 1000, true));
        expectedAnimals.add(new Animal("wesfdf", Animal.Type.BIRD, M, 2, 300, 1000, true));
        assertThat(tasks.canBite(animals)).isEqualTo(expectedAnimals);
    }

    //task12
    @Test
    void weightMoreThanHeightTest() {
        assertThat(tasks.weightMoreThanHeight(animals)).isEqualTo(3);
    }

    //task13
    @Test
    void nameWithMoreTwoWordsTest() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.BIRD, M, 2, 200, 1000, true));
        animals.add(new Animal("wesfdf dsf sdf", Animal.Type.BIRD, M, 2, 300, 1000, true));
        List<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(new Animal("wef fdw dsf", Animal.Type.BIRD, M, 2, 200, 1000, true));
        expectedAnimals.add(new Animal("wesfdf dsf sdf", Animal.Type.BIRD, M, 2, 300, 1000, true));
        assertThat(tasks.nameWithMoreTwoWords(animals)).isEqualTo(expectedAnimals);
    }

    //task14
    @Test
    void dogHigherThanK() {
        animals.add(new Animal("wef fdw dsf", DOG, M, 2, 200, 1000, true));
        assertThat(tasks.dogHigherThanK(animals, 100)).isTrue();
        assertThat(tasks.dogHigherThanK(animals, 500)).isFalse();
    }

    //task15
    @Test
    void summarizeWeightWithConditionTest() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.CAT, Animal.Sex.M, 26, 200, 1000, true));
        Map<Animal.Type, Integer> expectedMap = new HashMap<>();
        expectedMap.put(Animal.Type.FISH, 243);
        expectedMap.put(Animal.Type.CAT, 1432);
        assertThat(tasks.summarizeWeightWithCondition(animals, 25, 40)).isEqualTo(expectedMap);
    }

    //task16
    @Test
    void sortTypeSexName() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.CAT, M, 26, 200, 1000, true));
        System.out.println(tasks.someSorts(animals));
        System.out.println();
    }

    //task17
    @Test
    void spiderBitesMoreThanDogTest() {
        animals.add(new Animal("A", Animal.Type.SPIDER, Animal.Sex.M, 26, 200, 1000, true));
        animals.add(new Animal("B", Animal.Type.SPIDER, Animal.Sex.M, 26, 200, 1000, true));
        animals.add(new Animal("C", Animal.Type.DOG, Animal.Sex.M, 26, 200, 1000, false));
        assertThat(tasks.spiderBitesMoreThanDog(animals)).isTrue();
    }

    //task18
    @Test
    void findHeaviestFish() {
        List<Animal> animals2 = new ArrayList<>();
        animals.add(new Animal("Vasygaa", DOG, M, 10, 32, 364, true));
        animals.add(new Animal("Petfweya", FISH, F, 32, 53, 264, false));
        animals.add(new Animal("JorFWa", Animal.Type.BIRD, M, 53, 352, 53, false));
        animals.add(new Animal("FW", FISH, F, 30, 90, 432, true));
        assertThat(Tasks.findHeaviestFishInLists(animals, animals2)).isEqualTo(new Animal(
            "FW",
            FISH,
            F,
            30,
            90,
            432,
            true
        ));
    }

    //task19
    @Test
    void findErrorsTest() {
        animals.add(new Animal("3429fu f3f4", FISH, F, 30, 90, 432, true));
        Map<String, ValidationError> errors = tasks.findErrors(animals);
        assertThat(errors.get("Vasyaa").getWeightError().getMessage()).isEqualTo(
            "This type of animal can't have weight 364!");
        assertThat(errors.get("3429fu f3f4").getNameError().getMessage()).isEqualTo("Used illegal symbols!");
    }

    //task20
    @Test
    void findErrorsWithMessageTest() {
        Map<String, String> errors = tasks.findErrorsWithMessage(animals);
        System.out.println(errors);
        assertThat(errors.get("Liza")).isEqualTo(
            "No name error. No age error. This type of animal can't have height 90! This type of animal can't have weight 432!");
        assertThat(errors.get("Vasyaa")).isEqualTo(
            "No name error. No age error. No height error. This type of animal can't have weight 364!");
    }
}