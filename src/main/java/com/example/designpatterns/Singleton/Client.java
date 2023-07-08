package com.example.designpatterns.Singleton;

import java.util.concurrent.atomic.AtomicReference;

public class Client {
    int c=0;
    public static void main(String[] args) throws InterruptedException {
        /*
                Step 1 try creating two objects using constructor and check the result
                ---> Yes, the two objects will have different hashcodes
         */

//        DatabaseConfig databaseConfig1=new DatabaseConfig();
//        DatabaseConfig databaseConfig2=new DatabaseConfig();
//        System.out.print(databaseConfig1.equals(databaseConfig2));
        /*
            Why the hashcodes are different? --> because we are allowing the object instantiation using constructor
            and that will generate two unique objects every time which defeats our purpose to make the DatabaseConfig singleton
            So, lets modify the DatabseConfig:
              --> 1. Define a private constructor ---> any guess why?
              ***** because we should not allow object creation using Constructor as discussed above.

              But here there are few questions:

              1. if we don't allow object creation via constructor how can a client access the methods of the desired class?
              ****** Yes you guessed it right, make use of the static method.

              2. Okay, we have the static method but what we will be doing in this static method
              **** we are going to return the instance of the desired class, however
              to return the instance of the class we need to make the instance declaration static as well ,

              any guess why?

              ***** Because we cannot access a non-static member from static context.

              3.Return the desired object if it is not already instantiated.


                Now guess the below output after the above steps

                ----------answer is True!

                We are done with Singleton Implementaion

                But is it thread safe?-->  if you ask me what do you mean by that, the answer is:
                What if multiple clients try to get the object simultaneously, do you still think the answer will be true?

                Let's check that out.


         */
//        DatabaseConfig databaseConfig1=DatabaseConfig.getInstance();
//        DatabaseConfig databaseConfig2=DatabaseConfig.getInstance();
//        System.out.println(databaseConfig2.equals(databaseConfig1));
//

        /*
            We created two threads and tried to fetch the object of DatabaseConfig and hashcode comparision resulted in false
            stating the two objects has been created- which violates our purpose.

            Now think about how to resolve this.


            There are two approaches:
            1. Eager initialization
            2. Lazy initialization

            Lets start with Eager
         */
//
//      AtomicReference<DatabaseConfig> databaseConfig1 = new AtomicReference<>();
//        AtomicReference<DatabaseConfig> databaseConfig2 = new AtomicReference<>();
//
//
//        Thread t1=new Thread( ()->{
//            databaseConfig1.set(DatabaseConfig.getInstance());
//        });
//
//        Thread t2=new Thread( ()->{
//            databaseConfig2.set(DatabaseConfig.getInstance());
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(databaseConfig2.get());
//        System.out.println(databaseConfig1.get());
//        System.out.println(databaseConfig2.get()==databaseConfig1.get());

        /*
                Eager initialization can be understood as making the DatabaseConfig singleton during the application startup itself.

                How can we do that?

                Answer is simple we can make the DatabaseConfig instance member as final

                This works but what is the issue with this approach?

                Think................

                Answer is simple if you are having 20 classes in your application which
                needs to be singleton and if you do eager initialization, during the application startup/class load all these
                20 instances will get created, as the classes gets increase this can have an advrse impact on ourr application startup which is not right.


                How to solve this, yes you need to follow Lazy initialzation.

                what does lazy initialization means --> simple, client is lazy and it needs the object only when it wants

                how to do that with thread safety ---> any guessssssssssssssss

               --> make the getInstance method synchronized

                Works like a charm!!!

                But what is side effects of making a method synchronized?

                There are many but one key impact to the application would be interms of performance, again guess why?

                ***** Threads need to wait for lock, acquire the lock and release it, don't you think these are expensive operations.

                So you might be thinking how to to resolve this

                *** You need not make thw whole method synchoronized make use of synchronized block

                 We optimised it yahooooooooooooooooo!!

                 We are not done yet, can we optimise it further?

                 What can we optimise here, here we are locking the check whether the instance is null or not
                 do we need to do that, can we allow all the threads to do that check? Yes we can so lets move the synchronised to one step down

                 But here there is catch even if we move the synchronized to one step below after the check if instance is null,
                 for the very first object instantiation there is a chance that two threads might access the block and create two objects

                 let's validate

                 Answer is false

                 This because thread1 and thread 2 accessed the block after the if check simultaneously & as i mentioned above this
                 issue will happen only for first initialization

                 Lets sort this out ---> give a pause and think about it

                Simple solution is add a double check of whether object is null after the synchronized block and we are done

                And the last cute step that we implemented is termed as "Double checked locking"

                Still thinking about what did we gain by moving the synchronized to multiple steps below:
                -> Thread interlocking happens only once i.e when the instance is null, once the instance is created there no way that new threads will
                go inside the synchronized block , where as earlier we were adding the synchronised in method declaration
                and the level above null check which results in threads interlocking every single time and it is expensive.

                Hope this makes sense!!!


                Hurray!!  We implemented the pattern

                Congratulations!!

         */
        AtomicReference<DatabaseConfig> databaseConfig1 = new AtomicReference<>();
        AtomicReference<DatabaseConfig> databaseConfig2 = new AtomicReference<>();
        AtomicReference<DatabaseConfig> databaseConfig3= new AtomicReference<>();


        Thread t1=new Thread( ()->{
            databaseConfig1.set(DatabaseConfig.getInstance());
        });

        Thread t2=new Thread( ()->{
            databaseConfig2.set(DatabaseConfig.getInstance());
        });
        Thread t3=new Thread( ()->{
            databaseConfig3.set(DatabaseConfig.getInstance());
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println(databaseConfig2.get());
        System.out.println(databaseConfig1.get());
        System.out.println(databaseConfig2.get()==databaseConfig1.get());
    }
}
