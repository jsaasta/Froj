# Frensta Open Java

## What is Froj?

Froj (Frensta Open Java) is a lightweight interpreter written in Java that makes use of the JVM.

### Frensta?
Where im currently living, in the countryside in a small town called 'Fränsta' in Sweden.

### Why Froj?

I wrote this interpreter as a way to learn and get some deeper understanding how interpreters is made.

### TODO:

Implement some standard functions and method such as:
* Read user input
* Block style comments `/* */`
* Lists
* And more!

# Pre-requisites
    Java Runtime (1.8 or newer).


# Hello World
## The simplest way to get started:
* [Download the .jar under releases](https://github.com/jsaasta/Froj/releases/tag/stable)
* Create file ``helloworld.froj`` with the contents below:

      print "Hello World";

* Run ``java -jar froj.jar ./helloworld.froj``


## Build the .jar from source:

### Makefile

* cd to ``/src``
* run``make compile``

### javac
* cd to `/src`
* run `javac -d ./ ./com/saasta/froj/*.java`
* run `jar -cfm froj.jar ./META-INF/MANIFEST.MF ./com/saasta/froj/*.class`
* Optional: Remove the .class files after creating the .jar:
  * Linux: `rm -f ./com/saasta/froj/*.class`
  * Windows(CMD): `del ./com/saasta/froj/*.class`
  * Windows(PowerShell): `Remove-Item ./com/saasta/froj/*.class`


# Thank you
Special thanks to [Robert Nystrom's book Crafting Interpreters](https://craftinginterpreters.com), as the book paved the way for Froj.