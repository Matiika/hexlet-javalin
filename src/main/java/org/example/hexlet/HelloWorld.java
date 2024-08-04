package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /

        app.get("/users", ctx -> {
                var name = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
                ctx.result("Hello, " + name + "!");
        });
        app.post("/users1", ctx -> ctx.result("POST /users1"));
        app.start(7070);
    }
}