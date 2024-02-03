package com.warpradar.misc.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Faction
 */
@DatabaseTable(tableName = "factions")
public class Faction {
  @DatabaseField(id = true, generatedId = true)
  private long id;
}
