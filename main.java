import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        FunctionalProg prog = new FunctionalProg();
        //prog.ex1();
        //prog.ex2();
        //prog.ex3();
        //prog.ex4();
        //prog.ex5();
        //prog.ex6();
        //prog.ex7();
       // prog.ex8();
        //prog.ex9();
        //prog.ex10();
        prog.examen1();

       Amain a = new Amain();
       C elem = new C();
       a.method3(elem);
    }
}


interface D {}
class A implements D{}   class B extends A implements D {}

class C extends A implements D {}



class Amain{



    D  method1(ArrayList<? extends A> list) {
        if (list.isEmpty() )
            return null;
        else
            return list.get(1);
    }



    void method2(ArrayList<? extends A >  list, C elem) {
        list.add(null);
    }


    void method3(C elem){

        ArrayList<A> listA=new ArrayList<A>(); listA.add(new A());listA.add(new A());

        ArrayList<B> listB = new ArrayList<B>(); listB.add(new B());listB.add(new B());

        ArrayList<C> listC = new ArrayList<C>(); listC.add(new C()); listC.add(new C());

        this.method1(listA); this.method1(listB); this.method1(listC);

        this.method2(listA,elem); this.method2(listB,elem); this.method2(listC,elem);
        //daca pui la b) super C nu merge cu B
        //daca pui la b) super B nu merge cu C
        //super A nu merg celelalte 2
        //extend A pare sa functioneze

    }}

interface In1{int getS1(int);}
class A implements In1{
    int f1;
    static int s1=0;

    public A(int a){this.f1 = a*s1; s1= s1+1;}
    static  int getS(){return getS1(f1);} //non-static method cannot be refferenced from static
    int getS1(){return s1;}
}

//A does not implement getS1(int) - compile error
