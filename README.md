
What's coming up?
---------------------
1. Well, I will keep adding graphs, balanced trees as i keep reading more.
2. I think adding a support of generating java-doc is a great help. [Done]
3. Then, we get little innovative and try to visualize data structures using graphic library.

Welcome to Structures!
------------------------
Structures is a nice compilation of abstract data structures that we could think of! Since its inception, it is growing slowly into a huge collection of ADT journal. We have written the intuition behind developing each structure in its code as introductory comment block with algorithmic analysis and its merits and de-merits.

The de-merits of one ADT leads to the motivation of creating another ADT, so you will find it like a chain story to browse :P


How to get it running?
---------------------------
'Structures' is a maven project. You must have any latest version of Git, Maven and Eclipse (optional) installed in your machine and follow the steps mentioned below:

   Clone the repo using command and generate eclipse project files:

    >$ git clone <clone_url>         // you will get the clone URL at the 
                                     // right side of the home page of this repo.
    >$ cd Structures                 // browse inside Structures       
     
    >$ mvn eclipse:eclipse           // it generates the eclipse specific files, so that 
                                     // you can import this project into eclipse

   If you are not using Eclipse, then you can convert it into your IDE specific project. For this, consult maven's website.
   
   Then, Import the project into Eclipse by File > Import > Existing Maven Project into Workspace
   
   Since recenlty, we converted the old test cases into junits, so running the same is super easy! But i still miss my old in-house developed testing framework :(

    >$ mvn compile     		// this will only compile your source code
    >$ mvn test        		// this will run the test suite
    
    >$ mvn javadoc:javadoc  // generates the java doc of all the ADTs
    							   // at "Structures/target/site/apidocs/"

   You can run these commands from command line inside your `Structures` directory. 
   
   Or using Eclipse by right click `Structures > Run As > Maven Build ...`

I found a bug/new feature!
---------------------------
Structures' bugs are tracked using [Github Issue tracker system](https://github.com/ashish-chopra/Structures/issues).

Please use issue tracker for following purpose:
 1. to raise a bug request; do include specific details and label it appropriately.
 2. to suggest any improvements in existing features.
 3. to suggest new features or structures or applications.

I want to contribute!
-------------------------
Awesome! Please fork the repository and branch it & start developing a new feature or fix a bug. Then send a pull request. I will review the submissions and add it into the main repo.
Please be sure to checkout the contribution guidelines to reduce friction!

Active contributors in the repo - 
 1. [Ashish Chopra - @ashish-chopra](http://github.com/ashish-chopra)


License
----------------
The code is licensed under MIT License. 
Let's have fun coding together!
