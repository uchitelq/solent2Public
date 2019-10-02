package org.solent.com504.factoryandfacade.model;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 4shkes64
 */
public class FarmFacadeImplementation implements FarmFacade {

    private List<Animal> animals = new ArrayList<Animal>();
    private AnimalObjectFactory factory=new AnimalObjectFactory();
    
    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList<Animal>(animals);
    }

    @Override
    public void addDog(String name) {
        Dog dog=new Dog();
        dog.setName(name);
        animals.add(dog);
    }

    @Override
    public void addCat(String name) {
        
        Animal cat=factory.createCat();
        cat.setName(name);
        animals.add(cat);
    }

    @Override
    public void addCow(String name) {
        Animal cow=factory.createCow();
        cow.setName(name);
        animals.add(cow);    }
    
}
