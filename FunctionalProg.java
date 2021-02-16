import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FunctionalProg {

    private List<String> myList;
    private List<Integer> integers;

    public FunctionalProg() {
        myList = new ArrayList<>();
        myList = Arrays.asList("hello", "hi", "nice to meet you", "Iulia", "Alex", "lovely 20 years");
        integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
    }

    public void ex1()
    {
        //P1. Loop down the words and print each on a separate line,
        // with two spaces in front of each word. Don’t use map.

        myList.stream().forEach(s->{System.out.println("**" + s);});
    }

    public void ex2()
    {
        //P2. Repeat the previous problem, but without the two spaces in front
        // . This is trivial if you use the same approach as in P1, so the point is to use a method reference here,
        // as opposed to an explicit lambda as in P1.
        Consumer<String> consumer = s->{System.out.println(s);};
      //  myList.stream().forEach(consumer);
        //SAU
        myList.stream().forEach(System.out::println);

    }



    public void ex3()
    {
        //P3. We assume that we have a method StringUtils.transformedList(List<String>, Function1<String>) where interface Function1<T> { T app(T);}
        // and we produced transformed lists like this:
        // • List<String> excitingWords = StringUtils.transformedList(words, s -> s + "!");
        // • List<String> eyeWords = StringUtils.transformedList(words, s -> s.replace("i", "eye"));
        // • List<String> upperCaseWords = StringUtils.transformedList(words, String::toUpperCase);
        // Produce the same lists as above,
        // but this time use streams and the builtin “map” method.

        List<String> newList = myList.stream().map(s->{return s +"!";}).collect(Collectors.toList());
        newList.forEach(System.out::println);

        List<String> newList2 = myList.stream().map(s->s.replace("i","eye")).collect(Collectors.toList());
        newList2.forEach(System.out::println);

        List<String> newList3 = myList.stream().map(String::toUpperCase).collect(Collectors.toList());
        newList3.forEach(System.out::println);




    }

    public void ex4() {
        //P4. We assume that we have the method StringUtils.allMatches(List<String>, Predicate1<String>)
        // where  interface Predicate1<T> { boolean check(T);}
        // and we produced filtered lists like this:
        // • List<String> shortWords = StringUtils.allMatches(words, s -> s.length() < 4);
        // • List<String> wordsWithB = StringUtils.allMatches(words, s -> s.contains("b"));
        // • List<String> evenLengthWords = StringUtils.allMatches(words, s -> (s.length() % 2) == 0);
        //use filter
        List<String> newList = myList.stream().filter(s->s.length()<4).collect(Collectors.toList());
        newList.forEach(System.out::println);


        List<String> newList2 = myList.stream().filter(s->s.contains("b")).collect(Collectors.toList());
        newList2.forEach(System.out::println);

        List<String> newList3 = myList.stream().filter(s->(s.length() % 2 == 0)).collect(Collectors.toList());
        newList3.forEach(System.out::println);



    }


    public void ex5(){
        //5. Turn the strings into uppercase, keep only the ones that are shorter than 6 characters,
        // of what is remaining, keep only the ones that contain “I”,
        // and print the first result.
        // Repeat the process, except checking for a “Q” instead of an “E”.
        // When checking for the “Q”, try to avoid repeating all the code from when you checked for an “E”.

        myList.stream().map(s->s.toUpperCase()).filter(s->s.length()<6).filter(s->s.contains("I")).forEach(System.out::println);

        //n-am mai facut a 2 a parte
    }
    public void ex6(){
        //P6. Produce a single String that is the result of concatenating the uppercase versions of all of the Strings.
        // Use a single reduce operation, without using map.

        String newString = myList.stream().reduce("", (partial, s)->partial +" "+ s.toUpperCase());
        System.out.println(newString);
    }
    public void ex7() {
        //P7. Produce the same String as above, but this time via a map operation that turns
        // the words into uppercase, followed by a reduce operation that concatenates them.

        System.out.println(myList.stream().map(s->s.toUpperCase()).reduce("", String::concat));
    }

    public void ex8() {
        //P8. Produce a String that is all the words concatenated together,
        // but with commas in between.
        // E.g., the result should be "hi,hello,...".
        // Note that there is no comma at the beginning,
        // before “hi”, and also no comma at the end, after the last word.
        // Major hint: there are two versions of reduce discussedin the notes.

        System.out.println(myList.stream().reduce("", (partial, s)->partial +", "+ s));
    }

    public void ex9(){
        //P9. Find the total number of characters (i.e., sum of the lengths)
        // of the strings in the List.

        Integer nr = myList.stream().map(s->s.length()).reduce(0, (sum, word)-> sum + word);

        System.out.println(nr);
    }

    public void ex10(){
        //P10. Find the number of words that contain an “h”.
        Integer nr = Math.toIntExact(myList.stream().filter(s -> s.contains("h")).count());

        System.out.println(nr);

    }

    public void examen1() {
        //keep only the numbers multiple of 2 or 3
        //transform each remaining nr into a string with suffix a and preffix b
        //concatenate all strings

        System.out.println(integers.stream().filter(nr->(nr% 2== 0 || nr%3==0)).map(nr->"a"+nr.toString()+"b").reduce("",String::concat));


        System.out.println(integers.stream().filter(nr->(nr% 2== 0 || nr%3==0)).map(s->s+1).map(nr->"a"+nr.toString()+"b").reduce("",String::concat));


    }
}




