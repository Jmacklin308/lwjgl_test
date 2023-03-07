package org.example;

import org.lwjgl.opengl.GL11;

import java.util.Random;

public class Square extends GameObject{

    private GameObject[] _gameObjects = null;

    //Square specific members
    private float _scale = 0.04f;
    private Triangle _triangle = null;
    private float _speed = 0.1f;

    private Random _random = new Random();

    @Override
    public void load() {
        //randomize position
        setx(_random.nextFloat() * 5 - 1);
        sety(_random.nextFloat() * 5 - 1);

    }

    @Override
    public void loadGameObjects(GameObject[] gameObjects) {
        _gameObjects = gameObjects;

    }

    @Override
    public void update() {

        //slowly move towards triangle if triangle is not null
        if(_triangle != null){

            //move towards triangle
            moveTowards(_triangle);

        }
        else{
            //find triangle
            for(GameObject gameObject : _gameObjects){
                if(gameObject instanceof Triangle){
                    _triangle = (Triangle)gameObject;
                }
            }
        }
    }

    public void moveTowards(GameObject target)
    {
        //get the distance between the two objects
        float distanceX = target.getx() - getx();
        float distanceY = target.gety() - gety();

        //get the angle between the two objects
        float angle = (float)Math.atan2(distanceY, distanceX);

        //get the x and y components of the angle
        float xComponent = (float)Math.cos(angle);
        float yComponent = (float)Math.sin(angle);

        //move the object towards the target
        setx(getx() + xComponent * (_speed / 1000));
        sety(gety() + yComponent * (_speed / 1000));
    }

    // Render the square
    public void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(getx(), gety(), 0.0f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        GL11.glVertex2f(-_scale, -_scale);
        GL11.glVertex2f(_scale, -_scale);
        GL11.glVertex2f(_scale, _scale);
        GL11.glVertex2f(-_scale, _scale);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
}
