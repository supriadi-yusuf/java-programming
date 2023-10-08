package barokah.com.repository;

import barokah.com.data.Person;

public interface PersonRepository {
    Person selectById(String id);

    void insert(Person person);
}
