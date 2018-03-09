package AtmaniEspinasse.TpMorphia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;

/**
 * Main class involved in connecting to the MongoDB instance, populating the
 * entities and persisting them
 *
 */
public class App {
	public static void main(String[] args) {

		Morphia morphia = new Morphia();
		MongoClient mongoClient = new MongoClient();
		morphia.map(Person.class).map(Address.class).map(Article.class);
		Datastore datastore = morphia.createDatastore(mongoClient, "tpMorphia");

		/**
		 * Creating Persons
		 */

		Person Ines = new Person();
		Person Dimas = new Person();
		Person Imene = new Person();
		Ines.setName("Ines Atm");
		Dimas.setName("Dimas Do");
		Imene.setName("Imene Atm");

		/**
		 * Creating Person's addresses
		 */
		Address address = new Address();
		address.setStreet("90 Old Edinburgh Road");
		address.setCity("BEELEY");
		address.setPostCode("DE4 1FX");
		address.setCountry("United Kingdom");

		Address address1 = new Address();
		address1.setStreet("28 Newgate Street");
		address1.setCity("JEFFREYSTON");
		address1.setPostCode("SA68 1GE");
		address1.setCountry("United Kingdom");

		Address address0 = new Address();
		address0.setStreet("2635 Bryan Avenue");
		address0.setCity("Eagan, Minnesota");
		address0.setPostCode("55121");
		address0.setCountry("United State");

		Address address2 = new Address();
		address2.setStreet("1611 Jade St");
		address2.setCity("West Vancouver");
		address2.setPostCode("V7V 1Y8");
		address2.setCountry("CANADA");

		Address address3 = new Address();
		address3.setStreet("46 rue Garneau");
		address3.setCity("Quebec");
		address3.setPostCode("G1V 3V5");
		address3.setCountry("CANADA");

		Address address4 = new Address();
		address4.setStreet("138 Hammarskjold Dr");
		address4.setCity("Burnaby");
		address4.setPostCode("V5B 3C9");
		address4.setCountry("CANADA");

		List<Address> adI = new ArrayList<Address>();
		List<Address> adO = new ArrayList<Address>();
		List<Address> adM = new ArrayList<Address>();
		adI.addAll(Arrays.asList(address1, address4));
		adO.addAll(Arrays.asList(address2, address0));
		adM.addAll(Arrays.asList(address3, address));
		// adI.add(address1);
		// adI.add(address4);
		// adO.add(address2);
		// adO.add(address0);
		// adM.add(address3);
		// adM.add(address);

		/**
		 * Set Person's addresses
		 */
		Ines.setAdresses(adI);
		Dimas.setAdresses(adO);
		Imene.setAdresses(adM);

		/**
		 * Creating Articles
		 */
		Article article = new Article();
		Article article1 = new Article();
		Article article2 = new Article();

		/**
		 * Assigning articles to the persons who bought them
		 */
		article1.setPersons(Arrays.asList(Ines, Imene));
		article2.setPersons(Arrays.asList(Dimas, Imene));
		article.setPersons(Arrays.asList(Ines, Dimas));
		/**
		 * Save POJO
		 */
		datastore.save(Ines);
		datastore.save(Dimas);
		datastore.save(Imene);
		datastore.save(address0);
		datastore.save(address);
		datastore.save(address1);
		datastore.save(address2);
		datastore.save(address3);
		datastore.save(address4);
		datastore.save(article);
		datastore.save(article1);
		datastore.save(article2);

		for (Article e : datastore.find(Article.class))
			System.err.println(e.toString());
	}

}
