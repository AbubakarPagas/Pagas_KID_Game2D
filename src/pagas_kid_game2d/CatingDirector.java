/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagas_kid_game2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author pagas
 */
public class CatingDirector {
    private final List<Actor> CURRENT_CAST;
    //creating an ArrayList object collide checkList
    private final List<Actor> COLLIDE_CHECKLIST;
    // creating for the remove
    private final Set<Actor> REMOVED_ACTORS;

    public CatingDirector() {
        this.REMOVED_ACTORS = new HashSet<>();
        this.COLLIDE_CHECKLIST = new ArrayList<>();
        this.CURRENT_CAST = new ArrayList<>();
    }
    //for current cast data store
    public List<Actor> getCurrentCast(){
        return CURRENT_CAST;
    }
   
    public void addCurrentCast (Actor... actors){
       if (actors.length > 1) {
            CURRENT_CAST.addAll(Arrays.asList(actors));
        } else {
            CURRENT_CAST.add(actors[0]);
        }   
    }
    
    public void removeCurrentCast(Actor... actors){
        CURRENT_CAST.removeAll(Arrays.asList(actors));
    }
    
    public void resetCurrentCast(){
        CURRENT_CAST.clear();
    }
    
    // for the get collide checkList
    public List getCollideCheckList(){
        return COLLIDE_CHECKLIST;
    }
    public void resetCollideCheckList(){
        COLLIDE_CHECKLIST.clear();
        COLLIDE_CHECKLIST.addAll(CURRENT_CAST);
    }
    
    public Set getRemovedActor(){
        return REMOVED_ACTORS;
    }
    public void addRemovedActors(Actor... actors){
      if (actors.length > 1)  {
          REMOVED_ACTORS.addAll(Arrays.asList((Actor[]) actors));
      } else {
          REMOVED_ACTORS.add(actors[0]);
      }
    }
    public void resetRemoveActors(){
        CURRENT_CAST.removeAll(REMOVED_ACTORS);
        REMOVED_ACTORS.clear();
    }
}

