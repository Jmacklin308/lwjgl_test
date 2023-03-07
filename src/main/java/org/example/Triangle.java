package org.example;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Triangle extends GameObject{

    private float _scale = 0.09f;

    private GameObject[] _gameObjects = null;


    @Override
    public void load() {
        setx(0.0f);
        sety(0.0f);
    }

    @Override
    public void loadGameObjects(GameObject[] gameObjects) {
        _gameObjects = gameObjects;
    }

    // Update the triangle's position based on input
    @Override
    public void update() {
        Input();
    }

    private void Input(){
        // Handle input
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW.GLFW_KEY_LEFT) == GLFW.GLFW_PRESS) {
            setx(getx() - 0.001f);
        }
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW.GLFW_KEY_RIGHT) == GLFW.GLFW_PRESS) {
            setx(getx() + 0.001f);
        }

        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW.GLFW_KEY_UP) == GLFW.GLFW_PRESS) {
            sety(gety() + 0.001f);
        }

        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW.GLFW_KEY_DOWN) == GLFW.GLFW_PRESS) {
            sety(gety() - 0.001f);
        }

        //decrease scale if spacebar is pressed
        if (GLFW.glfwGetKey(GLFW.glfwGetCurrentContext(), GLFW.GLFW_KEY_SPACE) == GLFW.GLFW_PRESS) {
            _scale += 0.001f;
        }


    }

    // Render the triangle
    public void render() {
        GL11.glPushMatrix();
        GL11.glTranslatef(getx(), gety(), 0.0f);
        GL11.glBegin(GL11.GL_TRIANGLES);
        GL11.glColor3f(0.0f, 0.0f, 0.0f);
        GL11.glVertex2f(-_scale, -_scale);
        GL11.glVertex2f(_scale, -_scale);
        GL11.glVertex2f(0.0f, _scale);
        GL11.glEnd();
        GL11.glPopMatrix();
    }

}
