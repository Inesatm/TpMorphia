## TP 3 de SIR : à la découverte des bases NoSQL

#### Binôme : Atmani_Espinasse


#### MongoDB
Réaliser une application simple en utilisant une API comme Morphia proche de JPA en se plaçant dans un cadre classique de développement au dessus d’une base orientée document comme Mongo.

*  Installer la base de données MongoDB, lancer la base de donnée.
*  Utiliser Morphia pour se connecter à la base de données.

  #### Le modèle métier du tp
  
 ![Modèle métier du tp](sir/tp3.png)
 
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
Classe principale qui nous permet de manipuler les données dans la bdd via la librairie Morphia. (la classe à lancer pour tester la partie MongoDB)

### Questions: Quelles sont les limites d’une base données orientées document ?
* Intergrité des données: dû au fait que le développeur peut facilement insérer des données de qualité variable dans n'importe quelle collection, ce qui implique un risque d'avoir des structures de documents mal définie ou obsolètes.
* Les requêtes qu'on peut effectuer sur cette base sont moins fortes qu'en SQL classique ce qui limite les requêtes complexes par rapport à une base relationnelle.

#### Redis
#### La classe App.java
Classe qui définie toutes les opérations concernant Redis
### Questions: Quelles sont les types de données stockés dans Redis, que peut on faire comme types de requêtes ?
* Redis est une base de données orientée clefs-valeurs. Elle permet de manipuler des types de données simples : String, Listes, Hash, Sets et Sets triés.

On peut effectuer différents types de requêtes (insérer, mettre à jour, filtrer) avec Redis, ces dernieres dépendent de chaque structure de données.
* INCR :incrémenter un nombre contenu dans une clé
* SET : ajouter  une valeur 
* GET :  voir les valeurs d'une clé
* DEL : supprimer une valeur

