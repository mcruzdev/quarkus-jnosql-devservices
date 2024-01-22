package dev.matheuscruz;

import java.util.Objects;
import java.util.UUID;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

@Entity
public class Developer {

    @Id
    String id;

    @Column
    String name;

    @Column
    String github;

    public Developer() {
    }

    public Developer(String name, String github) {
        this.id = UUID.randomUUID().toString();
        this.name = Objects.requireNonNullElse(name, "anonymous");
        this.github = Objects.requireNonNullElse(github, "https://github.com/anonymous");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGithub() {
        return github;
    }
}
