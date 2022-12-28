Project Description
*******************

Your goal is to implement, from scratch, a GUI application in Java 11 using JavaFX 11
that incorporates a preponderance of the topics introduced in this course in a way that
demonstrates that you have met the learning outcomes related to those topics.

To get started, you must **pick one** the following app categories for this
project:

1. External API Tool; or
2. Arcade Game.

A brief description of each category is provided below.

External API Tool
   Integrate two or more external RESTful JSON APIs into your app so that your users don't need
   to utilize multiple services themselves to get the information or content that
   they want. Your app needs to do more than just download and display responses
   from the external APIs, it needs to combine the responses in some meaningful
   way.

   - Services like the |openlib_api|_, |the_cat_api|_, |the_dog_api|_, |poke_api|_, etc.
     provide **free access** to their RESTful JSON APIs -- a RESTful JSON API is one that
     you can access with an ``InputStreamReader`` and parse with a JSON library like Gson.
     For this project, you may only use RESTful JSON APIs and no other kinds of APIs.

     .. |the_dog_api| replace:: TheDogApi
     .. _the_dog_api: https://thedogapi.com/

     .. |the_cat_api| replace:: TheCatApi
     .. _the_cat_api: https://thecatapi.com/

     .. |poke_api| replace:: PokeApi
     .. _poke_api: https://pokeapi.co/

     .. |openlib_api| replace:: Open Library Search API
     .. _openlib_api: https://openlibrary.org/dev/docs/api/search

   - Some of these API services do require you to register with them to gain access to
     an "API key" -- an API key is usually just a special string that is unique to you
     that must be incorporated into how you request the JSON response. For example,
     suppose you have an API key for |the_dog_api|_ stored in ``API_KEY``, then you
     might use the following URL when requesting the JSON for a list of breeds
     (see |the_dog_api_breeds|_):

     .. code::

        "https://api.thedogapi.com/v1/breeds?apikey=" + API_KEY

     .. |the_dog_api_breeds| replace:: ``/breeds``
     .. _the_dog_api_breeds: https://docs.thedogapi.com/api-reference/breeds/breeds-list

   - If you choose this app category, then you should read the "|working_with_apis|_"
     appendix section before you write any code.

Arcade Game
   Find a classic |arcade_game|_ that interests you and implement your own version
   of it. The visuals and game mechanics must be easily recognizable and consistent with
   traditional implementations of the game you chose. You are required to utilize either
   keyboard event handlers or mouse event handlers that aren't related to one or
   more buttons.

   .. |arcade_game| replace:: arcade game
   .. _arcade_game: https://en.wikipedia.org/wiki/Arcade_game

   - We have included a simple example of a JavaFX component for a game in
     |cs1302_game_DemoGame|_ -- it's actually used in the starter code that's provided
     for this project. It utilizes the abstract parent class called |cs1302_game_Game|_
     that provides some neat features like a main game loop and support for
     continuously holding down a key.

     .. |cs1302_game_DemoGame| replace:: ``cs1302.game.DemoGame``
     .. _cs1302_game_DemoGame: https://github.com/cs1302uga/cs1302-omega/blob/main/src/main/java/cs1302/game/DemoGame.java
     .. |cs1302_game_Game| replace:: ``cs1302.game.Game``
     .. _cs1302_game_Game: https://github.com/cs1302uga/cs1302-omega/blob/main/src/main/java/cs1302/game/Game.java

   - You are not required to utilize |cs1302_game_Game|_; however, feel free to adapt it into
     your abstract parent class in the ``cs1302.omega`` package. All of the things that you
     have learned about JavaFX still apply, but it's likely that your arcade game will have
     less buttons and more moving images.

   - If you choose this app category, then you should read the "|working_with_games|_"
     appendix section before you write any code.

Now that you have chosen an app category from the list above, you still have a lot of
flexibility with regard to the functionality and visuals of your app. So long as your
app actually functions and you meet the other requirements, you are free to make the
app look and feel however you want (keep it appropriate).

Remember, part of software development is being given a goal but not necessarily being
given instruction on all of the details needed to accomplish that goal. For example, even
though working with things like keyboard events, mouse events, or API keys have not
been explicitly covered in class, you may need to are going to need to look up how to
do these things in order to complete this project.

Learning Outcomes
*****************

Here are some of the learning outcomes for this project:

