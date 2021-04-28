# The History

## Story

Petunia is a decent little country with a strong and wise leader. He sets wise
laws in order to keep the country safe, stable, and prosperous. For example it
is forbidden to use the word 'dictator' since it would induce uneasiness and
threaten peace.

Pet Un, the wise leader, likes if the history of the country reflects all the
up to date information scholars have at any given moment. There is a central,
authoritative source of information about historical facts called _The History_
which must be updated by historians any time they become aware of a new piece
of fact.

> For example, based on their false memories, some would mistakenly say that
> the country's great victories have been fought during the period when Pet Un's
> father, Pet Il was in rule - this is an example of dangerous and misleading
> information that has to be erased and set straight in the official version
> once for all.

And another thing. Performance is of utmost importance; Pet Un personally
ordered that the replacement in _The History_ must be as fast as possible.

The IT department at _The History Institute_ chose to keep the current state
of history as a list of words. They heard that different list implementations
have different [performance characteristics](https://dzone.com/articles/arraylist-vs-linkedlist-vs),
dynamic arrays (`ArrayList` in Java) 
are better at _accessing data_ while linked lists (`LinkedList` in Java) 
are better at _inserting and deleting data_, but neither of them is an
expert of using these data structures properly, especially from a
performance point of view.

They piloted a research project to check the difference between the two
implementations. Their solutions are correct according to the tests but
unfortunately slow as hell. Without a time cap, the performance tests
operating on a text similar in size as _The History_, run _for minutes_!
The wise leader won't tolerate this, and the deadline is getting closer
and closer.

They must be doing something wrong. And they fear for their lives, which
doesn't help solving the problem. One developer, a not too bright guy you
know back from school, reached out to you asking for help. They hope that
you can rewrite the code so that the performance tests would run within
the short attention span of the wise leader.

## What are you going to learn?

You'll have to:

- get some idea of interfaces
- look up different list implementations
- find out how dynamic arrays and linked lists work
- develop code against an existing set of tests
- test different list implementations for performance
- develop custom algorithms for altering collections
- try using iterators and find out how they work

## Tasks

1. Make sure you understand what's happening in the tho cases, crunch the code until you understand what the different methods do. See what the role of the interface is in the testability of these classes. Document it!
    - The test results of the `TestHistoryCorrectness` class are documented by a screenshot named as `correctness_before.png` and placed in the `resources` folder
    - The test results of the `TestHistoryPerformance` class are documented by a screenshot named as `performance_before.png` and placed in the `resources` folder. Most test cases will likely fail
    - All methods of the `History` interface are documented by well formatted Javadoc comments. Every documentation comment contains a description of what the method does, and explanations of the return value and the input parameters

2. Make sure that every `LinkedListHistory` related test passes both the correctness and the performance tests. Document it!
    - The test results of the `TestHistoryCorrectness` class are documented by a screenshot named as `correctness_after.png` and placed in the `resources` folder
    - The test results of the `TestHistoryPerformance` class are documented by a screenshot named as `performance_after.png` and placed in the `resources` folder
    - The `add()` method of `LinkedListHistory` passes all the related tests and uses _only one_ replacement call
    - The `remove()` method of `LinkedListHistory` passes all the related tests
    - The `replaceOneWord()` method of `LinkedListHistory` passes all the related tests
    - The `replaceMoreWord()` method of `LinkedListHistory` passes all the related tests

3. Make sure that every `ArrayListHistory` related test passes both the correctness and the performance tests.
    - The `add()` method of `ArrayListHistory` passes all the related tests and uses _only one_ replacement call
    - The `remove()` method of `ArrayListHistory` passes all the related tests
    - The `replaceOneWord()` method of `ArrayListHistory` passes all the related tests
    - The `replaceMoreWord()` method of `ArrayListHistory` passes all the related tests

## General requirements

None

## Hints

- Maybe you haven't used a unit testing framework (yet!). In this
  case navigate to the test class, and your IDE will help.
    - You can run all tests at once.
    - There is a timeout set for each performance test method which means the
      test cases should be finishing within 5 seconds.
    - Use the debugger when examining the code. Play with the test cases.
      Unset the time cap and see what happens.
- Think about the operational costs of code snippets, and don't
  forget to include the costs of the methods they call. A method call
  can be deceivingly short but the time needed for it to return may
  not scale well. 
    - What can ruin linked list's performance? Think about what the `get()`
      method is doing, or look it up in the implementation's source code!
    - You definitely should use iterators for linked lists but the devil
      lives in the details here. It is really tricky to repair
      `@replaceMoreWords()` without losing the performance advantage
      of linked lists.
    - In case of dynamic arrays, you are free to use either iterators or
      the `get()` method, it doesn't have much impact on its performance
      Try it out, and think about the whys!
    - What can be of rescue here, then? Well, don't remove _and_ insert
      at the same time if you don't have to.
    - Still not green? Try to think out of the box :) But please, stay in
      the domain of collections.

## Background materials

- <i class="far fa-exclamation"></i> [Javadoc](project/curriculum/materials/pages/java/introduction-to-javadoc.md)
- <i class="far fa-exclamation"></i> [Collections](project/curriculum/materials/competencies/java-data-structures/java-collections.md.html)
- <i class="far fa-exclamation"></i> [How to iterate through List?](https://www.baeldung.com/java-iterate-list)
- [Abstraction and interfaces](project/curriculum/materials/pages/java/abstraction.md)
- [3 good reasons to avoid arrays in Java Interfaces](https://eclipsesource.com/blogs/2014/04/11/3-good-reasons-to-avoid-arrays-in-java-interfaces/)

