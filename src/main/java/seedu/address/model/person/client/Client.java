package seedu.address.model.person.client;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonId;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

/**
 * Represents a Client in HairStyleX record.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Client extends Person {

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Client(Name name, Phone phone, Email email, Gender gender, Address address, Set<Tag> tags) {
        super(name, phone, email, gender);
        requireAllNonNull(address, tags);
        this.address = address;
        this.tags.addAll(tags);
    }

    /**
     * For id counter.
     * This is an existing patient and does not need to generate a new ID.
     */
    public Client(PersonId id, Name name, Phone phone, Email email, Gender gender, Address address, Set<Tag> tags) {
        super(id, name, phone, email, gender);
        requireAllNonNull(address, tags);
        this.address = address;
        this.tags.addAll(tags);
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }


    /**
     * Returns true if both clients have the same identity and data fields.
     * This defines a stronger notion of equality between two clients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Client)) {
            return false;
        }

        Client otherClient = (Client) other;
        return otherClient.getName().equals(getName())
                && otherClient.getGender().equals(getGender())
                && otherClient.getEmail().equals(getEmail())
                && otherClient.getPhone().equals(getPhone())
                && otherClient.getAddress().equals(getAddress())
                && otherClient.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
