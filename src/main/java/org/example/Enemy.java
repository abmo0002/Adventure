package org.example;

public class Enemy {
    private String enemyName;
    private int enemyHealthPoints;
    private Weapon enemyWeapon;
    private Room room;



    public Enemy(String enemyName, int enemyHealth, Weapon enemyWeapon ) {
        this.enemyName = enemyName;
        this.enemyHealthPoints = enemyHealth;
        this.enemyWeapon = enemyWeapon;

    }

    public String getEnemyName() {
        return enemyName;
    }


    public int getEnemyHealthPoints() {
        return enemyHealthPoints;
    }

public void setEnemyHealthPoints(int enemyHealthPoints) {
    this.enemyHealthPoints = enemyHealthPoints;
}

public Weapon getEnemyWeapon() {
        return enemyWeapon;
}



public void setEnemyWeapon () {
        this.enemyWeapon = enemyWeapon;

    }
    public  void hit(int damage) {
        enemyHealthPoints -= damage;
        if (enemyHealthPoints <= 0) {

        }
    }

    private void die() {
    }
    public void attack(Player player) {

    }

    public ReturnMessage hasEnemyDied(){
        if (enemyHealthPoints> 0) {
            return ReturnMessage.ENEMY_ALIVE;

        } else {
            return ReturnMessage.ENEMY_DIED;
        }
    }
    public boolean enemyDied() {
        if (enemyHealthPoints < 1) {
            room.addItemToRoom(enemyWeapon);
            room.removeEnemyFromRoom(this);
            return true;
        }else {
            return false;
        }
    }


    @Override
    public String toString() {
        return enemyName + " " + "Enemy weapon: "  + enemyWeapon + " " + " Health points: " + enemyHealthPoints ;
    }
}
