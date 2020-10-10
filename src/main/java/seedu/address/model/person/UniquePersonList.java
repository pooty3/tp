package seedu.address.model.person;

import java.util.List;

import seedu.address.model.exception.DuplicateElementException;
import seedu.address.model.exception.ElementNotFoundException;
import seedu.address.model.person.exceptions.DuplicatePersonException;
import seedu.address.model.person.exceptions.PersonNotFoundException;


/**
 * A list of persons that enforces uniqueness between its elements and does not allow nulls.
 * A person is considered unique by comparing using {@code Person#isSamePerson(Person)}. As such, adding and updating of
 * persons uses Person#isSamePerson(Person) for equality so as to ensure that the person being added or updated is
 * unique in terms of identity in the UniquePersonList. However, the removal of a person uses Person#equals(Object) so
 * as to ensure that the person with exactly the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see Person#isSamePerson(Person)
 */
<<<<<<< HEAD
public class UniquePersonList<T extends Person> implements Iterable<T> {

    private final ObservableList<T> internalList = FXCollections.observableArrayList();
    private final ObservableList<T> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    public boolean contains(T toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSamePerson);
    }

    /**
     * Adds a person to the list.
     * The person must not already exist in the list.
     */
    public void add(T toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicatePersonException();
        }
        internalList.add(toAdd);
    }
=======
public class UniquePersonList<T extends Person> extends UniqueEntityList<T> {

>>>>>>> master

    /**
     * Replaces the person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the list.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the list.
     */
    public void setPerson(T target, T editedPerson) {
<<<<<<< HEAD
        requireAllNonNull(target, editedPerson);

        int index = internalList.indexOf(target);
        if (index == -1) {
=======
        try {
            setElement(target, editedPerson);
        } catch (ElementNotFoundException ex) {
>>>>>>> master
            throw new PersonNotFoundException();
        } catch (DuplicateElementException ex) {
            throw new DuplicatePersonException();
        }
    }

<<<<<<< HEAD
    /**
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
    public void remove(T toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
=======
    @Override
    public void remove(T toRemove) {
        try {
            super.remove(toRemove);
        } catch (ElementNotFoundException ex) {
>>>>>>> master
            throw new PersonNotFoundException();
        }
    }

<<<<<<< HEAD
    public void setPersons(UniquePersonList<T> replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setPersons(List<T> persons) {
        requireAllNonNull(persons);
        if (!personsAreUnique(persons)) {
=======

    @Override
    public void add(T toAdd) {
        try {
            super.add(toAdd);
        } catch (DuplicateElementException ex) {
>>>>>>> master
            throw new DuplicatePersonException();
        }
    }

    public void setPersons(UniquePersonList<T> replacement) {
        setElements(replacement);
    }

    /**
     * Replaces the contents of this list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
<<<<<<< HEAD
    public ObservableList<T> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<T> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UniquePersonList// instanceof handles nulls
                        && internalList.equals(((UniquePersonList) other).internalList));
    }
=======
    public void setPersons(List<T> persons) {
        try {
            setElements(persons);
        } catch (DuplicateElementException ex) {
            throw new DuplicatePersonException();
        }
    }


>>>>>>> master


<<<<<<< HEAD
    /**
     * Returns true if {@code persons} contains only unique persons.
     */
    private boolean personsAreUnique(List<T> persons) {
        for (int i = 0; i < persons.size() - 1; i++) {
            for (int j = i + 1; j < persons.size(); j++) {
                if (persons.get(i).isSamePerson(persons.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
=======
>>>>>>> master
}
