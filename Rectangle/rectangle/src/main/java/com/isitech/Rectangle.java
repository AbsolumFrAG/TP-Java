package com.isitech;

public class Rectangle {
    private int w;
    private int h;

    public Rectangle(int width, int height) {
        this.w = width;
        this.h = height;
    }

    public int getWidth() {
        return this.w;
    }

    public int getHeight() {
        return this.h;
    }

    public void afficher(String character) {
        for (int i = 1; i <= getHeight(); i++) {
            for (int j = 1; j <= getWidth(); j++) {
                System.out.print(character);
            }
            System.out.println();
        }
    }
}
