package com.warpradar.config;

import com.warpradar.main.WarpRadar;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Field;

import com.google.gson.Gson;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;

public class FluidConvertorConfig {
    public static HashMap<FluidType, Fluid> fluidMap = new HashMap<>();
    public static final Gson gson = new Gson();
    private static File file = new File(WarpRadar.modConfigDir.getAbsolutePath() + File.separatorChar + "convertor.json");

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
            Field field = Fluids.class.getField("nameMapping");
            field.setAccessible(true);
            HashMap<String, FluidType> nameMapping = (HashMap<String, FluidType>) field.get(null);
            FluidConverterRecipe[] recipes = gson.fromJson(new FileReader(file), FluidConverterRecipe[].class);
            for(FluidConverterRecipe recipe : recipes){
                fluidMap.put(nameMapping.get(recipe.hbm_name), FluidRegistry.getFluid(recipe.forge_name));
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
