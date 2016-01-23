/**
 * an illustration of FactoryMethod
 */
package com.design.creational;

interface IPeople
{
  public String getName();
}

class Villagers implements IPeople
{
@Override
  public String getName()
  {
      return "Village Person";
  }
}

class CityPeople implements IPeople
{
	@Override
  public String getName()
  {
      return "City Person";
  }
}


/**
 *  <summary>
 *  Implementation of Factory - Used to create objects
 *  </summary>
 * @author rbaral
 *
 */

enum PeopleType {RURAL,URBAN }
public class FactoryMethod {
	
	public static IPeople getPeople(PeopleType type)
	  {
	     switch (type)
	      {
	          case RURAL:
	              return new Villagers();
	          case URBAN:
	              return new CityPeople();
	          default:
	        	  return new CityPeople();
	      }
	    }
	
	public static void main(String[] args) {
		IPeople people = getPeople(PeopleType.RURAL);
		System.out.println(people.getName());
	}

}
