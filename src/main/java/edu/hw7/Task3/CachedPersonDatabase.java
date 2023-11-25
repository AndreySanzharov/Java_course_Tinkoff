package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CachedPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> personMap = new ConcurrentHashMap<>();

    private final Map<String, List<Integer>> nameIndex = new ConcurrentHashMap<>();

    private final Map<String, List<Integer>> addressIndex = new ConcurrentHashMap<>();

    private final Map<String, List<Integer>> phoneIndex = new ConcurrentHashMap<>();

    @Override
    public synchronized void add(Person person) {
        int id = person.id();
        personMap.put(id, person);

        addToIndex(nameIndex, person.name(), id);
        addToIndex(addressIndex, person.address(), id);
        addToIndex(phoneIndex, person.phoneNumber(), id);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = personMap.remove(id);

        removeFromIndex(nameIndex, person.name(), id);
        removeFromIndex(addressIndex, person.address(), id);
        removeFromIndex(phoneIndex, person.phoneNumber(), id);
    }

    @Override
    public List<Person> findByName(String name) {
        return findFromIndex(nameIndex, name);
    }

    @Override
    public List<Person> findByAddress(String address) {
        return findFromIndex(addressIndex, address);
    }

    @Override
    public List<Person> findByPhone(String phone) {
        return findFromIndex(phoneIndex, phone);
    }

    private synchronized void addToIndex(Map<String, List<Integer>> index, String key, int id) {
        // Если ключ (например, имя, адрес, телефон) отсутствует в индексе, создаем новый список
        index.computeIfAbsent(key, k -> new CopyOnWriteArrayList<>()).add(id);
    }

    private synchronized void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        index.computeIfPresent(key, (k, list) -> {
            list.remove(Integer.valueOf(id));

            if (list.isEmpty()) {
                return null;
            }

            return list;
        });
    }

    private List<Person> findFromIndex(Map<String, List<Integer>> index, String key) {
        List<Integer> ids = index.getOrDefault(key, Collections.emptyList());
        List<Person> result = new ArrayList<>();

        for (int id : ids) {
            Person person = personMap.get(id);
            if (person != null) {
                result.add(person);
            }
        }

        return result;
    }
}
