package org.example;

public class Map {
    private Room currentRoom;

    public Map() {
    }

    public void buildMap() {


        Room room1 = new Room(" Aria's Room", "Aria's room is gloomy and eerie. The cement walls are covered in dark stains, and there is only faint lighting from a single hanging light bulb. ");
        Room room2 = new Room(" Hanna's Room", "Hanna's room is like a scene from a nightmarish theater production. The walls are painted in dark hues, and there are designer handbags hanging on hooks all around.");
        Room room3 = new Room(" Emily's Room", "Emily's room is filled with dark shadows and the sound of faint whispers from her dead father. Strange paintings hang on the walls, seeming to change when not looked at directly ");
        Room room4 = new Room(" Spencer's Room", "Spencer's room is filled with eerie antiques and dark furniture. The walls are angular and harsh, and there are old, creaking mirrors hanging, reflecting a skewed and distorted version of the room");
        Room room5 = new Room(" Radley Sanitarium", "Radley Sanitarium was a mental institution, located in Darkette County, Pennsylvania, that treated both children and adults with mental illness");
        Room room6 = new Room(" Morgue", "The morgue is a cold, clinical environment, designed for the solemn purpose of handling the deceased. The walls are painted in pale, neutral colors.");
        Room room7 = new Room(" The Hole", "The Hole is a pit dug into the ground, it is a horrifying and sinister space, designed to confine and isolate individuals against their will.");
        Room room8 = new Room(" The Torture Room", "The  torture room exudes an aura of unspeakable suffering, bearing witness to the horrors that have unfolded within its confines. ");
        Room room9 = new Room(" Charles' vault", "Charles's vault is a room in which are kept A's most precious and treasured things.");

        currentRoom = room1;

        room1.setEast(room2);
        room1.setNorth(null);
        room1.setSouth(room4);
        room1.setWest(null);
        room1.addItemToRoom(new Item("plastic books", "A couple of"));
        room1.addItemToRoom(new Item("paint brushes", "Dirty"));

        Food crackers = new Food("crackers,", "dry", 3);
        room1.addItemToRoom(crackers);


        Liquid poison = new Liquid("poison", "poisonous", -30);
        room1.addItemToRoom(poison);


        room2.setEast(room3);
        room2.setNorth(null);
        room2.setSouth(null);
        room2.setWest(room1);
        room2.addItemToRoom(new Item("designer bags", "Expensive"));
        room2.addItemToRoom(new Item("chanel sunglasses", "Trendy"));

        RangedWeapon weapon2 = new RangedWeapon("Gun", 10, 3, 3);
        room2.addItemToRoom(weapon2);


        Food tuna = new Food("canned tuna ,", "moldy", -50);
        room2.addItemToRoom(tuna);
        Enemy Monster= new Enemy ("Monster(A)",50, new Weapon("Dagger",4));
        room2.addEnemy(Monster );

        room3.setEast(null);
        room3.setNorth(null);
        room3.setSouth(room6);
        room3.setWest(room2);
        room3.addItemToRoom(new Item("magazines", "Vogue"));
        room3.addItemToRoom(new Item("medals", "Shiny"));

        Food proteinBar = new Food("protein bar ,", "Expired", 70);
        room3.addItemToRoom(proteinBar);

        RangedWeapon weapon3 = new RangedWeapon("gun", 100, 4, 2);
        room3.addItemToRoom(weapon3);


        room4.setEast(null);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room4.setWest(null);
        room4.addItemToRoom(new Item("awards", "Polished"));
        room4.addItemToRoom(new Item("chair", "Creaky old"));
        room4.addItemToRoom(new Food("instant noodles ,", "Pig feet flavoured ", 50));


        room5.setEast(null);
        room5.setNorth(null);
        room5.setSouth(room8);
        room5.setWest(null);
        room5.addItemToRoom(new Item("keys", " A key to the room"));
        room5.addItemToRoom(new Item("Books", "Effective self help"));

        room5.addItemToRoom(new Food("liquid sedative ,", "Deadly", 50));

        room6.setEast(null);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.setWest(null);
        room6.addItemToRoom(new Item("stainless steel tables", "Cold"));
        room6.addItemToRoom(new Item("white blankets", "Heavy"));

        room7.setEast(room8);
        room7.setNorth(room4);
        room7.setSouth(null);
        room7.setWest(null);


        room8.setEast(room9);
        room8.setNorth(room5);
        room8.setSouth(null);
        room8.setWest(room7);
        room8.addItemToRoom(new Item(" buttons", "Electric shock"));
        room8.addItemToRoom(new Item("chair", "Electric "));
        Enemy Troll = new Enemy ("Troll(A)",10, new Weapon("Arrow",20));
        room8.addEnemy(Troll );

        room9.setEast(null);
        room9.setNorth(room6);
        room9.setSouth(null);
        room9.setWest(room8);
        room9.addItemToRoom(new Item("movies", "Home"));
        room9.addItemToRoom(new Item("toys and teddy bears", "Children's"));

    }

    public void getMap() {
        buildMap();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }


}




