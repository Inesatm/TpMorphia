package AtmaniEspinasse.TpMorphia;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class Article {
	private ObjectId id;
	private String name;
	private Collection<Person> persons;

	public Article() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}

}
