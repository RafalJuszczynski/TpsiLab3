package labs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
        public static void main(String[] args) {
        
        Map<String,Teacher> lista = new TreeMap<>();
        lista.put("Programowanie obiektowe", new Teacher("Jan", "Kowalski"));
        lista.put("Programowanie kart", new Teacher("Janusz", "Podbylski"));
        lista.put("Programowanie muzyki", new Teacher("Klaudia", "Kowalska"));
        lista.put("Programowanie grafiki", new Teacher("Jan", "Modelski"));
        lista.put("Programowanie obiektowe2", new Teacher("Jarek", "Miły"));
        
        List<Student> grupa32D = new ArrayList<>();
        grupa32D.add(new Student("Jan", "Jarosz"));
        grupa32D.add(new Student("Zenon", "Juszczyk"));
        grupa32D.add(new Student("Kałach", "Anton"));
        
        List<Student> grupa32C = new ArrayList<>();
        grupa32C.add(new Student("Mariusz", "Kowal"));
        grupa32C.add(new Student("Michał", "Nowak"));
        grupa32C.add(new Student("Arnold", "Antyl"));
        
        List<Student> grupa32B = new ArrayList<>();
        grupa32B.add(new Student("Michał", "Podbylski"));
        grupa32B.add(new Student("Rafał", "Arnobyndzki"));
        grupa32B.add(new Student("Janusz", "Grażynowy"));
        
        Map<String,List<Student>> lista_grup = new TreeMap<>();
        lista_grup.put("32D", grupa32D);
        lista_grup.put("32C", grupa32C);
        lista_grup.put("32B", grupa32B);
            
        Person s1 = new Student("Jan", "Kowalski");
        Person s2 = new Student("Hermenegilda", "Nowak");
        Student s3 = new Student("Hermenegilda2", "Nowak2");
        
        //-----------------------------ZADANIE 1-------------------------------------------
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedzialek");
        zbiorDni.add("wtorek");
        zbiorDni.add("sroda");
        zbiorDni.add("czwartek");
        zbiorDni.add("piatek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");
        for(String dzien : zbiorDni){
            System.out.println(dzien);
        }
        
        
        //odp1 treeset jest posortowany, hashset nie zapewnia
        //odp2 treeset
        //odp3 nie
        //-----------------------------ZADANIE 2-------------------------------------------
        System.out.println("Programowanie obiektowe, Nauczyciel - " + lista.get("Programowanie obiektowe" ));
        System.out.println("Programowanie kart, Nauczyciel - " + lista.get("Programowanie kart" ));
           
    
        String nrGrupy="32D";
        try{
            List<Student> studenci = lista_grup.get(nrGrupy);
            for(Student student : studenci){
                    System.out.println(nrGrupy + " - " + student);
            }
        }
        catch(Exception ex){
            System.out.println("Grupa nie istnieje");
        }
        
        
        //-----------------------------ZADANIE 3-------------------------------------------
        
        List<Product> lista_produktow = new ArrayList<>();
        Set<String> lista_kategorii = new TreeSet<>();
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {
                
                String s = in.readLine();
                while(s!=null) {
                    String[] pola = s.split(";");
                    lista_kategorii.add(pola[2]);
                    lista_produktow.add(new Product(Integer.parseInt(pola[0]),pola[1],Double.parseDouble(pola[3]),pola[2]));
                    
                    s = in.readLine();
                }
        }
        catch (IOException ex) {
           ex.printStackTrace();
        }    
        System.out.println("Id  name   price   category");
        for(Product produkt : lista_produktow){
          System.out.println(produkt);
        }
        
        Map<Integer,Product> mapa_produkty = new TreeMap<>();
        for(Product produkt : lista_produktow){
          mapa_produkty.put(produkt.getId(),produkt);
        }
        System.out.println(mapa_produkty.get(105));
        
        Map<String,List<Product>> x_mapa_kategorii = new TreeMap<>();
        Integer counter=0;
        
        for(String produkt : lista_kategorii){
            x_mapa_kategorii.put(produkt, new ArrayList<Product>());
        }

                
        for(Product produkt : lista_produktow){
           String kategoria = produkt.getCategory();
           x_mapa_kategorii.get(kategoria).add(produkt);

        }
          
           

        
        System.out.println(x_mapa_kategorii);
        
 
                
                
    }
}
           
       
        
        
   