* Plan, design, implement, test, debug, and deploy a complete object-oriented software solution in Linux/Unix environment (1302-LO1).
* Utilize inheritance and polymorphism in a software project (1302-LO3-LO4).
* Develop a GUI for a software project (1302-LO7).
* Implement exception-handling in a software project (1302-LO8).
* Understand and apply language basics using an OOP language (1302-LO11).

.. |freqs| replace:: Functional Requirements
.. _freqs: #functional-requirements


Final Project Policies
**********************

.. |final_pols| replace:: Final Project Policies
.. _final_pols: https://github.com/cs1302uga/cs1302-omega#final-project-policies

Final Project == Final Exam
   Per university policy, each student must be provided the opportunity to stand
   for a final examination as part of the completion of a full instructional term,
   and instructors have the authority to design and administer the final examination
   for a course in whatever manner is appropriate. In CSCI 1302 this semester,
   **the final project that described by this document will be treated as the final
   examination** since the grade and feedback that a student receives for this
   assignment is a summative evaluation of the entire term's work.
   
Final Project Grade Not Dropped
   Since this Final Project is your Final Exam, the grade that you earn for your
   final project submission does not qualify as a grade that can be dropped.

Final Submission Deadline
   Please take care to note the date/time for final submission deadline,
   **Deadline 3**. In particular, the deadline time is 06:30 PM, which is earlier
   in the day compared to previous projects.

Amended Late Work Policy
   For both logistical and policy-related reasons, the usual late work policy
   will not apply for this project, and **no late submissions will be accepted after
   11:59:59 PM on WED 2021-12-15 (Dec 15)**.
   You can still submit late for partial credit, but late submissions will only be
   accepted between **06:30:01 PM -- 11:59:59 PM on MON 2021-12-15 (Dec 15)**;
   submissions received during that time frame will incur the standard
   penalty for one day late. Final submissions received after the acceptance
   window will not be graded.

Non-Discrimination and Anti-Harassment Policy
   Since this project affords you more flexibility with respect to the content of your
   app, you are reminded that, as a UGA student, you must conduct yourself in accordance
   with the |uga_ndah|_.

   .. |uga_ndah| replace:: Non-Discrimination and Anti-Harassment Policy
   .. _uga_ndah: https://eoo.uga.edu/policies-resources/ndah-policy/

Private GitHub-hosted Git Repository
   Each student is required to setup a private GitHub-hosted Git repository
   for their project with the CSCI 1302 course instructors for this semester
   added as collaborators. **Instructions are provided later in this document.**

Working on a Local Machine
   If you decide to work on part or all of the project on your local machine,
   then it's your responsibility to ensure that your environment is compatible
   with the versions of software on Odin. No technical assistance will be provided
   by the instructional staff to accommodate this beyond the information provided
   in this policy statement. Remember, **your code still needs to compile and
   run on Odin** per the "Development Environment" absolute requirement. That is,
   if your submission does not compile on Odin, then that will result in an
   immediate zero for the assignment. A list of the relevant software versions
   currently in use on Odin (at the time of this writing) is provided below for
   convenience.

   * **Apache Maven 3.8.1**
        https://maven.apache.org/
   * **Java 11.0.12** (vendor: Oracle Corporation; **not OpenJDK**)
        https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
   * **OpenJFX 11.0.2** (note: should get handled by Maven)
         https://gluonhq.com/products/javafx/


Appendix
********

.. rubric:: **JavaFX**

* `JavaFX 11 API Documentation <https://openjfx.io/javadoc/11/>`__
* `JavaFX 11 Bookmarks <https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx-bookmarks.md>`__
* `CSCI 1302 JavaFX Tutorial <https://github.com/cs1302uga/cs1302-tutorials/blob/master/javafx/javafx.md>`__

.. rubric:: **Git**

.. |git_feature_workflow| replace:: Git Feature Branch Workflow
.. _git_feature_workflow: https://github.com/cs1302uga/cs1302-omega/blob/main/APPENDIX_GIT.rst

* |git_feature_workflow|_

.. rubric:: **RESTful JSON APIs**

.. |working_with_apis| replace:: Working with RESTful JSON APIs
.. _working_with_apis: https://github.com/cs1302uga/cs1302-omega/blob/main/APPENDIX_API.rst

* |working_with_apis|_

.. rubric:: **Games**

.. |working_with_games| replace:: Creating Games in JavaFX
.. _working_with_games: https://github.com/cs1302uga/cs1302-omega/blob/main/APPENDIX_GAME.rst

* |working_with_games|_
