package org.solent.com504.factoryandfacade.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.Dog;
import java.util.List;
import java.util.ArrayList;

import org.solent.com504.factoryandfacade.model.AnimalObjectFactory;
import org.solent.com504.factoryandfacade.model.FarmFacade;

/**
 *
 * @author cgallen
 */
public class FarmFacadeTest {

    @Test
    public void FarmFacadeTest() {

        FarmFacade farmFacade = AnimalObjectFactory.createFarmFacade();
        assertNotNull(farmFacade);
        
        String dog1="dawg";
        farmFacade.addDog(dog1);
        
        String cat1="grab her by the..";
        farmFacade.addCat(cat1);
        
        String cow1="Theresa May";
        farmFacade.addCow(cow1);
        
        
        int found_counter=0;
        List<Animal> animals=farmFacade.getAllAnimals();

        for(int i=0;i<animals.size();i++){
            Animal temp=animals.get(i);
            if(temp.getName().equals("dawg")){
                found_counter++;
            }
            if(temp.getName().equals("grab her by the..")){
                found_counter++;
            }
            if(temp.getName().equals("Theresa May")){
                found_counter++;
            }
            
        }
        System.out.println("Boomshakalaka");
           assertEquals(found_counter,3);
    }
}
