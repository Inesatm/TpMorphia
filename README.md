## TP 3 de SIR : à la découverte des bases NoSQL

#### Binôme : Atmani_Espinasse


#### Partie 1 API Morphia
####  Sujet
Réaliser une application simple en utilisant une API comme Morphia proche de JPA en se plaçant dans un cadre classique de développement au dessus d’une base orientée document comme Mongo.

*  Installer la base de données MongoDB, lancer la base de donnée.
*  Utiliser Morphia pour se connecter à la base de données.

  #### Le modèle métier du tp
  
![tp3](https://user-images.githubusercontent.com/31792531/37434409-c3723666-27df-11e8-961a-40b3b0dfdb74.png)

 
 * Implémentation de ce modèle en utilisant les différentes annotations Morphia, Ces annotations nous permettent de réaliser le mapping des données de la même manière que nous premet de le faire JPA .

#### La classe Person.java
Contient 3 variables dont id de type **ObjectId** qui sert d'identifiant unique pour chaque personne.

```Java
@Id
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

```
 #### Les deux autres classes Article.java et Adress.java ont la même structure que Person.java
 
#### Article.java
```Java
	@Id
	private ObjectId id;
	private String name;
	@Embedded
	private Collection<Person> persons
```

#### Address.java
```Java
  @Id
	private ObjectId id;
	private String street;
	private String city;
	private String postCode;
	private String country;
```

#### La classe App.java
Classe principale qui nous permet de manipuler les données dans la bdd via la librairie Morphia.



### Questions: Quelles sont les limites d’une base données orientées document ?

### Questions: Quelles sont les types de données stockés dans Redis, que peut on
faire comme types de requêtes ?
