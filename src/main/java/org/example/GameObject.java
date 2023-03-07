package org.example;

public abstract class GameObject {
// Position
    private float x = 0.0f;
    private float y = 0.0f;

    // Velocity
    private float vx = 0.0f;
    private float vy = 0.0f;

    private GameObject[] _gameObjects = null;

    public abstract void load();

    public abstract void loadGameObjects(GameObject[] gameObjects);

    // Update the triangle's position based on input
    public abstract void update();

    // Render the game object
    public void render() {}

    // Getters and setters for position and velocity
    public float getx() {
        return x;
    }

    public void setx(float x) {
        this.x = x;
    }

    public float gety() {
        return y;
    }

    public void sety(float y) {
        this.y = y;
    }

    public float getvx() {
        return vx;
    }

    public void setvx(float vx) {
        this.vx = vx;
    }

    public float getvy() {
        return vy;
    }

    public void setvy(float vy) {
        this.vy = vy;
    }
}