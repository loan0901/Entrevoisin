package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.AddNeighbourActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.DetailActivity;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourPagerAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFragment;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addNeighbourToFavorite() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.addFavorite(neighbourToAdd);
        Boolean favorite = neighbourToAdd.getFavotite();
        assertTrue(favorite.equals(true));
    }

    @Test
    public void removeNeighbourToFavorite() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.removeFavorite(neighbourToAdd);
        Boolean favorite = neighbourToAdd.getFavotite();
        assertTrue(favorite.equals(false));
    }

    @Test
    public void getNeighbourName() {
        Neighbour neighbour = service.getNeighbours().get(0);
        assertTrue(neighbour.getName().equals("Caroline"));
    }

    @Test
    public void getNeighbourFavorite() {
        List<Neighbour> neighbour = service.getNeighbours();
        List<Neighbour> expectedNeighbours = service.getFavoriteNeighbour();
        assertFalse(expectedNeighbours.equals(neighbour));
    }
}