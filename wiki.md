# Examples

## if-statement

        if(a < 0){
            // ...
        } else if(a > 0) {
            // ...
        } else {
            // ...
        }

## for-loop

    for(var i = 0; i < 10; i = i + 1){
        print i;
    }

## while-loop
    
    var a = 0;
    while(a < 10){
        a = a + 1;
    }

## Functions & Callbacks

    function add(a, b) {
        return a + b;
    }

    function foo(bar){
        var a = 1;
        var b = 2;
        return bar(a, b);
    }

    print add(4,5); // prints 9
    print foo(add); // prints 3

    


# Classes and inheritance

    class FooParent {

        welcome(){
            print "Hello from Parent";
        }
    }
    
    class Foo < FooParent {
        
        init(helloString){
            this.helloString = helloString;
        }
    
        welcome(){
            super.welcome();
            print this.helloString;
        }
    }
    
    var hello = "Hello World!";
    var foo = Foo(hello);
    foo.welcome();

---

    class Person {

        init(name){
            this.name = name;
        }
    
        whoAmI() {
            return "This persons name is: " + this.name;
        }

    }
    var john = Person("John");
    john.age = 30; //Initialize new variables outside of class

    print john.whoAmI();
    
    print john.age;
