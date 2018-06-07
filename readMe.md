# My Build Notes
  * Working with Siddiqa!

* [X] 1. Add cages and litter box to the shelter
* [X] 2. Add pets to those cages or litter box (PetBox). Need to be able to assign the pet to a particular cage or litterbox.
      * _Aaron helped guide me to a way to link the PetBox with the pet by using the PetBox object as a field in VirtualPet()_

* [X] The tick should 
  * increment hunger over time as well as decrease happiness. 
  * Then as hunger subsides, thirst increases along with waste.
  * Once waste reaches a certain level, it drops down which means the cage/litterbox is dirty. _Unless you walked the dog before you reach that level_.
  * As play increases, thirst and tired increases.
  * Robots don't get hungry, but they get bored and if they get bored they start to rust.

* [x] petDeathI() if the pet dies, ~then it should be removed from the cage. You would have to be able to list a cage as empty or remove it from the shelter.~
_On second thought, I thought it might be fun to just list the status as Dead... which means it may come back to life. Ever watch pet cemetery?_

* [x] Used a comparable! When the pets are introduced, I sort the pets by name. I had to implement a Comparable in VirtualPet to make that work. _This only works during the introduction because of how I ended showing the status of the pets. I broke it into two parts, organic & robotic_.

# Virtual Pets AMOK!
Oh noes! Your virtual pet shelter has become a mess!

Food and water and playtime aren’t enough anymore. The virtual cats are chasing the virtual dogs. The virtual organic animals are letting nature take its course in every corner, while the virtual robotic pets are getting rusty. Let’s just say things are piling up.

Thanks to the generosity of donors, leashes aren’t an issue, so you can walk all of your virtual dogs at once. This is great, since they are less like to soil their cages if walked regularly. Did I mention dogs are in cages now? Yeah, it keeps the cats from chasing them. Better keep those cages clean.

Cats hang out in a communal area and use a common litter box. Don’t even bother trying to walk them. What happens if that litter box overflows? Does it reduce pets’ health?

We’re introducing a health attribute for pets. Organic pets have their health decreased by unclean circumstances, and by thirst or hunger growing too high. Robotic pets only lose health if they’re not oiled regularly. All pets lose health if their happiness drops too low.

## Setup
You can copy your code from the previous project to use as a starter, or start from scratch.

  * [x] Create a Java project in Eclipse named virtual-pets-amok.
  * [x] Create a README.md file in your project folder to describe what you’ve done with your project. No fancy formatting is necessary. Just separate paragraphs with an empty line. (If you’d like to learn more about Markdown formatting, check out the Github Markdown Guide.)
  * [x] Create a GitHub repository also named virtual-pets-amok and set it up so that you can push your code there from your Eclipse project. Do this now. It’s the least fun part, so just get it out of the way.

## Required Tasks
### General
  * introduce ways to track:
	* [x] cage cleanliness for organic dogs
	* [x] shelter litter box cleanliness for organic cats
	* [x] oil/maintenance level for robot animals

### All classes
  * [x] Encapsulate all instance variables.
  * [x] Assign appropriate visibility modifiers to methods only used internally by a class or within a class hierarchy.

### VirtualPet class and related subclasses/interfaces
In addition to the last project’s requirements:

  * [x] create a model that allows for dogs and cats, either of which may be robotic
  * [x] introduce an attribute (instance variable) representing overall health that is updated as a result of other attributes moving in a negative or positive direction, influencing happiness
  * introduce methods that allow for:
	* [x] oiling robotic pets
	* [x] walking dogs, decreasing the likelihood that organic dogs will soil their cages, while increasing happiness in all dogs
  * do not allow:
	* [x] feeding/watering robotic pets
	* [x] oiling organic pets
  * [x] modify the `tick` method to return a value indicating the amount of waste a pet creates, which should contribute to either (optionally, create accessor methods to retrieve these values instead):
	  * [x] amount of waste in the litter box
	  * [x] amount of waste in an individual dog cage

### VirtualPetShelter class

In addition to the last project’s requirements:

  * introduce methods that allow for:
	* [x] oiling/maintaining all robotic pets
	* [x] cleaning dog cages
	* [x] emptying the litterbox
  * [x] modify existing methods to only feed/water pets that are not robotic

### VirtualPetShelterApp class
In addition to the last project’s requirements:

* add options to:
  * [x] walk all dogs
  * [x] clean dog cages
  * [x] clean the shelter litterbox
  * [x] oil all robotic pets

## Tips
  * Remember: don’t get caught up in the user interface at first. Focus on shelter/pet behavior. Try to get one thing working at a time.
  * Try creating tests to verify pet behavior, limiting your immediate goal to something small.

### Grading
Here is the [rubric](https://wecancodeit.github.io/java-exercises/virtual-pets-amok/rubric.html).

## Stretch Tasks
  * [ ] Allow for other types of pets. Are they caged? What maintenance do they require?
  * [ ] Allow an option for giving treats to pets. What sorts of treats do different pets like?
  * [x] introduce a `Cage` class for each dog, where cleanliness is tracked, keying these on the dog to which each is assigned (to use a `VirtualPet` as a key in a `HashMap`, you should implement `hashCode` and `equals`)
  * [ ] Herd your cats.

_(Note: the author is aware that it would not be a wise decision to allow all cats in a shelter to share a litterbox. They’re virtual pets, so virtually disease-free.)_