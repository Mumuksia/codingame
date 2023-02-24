package codingame.spring2022;

import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int baseX = in.nextInt(); // The corner of the map representing your base
        int baseY = in.nextInt();
        int heroesPerPlayer = in.nextInt(); // Always 3
        int initialX1 = Math.abs(baseX - 3810);
        int initialY1 = Math.abs(baseY - 3500);
        int initialX2 = Math.abs(baseX - 3810);
        int initialY2 = Math.abs(baseY - 3500);
        int initialX3 = Math.abs(baseX - 3810);
        int initialY3 = Math.abs(baseY - 3500);
        //heroes are in order 0 1 2 3 4 5


        // game loop
        while (true) {
            List<Hero> heroes = new ArrayList<>();
            List<Monster> monsters = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                int health = in.nextInt(); // Your base health
                int mana = in.nextInt(); // Ignore in the first league; Spend ten mana to cast a spell
            }
            int entityCount = in.nextInt(); // Amount of heros and monsters you can see
            for (int i = 0; i < entityCount; i++) {
                int id = in.nextInt(); // Unique identifier
                int type = in.nextInt(); // 0=monster, 1=your hero, 2=opponent hero
                int x = in.nextInt(); // Position of this entity
                int y = in.nextInt();
                int shieldLife = in.nextInt(); // Ignore for this league; Count down until shield spell fades
                int isControlled = in.nextInt(); // Ignore for this league; Equals 1 when this entity is under a control spell
                int health = in.nextInt(); // Remaining health of this monster
                int vx = in.nextInt(); // Trajectory of this monster
                int vy = in.nextInt();
                int nearBase = in.nextInt(); // 0=monster with no target yet, 1=monster targeting a base
                int threatFor = in.nextInt(); // Given this monster's trajectory, is it a threat to 1=your base, 2=your opponent's base, 0=neither
                switch (type){
                    case 1: heroes.add(new Hero(x, y, id));
                    break;
                    case 0: monsters.add(new Monster(x, y, id, nearBase, health, threatFor, vx, vy));
                    break;
                    default:
                        break;
                }
            }
            monsters = monsters.stream().filter(m->m.threatFor==1).
                    sorted(Comparator.comparingInt(a -> a.getSquaredDistanceToBase(baseX, baseY))).
                    collect(Collectors.toList());
            if (monsters.size() > 3){
                monsters = monsters.subList(0, 3);
            }

            heroes = heroes.stream().sorted(Comparator.comparingInt(a -> a.id)).collect(Collectors.toList());
            heroes.forEach(h -> h.setToDefault(baseX, baseY));
            List<Integer> usedHeroes = new ArrayList<>();
            for (Monster m: monsters) {

                Map<Monster, Hero> allocatedHeroes = new HashMap<>();
                int minDistance = 10000000;
                for (Hero h: heroes){
                    if (!usedHeroes.contains(h.id) && minDistance > h.getSquaredDistanceToMonster(m)){
                        allocatedHeroes.put(m, h);
                        minDistance = h.getSquaredDistanceToMonster(m);
                    }
                }
                Hero tempHero = allocatedHeroes.get(m);
                if (minDistance < 9000000){
                    usedHeroes.add(tempHero.id);
                    allocatedHeroes.get(m).calculatePathToInterceptMonster(m);
                }
            }

            heroes.forEach(Hero::print);
        }
    }


}

class Hero{
    int x;
    int y;
    int id;
    int vx;
    int vy;

    public Hero(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getSquaredDistanceToMonster(Monster m){
        return Math.abs(x-m.x)*Math.abs(x-m.x) + Math.abs(y-m.y)*Math.abs(y-m.y);
    }

    public void calculatePathToInterceptMonster(Monster m){
        //complicated :)
            vx=m.x;
            vy=m.y;
    }

    public void print(){
        if (x == vx && y == vy){
            System.out.println("WAIT");
        } else {
            System.out.println("MOVE " + vx + " " + vy);
        }
    }

    public void setToDefault(int baseX, int baseY){
        if (id == 0 || id == 3){
            vx = Math.abs(baseX - 6830);
            vy = Math.abs(baseY - 1650);
        }
        if (id == 1 || id == 4){
            vx = Math.abs(baseX - 5300);
            vy = Math.abs(baseY - 4200);
        }
        if (id == 2 || id == 5){
            vx = Math.abs(baseX - 1830);
            vy = Math.abs(baseY - 6600);
        }
    }
}

class Monster{
    int x;
    int y;
    int id;
    int nearBase;
    int health;
    int threatFor;
    int vx;
    int vy;

    public Monster(int x, int y, int id, int nearBase, int health, int threatFor, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.nearBase = nearBase;
        this.health = health;
        this.threatFor = threatFor;
        this.vx = vx;
        this.vy = vy;
    }

    public int getSquaredDistanceToBase(int baseX, int baseY){
        return Math.abs(x-baseX)*Math.abs(x-baseX) + Math.abs(y-baseY)*Math.abs(y-baseY);
    }
}
