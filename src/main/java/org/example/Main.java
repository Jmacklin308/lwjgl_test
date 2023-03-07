package org.example;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Main {
    public static void main(String[] args) {
        GLFW.glfwInit();
        long window = GLFW.glfwCreateWindow(1280, 720, "Hello World!", 0, 0);
        GLFW.glfwMakeContextCurrent(window);

        GL.createCapabilities();
        GL11.glClearColor(0.45f, 0.45f, 0.45f, 1.0f);

        Triangle triangle = new Triangle();

        int totalSquares = 1000;

        //list of every object
        GameObject[] objects = {triangle};

        //add squares to list
        for(int i = 0; i < totalSquares; i++){
            Square tempSquare = new Square();
            //add new square to objects list
            GameObject[] tempObjects = new GameObject[objects.length + 1];
            for(int j = 0; j < objects.length; j++){
                tempObjects[j] = objects[j];
            }
            tempObjects[tempObjects.length - 1] = tempSquare;
            objects = tempObjects;
        }


        //load objects
        load(objects);


        while (!GLFW.glfwWindowShouldClose(window)) {

            //clear screen
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            update(objects);

            render(objects);

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }

        //clean up
        GLFW.glfwTerminate();

    }

    private static void load(GameObject[] objects) {
        //load
        for (GameObject object : objects) {
            object.load();
            object.loadGameObjects(objects);
        }
    }

    private static void render(GameObject[] objects) {
        //render
        for (GameObject object : objects) {
            object.render();
        }
    }

    private static void update(GameObject[] objects) {

        //update
        for (GameObject object : objects) {
            object.update();
        }
    }
}