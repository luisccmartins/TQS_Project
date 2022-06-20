package com.example.expressdelivery.Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RiderTest {
    private Rider rider;

    @Test
    public void getName() {
        rider = new Rider("Rider", 987654321, 20, "rider@rider.pt", "rider");
        assertEquals("Rider",rider.getName());
    }

    @Test
    public void getAge() {
        rider = new Rider("Rider", 987654321, 20, "rider@rider.pt", "rider");
        assertEquals(20,rider.getAge());
    }

    @Test
    public void getPhone_number() {
        rider = new Rider("Rider", 987654321, 20, "rider@rider.pt", "rider");
        assertEquals(987654321,rider.getPhone_number());
    }

    @Test
    public void getEmail() {
        rider = new Rider("Rider", 987654321, 20, "rider@rider.pt", "rider");
        assertEquals("rider@rider.pt",rider.getEmail());
    }

    @Test
    public void getPassword() {
        rider = new Rider("Rider", 987654321, 20, "rider@rider.pt", "rider");
        assertEquals("rider",rider.getPassword());
    }
}