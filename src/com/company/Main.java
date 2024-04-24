package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

        public class Main {

            public static void main(String[] args) {
                Path resourceDirectory= Paths.get("src");
                String absolutePath=resourceDirectory.toFile().getAbsolutePath();
                File f1=new File(absolutePath+"/testData_Apartments.txt");
                Scanner sc=null;
                List<Apartment> appartment=new ArrayList<>();
                Map<String,Integer> numApartments=new HashMap<>();
                Set<String> rabotesthi=new HashSet<>();

                try{
                    sc=new Scanner(f1);
                    while(sc.hasNext()){
                        String city=sc.next();
                        int  rooms=sc.nextInt();
                        int kvad=sc.nextInt();
                        int price=sc.nextInt();
                        String telefon=sc.next();

                        Apartment neww=new Apartment(city,rooms,kvad,price,telefon);
                        if(rooms==3 && kvad>=100 && (city.equals("Бургас") || city.equals("София") || city.equals("Варна"))){
                            appartment.add(neww);
                        }
                        if(!numApartments.containsKey(city)){
                            numApartments.put(city,1);
                        } else{
                            numApartments.put(city,numApartments.get(city)+1);
                        }

                    }
                    if(appartment.size()==0){
                        throw new UnsuitableApartmentException();
                    }


                }catch(FileNotFoundException e){
                    System.out.println(e.getMessage());
                }catch(UnsuitableApartmentException e){
                    System.out.println("Wir haben keine Wohnungen! Entschuldigung!");
                }finally{

                }
                Collections.sort(appartment);
                for(int i=0;i<5;i++) {
                    if (!rabotesthi.contains(appartment.get(i).getNumber())) {
                        rabotesthi.add(appartment.get(i).getNumber());
                    }
                }
                PrintWriter output=null;
                try{
                    Map<String, Integer> cityApCounter = new HashMap<>();

                    List<Map.Entry<String, Integer>> list = new ArrayList<>(numApartments.entrySet());

                    list.sort(Map.Entry.comparingByValue());

                    String city1=list.get(3).getKey();
                    for (Map.Entry<String, Integer> entry : list) {
                        cityApCounter.put(entry.getKey(), entry.getValue());
                    }
                    numApartments=cityApCounter;
                    File file2=new File(absolutePath+"/output.txt");
                    output=new PrintWriter(file2);

                    output.println(city1);
                    for(String s:rabotesthi){
                        output.println( s);}
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }finally{
                    output.close();
                }

            }
        }

    }
}
