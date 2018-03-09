package AtmaniEspinasse.TpMorphia;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class Person {
	private ObjectId id;
	private String name;
	private Collection<Address> adresses;

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(Collection<Address> adresses) {
		this.adresses = adresses;
	}

}
