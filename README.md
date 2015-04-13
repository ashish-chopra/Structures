
NOTE: 
=======================
I am planning to port this ant based project into maven project structure. The side effect of this would be change in the way the code is setup. Changes might be expected in package structure. We will still use acceptanceTester class to check our tests.

In case if the user of this project have any comments, please send me to `sendtoashishchopra@gmail.com`.


Welcome to Structures!
------------------------
Structures is a nice compilation of abstract data structures that we could think of! Since its inception, it is growing slowly into a mangnificent collection of ADT journal. We have written the intuition behind developing each structure in its code as introductory code block with algorithm analysis and its merits and de-merits.

The de-merits of one ADT leads to the motivation of creating another ADT, so you will find it like a chain story to browse :P

How to run?
----------------
Structures is a shadow of java project created in eclipse, it contains an in-house developed framework to run test suites. In order to run it on you machine, clone the repo and import the project in your IDE. 
Run `AcceptanceTester` class in `tests/com` folder. Please add VM arguments `-ea` to enable assertions in JVM.

We have also built an ant script to compile, run and generate javadocs through command line. In order to build through ant script `build.xml`, please ensure that you have ant installed on your system. Then browse to 
`Structures/` and run following commands on command line:

    >$ ant                      // it builds complete project and runs the test suite automatically.
    >$ ant run                  // it runs the test suite only.
    >$ ant docs                 // it generates the javadoc inside 'Structures/docs/'

I found a bug/new feature!
---------------------------
Structures' bugs are tracked using [Github Issue tracker system](https://github.com/ashish-chopra/Structures/issues).

Please use issue tracker for following purpose:
 1. to raise a bug request; do include specific details and label it appropriately.
 2. to suggest any improvements in existing features.
 3. to suggest new features or structures or applications.

I want to contribute!
-------------------------
Awesome! Please fork the repository and branch it & start developing a new feature or fix a bug. Then send a pull request. We will review the submissions and add it into the main repo.
Please be sure to checkout our contribution guidelines to reduce friction!

Active contributors in the repo - 
 1. [Ashish Chopra - @ashish-chopra](http://github.com/ashish-chopra)
 2. [Shivam Goel - @shivamgoel](http://github.com/shivamgoel)


License
----------------
The code is licensed under MIT License.
