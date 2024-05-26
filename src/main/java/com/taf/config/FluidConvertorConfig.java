package com.taf.config;

import com.taf.main.Taf;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;

public class FluidConvertorConfig {
    public static HashMap<FluidType, Fluid> fluidMap = new HashMap<>();
    public static final Gson gson = new Gson();
    private static File file = new File(Taf.modConfigDir.getAbsolutePath() + File.separatorChar + "convertor.json");

    public static void initialize(){
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeDefaultRecipes();
        }
        readCustomConverterRecipes();
    }
    private static void writeDefaultRecipes(){
        ArrayList<FluidConverterRecipe> recipes = new ArrayList<>();
        recipes.add( new FluidConverterRecipe("WATER", "water"));

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(gson.toJson(recipes));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void readCustomConverterRecipes(){
        try{
            ArrayList<FluidConverterRecipe> recipes = gson.fromJson(new FileReader(file), new TypeToken<ArrayList<FluidConverterRecipe>>() {}.getType());
            for(FluidConverterRecipe recipe : recipes){
                fluidMap.put(Fluids.fromName(recipe.hbm_name), FluidRegistry.getFluid(recipe.forge_name));
            }
        } catch(Exception e){

        }
    }
    public static class FluidConverterRecipe{
        public FluidConverterRecipe(String hbm_name, String forge_name){
            this.hbm_name = hbm_name;
            this.forge_name = forge_name;
        }
        public String hbm_name;
        public String forge_name;
    }
}
