package com.warpradar.misc.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Faction
 */
@DatabaseTable(tableName = "factions")
public class Faction {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(unique = true)
    private String name;

}
