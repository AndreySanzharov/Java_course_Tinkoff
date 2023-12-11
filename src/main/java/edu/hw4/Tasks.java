package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings({"MethodName", "MagicNumber", "ParameterAssignment"})
public class Tasks {
    //1
    public List<Animal> sortByHeight(List<Animal> animals) {
        animals = animals.stream().sorted(Comparator.comparing(Animal::height)).toList();
        return animals;
    }

    //2
    public List<Animal> lightToHeavyWeight(List<Animal> animals, Integer k) {
        animals = animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
        return animals;
    }

    //3
    public Map<Animal.Type, Integer> countTypes(List<Animal> animals) {
        Map<Animal.Type, Integer> types = new HashMap<>();
        animals.forEach(animal -> {
            if (types.containsKey(animal.type())) {
                types.put(animal.type(), types.get(animal.type()) + 1);
            } else {
                types.put(animal.type(), 1);
            }
        });
        return types;
    }

    //4
    public Animal longestName(List<Animal> animals) {
        animals =
            animals.stream().sorted((Animal n1, Animal n2) -> Integer.compare(n2.name().length(), n1.name().length()))
                .limit(1).toList().reversed();
        return animals.get(0);
    }

    //5
    public Animal.Sex maleOrFemale(List<Animal> animals) {
        Map<Animal.Sex, Integer> sexesCount = new HashMap<>();
        sexesCount.put(Animal.Sex.M, 0);
        sexesCount.put(Animal.Sex.F, 0);
        animals.forEach(animal ->
            sexesCount.put(animal.sex(), sexesCount.get(animal.sex()) + 1)
        );
        return sexesCount.get(Animal.Sex.M) >= sexesCount.get(Animal.Sex.F) ? Animal.Sex.M : Animal.Sex.F;
    }

    //6
    public Map<Animal.Type, Animal> heaviestAnimalOfTypes(List<Animal> animalList) {
        return animalList.stream()
            .collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
            ));
    }

    //7
    public Animal oldestK(List<Animal> animals, Integer k) {
        return animals.stream().sorted(Comparator.comparing(Animal::age).reversed()).toList().get(k - 1);
    }

    //8
    public Optional<Animal> haviestAnimalBelowK(List<Animal> animals, Integer k) {
        return animals.stream().filter(animal -> animal.height() < k).max(Comparator.comparing(Animal::weight));
    }

    //9
    public Integer countPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    //10
    public List<Animal> animalsWithAgeNotEqualsPaws(List<Animal> animals) {
        return animals.stream().filter((animal) -> animal.age() != animal.paws()).toList();
    }

    //11
    public List<Animal> canBite(List<Animal> animals) {
        return animals.stream().filter((animal -> animal.height() > 100 && animal.bites())).toList();
    }

    //12
    public Integer weightMoreThanHeight(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.weight() > animal.height()).toList().size();
    }

    //13
    public List<Animal> nameWithMoreTwoWords(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.name().split(" ").length > 2).toList();
    }

    //14
    public Boolean dogHigherThanK(List<Animal> animals, Integer k) {
        return !(animals.stream().filter(animal -> animal.type().equals(Animal.Type.DOG) && animal.height() > k)
            .toList().isEmpty());
    }

    //15
    public Map<Animal.Type, Integer> summarizeWeightWithCondition(List<Animal> animalList, Integer k, Integer i) {
        return animalList.stream().filter(animal -> animal.age() >= k && animal.age() <= i)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    //16
    public List<Animal> someSorts(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    //17
    public Boolean spiderBitesMoreThanDog(List<Animal> animalList) {
        long bitingSpiders = animalList.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        long bitingDogs = animalList.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        return bitingSpiders > bitingDogs;
    }

    //18
    @SafeVarargs public static Animal findHeaviestFishInLists(List<Animal>... animals) {
        if (animals.length < 2) {
            throw new IllegalArgumentException("There should be at least 2 lists");
        }
        List<Animal> animalList = Arrays.stream(animals).flatMap(List::stream).toList();
        if (animalList.isEmpty() || animalList.contains(null)) {
            return null;
        }
        return animalList.stream()
            .filter((animal) -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    //19
    Map<String, ValidationError> findErrors(List<Animal> animalList) {
        Map<String, ValidationError> errorsOfAnimals =
            animalList.stream()
                .collect(Collectors.toMap(Animal::name, a -> {
                    ValidationError validationError = new ValidationError();
                    validationError.checkAllErrors(a);
                    return validationError;
                }));
        return errorsOfAnimals;
    }

    //20
    Map<String, String> findErrorsWithMessage(List<Animal> animalList) {
        Map<String, String> errorsOfAnimals =
            animalList.stream()
                .collect(Collectors.toMap(Animal::name, a -> {
                    ValidationError validationError = new ValidationError();
                    validationError.checkAllErrors(a);
                    String message = validationError.getNameError().getMessage() + " "
                        + validationError.getAgeError().getMessage() + " "
                        + validationError.getHeightError().getMessage() + " "
                        + validationError.getWeightError().getMessage();
                    return message;
                }));
        return errorsOfAnimals;
    }
}
