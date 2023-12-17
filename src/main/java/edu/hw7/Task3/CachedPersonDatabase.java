package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CachedPersonDatabase implements PersonDatabase {
    private final Map<Integer, Person> personMap = new ConcurrentHashMap<>();

    private final Map<String, List<Integer>> nameIndex = new ConcurrentHashMap<>();

    private final Map<String, List<Integer>> addressIndex = new ConcurrentHashMap<>();

    private final Map<String, List<Integer>> phoneIndex = new ConcurrentHashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void add(Person person) {
        int id = person.id();

        lock.writeLock().lock();
        try {
            personMap.put(id, person);
            addToIndex(nameIndex, person.name(), id);
            addToIndex(addressIndex, person.address(), id);
            addToIndex(phoneIndex, person.phoneNumber(), id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = personMap.remove(id);
            removeFromIndex(nameIndex, person.name(), id);
            removeFromIndex(addressIndex, person.address(), id);
            removeFromIndex(phoneIndex, person.phoneNumber(), id);
        } finally {
            lock.writeLock().unlock();
        }
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

    private void addToIndex(Map<String, List<Integer>> index, String key, int id) {
        lock.writeLock().lock();
        try {
            index.computeIfAbsent(key, k -> new CopyOnWriteArrayList<>()).add(id);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void removeFromIndex(Map<String, List<Integer>> index, String key, int id) {
        lock.writeLock().lock();
        try {
            index.computeIfPresent(key, (k, list) -> {
                list.remove(Integer.valueOf(id));
                if (list.isEmpty()) {
                    return null;
                }
                return list;
            });
        } finally {
            lock.writeLock().unlock();
        }
    }

    private List<Person> findFromIndex(Map<String, List<Integer>> index, String key) {
        lock.readLock().lock();
        try {
            List<Integer> ids = index.getOrDefault(key, Collections.emptyList());
            List<Person> result = new ArrayList<>();

            for (int id : ids) {
                Person person = personMap.get(id);
                if (person != null) {
                    result.add(person);
                }
            }

            return result;
        } finally {
            lock.readLock().unlock();
        }
    }
}
