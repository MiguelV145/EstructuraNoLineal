package main.Materia.Controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetsClase {

    //Constructor
    public SetsClase(){
        construirHashSet();
        construirLinkedHashSet();
        construirTreeSet();
        construirTreeConComparadaor();
    }

    //metodos
    //construir y mostar un hash sets
    public  void construirHashSet(){
        HashSet <String> conjunto= new HashSet<>();
        conjunto.add("Manzana");
        System.out.println(conjunto);
        conjunto.add("Banana");
        System.out.println(conjunto);

        conjunto.add("Hola");
        System.out.println(conjunto);

        conjunto.add("Hola");//Duplicado
        System.out.println(conjunto);

        conjunto.add("Moto");
        System.out.println(conjunto);

        conjunto.add("Carro");
        System.out.println(conjunto);

        conjunto.add("Juan");;
        System.out.println(conjunto);

        conjunto.add("Polo");
        System.out.println(conjunto);

        System.out.println("HashSet: "+ conjunto);

        conjunto.remove("Moto");
        System.out.println("hash despuesd de eliminar un elemento " + conjunto);

        //Verificar si un elemento existente
        boolean conjuntoHola= conjunto.contains("Hola");
        System.out.println("¿ hashSet contiene 'Hola'? "+ conjuntoHola);

        //obtener el tamaño del conjunto
        int tamano= conjunto.size();
        System.out.println(" El tamaño del hashSet: "+ tamano);

    }
//construir y mostar un hash LinkedHashset
    public void construirLinkedHashSet(){

        LinkedHashSet <String> conjunto= new LinkedHashSet<>();
        //Agregar elemneto
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Hola");
        conjunto.add("Hola");//Duplicado
        conjunto.add("Moto");
        conjunto.add("Carro");
        conjunto.add("Juan");;
        conjunto.add("Polo");
        System.out.println("LinkedHashSets: "+ conjunto);

    }
//construir y mostar un TreeSets
    public void construirTreeSet(){
        TreeSet <String> conjunto= new TreeSet<>();
        //Agregar elemneto
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Hola");
        conjunto.add("Hola");//Duplicado
        conjunto.add("Moto");
        conjunto.add("Carro");
        conjunto.add("Juan");;
        conjunto.add("Polo");
        System.out.println("TreeSet "+ conjunto);

    }

    public void construirTreeConComparadaor(){
        //Comparador personalizado que ordena las cadenas 
        Comparator <String> comparatorOrdenInverso=
        new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
            }
        };

        TreeSet <String> conjunto= new TreeSet<>(comparatorOrdenInverso);
        //Agregar elemneto
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Hola");
        conjunto.add("Hola");//Duplicado
        conjunto.add("Moto");
        conjunto.add("Carro");
        conjunto.add("Juan");;
        conjunto.add("Polo");
        System.out.println("TreeSet "+ conjunto);


    }
}
