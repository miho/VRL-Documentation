CSS:	resources/css/vrl-documentation.css

# Debugging #

## Requirements ##

- VRL-Studio >= 4.4.2
- VRL >= 0.4.2.6

## Depends on ##

[Defining A Workflow](defining-a-workflow.html)

## Contents ##

In this tutorial you will learn how to

- enable debug output
- find bugs in your code
- perform visual debugging

## Difficulty Level##

### Difficulty Level ###

Intermediate

## Introduction ##

Groovy is a dynamic language. Current versions of Groovy (< 2.0) do not support static compilation. Thus, many errors occur at runtime. Even though dynamic languages tend to have a flat learning curve they often make it difficult to find bugs in the code. Many errors can only be detected if the code is executed. For code that contains many conditional statements this can be problematic.

VRL provides some basic debugging features that may help finding bugs in your code.


### Enabling Debug Output ###

Click on `Edit->Preferences` and then on the `Development` tab (see [Enable Logging]). Here you can enable 

- `System.out` : shows usual text output, e.g., `println("msg")`
- `System.err` : shows error output, e.g., stack traces etc.

![Enable Logging][]

[Enable Logging]: resources/img/enable-logging-01.png width=450px

Drag the ruler up to show the log (see [Show Log]). Now you can see VRL debug output in the log.

![Show Log][]

[Show Log]: resources/img/show-log-01.png width=450px

## Debugging Code ##

### Basic Example ###

Consider the following code:

    package eu.mihosoft.vrl.user;
    @ComponentInfo(name="BuggyClass", category="Custom")
    class BuggyClass implements Serializable {
      private static final long serialVersionUID=1;

      public String letItCrash(){
        String s = "a string";
        s.thisMethodDoesNotExist();
        return "Nice! It doesn't crash anymore!";
      }
    }

It compiles without problems. But when you run it you will get an error message:

![Error Message][]

[Error Message]: resources/img/debugging-error-msg-01.png width=650px

### Reading The Log ###

If the code you are trying to debug is very long it might be difficult to figure out where the exception was thrown. Therefore it might be useful to look at the stack trace. We do this by opening the log (see [Show Log]).

The log gives us the following output:

    Method "eu.mihosoft.vrl.user.BuggyClass.letItCrash()" can't be invoked:groovy.lang.MissingMethodException: No signature of method: java.lang.String.thisMethodDoesNotExist() is applicable for argument types: () values: []
    No signature of method: java.lang.String.thisMethodDoesNotExist() is applicable for argument types: () values: []
     --> at org.codehaus.groovy.runtime.ScriptBytecodeAdapter.unwrap(ScriptBytecodeAdapter.java:52)
     --> at org.codehaus.groovy.runtime.callsite.PojoMetaClassSite.call(PojoMetaClassSite.java:43)
     --> at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:39)
     --> at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:105)
     --> at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:109)

    --------------------------
     --> at eu.mihosoft.vrl.user.BuggyClass.letItCrash(BuggyClass.groovy:11) <-- PROJECT CLASS!
    --------------------------

     --> at sun.reflect.NativeMethodAccessorImpl.invoke0(NativeMethodAccessorImpl.java:-5)
     --> at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:36)
     --> at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:22)
     --> at java.lang.reflect.Method.invoke(Method.java:594)
     --> at eu.mihosoft.vrl.reflection.ObjectInspector.invoke(ObjectInspector.java:185)
     --> at eu.mihosoft.vrl.reflection.VisualObjectInspector.invoke(VisualObjectInspector.java:625)
     --> at eu.mihosoft.vrl.reflection.VisualObjectInspector.invoke(VisualObjectInspector.java:592)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation.invoke(DefaultMethodRepresentation.java:1051)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation.invoke(DefaultMethodRepresentation.java:1236)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation.invoke(DefaultMethodRepresentation.java:1248)
     --> at eu.mihosoft.vrl.reflection.DefaultMethodRepresentation$6.run(DefaultMethodRepresentation.java:730)
     --> at java.lang.Thread.run(Thread.java:677)
    Can't invoke Method: see stack trace for details!

The stack trace shows all method calls that are involved in the execution that led to the runtime error. Method calls from classes that are defined in the VRL project, i.e.,  the classes that we defined via Groovy code, can be easily distinguished from other method calls. In our example it is the invocation of our `letItCrash()` method:

    --------------------------
     --> at eu.mihosoft.vrl.user.BuggyClass.letItCrash(BuggyClass.groovy:11) <-- PROJECT CLASS!
    --------------------------

The [Error Message] already shows what's wrong. But still we don't exactly know where the error occurred. Therefore, it is very useful to check the stack trace which exactly shows where an error occurred.

## Breakpoints ##

VRL comes with a utility class that allows to stop a visually invoked method at certain points. Therefore, the `VDebug` class can be used. To add a breakpoint to the code shown above we change it a bit:

    package eu.mihosoft.vrl.user;
    @ComponentInfo(name="BuggyClass", category="Custom")
    class BuggyClass implements Serializable {
      private static final long serialVersionUID=1;

      public String letItCrash(){
        String s = "a string";
		VDebug.setBreak("01") // --> BREAKPOINT 01
        s.thisMethodDoesNotExist();
        return "Nice! It doesn't crash anymore!";
      }
    }

Now click on `invoke`. Nothing happens. That is exactly what we intended. 

## Further Reading ##

- [Version Management](version-management.html)



