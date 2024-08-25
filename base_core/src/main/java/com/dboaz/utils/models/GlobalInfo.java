package com.dboaz.utils.models;

/**
 * Model class for feature Global Info
 *
 * @author GustavoBoaz
 * @version 1.0.0
 **/
public class GlobalInfo {
    // Atributes
    private String name;
    private String version;
    private String description;

    // Construct Pattern - Builder
    public static GlobalInfo builder() { return new GlobalInfo(); }
    public GlobalInfo name(String name) { this.name = name; return this; }
    public GlobalInfo version(String version) { this.version = version; return this; }
    public GlobalInfo description(String description) { this.description = description; return this; }
    public GlobalInfo build() { return this; }

    // toString
    @Override
    public String toString() {
        return
            "\n\n\n GlobalInfo " +
            "\n name: "+ name +
            "\n version: "+ version +
            "\n description: "+ description +
            "\n\n";
    }

    // Getters
    public String getName() { return this.name; }
    public String getVersion() { return this.version; }
    public String getDescription() { return this.description; }
}
