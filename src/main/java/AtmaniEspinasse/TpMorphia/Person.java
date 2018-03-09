package AtmaniEspinasse.TpMorphia;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Person {
	@Id
	@Property("id")
	private ObjectId id;
	private String name;
	@Embedded
	private Collection<Address> adresses;

	public Person() {

	}
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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
