package com.isitech;

public class Carre extends Rectangle {
    private int side;

    public Carre(int side) {
        super(side, side);
        this.side = side;
    }

    public void afficher() {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public void surface() {
        System.out.print("Surface du Carré : " + side * side + "m²");
    }
}
